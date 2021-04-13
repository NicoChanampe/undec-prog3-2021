package test_useCase;

import com.domain.Airport;
import com.exception.exceptionsAirport.ExceptionAirport;
import com.exception.exceptionsAirport.ExceptionAirportDontExist;
import com.repository.IReadRepoAirport;
import com.useCase.ReadAirportUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class TestReadAirport {
    @Mock
    IReadRepoAirport iReadRepoAirport;

    @Test
    public void test01_readAirport_airportExist() throws ExceptionAirport {
        Airport myAirport = Airport.factoryAirport("EZE","Aeroparque Jorge Newberry","CABA",1802);

        Mockito.when(iReadRepoAirport.findAirportByIata("EZE")).thenReturn(myAirport);
        ReadAirportUseCase readAirportUseCase = new ReadAirportUseCase(iReadRepoAirport);
        assertEquals(myAirport,readAirportUseCase.readAirport("EZE"));
    }

    @Test
    public void test02_readAirport_airportDontExist() throws ExceptionAirport {

        Mockito.when(iReadRepoAirport.findAirportByIata("EZE")).thenReturn(null);
        ReadAirportUseCase readAirportUseCase = new ReadAirportUseCase(iReadRepoAirport);
        assertThrows(ExceptionAirportDontExist.class, () -> {
            readAirportUseCase.readAirport("EZE");
        });
    }
}
