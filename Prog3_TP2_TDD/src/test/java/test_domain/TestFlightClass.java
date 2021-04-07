package test_domain;

import com.domain.*;
import com.exception.exceptionsAirline.ExceptionAirline;
import com.exception.exceptionsAirport.ExceptionAirport;
import com.exception.exceptionsFlight.*;
import com.exception.exceptionsPilot.ExceptionPilot;
import com.exception.exceptionsPlane.ExceptionPlane;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

public class TestFlightClass {
    @Test
    public void test01_GenerateFlightObjectCorrectly() throws ExceptionAirport, ExceptionAirline, ExceptionPlane, ExceptionPilot, ExceptionFlight {
        LocalDate dateCommandant = LocalDate.parse("1990-11-07");
        LocalDate dateCopilot = LocalDate.parse("1997-08-21");
        LocalDate data = LocalDate.parse("2015-04-02");
        Airport depatureAirport = Airport.factoryAirport("RES","Aeropuerto Internacional de Resistencia","Resistencia",3500);
        Airport arrivalAirport = Airport.factoryAirport("COR","Aeropuerto Internacional Ingeniero Aeronautico Ambrosio Travella","Cordoba",5000);
        Plane plane = Plane.factoryPlane("LV-FNI","Airbus A330-200",264,2015);
        Pilot commandant = Pilot.factoryPilot("26-35489652-6",666,"Reyna","Maximiliano",dateCommandant);
        Pilot copilot = Pilot.factoryPilot("19-38654881-3",169,"Luna","Cin Woo",dateCopilot);
        Airline airline = Airline.factoryAirline("30-64140555-4","AR","Aerolineas Argentinas",data);

        LocalDateTime departure = LocalDateTime.parse("2018-10-10T11:25");
        LocalDateTime arrival = LocalDateTime.parse("2018-10-10T12:30");


        Flight myFlight = Flight.factoryFlight("AR 1234",departure,arrival,depatureAirport,arrivalAirport,plane,commandant,copilot,airline);
        assertNotNull(myFlight);
    }

    @Test
    public void test02_FlightCreation_departureGreaterThanArrival()throws ExceptionAirport,ExceptionAirline,ExceptionPlane,ExceptionPilot{
        LocalDate dateCommandant = LocalDate.parse("1990-11-07");
        LocalDate dateCopilot = LocalDate.parse("1997-08-21");
        LocalDate data = LocalDate.parse("2015-04-02");
        Airport depatureAirport = Airport.factoryAirport("RES","Aeropuerto Internacional de Resistencia","Resistencia",3500);
        Airport arrivalAirport = Airport.factoryAirport("COR","Aeropuerto Internacional Ingeniero Aeronautico Ambrosio Travella","Cordoba",5000);
        Plane plane = Plane.factoryPlane("LV-FNI","Airbus A330-200",264,2015);
        Pilot commandant = Pilot.factoryPilot("26-35489652-6",666,"Reyna","Maximiliano",dateCommandant);
        Pilot copilot = Pilot.factoryPilot("19-38654881-3",169,"Luna","Cin Woo",dateCopilot);
        Airline airline = Airline.factoryAirline("30-64140555-4","AR","Aerolineas Argentinas",data);

        LocalDateTime arrival = LocalDateTime.parse("2018-10-10T11:25");
        LocalDateTime departure = LocalDateTime.parse("2018-10-10T12:30");


        assertThrows(ExceptionFlightDepartureGreaterArrival.class,() -> {
            Flight myFlight = Flight.factoryFlight("AR 1234",departure,arrival,depatureAirport,arrivalAirport,plane,commandant,copilot,airline);
        });
    }

    @Test
    public void test03_FlightCreation_codeFlyNullOrEmpty()throws ExceptionAirport,ExceptionAirline,ExceptionPlane,ExceptionPilot{
        LocalDate dateCommandant = LocalDate.parse("1990-11-07");
        LocalDate dateCopilot = LocalDate.parse("1997-08-21");
        LocalDate data = LocalDate.parse("2015-04-02");
        Airport depatureAirport = Airport.factoryAirport("RES","Aeropuerto Internacional de Resistencia","Resistencia",3500);
        Airport arrivalAirport = Airport.factoryAirport("COR","Aeropuerto Internacional Ingeniero Aeronautico Ambrosio Travella","Cordoba",5000);
        Plane plane = Plane.factoryPlane("LV-FNI","Airbus A330-200",264,2015);
        Pilot commandant = Pilot.factoryPilot("26-35489652-6",666,"Reyna","Maximiliano",dateCommandant);
        Pilot copilot = Pilot.factoryPilot("19-38654881-3",169,"Luna","Cin Woo",dateCopilot);
        Airline airline = Airline.factoryAirline("30-64140555-4","AR","Aerolineas Argentinas",data);

        LocalDateTime arrival = LocalDateTime.parse("2018-10-10T11:25");
        LocalDateTime departure = LocalDateTime.parse("2018-10-10T12:30");

        assertThrows(ExceptionFlightCodeFlyNullOrEmpty.class,() -> {
            Flight myFlight = Flight.factoryFlight("",departure,arrival,depatureAirport,arrivalAirport,plane,commandant,copilot,airline);
        });

        assertThrows(ExceptionFlightCodeFlyNullOrEmpty.class,() -> {
            Flight myFlight = Flight.factoryFlight(null,departure,arrival,depatureAirport,arrivalAirport,plane,commandant,copilot,airline);
        });
    }

