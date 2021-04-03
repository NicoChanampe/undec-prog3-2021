package ocp;

public class AutoGasolero extends Automovil{
    public AutoGasolero(String marca, String modelo) {
        super(marca, modelo);
    }

    public void calibrar() {
        super.calibrarNeumaticos();
    }

    public String recargarCombustible() {
        return "Cargar Diesel";
    }
}
