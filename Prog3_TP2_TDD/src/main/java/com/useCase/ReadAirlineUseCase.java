package com.useCase;

import com.domain.Airline;
import com.exception.exceptionsAirline.ExceptionAirline;
import com.exception.exceptionsAirline.ExceptionAirlineDontExist;
import com.repository.IReadRepoAirline;

public class ReadAirlineUseCase {
    public IReadRepoAirline iReadAirline;

    public ReadAirlineUseCase(IReadRepoAirline iReadRepoAirline) {
        this.iReadAirline = iReadRepoAirline;
    }


    public Airline readAirline(String cCuil) throws ExceptionAirline {
        Airline searchingAirline = iReadAirline.findAirlineByCuit(cCuil);
        if(searchingAirline == null)
            throw new ExceptionAirlineDontExist("the airline don't exist in database");
        return searchingAirline;
    }
}