    @Test
    public void test04_FlightCreation_codeFlyWrong()throws ExceptionAirport,ExceptionAirline,ExceptionPlane,ExceptionPilot{
        LocalDate dateCommandant = LocalDate.parse("1990-11-07");
        LocalDate dateCopilot = LocalDate.parse("1997-08-21");
        LocalDate data = LocalDate.parse("2015-04-02");
        Airport depatureAirport = Airport.factoryAirport("RES","Aeropuerto Internacional de Resistencia","Resistencia",3500);
        Airport arrivalAirport = Airport.factoryAirport("COR","Aeropuerto Internacional Ingeniero Aeronautico Ambrosio Travella","Cordoba",5000);
        Plane plane = Plane.factoryPlane("LV-FNI","Airbus A330-200",264,2015);
        Pilot commandant = Pilot.factoryPilot("26-35489652-6",666,"Reyna","Maximiliano",dateCommandant);
        Pilot copilot = Pilot.factoryPilot("19-38654881-3",169,"Luna","Cin Woo",dateCopilot);
        Airline airline = Airline.factoryAirline("30-64140555-4","AR","Aerolineas Argentinas",data);

        LocalDateTime arrival = LocalDateTime.parse("2018-10-10T11:25");
        LocalDateTime departure = LocalDateTime.parse("2018-10-10T12:30");

        assertThrows(ExceptionFlightCodeFlyWrong.class,() -> {
            Flight myFlight = Flight.factoryFlight("AR 13f3",departure,arrival,depatureAirport,arrivalAirport,plane,commandant,copilot,airline);
        });

        assertThrows(ExceptionFlightCodeFlyWrong.class,() -> {
            Flight myFlight = Flight.factoryFlight("Ar 1234",departure,arrival,depatureAirport,arrivalAirport,plane,commandant,copilot,airline);
        });

        assertThrows(ExceptionFlightCodeFlyWrong.class,() -> {
            Flight myFlight = Flight.factoryFlight("A 1234",departure,arrival,depatureAirport,arrivalAirport,plane,commandant,copilot,airline);
        });

        assertThrows(ExceptionFlightCodeFlyWrong.class,() -> {
            Flight myFlight = Flight.factoryFlight("AR 13",departure,arrival,depatureAirport,arrivalAirport,plane,commandant,copilot,airline);
        });

        assertThrows(ExceptionFlightCodeFlyWrong.class,() -> {
            Flight myFlight = Flight.factoryFlight("AR 12345",departure,arrival,depatureAirport,arrivalAirport,plane,commandant,copilot,airline);
        });

        assertThrows(ExceptionFlightCodeFlyWrong.class,() -> {
            Flight myFlight = Flight.factoryFlight("ARA 1234",departure,arrival,depatureAirport,arrivalAirport,plane,commandant,copilot,airline);
        });
    }

    @Test
    public void test05_FlightCreation_codeFlyDistinctCodeIataAirline()throws ExceptionAirport,ExceptionAirline,ExceptionPlane,ExceptionPilot{
        LocalDate dateCommandant = LocalDate.parse("1990-11-07");
        LocalDate dateCopilot = LocalDate.parse("1997-08-21");
        LocalDate data = LocalDate.parse("2015-04-02");
        Airport depatureAirport = Airport.factoryAirport("RES","Aeropuerto Internacional de Resistencia","Resistencia",3500);
        Airport arrivalAirport = Airport.factoryAirport("COR","Aeropuerto Internacional Ingeniero Aeronautico Ambrosio Travella","Cordoba",5000);
        Plane plane = Plane.factoryPlane("LV-FNI","Airbus A330-200",264,2015);
        Pilot commandant = Pilot.factoryPilot("26-35489652-6",666,"Reyna","Maximiliano",dateCommandant);
        Pilot copilot = Pilot.factoryPilot("19-38654881-3",169,"Luna","Cin Woo",dateCopilot);
        Airline airline = Airline.factoryAirline("30-64140555-4","AR","Aerolineas Argentinas",data);

        LocalDateTime arrival = LocalDateTime.parse("2018-10-10T11:25");
        LocalDateTime departure = LocalDateTime.parse("2018-10-10T12:30");

        assertThrows(ExceptionFlightCodeFlyDistinctCodeIataAirline.class,() -> {
            Flight myFlight = Flight.factoryFlight("AL 1234",departure,arrival,depatureAirport,arrivalAirport,plane,commandant,copilot,airline);
        });
    }
}
