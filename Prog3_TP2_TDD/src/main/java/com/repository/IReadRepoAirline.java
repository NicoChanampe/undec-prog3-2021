package com.repository;

import com.domain.Airline;

public interface IReadRepoAirline {

    Airline findAirlineByCuit(String cCuit);
}
