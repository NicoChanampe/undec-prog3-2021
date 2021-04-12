package test_useCase;

import com.domain.Plane;
import com.exception.exceptionsPlane.*;
import com.repository.IReadRepoPlane;
import com.useCase.ReadPlaneUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class TestReadPlane {
    @Mock
    IReadRepoPlane iReadRepoPlane;

    @Test
    public void test01_readPlane_planeExist() throws ExceptionPlane {
        Plane myPlane = Plane.factoryPlane("LV-FNI","Airbus A330-200",264,2015);

        Mockito.when(iReadRepoPlane.findPlaneByLicensePlate("LV-FNI")).thenReturn(myPlane);
        ReadPlaneUseCase readPlaneUseCase = new ReadPlaneUseCase(iReadRepoPlane);
        assertEquals(myPlane,readPlaneUseCase.readPlane("LV-FNI"));
    }

    @Test
    public void test02_readPlane_planeDontExist() throws ExceptionPlane {

        Mockito.when(iReadRepoPlane.findPlaneByLicensePlate("LV-FNI")).thenReturn(null);
        ReadPlaneUseCase readPlaneUseCase = new ReadPlaneUseCase(iReadRepoPlane);
        assertThrows(ExceptionPlaneDontExist.class, () -> {
            readPlaneUseCase.readPlane("LV-FNI");
        });
    }
}
