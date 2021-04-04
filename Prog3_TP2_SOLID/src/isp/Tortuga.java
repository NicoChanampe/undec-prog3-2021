package isp;

public class Tortuga implements AnimalAccionesBasicas{
    private String nombre;

    public Tortuga(String nombre) {
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
        return "comiendo hierbas";
    }
}
