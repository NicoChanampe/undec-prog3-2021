package test_useCase;

import com.domain.Airline;
import com.exception.exceptionsAirline.ExceptionAirline;
import com.exception.exceptionsAirline.ExceptionAirlineDontExist;
import com.repository.IReadRepoAirline;
import com.useCase.ReadAirlineUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class TestReadAirline {
    @Mock
    IReadRepoAirline iReadRepoAirline;

    @Test
    public void test01_readAirline_airlineExist() throws ExceptionAirline {
        LocalDate data = LocalDate.parse("2018-02-13");
        Airline objectAirline = Airline.factoryAirline("30-64140555-4","AR","Aerolineas Argentinas",data);

        Mockito.when(iReadRepoAirline.findAirlineByCuit("30-64140555-4")).thenReturn(objectAirline);
        ReadAirlineUseCase readAirlineUseCase = new ReadAirlineUseCase(iReadRepoAirline);
        assertEquals(objectAirline,readAirlineUseCase.readAirline("30-64140555-4"));
    }

    @Test
    public void test02_readAirline_airlineDontExist() throws ExceptionAirline {

        Mockito.when(iReadRepoAirline.findAirlineByCuit("30-64140555-4")).thenReturn(null);
        ReadAirlineUseCase readAirlineUseCase = new ReadAirlineUseCase(iReadRepoAirline);
        assertThrows(ExceptionAirlineDontExist.class, () -> {
            readAirlineUseCase.readAirline("30-64140555-4");
        });
    }
}
