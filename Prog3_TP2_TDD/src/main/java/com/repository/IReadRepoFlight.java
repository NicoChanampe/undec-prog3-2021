package com.repository;

import com.domain.Flight;

public interface IReadRepoFlight {

    Flight findFlightByCodeFly(String cCode);
}
