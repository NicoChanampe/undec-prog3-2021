package com.useCase;

import com.domain.Pilot;
import com.exception.exceptionsPilot.*;
import com.repository.ICreateRepoPilot;

public class CreatePilotUseCase {
    private ICreateRepoPilot iCreatePilot;

    public CreatePilotUseCase(ICreateRepoPilot iCreateRepoPilot){
        this.iCreatePilot = iCreateRepoPilot;
    }

    public boolean loadPilot(Pilot pilotLoad) throws ExceptionPilot {

        if(pilotExist(pilotLoad.getCuil()))
            throw new ExceptionPilotExist("The pilot exist");

        return iCreatePilot.savePilot(pilotLoad);
    }

    private boolean pilotExist(String pcuil) {
        Pilot searchingPilot = iCreatePilot.findPilotByCuil(pcuil);
        if (searchingPilot == null)
            return false;
        else
            return true;
    }
}
