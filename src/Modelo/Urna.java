package Modelo;
import java.util.ArrayList;

public class Urna {
    /**
     * @aggregation shared
     */
    private ArrayList<Votante> votantes;
    private ArrayList<Papeleta> votosEmitidos;
    public Urna(ArrayList<Votante> pVotantes) {
        votantes = pVotantes;
    }
    //Devuelve True si puede registrar al votante, falso en cualquier otro caso.
    private boolean registrarVotanteEnBitacora(String pIdentificacionVotante)
    {
        int tam  = votantes.size();
        for(int i =0; i<tam;i++)
        {
            Votante votante = votantes.get(i);
            if(votante.getIdentificacion() == pIdentificacionVotante)
            {
                if(!votante.isEstadoVoto())
                {
                    votante.setEstadoVoto(true);
                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
        return false;
    }
    public int obtenerAsistencia()
    {
        int tam = votantes.size();
        int cont = 0;
        for (int i = 0; i<tam;i++)
        {
            Votante persona = votantes.get(i);
            if(persona.isEstadoVoto())
            {
                cont++;
            }
        }
        return cont;
    }
    public int obtenerVotosPorCandidato(int pCandidato)
    {
        int tam = votosEmitidos.size();
        int sum =0;
        for(int i=0;i<tam;i++)
        {
            Papeleta voto = votosEmitidos.get(i);
             if(voto.getVotoSeleccionado() == pCandidato)
             {
                 sum++;
             }
        }
        return sum;
    }
    //La funcion retorna True en caso de ser correcto, falso de lo contrario.
    public boolean registrarVoto(String pIdentificacion, int pVotoEmitido)
    {
        //Registra al votante como verdadero para saber que ya voto
        if(registrarVotanteEnBitacora(pIdentificacion))
        {
            ArrayList<Candidato> listaCandidatos = loadCandidatos();
            Papeleta nuevaPapeleta = new Papeleta(listaCandidatos);
            nuevaPapeleta.votarPor(pVotoEmitido);
            votosEmitidos.add(nuevaPapeleta);
            return true;
        }
        else
            return false;
    }
    public ArrayList<Papeleta> getVotosEmitidos() {
        return votosEmitidos;
    }
    private   ArrayList<Candidato> loadCandidatos()
    {
        //Cargarlos de la base de datos.
        Candidato cand1 = new Candidato("Candidato 1","Miembro de la IEEE");
        Candidato cand2 = new Candidato("Candidato 2","Miembro del Consejo");
        Candidato cand3 = new Candidato("Candidato 3","Miembro de ACM");

        ArrayList<Candidato> listaCandidatos = new ArrayList<Candidato>();

        listaCandidatos.add(cand1);
        listaCandidatos.add(cand2);
        listaCandidatos.add(cand3);

        return listaCandidatos;
    }

    public void setVotantes(ArrayList<Votante> votantes) {
        this.votantes = votantes;
    }

    public ArrayList<Votante> getVotantes() {
        return votantes;
    }
}
