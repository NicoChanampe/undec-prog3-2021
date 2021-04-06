package test_domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class TestAirlineClass {
    @Test
    public void test01_GenerateAirlineObjectCorrectly() throws ExceptionAirline{
        LocalDate data = LocalDate.parse("2015-04-02");
        Airline airline = Airline.factoryAirline("30-64140555-4","AR","Aerolineas Argentinas",data);
        assertNotNull(airline);
    }

    @Test
    public void test02_AirlineAllGettersFunctionCorrectly() throws ExceptionAirline{
        LocalDate data = LocalDate.parse("2015-04-02");
        Airline airline = Airline.factoryAirline("30-64140555-4","AR","Aerolineas Argentinas",data);

        assertEquals("30-64140555-4",airline.getCuit());
        assertEquals("AR",airline.getCodeIATA());
        assertEquals("Aerolineas Argentinas",airline.getName());
        assertTrue(data.equals(airline.getDateStartActivities()));
    }

    @Test
    public void test03_AirlineAllSettersFunctionCorrectly() throws ExceptionAirline{
        LocalDate data = LocalDate.parse("2015-04-02");
        LocalDate newDate = LocalDate.parse("2017-01-14");
        Airline airline = Airline.factoryAirline("37-98140555-5","AL","Aerolineas Argelinas",data);

        airline.setCuit("30-64140555-4");
        airline.setCodeIATA("AR");
        airline.setName("Aerolineas Argentinas");
        airline.setDateStartActivities(newDate);
        assertEquals("30-64140555-4",airline.getCuit());
        assertEquals("AR",airline.getCodeIATA());
        assertEquals("Aerolineas Argentinas",airline.getName());
        assertTrue(newDate.equals(airline.getDateStartActivities()));
    }

    @Test
    public void test04_AirlineCreate_someAtributeNull(){
        LocalDate data = LocalDate.parse("2015-04-02");

        assertThrows(ExceptionAirlineCuitNull.class, () -> {
            Airline airline = Airline.factoryAirline(null,"AR","Aerolineas Argentinas",data);
        });

        assertThrows(ExceptionAirlineCodeIataNull.class, () -> {
            Airline airline = Airline.factoryAirline("30-64140555-4",null,"Aerolineas Argentinas",data);
        });

        assertThrows(ExceptionAirlineNameNull.class, () -> {
            Airline airline = Airline.factoryAirline("30-64140555-4","AR",null,data);
        });
    }

    @Test
    public void test05_AirlineCreate_someAtributeEmpty(){
        LocalDate data = LocalDate.parse("2015-04-02");

        assertThrows(ExceptionAirlineCuitEmpty.class, () -> {
            Airline airline = Airline.factoryAirline("","AR","Aerolineas Argentinas",data);
        });

        assertThrows(ExceptionAirlineCodeIataEmpty.class, () -> {
            Airline airline = Airline.factoryAirline("30-64140555-4","","Aerolineas Argentinas",data);
        });

        assertThrows(ExceptionAirlineNameEmpty.class, () -> {
            Airline airline = Airline.factoryAirline("30-64140555-4","AR","",data);
        });
    }

    @Test
    public void test06_AirlineCreation_CuitWrong() {
        LocalDate data;
        data = LocalDate.parse("2018-01-20");

        assertThrows(ExceptionAirlineWrongCuit.class, () -> {
            Airline airline = Airline.factoryAirline("303-64140555-4","AR","Aerolineas Argentinas",data);
        });

        assertThrows(ExceptionAirlineWrongCuit.class, () -> {
            Airline airline = Airline.factoryAirline("30-64d40555-4","AR","Aerolineas Argentinas",data);
        });

        assertThrows(ExceptionAirlineWrongCuit.class, () -> {
            Airline airline = Airline.factoryAirline("30-641455-4","AR","Aerolineas Argentinas",data);
        });

        assertThrows(ExceptionAirlineWrongCuit.class, () -> {
            Airline airline = Airline.factoryAirline("3-640555848-4","AR","Aerolineas Argentinas",data);
        });

        assertThrows(ExceptionAirlineWrongCuit.class, () -> {
            Airline airline = Airline.factoryAirline("33-64140555-g","AR","Aerolineas Argentinas",data);
        });

        assertThrows(ExceptionAirlineWrongCuit.class, () -> {
            Airline airline = Airline.factoryAirline("30641405554","AR","Aerolineas Argentinas",data);
        });

        assertThrows(ExceptionAirlineWrongCuit.class, () -> {
            Airline airline = Airline.factoryAirline("30-64140555-45","AR","Aerolineas Argentinas",data);
        });
    }

    @Test
    public void test07_CreationAirline_CodeIATAlWrong(){
        LocalDate data = LocalDate.parse("2015-04-02");

        assertThrows(ExceptionAirlineCodeIATAWrong.class, () ->{
            Airline airline = Airline.factoryAirline("30-64140555-4","ar","Aerolineas Argentinas",data);
        });

        assertThrows(ExceptionAirlineCodeIATAWrong.class, () ->{
            Airline airline = Airline.factoryAirline("30-64140555-4","Ar","Aerolineas Argentinas",data);
        });

        assertThrows(ExceptionAirlineCodeIATAWrong.class, () ->{
            Airline airline = Airline.factoryAirline("30-64140555-4","ARA","Aerolineas Argentinas",data);
        });

        assertThrows(ExceptionAirlineCodeIATAWrong.class, () ->{
            Airline airline = Airline.factoryAirline("30-64140555-4","A","Aerolineas Argentinas",data);
        });
    }

}
