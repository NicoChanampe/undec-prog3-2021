package com.repository;

import com.domain.Airline;

public interface ICreateRepoAirline {

    public boolean saveAirline(Airline newAirline);

    public Airline findAirlineByCuit(String cCuit);
}
