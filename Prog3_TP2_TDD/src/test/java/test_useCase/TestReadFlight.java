package test_useCase;

import com.domain.*;
import com.exception.exceptionsAirline.ExceptionAirline;
import com.exception.exceptionsAirport.ExceptionAirport;
import com.exception.exceptionsFlight.ExceptionFlight;
import com.exception.exceptionsFlight.ExceptionFlightDontExist;
import com.exception.exceptionsPilot.ExceptionPilot;
import com.exception.exceptionsPlane.ExceptionPlane;
import com.exception.exceptionsPlane.ExceptionPlaneDontExist;
import com.repository.IReadRepoFlight;
import com.repository.IReadRepoPlane;
import com.useCase.ReadFlightUseCase;
import com.useCase.ReadPlaneUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class TestReadFlight {
    @Mock
    IReadRepoFlight iReadRepoFlight;

    @Test
    public void test01_readFlight_planeFlight() throws ExceptionFlight, ExceptionAirport, ExceptionAirline, ExceptionPilot, ExceptionPlane {
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


        Mockito.when(iReadRepoFlight.findFlightByCodeFly("AR 1234")).thenReturn(theSameFlight);
        ReadFlightUseCase readFlightUseCase = new ReadFlightUseCase(iReadRepoFlight);
        assertEquals(theSameFlight,readFlightUseCase.readFlight("AR 1234"));
    }

    @Test
    public void test02_readFlight_flightDontExist() throws ExceptionFlight {

        Mockito.when(iReadRepoFlight.findFlightByCodeFly("AR 1234")).thenReturn(null);
        ReadFlightUseCase readFlightUseCase = new ReadFlightUseCase(iReadRepoFlight);
        assertThrows(ExceptionFlightDontExist.class, () -> {
            readFlightUseCase.readFlight("AR 1234");
        });
    }
}
