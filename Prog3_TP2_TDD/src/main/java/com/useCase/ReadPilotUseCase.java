package com.useCase;

import com.domain.Pilot;
import com.exception.exceptionsPilot.ExceptionPilot;
import com.exception.exceptionsPilot.ExceptionPilotDontExist;
import com.repository.IReadRepoPilot;

public class ReadPilotUseCase {
    public IReadRepoPilot iReadPilot;

    public ReadPilotUseCase(IReadRepoPilot iReadRepoPilot) {
        this.iReadPilot = iReadRepoPilot;
    }

    public Pilot readPilot(String cCuil) throws ExceptionPilot {
        Pilot searchPilot = iReadPilot.findPilotByCuil(cCuil);

        if(searchPilot == null)
            throw new ExceptionPilotDontExist("The pilot not exist in database");

        return searchPilot;
    }
}
