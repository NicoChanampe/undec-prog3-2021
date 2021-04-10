package com.repository;

import com.domain.Flight;

public interface ICreateRepoFlight {
    public boolean saveFlight(Flight myFlight);

    public Flight findFlightByCodeFly(String cCodeFly);
}
