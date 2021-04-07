package test_domain;

import com.domain.Airport;
import com.exception.exceptionsAirport.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestAirportClass {

    @Test
    public void test01_CreationAirportCorrectly() throws ExceptionAirport {
        Airport airport = Airport.factoryAirport("EZE","Aeroparque Jorge Newberry","CABA",1802);
        assertNotNull(airport);
    }


    @Test
    public void test02_CreationAirportCorrectly() throws ExceptionAirport{
        Airport airport = Airport.factoryAirport("MDP","Aeropuerto Internacional Astor Piazolla","Mar del Plata",7600);

        airport.setCodeIATA("EZE");
        airport.setName("Aeroparque Jorge Newberry");
        airport.setCity("CABA");
        airport.setCodePostal(1802);

        assertEquals("EZE",airport.getCodeIATA());
        assertEquals("Jorge Newberry",airport.getName());
        assertEquals("CABA",airport.getCity());
        assertEquals(1802,airport.getCodePostal());
    }

    @Test
    public void test03_CreationAirport_AtributesNull(){
        assertThrows(ExceptionAirportCodeIATANull.class, () ->{
            Airport airport = Airport.factoryAirport(null,"Aeroparque Jorge Newberry","CABA",1802);
        });

        assertThrows(ExceptionAirportNameNull.class, () ->{
            Airport airport = Airport.factoryAirport("EZE",null,"CABA",1802);
        });

        assertThrows(ExceptionAirportCityNull.class, () ->{
            Airport airport = Airport.factoryAirport("EZE","Aeroparque Jorge Newberry",null,1802);
        });

        assertThrows(ExceptionAirportCodePostalNull.class, () ->{
            Airport airport = Airport.factoryAirport("EZE","Aeroparque Jorge Newberry","CABA",null);
        });
    }

    @Test
    public void test04_CreationAirport_AtributesEmpty(){
        assertThrows(ExceptionAirportCodeIATAEmpty.class, () ->{
            Airport airport = Airport.factoryAirport("","Aeroparque Jorge Newberry","CABA",1802);
        });

        assertThrows(ExceptionAirportNameEmpty.class, () ->{
            Airport airport = Airport.factoryAirport("EZE","","CABA",1802);
        });

        assertThrows(ExceptionAirportCityEmpty.class, () ->{
            Airport airport = Airport.factoryAirport("EZE","Aeroparque Jorge Newberry","",1802);
        });
    }

    @Test
    public void test05_CreationAirport_CodePostalWrong(){
        assertThrows(ExceptionAirportCodePostalWrong.class, () ->{
            Airport airport = Airport.factoryAirport("EZE","Aeroparque Jorge Newberry","CABA",0);
        });

        assertThrows(ExceptionAirportCodePostalWrong.class, () ->{
            Airport airport = Airport.factoryAirport("EZE","Aeroparque Jorge Newberry","CABA",-1208);
        });
    }

    @Test
    public void test06_CreationAirport_CodeIATAlWrong(){
        assertThrows(ExceptionAirportCodeIATAWrong.class, () ->{
            Airport airport = Airport.factoryAirport("eze","Aeroparque Jorge Newberry","CABA",1802);
        });

        assertThrows(ExceptionAirportCodeIATAWrong.class, () ->{
            Airport airport = Airport.factoryAirport("EZe","Aeroparque Jorge Newberry","CABA",1802);
        });

        assertThrows(ExceptionAirportCodeIATAWrong.class, () ->{
            Airport airport = Airport.factoryAirport("EZ","Aeroparque Jorge Newberry","CABA",1802);
        });

        assertThrows(ExceptionAirportCodeIATAWrong.class, () ->{
            Airport airport = Airport.factoryAirport("EZEX","Aeroparque Jorge Newberry","CABA",1802);
        });
    }
}
