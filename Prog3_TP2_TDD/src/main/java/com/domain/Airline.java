package com.domain;

import java.time.LocalDate;
import com.exception.exceptionsAirline.*;

public class Airline {
    private String cuit;
    private String codeIATA;
    private String name;
    private LocalDate dateStartActivities;

    public static Airline factoryAirline(String pcuit, String pcodeIATA, String pname, LocalDate pdateStartActivities) throws ExceptionAirline{
        if(pcuit == null)
            throw new ExceptionAirlineCuitNull("The cuit must not be null");
        if(pcodeIATA == null)
            throw new ExceptionAirlineCodeIataNull("The IATA code must not be null");
        if(pname == null)
            throw new ExceptionAirlineNameNull("The name must not be null");
        if(pcuit == "")
            throw new ExceptionAirlineCuitEmpty("The cuit must not be empty");
        if(pcodeIATA == "")
            throw new ExceptionAirlineCodeIataEmpty("The IATA code must not be empty");
        if(pname == "")
            throw new ExceptionAirlineNameEmpty("The name must not be empty");
        if(cuitWrong(pcuit))
            throw new ExceptionAirlineWrongCuit("The cuit must be xx-xxxxxxxx-x");
        if(codeIataWrong(pcodeIATA))
            throw new ExceptionAirlineCodeIATAWrong("The IATA code must be composed of two capital letters");

        return new Airline(pcuit,pcodeIATA,pname,pdateStartActivities);
    }

    private Airline(String pcuit, String pcodeIATA, String pname, LocalDate pdateStartActivities) {
        this.cuit = pcuit;
        this.codeIATA = pcodeIATA;
        this.name = pname;
        this.dateStartActivities = pdateStartActivities;
    }

    private static boolean cuitWrong(String pcuit){
        if(pcuit.length() != 13)
            return true;

        String firstLine = pcuit.substring(2,3);
        String secondLine = pcuit.substring(11,12);

        if (firstLine == "-" || secondLine == "_")
            return true;


        for(int i = 0;i<pcuit.length();i++){
            if(i != 2 && i != 11)
                if(pcuit.codePointAt(i) < 48 || pcuit.codePointAt(i) > 57)
                    return true;
        }
        return false;
    }

    private static boolean codeIataWrong(String codeIATA){
        if(codeIATA.length() != 2)
            return true;
        if (!codeIATA.equals(codeIATA.toUpperCase()))
            return true;
        return false;
    }

    public String getCuit() {
        return cuit;
    }

    public String getCodeIATA() {
        return codeIATA;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateStartActivities() {
        return dateStartActivities;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public void setCodeIATA(String codeIATA) {
        this.codeIATA = codeIATA;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateStartActivities(LocalDate dateStartActivities) {
        this.dateStartActivities = dateStartActivities;
    }
}
