package com.repository;

import com.domain.Plane;

public interface IReadRepoPlane {
    Plane findPlaneByLicensePlate(String cLicensePlate);
}
