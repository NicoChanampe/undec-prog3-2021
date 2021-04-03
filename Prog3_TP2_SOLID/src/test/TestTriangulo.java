package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import srp.AreaTriangulo;
import srp.PerimetroTriangulo;
import srp.Triangulo;
import srp.TrianguloSinSRP;

public class TestTriangulo {
    @Test
    void test01_TrianguloSirve() {

        double lado1 = 16.16;
        double lado2 = 16.16;
        double lado3 = 12.00;

        Triangulo esteTriangulo = new Triangulo(lado1,lado2,lado3);

        assertEquals(lado1,esteTriangulo.getLadoUno());
        assertEquals(lado2,esteTriangulo.getLadoDos());
        assertEquals(lado3,esteTriangulo.getLadoBase());
    }

    @Test
    void test02_CalculosDePerimetroYArea() {

        double perimetroEsperado = 44.32;
        double areaEsperada = 90.00;

        AreaTriangulo area = new AreaTriangulo(16.16,16.16,12.00);
        PerimetroTriangulo perimetro = new PerimetroTriangulo(16.16,16.16,12.00);

        assertEquals(areaEsperada,area.calculoArea());
        assertEquals(perimetroEsperado,perimetro.calculoPerimetro());
    }

    @Test
    void test03_TrianguloSinAplicarSRP() {

        double lado1 = 16.16;
        double lado2 = 16.16;
        double lado3 = 12.00;

        double perimetroEsperado = 44.32;
        double areaEsperada = 90.00;

        TrianguloSinSRP esteTriangulo = new TrianguloSinSRP(lado1,lado2,lado3);

        assertEquals(lado1,esteTriangulo.getLadoUno());
        assertEquals(lado2,esteTriangulo.getLadoDos());
        assertEquals(lado3,esteTriangulo.getLadoBase());
        assertEquals(areaEsperada,esteTriangulo.dameArea());
        assertEquals(perimetroEsperado,esteTriangulo.damePerimetro());
    }
}
