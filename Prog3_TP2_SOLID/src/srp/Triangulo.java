package srp;

public class Triangulo {
    private double ladoUno;
    private double ladoDos;
    private double ladoBase;

    public Triangulo(double lado1, double lado2, double ladoBase) {
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
}
