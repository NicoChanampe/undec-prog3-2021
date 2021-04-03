package ocp;

public class AutoNaftero extends Automovil{
    public AutoNaftero(String marca, String modelo) {
        super(marca, modelo);
    }

    public void calibrar() {
        super.calibrarNeumaticos();
    }

    public String recargarCombustible() {
        return "Cargar Nafta";
    }
}
