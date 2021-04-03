package srp;

public class AreaTriangulo extends Triangulo{
    public AreaTriangulo(double lado1, double lado2, double ladoBase) {
        super(lado1, lado2, ladoBase);
    }

    public double calculoArea() {
        double altura = AlturaTriangulo.dameAltura(super.getLadoUno(),super.getLadoDos(),super.getLadoBase());
        return Math.round((altura*super.getLadoBase())/2);
    }
}
