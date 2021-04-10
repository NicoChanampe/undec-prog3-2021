package test_useCase;

import com.domain.*;
import com.exception.exceptionsAirline.ExceptionAirline;
import com.exception.exceptionsAirport.ExceptionAirport;
import com.exception.exceptionsFlight.ExceptionFlight;
import com.exception.exceptionsFlight.ExceptionFlightExist;
import com.exception.exceptionsPilot.ExceptionPilot;
import com.exception.exceptionsPlane.ExceptionPlane;
import com.repository.ICreateRepoFlight;
import com.useCase.CreateFlightUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class TestCreateNewFlight {
    @Mock
    ICreateRepoFlight iCreateRepoFlight;

    @Test
    public void test01_createFlight_flightDoesntExist_loadFlightCorrectly() throws ExceptionFlight, ExceptionAirport, ExceptionAirline, ExceptionPilot, ExceptionPlane {
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

        Mockito.when(iCreateRepoFlight.saveFlight(myFlight)).thenReturn(true);
        CreateFlightUseCase createFlightUseCase = new CreateFlightUseCase(iCreateRepoFlight);
        assertTrue(createFlightUseCase.loadFlight(myFlight));
    }

    @Test
    public void test02_createFlight_flightDoesExist_ExceptionFlightExist() throws ExceptionFlight, ExceptionAirport, ExceptionAirline, ExceptionPilot, ExceptionPlane {
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


        Flight theSameFlight = Flight.factoryFlight("AR 1234",departure,arrival,depatureAirport,arrivalAirport,plane,commandant,copilot,airline);

        Mockito.when(iCreateRepoFlight.findFlightByCodeFly("AR 1234")).thenReturn(theSameFlight);
        CreateFlightUseCase createFlightUseCase = new CreateFlightUseCase(iCreateRepoFlight);
        assertThrows(ExceptionFlightExist.class, () -> {
            createFlightUseCase.loadFlight(theSameFlight);
        });
    }
}
