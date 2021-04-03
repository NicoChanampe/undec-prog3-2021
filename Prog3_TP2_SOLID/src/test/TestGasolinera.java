package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TestGasolinera {

    @Test
    void test01_CrearAuto() {

        String marca = "Fiat";
        String modelo = "Duna";

        Automovil auto01 = new AutoGasolero(marca,modelo);

        assertEquals(marca,auto01.getMarca());
        assertEquals(modelo,auto01.getModelo());
    }

    @Test
    void test02_AutosDistintosCarganCombustible() {

        Automovil auto01 = new AutoGasolero("Fiat","Duna");
        Automovil auto02 = new AutoNaftero("Chevrolet","Corsa");
        Automovil auto03 = new AutoNaftero("Ford","Falcon");

        assertEquals("Cargar Diesel",auto01.recargarCombustible());
        assertEquals("Cargar Nafta",auto02.recargarCombustible());
        assertEquals("Cargar Nafta",auto03.recargarCombustible());
    }

    @Test
    void test02_mismoAutoVariasAcciones() {

        Automovil auto01 = new AutoNaftero("Fiat","147");


        assertEquals("Calibrando",auto01.calibrarNeumaticos());
        assertEquals("Cargar Nafta",auto01.recargarCombustible());
    }
}
