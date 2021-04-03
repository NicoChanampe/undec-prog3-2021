package srp;

public class TrianguloSinSRP {
    private double ladoUno;
    private double ladoDos;
    private double ladoBase;

    public TrianguloSinSRP(double lado1, double lado2, double ladoBase) {
        this.ladoUno = lado1;
        this.ladoDos = lado2;
        this.ladoBase = ladoBase;
    }

    public double getLadoUno() {
        return ladoUno;
    }

    public void setLadoUno(double ladoUno) {
        this.ladoUno = ladoUno;
    }

    public double getLadoDos() {
        return ladoDos;
    }

    public void setLadoDos(double ladoDos) {
        this.ladoDos = ladoDos;
    }

    public double getLadoBase() {
        return ladoBase;
    }

    public void setLadoBase(double ladoBase) {
        this.ladoBase = ladoBase;
    }

    public double damePerimetro() {
        return ladoUno+ladoDos+ladoBase;
    }

    public double dameArea() {
        double altura = AlturaTriangulo.dameAltura(ladoUno,ladoDos,ladoBase);
        return Math.round((altura*ladoBase)/2);
    }
}
