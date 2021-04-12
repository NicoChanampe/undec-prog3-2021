package com.useCase;

import com.domain.Plane;
import com.exception.exceptionsPlane.ExceptionPlane;
import com.exception.exceptionsPlane.ExceptionPlaneDontExist;
import com.repository.IReadRepoPlane;

public class ReadPlaneUseCase {
    public IReadRepoPlane iReadPlane;

    public ReadPlaneUseCase(IReadRepoPlane iReadRepoPlane) {
        this.iReadPlane = iReadRepoPlane;
    }

    public Plane readPlane(String cLicensePlate) throws ExceptionPlane {
        Plane searchingPlane = iReadPlane.findPlaneByLicensePlate(cLicensePlate);
        if(searchingPlane == null)
            throw new ExceptionPlaneDontExist("the plane don't  exist in database");
        return searchingPlane;
    }
}
