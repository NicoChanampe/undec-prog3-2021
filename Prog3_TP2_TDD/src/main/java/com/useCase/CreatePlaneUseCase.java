package com.useCase;

import com.domain.Plane;
import com.exception.exceptionsPlane.ExceptionPlane;
import com.exception.exceptionsPlane.ExceptionPlaneExist;
import com.repository.ICreateRepoPlane;

public class CreatePlaneUseCase {
    ICreateRepoPlane iCreatePlane;

    public CreatePlaneUseCase(ICreateRepoPlane iCreateRepoPlane){
        this.iCreatePlane = iCreateRepoPlane;
    }


    public boolean loadPlane(Plane planeLoad) throws ExceptionPlane {

        if(planeExist(planeLoad.getLicensePlate())) {
            throw new ExceptionPlaneExist("The plane Exist");
        }

        return iCreatePlane.savePlane(planeLoad);
    }

    private boolean planeExist(String cLicensePlate){
        Plane searchingPlane = iCreatePlane.findPlaneByLicensePlate(cLicensePlate);
        return searchingPlane != null;
    }
}
