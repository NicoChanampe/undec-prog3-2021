package lsp;

public class MotorCuatroTiempos extends Motor{
    public MotorCuatroTiempos(String nombre) {
        super(nombre);
    }

    public String prender() {
        return "Paso 1 -> Paso 2 -> Paso 3 -> Paso 4";
    }
}
