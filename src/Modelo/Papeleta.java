package Modelo;

import java.util.ArrayList;

public class Papeleta {
    private ArrayList<Candidato> candidatos;
    private int votoSeleccionado = -1;

    public Papeleta(ArrayList<Candidato> pCandidatos) {
        super();
    }
    public void votarPor(int voto)
    {
        this.votoSeleccionado = voto;
    }

    public ArrayList<Candidato> getCandidatos() {
        return candidatos;
    }

    public int getVotoSeleccionado() {
        return votoSeleccionado;
    }
}
