package com.domain;

import com.exception.exceptionsFlight.*;

import java.time.LocalDateTime;

public class Flight {
    private String codeFly;
    private LocalDateTime departure;
    private LocalDateTime arrival;
    private Airport departureAirport;
    private Airport arrivalAirport;
    private Plane plane;
    private Pilot commandant;
    private Pilot copilot;
    private Airline airline;

    public static Flight factoryFlight(String codeFly, LocalDateTime departure, LocalDateTime arrival,
                                       Airport departureAirport, Airport arrivalAirport, Plane plane,
                                       Pilot commandant, Pilot copilot, Airline airline)throws ExceptionFlight {
        if(arrival.isBefore(departure))
            throw new ExceptionFlightDepartureGreaterArrival("The date of departure was less than date of arrival");
        if(codeFly == null)
            throw new ExceptionFlightCodeFlyNullOrEmpty("The code must not be null or empty");
        if (codeFly.equals(""))
            throw new ExceptionFlightCodeFlyNullOrEmpty("The code must not be null or empty");
        if(codeFlyWrong(codeFly))
            throw new ExceptionFlightCodeFlyWrong("The flight code is misspelled");
        if(!airline.getCodeIATA().equals(codeFly.substring(0, 2)))
            throw new ExceptionFlightCodeFlyDistinctCodeIataAirline("The flight code must be equals that IATA code of airline");
        return new  Flight(codeFly,departure,arrival,departureAirport,arrivalAirport,plane,commandant,copilot,airline);
    }

    private static boolean codeFlyWrong(String codeFly){
        String firstValor = codeFly.substring(0,2);
        String comparateFirstValor = firstValor.toUpperCase();

        if(codeFly.length() != 7)
            return true;

        String secondValor = codeFly.substring(2,6);
        if(firstValor != comparateFirstValor)
            return true;
        if(firstValor.codePointAt(0) < 65 || firstValor.codePointAt(0) > 90)
            return true;
        if(firstValor.codePointAt(1) < 65 || firstValor.codePointAt(1) > 90)
            return true;
        if(secondValor.codePointAt(0) != 32)
            return true;
        for(int i =1;i<secondValor.length();i++){
            if(secondValor.codePointAt(i) < 48 || secondValor.codePointAt(i) > 57)
                return true;
        }
        return false;
    }

    private Flight(String codeFly, LocalDateTime departure, LocalDateTime arrival, Airport departureAirport,
                   Airport arrivalAirport, Plane plane, Pilot commandant, Pilot copilot, Airline airline) {
        this.codeFly = codeFly;
        this.departure = departure;
        this.arrival = arrival;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.plane = plane;
        this.commandant = commandant;
        this.copilot = copilot;
        this.airline = airline;
    }

    public String getCodeFly() {
        return codeFly;
    }

    public LocalDateTime getDeparture() {
        return departure;
    }

    public LocalDateTime getArrival() {
        return arrival;
    }

    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public Airport getArrivalAirport() {
        return arrivalAirport;
    }

    public Plane getPlane() {
        return plane;
    }

    public Pilot getCommandant() {
        return commandant;
    }

    public Pilot getCopilot() {
        return copilot;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setCodeFly(String codeFly) {
        this.codeFly = codeFly;
    }

    public void setDeparture(LocalDateTime departure) {
        this.departure = departure;
    }

    public void setArrival(LocalDateTime arrival) {
        this.arrival = arrival;
    }

    public void setDepartureAirport(Airport departureAirport) {
        this.departureAirport = departureAirport;
    }

    public void setArrivalAirport(Airport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public void setCommandant(Pilot commandant) {
        this.commandant = commandant;
    }

    public void setCopilot(Pilot copilot) {
        this.copilot = copilot;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }
}
