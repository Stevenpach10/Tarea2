package Modelo;

public class Candidato {

    private String nombre;
    private String detalle;

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    private int identificador;
    public String getNombre() {
        return nombre;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getDetalle()
    {
        return detalle;
    }
    
    public Candidato(int pIdentificador, String pNombre, String pDetalle) {
        super();
        this.nombre = pNombre;
        this.detalle = pDetalle;
        this.identificador = pIdentificador;
     
    }
}
