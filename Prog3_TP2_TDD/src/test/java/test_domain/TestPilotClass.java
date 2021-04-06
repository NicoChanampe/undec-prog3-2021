package test_domain;

import com.domain.Pilot;
import com.exception.exceptionsPilot.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class TestPilotClass {
    @Test
    public void test01_GenerateObjectPilotCorrectly() throws ExceptionPilot {
        LocalDate dateBorn = LocalDate.parse("1994-01-20");
        Pilot pilot = Pilot.factoryPilot("30-64140555-4",120,"Cardozo","Franco David",dateBorn);
        assertNotNull(pilot);
    }

    @Test
    public void test02_PilotCreation_SomeAtributeNull(){
        LocalDate dateBorn;
        dateBorn = LocalDate.parse("1994-01-20");

        assertThrows(ExceptionPilotNullCuil.class, () ->{
            Pilot pilot = Pilot.factoryPilot(null,350,"Cardozo","Fransisco David",dateBorn);
        });

        assertThrows(ExceptionPilotNullBundle.class, () ->{
            Pilot pilot = Pilot.factoryPilot("30-64140555-4",null,"Cardozo","Fransisco David",dateBorn);
        });

        assertThrows(ExceptionPilotNullLastName.class, () ->{
            Pilot pilot = Pilot.factoryPilot("30-64140555-4",350,null,"Fransisco David",dateBorn);
        });

        assertThrows(ExceptionPilotNullName.class, () ->{
            Pilot pilot = Pilot.factoryPilot("30-64140555-4",350,"Cardozo",null,dateBorn);
        });
    }

    @Test
    public void test03_PilotCreation_SomeStringAtributeEmpty(){
        LocalDate dateBorn;
        dateBorn = LocalDate.parse("1994-01-20");

        assertThrows(ExceptionPilotEmptyCuil.class, () ->{
            Pilot pilot = Pilot.factoryPilot("",350,"Cardozo","Fransisco David",dateBorn);
        });

        assertThrows(ExceptionPilotEmptyLastName.class, () ->{
            Pilot pilot = Pilot.factoryPilot("30-64140555-4",350,"","Fransisco David",dateBorn);
        });

        assertThrows(ExceptionPilotEmptyName.class, () ->{
            Pilot pilot = Pilot.factoryPilot("30-64140555-4",350,"Cardozo","",dateBorn);
        });
    }

    @Test
    public void test04_PilotCreation_BundleWrong(){
        LocalDate dateBorn;
        dateBorn = LocalDate.parse("1994-01-20");


        assertThrows(ExceptionPilotBundleCero.class, () ->{
            Pilot pilot = Pilot.factoryPilot("30-64140555-4",0,"Cardozo","Fransisco David",dateBorn);
        });

        assertThrows(ExceptionPilotBundleNegative.class, () -> {
            Pilot pilot = Pilot.factoryPilot("30-64140555-4", -350, "Cardozo", "Fransisco David", dateBorn);
        });
    }

    @Test
    public void test05_PilotCreation_CuilWrong() {
        LocalDate dateBorn;
        dateBorn = LocalDate.parse("1994-01-20");

        assertThrows(ExceptionPilotWrongCuil.class, () -> {
            Pilot pilot = Pilot.factoryPilot("303-64140555-4", 350, "Cardozo", "Fransisco David", dateBorn);
        });

        assertThrows(ExceptionPilotWrongCuil.class, () -> {
            Pilot pilot = Pilot.factoryPilot("30-6140555-4", 350, "Cardozo", "Fransisco David", dateBorn);
        });

        assertThrows(ExceptionPilotWrongCuil.class, () -> {
            Pilot pilot = Pilot.factoryPilot("30-464140555-4", 350, "Cardozo", "Fransisco David", dateBorn);
        });

        assertThrows(ExceptionPilotWrongCuil.class, () -> {
            Pilot pilot = Pilot.factoryPilot("30-64140555", 350, "Cardozo", "Fransisco David", dateBorn);
        });

        assertThrows(ExceptionPilotWrongCuil.class, () -> {
            Pilot pilot = Pilot.factoryPilot("30-64140555-43", 350, "Cardozo", "Fransisco David", dateBorn);
        });

        assertThrows(ExceptionPilotWrongCuil.class, () -> {
            Pilot pilot = Pilot.factoryPilot("30641405554", 350, "Cardozo", "Fransisco David", dateBorn);
        });
    }
}
