package com.domain;

import java.time.LocalDate;
import com.exception.exceptionsPilot.*;

public class Pilot {
    private String cuil;
    private Integer bundle;
    private String lastName;
    private String name;
    private LocalDate dateBorn;

    public static Pilot factoryPilot(String pcuil,Integer pbundle,String plastName,String pname,LocalDate pdateBorn) throws ExceptionPilot{
        if(pcuil == null)
            throw new ExceptionPilotNullCuil("The cuil must not be null");
        if(plastName == null)
            throw new ExceptionPilotNullLastName("The last name must not be null");
        if(pname == null)
            throw new ExceptionPilotNullName("The name must not be null");
        if(pcuil == "")
            throw new ExceptionPilotEmptyCuil("The cuil must not be empty");
        if(pbundle == null)
            throw new ExceptionPilotNullBundle("The bundle must not be null");
        if(plastName == "")
            throw new ExceptionPilotEmptyLastName("The last name must not be empty");
        if(pname == "")
            throw new ExceptionPilotEmptyName("The name must not be empty");
        if(pbundle == 0)
            throw new ExceptionPilotBundleCero("The bundle can not be 0");
        if(pbundle < 0)
            throw new ExceptionPilotBundleNegative("The bundle can not be negative");
        if(cuilWrong(pcuil))
            throw new ExceptionPilotWrongCuil("The cuil must be in this format xx-xxxxxxxx-xx");
        return new Pilot(pcuil,pbundle,plastName,pname,pdateBorn);
    }

    private static boolean cuilWrong(String pcuil){
        if(pcuil.length() != 13)
            return true;

        String firstLine = pcuil.substring(2,3);
        String secondLine = pcuil.substring(11,12);

        if (!firstLine.equals("-") || !secondLine.equals("-"))
            return true;


        for(int i = 0;i<pcuil.length();i++){
            if(i != 2 && i != 11)
                if(pcuil.codePointAt(i) < 48 || pcuil.codePointAt(i) > 57)
                    return true;
        }
        return false;
    }
    private Pilot(String pcuil,Integer pbundle,String plastName,String pname,LocalDate pdateBorn){
        this.cuil = pcuil;
        this.bundle = pbundle;
        this.lastName = plastName;
        this.name = pname;
        this.dateBorn = pdateBorn;
    }

    public String getCuil() {
        return cuil;
    }

    public Integer getBundle() {
        return bundle;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateBorn() {
        return dateBorn;
    }

    public void setCuil(String pcuil) {
        this.cuil = pcuil;
    }

    public void setBundle(Integer pbundle) {
        this.bundle = pbundle;
    }

    public void setLastName(String plastName) {
        this.lastName = plastName;
    }

    public void setName(String pname) {
        this.name = pname;
    }

    public void setDateBorn(LocalDate pdateBorn) {
        this.dateBorn = pdateBorn;
    }
}
