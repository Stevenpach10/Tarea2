package Modelo;

public class Votante {
    private String nombre;
    private String identificacion;
    private boolean estadoVoto;
    
    public Votante() {
    }
    public Votante(String pNombre, String pIdentificacion) {
        nombre = pNombre;
        identificacion = pIdentificacion;
        estadoVoto = false;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setEstadoVoto(boolean estadoVoto) {
        this.estadoVoto = estadoVoto;
    }

    public boolean isEstadoVoto() {
        return estadoVoto;
    }
}
