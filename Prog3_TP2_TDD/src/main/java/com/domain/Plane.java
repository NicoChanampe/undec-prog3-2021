package com.domain;

import java.util.Objects;
import com.exception.exceptionsPlane.*;

public class Plane {
    private String licensePlate;
    private String model;
    private Integer capacity;
    private Integer yearConstruction;

    public static Plane factoryPlane(String plicensePlate, String pmodel, Integer pcapacity, Integer pyearConstruction) throws ExceptionPlane{
        if(plicensePlate == null)
            throw new ExceptionPlaneNullLicensePlate("The license plate must not be null");
        if(plicensePlate == "")
            throw new ExceptionPlaneEmptyLicensePlate("The license plate must not be empty");
        if(licensePlateWrong(plicensePlate))
            throw new ExceptionPlaneWrongLicensePlate("The license plate is misspelled");
        if(pmodel == "")
            throw new ExceptionPlaneEmptyModel("The model must not be empty");
        if(pmodel == null)
            throw new ExceptionPlaneNullModel("The model must not be null");
        if(pyearConstruction < 0)
            throw new ExceptionPlaneYearNegative("The year must be positive");
        if(pyearConstruction < 1990)
            throw new ExceptionPlaneYearSmall("The year must not be less than 1990");
        return new Plane(plicensePlate,pmodel,pcapacity,pyearConstruction);
    }

    private Plane(String plicensePlate, String pmodel, Integer pcapacity, Integer pyearConstruction){
        this.licensePlate = plicensePlate;
        this.model = pmodel;
        this.capacity = pcapacity;
        this.yearConstruction = pyearConstruction;
    }

    public static Plane factoryPlane(String plicensePlate, String pmodel, Integer pyearConstruction) throws ExceptionPlane{
        if(plicensePlate == null)
            throw new ExceptionPlaneNullLicensePlate("The license plate must not be null");
        if(plicensePlate == "")
            throw new ExceptionPlaneEmptyLicensePlate("The license plate must not be empty");
        if(licensePlateWrong(plicensePlate))
            throw new ExceptionPlaneWrongLicensePlate("The license plate is misspelled");
        if(pmodel == null)
            throw new ExceptionPlaneNullModel("The model must not be null");
        if (pmodel == "")
            throw new ExceptionPlaneEmptyModel("The model must not be empty");
        if(pyearConstruction < 0)
            throw new ExceptionPlaneYearNegative("The year must be positive");
        if(pyearConstruction < 1990)
            throw new ExceptionPlaneYearSmall("The year must not be less than 1990");
        return new Plane(plicensePlate,pmodel,pyearConstruction);
    }

    private static boolean licensePlateWrong(String plicensePlate) {
        String sigle = plicensePlate.substring(2, 3);

        if (!sigle.equals("-"))
            return true;

        if (!plicensePlate.equals(plicensePlate.toUpperCase()))
            return true;

        if(plicensePlate.length() != 6)
            return true;

        for(int i=0;i<plicensePlate.length();i++){
            if(i != 2){
                if(plicensePlate.codePointAt(i) < 65 || plicensePlate.codePointAt(i) > 90)
                    return true;
            }
        }
        return false;
    }

    private Plane(String plicensePlate, String pmodel, Integer pyearConstruction){
        this.licensePlate = plicensePlate;
        this.model = pmodel;
        this.capacity = 1;
        this.yearConstruction = pyearConstruction;
    }

    public String getLicensePlate(){
        return licensePlate;
    }

    public String getModel(){
        return model;
    }
    public Integer getCapacity(){
        return capacity;
    }
    public Integer getYearConstruction(){
        return yearConstruction;
    }

    public void setLicensePlate(String newLicense) {
        this.licensePlate = newLicense;
    }

    public void setModel(String newModel) {
        this.model = newModel;
    }

    public void setCapacity(Integer newCapacity) {
        this.capacity = newCapacity;
    }

    public void setYearConstruction(Integer pyearConstruction) {
        this.yearConstruction = pyearConstruction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plane plane = (Plane) o;
        return licensePlate.equals(plane.licensePlate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(licensePlate);
    }
}
