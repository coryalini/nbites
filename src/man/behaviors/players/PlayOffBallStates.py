import SharedTransitions as shared
import PlayOffBallTransitions as transitions
import RoleConstants as role
import ChaseBallTransitions as chase
import ChaseBallConstants as chaseConstants
import ClaimTransitions as claims
from SupporterConstants import getSupporterPosition, CHASER_DISTANCE, findStrikerHome, findDefenderHome, calculateHomePosition
import noggin_constants as NogginConstants
from ..navigator import Navigator as nav
from ..navigator import BrunswickSpeeds as speeds
from objects import Location, RobotLocation
from ..util import *
from math import hypot, fabs, atan2, degrees
import random

# IMPORTANT China 2015 bug found
# TODO fix oscillation between positionAtHome and positionAsSupporter

@defaultState('branchOnRole')
@superState('gameControllerResponder')
@ifSwitchNow(transitions.shouldFindSharedBall, 'searchFieldForSharedBall')
@ifSwitchNow(transitions.shouldBeSupporter, 'positionAsSupporter')
@ifSwitchNow(transitions.shouldApproachBall, 'approachBall')
def playOffBall(player):
    """
    Superstate for all off ball play.
    """
    player.inKickingState = False

#USOPEN2016: Back to Search Field by Quad
@superState('playOffBall')
def branchOnRole(player):
    """
    Chasers are going to have a different behavior again.
    We will branch on behavior based on role here
    """
    # print("TIME SINCE PLAYING:", player.brain.gameController.timeSincePlaying)
    if role.isFirstChaser(player.role):
        if transitions.shouldFindSharedBall(player) and player.brain.gameController.timeSincePlaying > 75:
            return player.goNow('searchFieldForSharedBall')
        return player.goNow('playerFourSearchBehavior')
    else if role.isSecondChaser(player.role):
        return player.goNow('playerFiveSearchBehavior')
    return player.goNow('positionAtHome')


@superState('playOffBall')
@stay
@ifSwitchNow(shared.navAtPosition, 'watchForBall')
def positionAtHome(player):
    """
    Go to the player's home position.
    """
    if role.isDefender(player.role):
        home = calculateHomePosition(player)
    else:
        home = player.homePosition

    if player.firstFrame():
        player.brain.tracker.trackBall()
        fastWalk = role.isChaser(player.role)
        player.brain.nav.goTo(home, precision = nav.HOME,
                              speed = speeds.SPEED_EIGHT, avoidObstacles = True,
                              fast = fastWalk, pb = False)

    player.brain.nav.updateDest(home)

@superState('playOffBall')
@stay
@ifSwitchNow(transitions.shouldSpinSearchFromWatching, 'spinAtHome')
def watchForBall(player):
    """
    The player is at home, waiting for the ball to be within box.
    """

    if player.firstFrame():
        print "-----------Player at home-----------"
        player.brain.tracker.trackBall()
        player.brain.nav.stand()

    if transitions.tooFarFromHome(player, 50, 20):
        return player.goLater('positionAtHome')

    while player.stateTime < 8:
        return player.stay()

    return player.goNow('spinAtHome')

@defaultState('doFirstHalfSpin')
@superState('playOffBall')
# @ifSwitchNow(transitions.stopSpinning, 'positionAtHome')
def spinAtHome(player):
    """
    Spin while at home.
    """
    pass

@superState('spinAtHome')
def doFirstHalfSpin(player):
    """
    Spin to where we think the ball is.
    """

    if player.firstFrame():
        print "------------First half spin-------------"
        
        if player.brain.playerNumber == 3:
            player.setWalk(0, 0, speeds.SPEED_FOUR)
            player.brain.tracker.lookToSpinDirection(1) #Clockwise
        else:
            player.setWalk(0, 0, -speeds.SPEED_FOUR)
            player.brain.tracker.lookToSpinDirection(-1) #AntiClockwise

    while player.stateTime < chaseConstants.SPUN_ONCE_TIME_THRESH / 2:
        return player.stay()

    return player.goNow('doPan')

@superState('spinAtHome')
def doPan(player):
    """
    Wide pan for 5 seconds.
    """
    if player.firstFrame():
        print "------------Doing Pan-------------"

        player.stand()
        player.brain.tracker.repeatWideSnapPan()

    while player.stateTime < 4: #Should use constant for 1 pan here.
        return player.stay()

    return player.goNow('doSecondHalfSpin')

@superState('spinAtHome')
def doSecondHalfSpin(player):
    """
    Keep spinning in the same direction.
    """
    if player.firstFrame():
        print "--------------Second Half Spin---------------"

        if player.brain.playerNumber == 3:
            player.setWalk(0, 0, speeds.SPEED_FOUR)
            player.brain.tracker.lookToSpinDirection(1) #Clockwise
        else:
            player.setWalk(0, 0, -speeds.SPEED_FOUR)
            player.brain.tracker.lookToSpinDirection(-1) #AntiClockwise

    while player.stateTime < chaseConstants.SPUN_ONCE_TIME_THRESH / 2:
        return player.stay()

    if role.isFirstChaser(player.role):
        return player.goNow('playerFourSearchBehavior')
    return player.goNow('playOffBall')

