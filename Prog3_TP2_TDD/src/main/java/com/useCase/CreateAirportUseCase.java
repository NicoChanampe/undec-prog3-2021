package com.useCase;

import com.domain.Airport;
import com.exception.exceptionsAirport.ExceptionAirport;
import com.exception.exceptionsAirport.ExceptionAirportExist;
import com.repository.ICreateRepoAirport;

public class CreateAirportUseCase {
    ICreateRepoAirport iCreateAirport;

    public CreateAirportUseCase(ICreateRepoAirport iCreateRepoAirport){
        this.iCreateAirport = iCreateRepoAirport;
    }


    public boolean loadAirport(Airport newAirport) throws ExceptionAirport {
        if(existAirport(newAirport.getCodeIATA()))
            throw new ExceptionAirportExist("The airport exist");
        return iCreateAirport.saveAirport(newAirport);
    }

    private boolean existAirport(String cIATAcode) throws ExceptionAirport {
        Airport searchingAirport = iCreateAirport.findAirportByCodeIata(cIATAcode);
        return searchingAirport != null;
    }
}
