package srp;

public class PerimetroTriangulo extends Triangulo{

    public PerimetroTriangulo(double lado1, double lado2, double ladoBase) {
        super(lado1, lado2, ladoBase);
    }

    public double calculoPerimetro() {
        return super.getLadoUno()+super.getLadoDos()+super.getLadoBase();
    }

}