@superState('playOffBall')
@stay
@ifSwitchLater(transitions.shouldNotBeSupporter, 'playOffBall')
def positionAsSupporter(player):
    """
    Position to support teammate with claim.
    """
    positionAsSupporter.position = getSupporterPosition(player, player.role)
    fastWalk = False

    if player.firstFrame():
        player.brain.tracker.trackBall()

        player.brain.nav.goTo(positionAsSupporter.position, precision = nav.GENERAL_AREA,
                              speed = speeds.SPEED_EIGHT, avoidObstacles = True,
                              fast = fastWalk, pb = False)

    if positionAsSupporter.position.distTo(player.brain.loc) > 20:
        player.brain.nav.goTo(positionAsSupporter.position, precision = nav.GENERAL_AREA,
                              speed = speeds.SPEED_EIGHT, avoidObstacles = True,
                              fast = fastWalk, pb = False)
    
    player.brain.nav.updateDest(positionAsSupporter.position, fast = fastWalk)

@superState('playOffBall')
@stay
@ifSwitchNow(transitions.noBallFoundAtSharedBall, 'playerFourSearchBehavior') #was: positionAtHome USOPEN2016
@ifSwitchNow(transitions.shouldFindFlippedSharedBall, 'searchFieldForFlippedSharedBall')
@ifSwitchNow(transitions.shouldStopLookingForSharedBall, 'playerFourSearchBehavior') #was: positionAtHome USOPEN2016
def searchFieldForSharedBall(player):
    """
    Searches the field for the shared ball.
    """
    sharedball = Location(player.brain.sharedBall.x, player.brain.sharedBall.y)

    if player.firstFrame():
        player.brain.tracker.trackBall()
        player.brain.tracker.repeatWideSnapPan()
        player.sharedBallCloseCount = 0
        player.sharedBallOffCount = 0
        player.brain.nav.goTo(sharedball, precision = nav.GENERAL_AREA,
                              speed = speeds.SPEED_EIGHT, avoidObstacles = True,
                              fast = True, pb = False)

    if sharedball.distTo(player.brain.loc) < 100:
        player.sharedBallCloseCount += 1
    else:
        player.sharedBallCloseCount = 0

    if not transitions.shouldFindSharedBall(player):
        player.sharedBallOffCount += 1
    else:
        player.sharedBallOffCount = 0

    player.brain.nav.updateDest(sharedball)

@superState('playOffBall')
@stay
@ifSwitchNow(transitions.shouldStopLookingForFlippedSharedBall, 'playerFourSearchBehavior') #was: positionAtHome USOPEN2016
def searchFieldForFlippedSharedBall(player):
    """
    Flips the shared ball and searches for it.
    """
    sharedball = Location(-1*(player.brain.sharedBall.x-NogginConstants.MIDFIELD_X) + NogginConstants.MIDFIELD_X,
                          -1*(player.brain.sharedBall.y-NogginConstants.MIDFIELD_Y) + NogginConstants.MIDFIELD_Y)

    if player.firstFrame():
        player.brain.tracker.trackBall()
        player.brain.tracker.repeatWideSnapPan()
        player.sharedBallCloseCount = 0
        player.brain.nav.goTo(sharedball, precision = nav.GENERAL_AREA,
                              speed = speeds.SPEED_EIGHT, avoidObstacles = True,
                              fast = True, pb = False)

    if sharedball.distTo(player.brain.loc) < 100:
        player.sharedBallCloseCount += 1
    else:
        player.sharedBallCloseCount = 0

    if not transitions.shouldFindSharedBall(player):
        player.sharedBallOffCount += 1
    else:
        player.sharedBallOffCount = 0
        
    player.brain.nav.updateDest(sharedball)

@superState('playOffBall')
@stay
def playerFourSearchBehavior(player):
    # How do we specify the heading of the robot

    if player.firstFrame():
        player.brain.tracker.trackBall()
        playerFourSearchBehavior.dest = min(playerFourPoints, key = lambda x:fabs(player.brain.loc.distTo(x)))
        player.brain.nav.goTo(playerFourSearchBehavior.dest, precision = nav.HOME,
                          speed = nav.QUICK_SPEED, avoidObstacles = True,
                          fast = True, pb = False)
        playerFourSearchBehavior.pointIndex = playerFourPoints.index(playerFourSearchBehavior.dest)
        playerFourSearchBehavior.pointsWalked = 0

    if shared.navAtPosition(player) and player.brain.loc.distTo(playerFourSearchBehavior.dest) < 60:
        playerFourSearchBehavior.pointIndex += 1
        playerFourSearchBehavior.pointsWalked += 1
        playerFourSearchBehavior.dest = playerFourPoints[playerFourSearchBehavior.pointIndex % len(playerFourPoints)]

    if playerFourSearchBehavior.pointsWalked > 2:
        return player.goLater('playOffBall')

    player.brain.nav.updateDest(playerFourSearchBehavior.dest) 

