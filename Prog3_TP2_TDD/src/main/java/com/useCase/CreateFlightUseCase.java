package com.useCase;

import com.domain.Flight;
import com.exception.exceptionsFlight.ExceptionFlight;
import com.exception.exceptionsFlight.ExceptionFlightExist;
import com.repository.ICreateRepoFlight;

public class CreateFlightUseCase {
    ICreateRepoFlight iCreateFlight;

    public CreateFlightUseCase(ICreateRepoFlight iCreateRepoFlight){
        this.iCreateFlight = iCreateRepoFlight;
    }


    public boolean loadFlight(Flight theFlight) throws ExceptionFlight{
        if(existFligh(theFlight.getCodeFly()))
            throw new ExceptionFlightExist("The flight exist");
        return iCreateFlight.saveFlight(theFlight);
    }

    private boolean existFligh(String cCodeFly){
        Flight searchingFlight = iCreateFlight.findFlightByCodeFly(cCodeFly);
        return searchingFlight != null;
    }
}
