package Modelo;

public class Papeleta {
    private int votoSeleccionado = -1;
    private int ID_URNA;

    public Papeleta(int pVotoSeleccionado,int pIdUrna) {
        votoSeleccionado = pVotoSeleccionado;
        ID_URNA = pIdUrna;
    }
    public Papeleta(){;}

    public void votarPor(int voto)
    {

        this.votoSeleccionado = voto;

    }

    public int getVotoSeleccionado()
    {
        return votoSeleccionado;
    }
}
