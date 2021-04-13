package com.repository;

import com.domain.Airport;

public interface IReadRepoAirport {

    Airport findAirportByIata(String cIataCode);
}
