package com.repository;

import com.domain.Pilot;

public interface IReadRepoPilot {

    Pilot findPilotByCuil(String cCuil);
}
