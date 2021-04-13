package com.useCase;

import com.domain.Airport;
import com.exception.exceptionsAirport.ExceptionAirport;
import com.exception.exceptionsAirport.ExceptionAirportDontExist;
import com.repository.IReadRepoAirport;

public class ReadAirportUseCase {
    IReadRepoAirport iReadAirport;

    public ReadAirportUseCase(IReadRepoAirport iReadRepoAirport) {
        this.iReadAirport = iReadRepoAirport;
    }


    public Airport readAirport(String cIataCode) throws ExceptionAirport {
        Airport searchingAirport = iReadAirport.findAirportByIata(cIataCode);
        if (searchingAirport == null)
            throw new ExceptionAirportDontExist("the airport don't exist in database");
        return searchingAirport;
    }
}
