package test_useCase;

import com.domain.Airline;
import com.exception.exceptionsAirline.ExceptionAirline;
import com.exception.exceptionsAirline.ExceptionAirlineExist;
import com.repository.ICreateRepoAirline;
import com.useCase.CreateAirlineUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class TestCreateNewAirline {
    @Mock
    ICreateRepoAirline iCreateRepoAirline;

    @Test
    public void test01_createAirline_AirlineDontExist_AirlineLoadedCorrectly() throws ExceptionAirline {

        LocalDate data = LocalDate.parse("2018-02-13");
        Airline newAirline = Airline.factoryAirline("30-64140555-4","AR","Aerolineas Argentinas",data);

        Mockito.when(iCreateRepoAirline.saveAirline(newAirline)).thenReturn(true);
        CreateAirlineUseCase createAirlineUseCase = new CreateAirlineUseCase(iCreateRepoAirline);
        assertTrue(createAirlineUseCase.loadAirline(newAirline));
    }

    @Test
    public void test02_createAirline_AirlineDoesExist_ExceptionAirlineExist() throws ExceptionAirline {

        LocalDate data = LocalDate.parse("2018-02-13");
        Airline existAirline = Airline.factoryAirline("30-64140555-4","AR","Aerolineas Argentinas",data);

        Mockito.when(iCreateRepoAirline.findAirlineByCuit("30-64140555-4")).thenReturn(existAirline);
        CreateAirlineUseCase createAirlineUseCase = new CreateAirlineUseCase(iCreateRepoAirline);
        assertThrows(ExceptionAirlineExist.class, () -> {
            createAirlineUseCase.loadAirline(existAirline);
        });
    }
}
