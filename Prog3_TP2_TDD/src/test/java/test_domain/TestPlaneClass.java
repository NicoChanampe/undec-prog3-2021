package test_domain;

import com.domain.Plane;
import com.exception.exceptionsPlane.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestPlaneClass {
    @Test
    public void test01_GenerateObjectPlaneWithAllData() throws ExceptionPlane {
        Plane jayjay = Plane.factoryPlane("LV-FNI","Airbus A330-200",264,2015);
        assertNotNull(jayjay);
    }

    @Test
    public void test02_GenerateObjectPlaneWithoutCapacity() throws ExceptionPlane{
        Plane jayjay = Plane.factoryPlane("LV-CBT","Boeing 737-700",2015);
        assertNotNull(jayjay);
    }

    @Test
    public void test03_PlaneCreation_ExceptionEmptyLicesnsePlate(){
        assertThrows(ExceptionPlaneEmptyLicensePlate.class, () ->{
            Plane jayjay = Plane.factoryPlane("","Boeing 737-800",162,2016);
        });

        assertThrows(ExceptionPlaneEmptyLicensePlate.class, () ->{
            Plane jayjay = Plane.factoryPlane("","Boeing 737-800",2016);
        });
    }

    @Test
    public void test04_PlaneCreation_ExceptionWrongLicensePlate(){
        assertThrows(ExceptionPlaneWrongLicensePlate.class, () ->{
            Plane jayjay = Plane.factoryPlane("LVS-SSS","Boeing 737-800",162,2016);
        });

        assertThrows(ExceptionPlaneWrongLicensePlate.class, () ->{
            Plane jayjay = Plane.factoryPlane("LVS-SSS","Boeing 737-800",2016);
        });

        assertThrows(ExceptionPlaneWrongLicensePlate.class, () ->{
            Plane jayjay = Plane.factoryPlane("LV-SSSD","Boeing 737-800",162,2016);
        });

        assertThrows(ExceptionPlaneWrongLicensePlate.class, () ->{
            Plane jayjay = Plane.factoryPlane("LVS-SSDD","Boeing 737-800",2016);
        });

        assertThrows(ExceptionPlaneWrongLicensePlate.class, () ->{
            Plane jayjay = Plane.factoryPlane("lv-dsc", "Boeing 737-800", 162, 2016);
        });

        assertThrows(ExceptionPlaneWrongLicensePlate.class, () ->{
            Plane jayjay = Plane.factoryPlane("lv-dsc","Boeing 737-800",2016);
        });
    }

    @Test
    public void test05_PlaneCreation_ExceptionNullLicesnsePlate(){
        assertThrows(ExceptionPlaneNullLicensePlate.class, () ->{
            Plane jayjay = Plane.factoryPlane(null,"Boeing 737-800",162,2016);
        });

        assertThrows(ExceptionPlaneNullLicensePlate.class, () ->{
            Plane jayjay = Plane.factoryPlane(null,"Boeing 737-800",2016);
        });
    }

    @Test
    public void test06_PlaneCreation_ExceptionEmptyModel(){
        assertThrows(ExceptionPlaneEmptyModel.class, () ->{
            Plane jayjay = Plane.factoryPlane("LV-FNI","",162,2016);
        });

        assertThrows(ExceptionPlaneEmptyModel.class, () ->{
            Plane jayjay = Plane.factoryPlane("LV-FNI","",2016);
        });
    }

    @Test
    public void test07_PlaneCreation_ExceptionNullModel(){
        assertThrows(ExceptionPlaneNullModel.class, () ->{
            Plane jayjay = Plane.factoryPlane("LV-FNI",null,162,2016);
        });

        assertThrows(ExceptionPlaneNullModel.class, () ->{
            Plane jayjay = Plane.factoryPlane("LV-FNI",null,2016);
        });
    }

    @Test
    public void test08_PlaneCreation_ExceptionYearNegative(){
        assertThrows(ExceptionPlaneYearNegative.class, () ->{
            Plane jayjay = Plane.factoryPlane("LV-CHR","Embraer 190",88,-1998);
        });

        assertThrows(ExceptionPlaneYearNegative.class, () ->{
            Plane jayjay = Plane.factoryPlane("LV-CHR","Embraer 190",-1998);
        });
    }

    @Test
    public void test10_PlaneCreation_ExceptionYearSmall(){
        assertThrows(ExceptionPlaneYearSmall.class, () ->{
            Plane jayjay = Plane.factoryPlane("LV-CHR","Embraer 190",88,1989);
        });

        assertThrows(ExceptionPlaneYearSmall.class, () ->{
            Plane jayjay = Plane.factoryPlane("LV-CHR","Embraer 190",1989);
        });
    }
}
