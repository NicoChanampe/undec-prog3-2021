package com.useCase;

import com.domain.Flight;
import com.exception.exceptionsFlight.ExceptionFlight;
import com.exception.exceptionsFlight.ExceptionFlightDontExist;
import com.repository.IReadRepoFlight;

public class ReadFlightUseCase {
    IReadRepoFlight iReadFlight;

    public ReadFlightUseCase(IReadRepoFlight iReadRepoFlight) {
        this.iReadFlight = iReadRepoFlight;
    }


    public Flight readFlight(String cCodeFly) throws ExceptionFlight {
        Flight searchingFlight = iReadFlight.findFlightByCodeFly(cCodeFly);
        if (searchingFlight == null)
            throw new ExceptionFlightDontExist("the flight not be charge in database");
        return searchingFlight;
    }
}
