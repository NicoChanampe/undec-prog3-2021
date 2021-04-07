package com.domain;

import com.exception.exceptionsAirport.*;
public class Airport {
    private String codeIATA;
    private String name;
    private String city;
    private Integer codePostal;

    public static Airport factoryAirport (String pcodeIATA, String pname, String pcity, Integer pcodePostal) throws ExceptionAirport{

        if(pcodeIATA == null)
            throw new ExceptionAirportCodeIATANull("The IATA code must not be null");
        if(pname == null)
            throw new ExceptionAirportNameNull("The name must not be null");
        if(pcity == null)
            throw new ExceptionAirportCityNull("The city must not be null");
        if(pcodePostal == null)
            throw new ExceptionAirportCodePostalNull("The postal code must not be null");
        if(pcodeIATA == "")
            throw new ExceptionAirportCodeIATAEmpty("The IATA code must not be empty");
        if(pname == "")
            throw new ExceptionAirportNameEmpty("The name must not be empty");
        if(pcity == "")
            throw new ExceptionAirportCityEmpty("The city must not be empty");
        if(pcodePostal <= 0)
            throw new ExceptionAirportCodePostalWrong("The postal code must be greatest of 0");
        if(codeIataWrong(pcodeIATA))
            throw new ExceptionAirportCodeIATAWrong("The code is tree letters Mayus");
        return new Airport(pcodeIATA,pname,pcity,pcodePostal);
    }

    private static boolean codeIataWrong(String pcodeIATA){
        if(pcodeIATA.length() != 3)
            return true;
        if (!pcodeIATA.equals(pcodeIATA.toUpperCase()))
            return true;
        return false;
    }

    private Airport(String pcodeIATA, String pname, String pcity, Integer pcodePostal) {
        this.codeIATA = pcodeIATA;
        this.name = pname;
        this.city = pcity;
        this.codePostal = pcodePostal;
    }

    public String getCodeIATA() {
        return codeIATA;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public Integer getCodePostal() {
        return codePostal;
    }

    public void setCodeIATA(String codeIATA) {
        this.codeIATA = codeIATA;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCodePostal(Integer codePostal) {
        this.codePostal = codePostal;
    }
}
