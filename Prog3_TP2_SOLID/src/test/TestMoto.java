package test;

import static org.junit.jupiter.api.Assertions.*;

import lsp.Moto;
import lsp.Motor;
import lsp.MotorCuatroTiempos;
import lsp.MotorDosTiempos;
import org.junit.jupiter.api.Test;

public class TestMoto {
    @Test
    void test() {
        Motor m1 = new MotorDosTiempos("algun motor de 2 tiempos");
        Motor m2 = new MotorCuatroTiempos("algun motor de 4 tiempos");

        Moto moto1 = new Moto("Motomel S2","Negro",m1);
        Moto moto2 = new Moto("Beta 125 Rr","Rojo y blanco",m2);


        assertEquals("Motomel S2",moto1.getModelo());
        assertEquals("Negro",moto1.getColor());
        assertEquals("Beta 125 Rr",moto2.getModelo());
        assertEquals("Rojo y blanco",moto2.getColor());
        assertEquals("Paso 1 -> Paso 2",moto1.encenderMoto());
        assertEquals("Paso 1 -> Paso 2 -> Paso 3 -> Paso 4",moto2.encenderMoto());
    }

}
