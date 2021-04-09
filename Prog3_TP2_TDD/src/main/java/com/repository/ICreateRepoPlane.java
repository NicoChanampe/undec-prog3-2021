package com.repository;

import com.domain.Plane;

public interface ICreateRepoPlane {
    boolean savePlane(Plane myPlane);

    Plane findPlaneByLicensePlate(String pLicensePlate);
}
