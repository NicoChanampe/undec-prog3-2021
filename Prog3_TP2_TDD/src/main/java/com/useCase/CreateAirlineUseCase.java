package com.useCase;

import com.domain.Airline;
import com.exception.exceptionsAirline.ExceptionAirline;
import com.exception.exceptionsAirline.ExceptionAirlineExist;
import com.repository.ICreateRepoAirline;

public class CreateAirlineUseCase {
    ICreateRepoAirline iCreateAirline;

    public CreateAirlineUseCase(ICreateRepoAirline iCreateRepoAirline){
        this.iCreateAirline = iCreateRepoAirline;
    }


    public boolean loadAirline(Airline newAirline) throws ExceptionAirline {
        if(existAirline(newAirline.getCuit()))
            throw new ExceptionAirlineExist("The airline exist");
        return iCreateAirline.saveAirline(newAirline);
    }

    private boolean existAirline(String cCuit){
        Airline searchingAirline = iCreateAirline.findAirlineByCuit(cCuit);
        return searchingAirline != null;
    }
}
