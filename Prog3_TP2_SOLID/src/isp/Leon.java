package isp;

public class Leon implements AnimalAccionesBasicas, AnimalCorre, AnimalRuge{

    private String nombre;

    public Leon(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String respirar() {
        return "inhala-exhala";
    }

    public String comer() {
        return "comiendo carne";
    }

    public String correr() {
        return "corriendo";
    }

    public String rugir(){
        return "rugido";
    }
}
