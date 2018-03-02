package Modelo;

public class Candidato {
    public String getNombre() {
        return nombre;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getDetalle() {
        return detalle;
    }
    private String nombre;
    private String detalle;
    
    public Candidato(String pNombre, String pDetalle) {
        super();
        this.nombre = pNombre;
        this.detalle = pDetalle;
     
    }
}
