package test_useCase;

import com.domain.Plane;
import com.exception.exceptionsPlane.*;
import com.repository.ICreateRepoPlane;
import com.useCase.CreatePlaneUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class TestCreateNewPlane {

    @Mock
    ICreateRepoPlane iCreateRepoPlane;

    @Test
    public void test01_CreateNewPlane_PlaneDoesntExist_planeLoadedCorrectly() throws ExceptionPlane {
        Plane newPlane = Plane.factoryPlane("LV-FNI","Airbus A330-200",264,2015);

        Mockito.when(iCreateRepoPlane.savePlane(newPlane)).thenReturn(true);
        CreatePlaneUseCase createPlaneUseCase = new CreatePlaneUseCase(iCreateRepoPlane);
        assertTrue(createPlaneUseCase.loadPlane(newPlane));
    }

    @Test
    public void test02_CreateNewPlane_planeDoesExist_ExceptionPlaneExist() throws ExceptionPlane{
        Plane theSamePlane = Plane.factoryPlane("LV-FNI","Airbus A330-200",264,2015);

        Mockito.when(iCreateRepoPlane.findPlaneByLicensePlate("LV-FNI")).thenReturn(theSamePlane);
        CreatePlaneUseCase createPlaneUseCase = new CreatePlaneUseCase(iCreateRepoPlane);
        assertThrows(ExceptionPlaneExist.class, () -> {
            createPlaneUseCase.loadPlane(theSamePlane);
        });
    }
}
