
// This file is part of Man, a robotic perception, locomotion, and
// team strategy application created by the Northern Bites RoboCup
// team of Bowdoin College in Brunswick, Maine, for the Aldebaran
// Nao robot.
//
// Man is free software: you can redistribute it and/or modify
// it under the terms of the GNU Lesser Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// Man is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU Lesser Public License for more details.
//
// You should have received a copy of the GNU General Public License
// and the GNU Lesser Public License along with Man.  If not, see
// <http://www.gnu.org/licenses/>.

#include <iostream>
#include <sstream>
#include <time.h>
#include <sys/time.h>
#include <Python.h>
#include <boost/shared_ptr.hpp>
#include <boost/assign/std/vector.hpp>
using namespace boost::assign;

#include "Man.h"
#include "manconfig.h"
#include "corpus/synchro.h"
#include "VisionDef.h"
#include "Common.h"
#include "PyRoboGuardian.h"
#include "PySensors.h"
#include "PyLights.h"
#include "PySpeech.h"
#include "memory/log/IOProviderFactory.h"

//#include <valgrind/callgrind.h>

using namespace std;
using boost::shared_ptr;
using namespace man::memory;
using namespace man::memory::log;

/////////////////////////////////////////
//                                     //
//  Module class function definitions  //
//                                     //
/////////////////////////////////////////

Man::Man (shared_ptr<Profiler> _profiler,
          shared_ptr<Sensors> _sensors,
          shared_ptr<RoboGuardian> guardian,
          shared_ptr<Transcriber> _transcriber,
          shared_ptr<ImageTranscriber> _imageTranscriber,
          shared_ptr<MotionEnactor> _enactor,
          shared_ptr<Lights> _lights,
          shared_ptr<Speech> _speech)
    :     profiler(_profiler),
          sensors(_sensors),
          guardian(guardian),
          transcriber(_transcriber),
          imageTranscriber(_imageTranscriber),
          enactor(_enactor),
          lights(_lights),
          speech(_speech)
{

#ifdef USE_TIME_PROFILING
    profiler->profiling = true;
    profiler->profileFrames(1400);
#endif

    // give python a pointer to the sensors structure. Method defined in
    // Sensors.h
    set_sensors_pointer(sensors);

    imageTranscriber->setSubscriber(this);

    pose = shared_ptr<NaoPose> (new NaoPose(sensors));

    // initialize core processing modules
#ifdef USE_MOTION
    motion = shared_ptr<Motion> (new Motion(enactor, sensors, pose));
    guardian->setMotionInterface(motion->getInterface());
#endif
    // initialize python roboguardian module.
    // give python a pointer to the guardian. Method defined in PyRoboguardian.h
    set_guardian_pointer(guardian);
    set_lights_pointer(_lights);
    set_speech_pointer(_speech);

    vision = shared_ptr<Vision> (new Vision(pose));

    set_vision_pointer(vision);

    comm = shared_ptr<Comm> (new Comm(sensors, vision));

    memory = shared_ptr<Memory> (new Memory(vision, sensors));

    loggingBoard = shared_ptr<LoggingBoard> (new LoggingBoard(memory));
    set_logging_board_pointer(loggingBoard);
    memory->addSubscriber(loggingBoard.get());

#ifdef USE_MEMORY
    loggingBoard->newIOProvider(IOProviderFactory::newAllObjectsProvider());
#endif

#ifdef USE_NOGGIN
    noggin = shared_ptr<Noggin> (new Noggin(vision, comm, guardian, sensors,
                                            loggingBoard,
                                            motion->getInterface()));
#endif// USE_NOGGIN
}

Man::~Man ()
{
  cout << "Man destructor" << endl;
}

void Man::startSubThreads() {

#ifdef DEBUG_MAN_THREADING
    cout << "Man starting" << endl;
#endif

    if (comm->start() != 0)
        cerr << "Comm failed to start" << endl;

#ifdef USE_MOTION
    // Start Motion thread (it handles its own threading
    if (motion->start() != 0)
        cerr << "Motion failed to start" << endl;
#endif

    //  CALLGRIND_START_INSTRUMENTATION;
    //  CALLGRIND_TOGGLE_COLLECT;
}

void Man::stopSubThreads() {

#ifdef DEBUG_MAN_THREADING
    cout << "Man stopping: " << endl;
#endif

#ifdef USE_MOTION
    motion->stop();
    motion->waitForThreadToFinish();
#endif

    //TODO: fix this from hanging
    comm->stop();
    comm->waitForThreadToFinish();
    // @jfishman - tool will not exit, due to socket blocking
    //comm->getTOOLTrigger()->await_off();
}

void
Man::processFrame ()
{

#ifdef USE_VISION
    // Need to lock image and vision angles for duration of
    // vision processing to ensure consistency.
    sensors->lockImage();
#ifdef USE_MEMORY
    // TODO: this is temporarily here
//    loggingBoard->log(MIMAGE_ID);
#endif
    PROF_ENTER(P_VISION);
    vision->notifyImage(sensors->getImage());
    PROF_EXIT(P_VISION);
    sensors->releaseImage();
#endif
#ifdef USE_MEMORY
    memory->updateVision();
    loggingBoard->log(MVISION_ID);
#endif
#ifdef USE_NOGGIN
    noggin->runStep();
#endif

    PROF_ENTER(P_LIGHTS);
    lights->sendLights();
    PROF_EXIT(P_LIGHTS);
}


void Man::notifyNextVisionImage() {

  transcriber->postVisionSensors();

  // Process current frame
  processFrame();

  // Make sure messages are printed
  fflush(stdout);
}
