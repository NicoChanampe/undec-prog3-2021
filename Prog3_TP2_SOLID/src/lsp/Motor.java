package lsp;

public abstract class Motor {
    private String nombre;

    public Motor(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public abstract String prender();
}
