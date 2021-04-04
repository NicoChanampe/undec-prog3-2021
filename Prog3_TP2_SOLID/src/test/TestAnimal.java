package test;
import static org.junit.jupiter.api.Assertions.*;

import isp.Leon;
import isp.Mono;
import isp.Tortuga;
import org.junit.jupiter.api.Test;

public class TestAnimal {
    @Test
    void test01_generarLeonYHacerloHacerCosas() {

        Leon simba = new Leon("leon");

        assertEquals("leon",simba.getNombre());
        assertEquals("inhala-exhala",simba.respirar());
        assertEquals("comiendo carne",simba.comer());
        assertEquals("corriendo",simba.correr());
        assertEquals("rugido",simba.rugir());
    }

    @Test
    void test02_generarMonoYHacerloHacerCosas() {

        Mono tarzan = new Mono ("mono");

        assertEquals("mono",tarzan.getNombre());
        assertEquals("respirando",tarzan.respirar());
        assertEquals("comiendo bananas",tarzan.comer());
        assertEquals("corriendo",tarzan.correr());
    }

    @Test
    void test03_generarTortugaYHacerloHacerCosas() {

        Tortuga manuelita = new Tortuga ("tortuga");

        assertEquals("tortuga",manuelita.getNombre());
        assertEquals("respirando",manuelita.respirar());
        assertEquals("comiendo hierbas",manuelita.comer());
    }

}
