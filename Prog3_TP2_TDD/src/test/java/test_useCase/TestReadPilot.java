package test_useCase;

import com.domain.Pilot;
import com.exception.exceptionsPilot.*;
import com.repository.IReadRepoPilot;
import com.useCase.ReadPilotUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class TestReadPilot {
    @Mock
    IReadRepoPilot iReadRepoPilot;

    @Test
    public void test01_readPilot_pilotExist() throws ExceptionPilot {
        LocalDate dateBorn = LocalDate.parse("1994-01-20");
        Pilot thePilot = Pilot.factoryPilot("30-64140555-4",120,"Cardozo","Franco David",dateBorn);

        Mockito.when(iReadRepoPilot.findPilotByCuil("30-64140555-4")).thenReturn(thePilot);
        ReadPilotUseCase readPilotUseCase = new ReadPilotUseCase(iReadRepoPilot);
        assertEquals(thePilot,readPilotUseCase.readPilot("30-64140555-4"));
    }

    @Test
    public void test02_readPilot_pilotDontExist() throws ExceptionPilot {

        Mockito.when(iReadRepoPilot.findPilotByCuil("30-64140555-4")).thenReturn(null);
        ReadPilotUseCase readPilotUseCase = new ReadPilotUseCase(iReadRepoPilot);
        assertThrows(ExceptionPilotDontExist.class, () -> {
            readPilotUseCase.readPilot("30-64140555-4");
        });
    }
}
