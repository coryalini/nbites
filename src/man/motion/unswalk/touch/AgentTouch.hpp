#pragma once

#include <semaphore.h>
#include "Touch.hpp"
#include "libagent/AgentData.hpp"

class AgentTouch : Touch {
   public:
      explicit AgentTouch();
      ~AgentTouch();
      SensorValues getSensors(UNSWKinematics &kinematics);
      bool getStanding();
      ButtonPresses getButtons();

   private:
      int shared_fd;
      AgentData* shared_data;
      sem_t* semaphore;
};
