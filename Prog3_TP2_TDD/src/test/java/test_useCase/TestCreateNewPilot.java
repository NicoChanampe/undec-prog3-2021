package test_useCase;

import com.domain.Pilot;
import com.exception.exceptionsPilot.*;
import com.repository.ICreateRepoPilot;
import com.useCase.CreatePilotUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.AssertTrue.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class TestCreateNewPilot {
    @Mock
    ICreateRepoPilot iCreateRepoPilot;

    @Test
    public void test01_createAirline_AirlineDontExist_AirlineLoadedCorrectly() throws ExceptionPilot {

        LocalDate dateBorn = LocalDate.parse("1994-01-20");
        Pilot newPilot = Pilot.factoryPilot("30-64140555-4",120,"Cardozo","Franco David",dateBorn);

        Mockito.when(iCreateRepoPilot.savePilot(newPilot)).thenReturn(true);
        CreatePilotUseCase createPilotUseCase = new CreatePilotUseCase(iCreateRepoPilot);
        assertTrue(createPilotUseCase.loadPilot(newPilot));
    }

    @Test
    public void test02_createAirline_AirlineDoesExist_ExceptionAirlineExist() throws ExceptionPilot {

        LocalDate dateBorn = LocalDate.parse("1994-01-20");
        Pilot theSamePilot = Pilot.factoryPilot("30-64140555-4",120,"Cardozo","Franco David",dateBorn);

        Mockito.when(iCreateRepoPilot.findPilotByCuil("30-64140555-4")).thenReturn(theSamePilot);
        CreatePilotUseCase createPilotUseCase = new CreatePilotUseCase(iCreateRepoPilot);
        assertThrows(ExceptionPilotExist.class, () -> {
            createPilotUseCase.loadPilot(theSamePilot);
        });
    }
}
