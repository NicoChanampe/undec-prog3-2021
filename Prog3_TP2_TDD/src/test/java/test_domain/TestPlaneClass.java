package test_domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestPlaneClass {
    @Test
    public void test01_GenerateObjectPlaneWithAllData() throws ExceptionPlane{
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
    public void test09_PlaneGettersAndSetters() throws ExceptionPlane {
        Plane jayjay = Plane.factoryPlane("LV-CBT","Bohemio 737-700",165,2015);
        Plane snuffy = Plane.factoryPlane("LV-CHR","Embrague 190",2015);

        assertEquals("LV-CBT",jayjay.getLicensePlate());
        assertEquals("Bohemio 737-700",jayjay.getModel());
        assertEquals(165,jayjay.getCapacity());
        assertEquals(2015,jayjay.getYearConstruction());
        assertEquals("LV-CHR",snuffy.getLicensePlate());
        assertEquals("Embrague 190",snuffy.getModel());
        assertEquals(1,snuffy.getCapacity());
        assertEquals(2015,snuffy.getYearConstruction());

        jayjay.setLicensePlate("LV-BYY");
        jayjay.setModel("Boeing 737-700");
        jayjay.setCapacity(264);
        jayjay.setYearConstruction(2016);
        snuffy.setLicensePlate("LV-CIF");
        snuffy.setModel("Embraer 190");
        snuffy.setCapacity(88);
        snuffy.setYearConstruction(2016);

        assertEquals("LV-BYY",jayjay.getLicensePlate());
        assertEquals("Boeing 737-700",jayjay.getModel());
        assertEquals(264,jayjay.getCapacity());
        assertEquals(2016,jayjay.getYearConstruction());
        assertEquals("LV-CIF",snuffy.getLicensePlate());
        assertEquals("Embraer 190",snuffy.getModel());
        assertEquals(88,snuffy.getCapacity());
        assertEquals(2016,snuffy.getYearConstruction());
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
