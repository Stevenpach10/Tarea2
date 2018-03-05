package Modelo;
import java.util.ArrayList;

public class Urna {
    /**
     * @aggregation shared
     */
    private ArrayList<Votante> votantes;

    public void setVotosEmitidos(ArrayList<Papeleta> votosEmitidos) {
        this.votosEmitidos = votosEmitidos;
    }

    private ArrayList<Papeleta> votosEmitidos;
    private int identificador;


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
            Papeleta nuevaPapeleta = new Papeleta();
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

    public void setVotantes(ArrayList<Votante> votantes) {
        this.votantes = votantes;
    }

    public ArrayList<Votante> getVotantes() {
        return votantes;
    }
}
