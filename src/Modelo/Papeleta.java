package Modelo;

public class Papeleta {
    private int votoSeleccionado = -1;

    public Papeleta() {
    }
    public void votarPor(int voto)
    {

        this.votoSeleccionado = voto;

    }

    public int getVotoSeleccionado()
    {
        return votoSeleccionado;
    }
}
