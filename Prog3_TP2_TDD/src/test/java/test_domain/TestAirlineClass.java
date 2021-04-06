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
    public void test02_AirlineCreate_someAtributeNull(){
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
    public void test03_AirlineCreate_someAtributeEmpty(){
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
    public void test04_AirlineCreation_CuitWrong() {
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
    public void test05_CreationAirline_CodeIATAlWrong(){
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
