package com.repository;

import com.domain.Pilot;

public interface ICreateRepoPilot {
    boolean savePilot(Pilot newPilot);

    Pilot findPilotByCuil(String pcuil);
}
