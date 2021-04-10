package test_useCase;

import com.domain.Airport;
import com.exception.exceptionsAirport.ExceptionAirport;
import com.exception.exceptionsAirport.ExceptionAirportExist;
import com.repository.ICreateRepoAirport;
import com.useCase.CreateAirportUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class TestCreateNewAirport {
    @Mock
    ICreateRepoAirport iCreateRepoAirport;

    @Test
    public void test01_createAirport_AirportDontExist_AirportLoadedCorrectly() throws ExceptionAirport {

        Airport newAirport = Airport.factoryAirport("EZE","Aeroparque Jorge Newberry","CABA",1802);

        Mockito.when(iCreateRepoAirport.saveAirport(newAirport)).thenReturn(true);
        CreateAirportUseCase createAirportUseCase = new CreateAirportUseCase(iCreateRepoAirport);
        assertTrue(createAirportUseCase.loadAirport(newAirport));
    }

    @Test
    public void test02_createAirport_AirportDoesExist_ExceptionAirportExist() throws ExceptionAirport {

        Airport existAirport = Airport.factoryAirport("EZE","Aeroparque Jorge Newberry","CABA",1802);

        Mockito.when(iCreateRepoAirport.findAirportByCodeIata("EZE")).thenReturn(existAirport);
        CreateAirportUseCase createAirportUseCase = new CreateAirportUseCase(iCreateRepoAirport);
        assertThrows(ExceptionAirportExist.class, () -> {
            createAirportUseCase.loadAirport(existAirport);
        });
    }
}
