package com.repository;

import com.domain.Airport;

public interface ICreateRepoAirport {
    public boolean saveAirport(Airport myAirport);


    public Airport findAirportByCodeIata(String cIATACode);
}