playerFourWayPoint1 = Location(NogginConstants.CENTER_FIELD_X - 160, NogginConstants.CENTER_FIELD_Y)
playerFourWayPoint2 = Location(NogginConstants.CENTER_FIELD_X + 170, NogginConstants.MY_GOALBOX_TOP_Y + 120)
playerFourWayPoint3 = Location(NogginConstants.CENTER_FIELD_X + 170, NogginConstants.MY_GOALBOX_BOTTOM_Y - 120)
playerFourPoints = [playerFourWayPoint1, playerFourWayPoint2, playerFourWayPoint3]

# @superState('spinAtHome')
def spinToFaceDestination(player):
    """
    Keep spinning in the same direction.
    """
    if player.firstFrame():
        player.setWalk(0, 0, -speeds.SPEED_FOUR)
        player.brain.tracker.lookToSpinDirection(-1) #AntiClockwise

    while player.stateTime < chaseConstants.SPUN_ONCE_TIME_THRESH / 2:
        return player.stay()

    if role.isFirstChaser(player.role):
        return player.goNow('playerFourSearchBehavior')
    return player.goNow('playOffBall')

@superState('playOffBall')
@stay
def playerFiveSearchBehavior(player):

    if player.firstFrame():
        player.brain.tracker.trackBall()
        playerFiveSearchBehavior.dest = min(playerFivePoints, key = lambda x:fabs(player.brain.loc.distTo(x)))
        player.brain.nav.goTo(playerFiveSearchBehavior.dest, precision = nav.HOME,
                          speed = nav.QUICK_SPEED, avoidObstacles = True,
                          fast = True, pb = False)
        playerFiveSearchBehavior.pointIndex = playerFivePoints.index(playerFiveSearchBehavior.dest)
        playerFiveSearchBehavior.pointsWalked = 0

    if shared.navAtPosition(player) and player.brain.loc.distTo(playerFiveSearchBehavior.dest) < 60:

        #At way point.

        #Pseudo
        # if at destination 1 or 3:
        #   pan
        # else:
        #   spin

        playerFiveSearchBehavior.pointIndex += 1
        playerFiveSearchBehavior.pointsWalked += 1
        playerFiveSearchBehavior.dest = playerFivePoints[playerFiveSearchBehavior.pointIndex % len(playerFivePoints)]

    if playerFiveSearchBehavior.pointsWalked > 3:
        return player.goLater('playOffBall')

    player.brain.nav.updateDest(playerFiveSearchBehavior.dest) 

playerFiveWayPoint1 = Location(NogginConstants.CENTER_FIELD_X + 160, NogginConstants.BLUE_GOALBOX_BOTTOM_Y - 70)
playerFiveWayPoint2 = Location(NogginConstants.CENTER_FIELD_X + 130, NogginConstants.CENTER_FIELD_Y)
playerFiveWayPoint3 = Location(NogginConstants.CENTER_FIELD_X - 160, NogginConstants.CENTER_FIELD_Y) # Mirror of 1
playerFiveWayPoint4 = Location(NogginConstants.CENTER_FIELD_X + 320, NogginConstants.CENTER_FIELD_Y)
playerFivePoints = [playerFiveWayPoint1, playerFiveWayPoint2, playerFiveWayPoint3, playerFiveWayPoint4]

# @superState('playOffBall')
# @stay
# def searchFieldByQuad(player):
#     """
#     Search the field quadrant by quadrant. Choose first quadrant by loc heading.
#     """
#     if player.firstFrame():
#         player.brain.tracker.trackBall()
#         # player.brain.tracker.repeatWideSnapPan()
#         searchFieldByQuad.dest = min(points, key=lambda x:fabs(player.brain.loc.distTo(x)))
#         player.brain.nav.goTo(searchFieldByQuad.dest, precision = nav.GRAINY,
#                           speed = speeds.SPEED_EIGHT, avoidObstacles = True,
#                           fast = True, pb = False)
#         searchFieldByQuad.quadIndex = points.index(searchFieldByQuad.dest)
#         searchFieldByQuad.quadsWalked = 0

#     if shared.navAtPosition(player) and player.brain.loc.distTo(searchFieldByQuad.dest) < 60:
#         searchFieldByQuad.quadIndex += 1
#         searchFieldByQuad.quadsWalked += 1
#         searchFieldByQuad.dest = points[searchFieldByQuad.quadIndex % len(points)]

#     if searchFieldByQuad.quadsWalked > 3:
#         return player.goLater('playOffBall')

#     player.brain.nav.updateDest(searchFieldByQuad.dest)

# quad1Center = Location(NogginConstants.CENTER_FIELD_X * .6, NogginConstants.CENTER_FIELD_Y * .6)
# quad2Center = Location(NogginConstants.CENTER_FIELD_X * 1.4, NogginConstants.CENTER_FIELD_Y * 1.4)
# quad3Center = Location(NogginConstants.CENTER_FIELD_X * 1.4, NogginConstants.CENTER_FIELD_Y * .6)
# quad4Center = Location(NogginConstants.CENTER_FIELD_X * .6, NogginConstants.CENTER_FIELD_Y * 1.4)
# points = [quad1Center, quad2Center, quad3Center, quad4Center]
