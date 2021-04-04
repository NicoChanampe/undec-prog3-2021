package lsp;

public class Moto {
    private String modelo;
    private String color;
    private Motor motor;

    public Moto(String modelo, String color, Motor motor) {
        this.modelo = modelo;
        this.color = color;
        this.motor = motor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public String encenderMoto() {
        return motor.prender();
    }
}
