package isp;

public class Mono implements AnimalAccionesBasicas, AnimalCorre {
    private String nombre;

    public Mono(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String respirar() {
        return "respirando";
    }

    public String comer() {
        return "comiendo bananas";
    }

    public String correr() {
        return "corriendo";
    }
}
