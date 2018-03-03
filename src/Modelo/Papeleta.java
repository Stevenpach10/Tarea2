package Modelo;

import java.util.ArrayList;

public class Papeleta {
    private int votoSeleccionado = -1;

    public Papeleta() {
        super();
    }
    public void votarPor(int voto)
    {
        this.votoSeleccionado = voto;
    }

    public int getVotoSeleccionado() {
        return votoSeleccionado;
    }
}
