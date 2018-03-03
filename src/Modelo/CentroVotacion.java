package Modelo;
        import Modelo.Urna;

        import java.util.ArrayList;

public class CentroVotacion {
    /**
     * @aggregation shared
     */
    private ArrayList<Urna> Urnas;
    private String nombre;
    private int id;


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public CentroVotacion(String pNombre, int pId) {
        this.id = pId;
        this.nombre = pNombre;
    }

    public void setUrnas(ArrayList<Urna> Urnas) {
        this.Urnas = Urnas;
    }

    public ArrayList<Urna> getUrnas() {
        return Urnas;
    }
    public int obtenerGanador()
    {
        //Los ganadores del 1 al 3 son candidatos, el 4 el voto en blanco.
        //No existe voto nulo.
        int ganador;

        int tam = Urnas.size();

        int[] candi = {0,0,0,0};

        for (int i = 0; i<tam;i++)
        {
            Urna urna = Urnas.get(i);

            candi[0] += urna.obtenerVotosPorCandidato(1);
            candi[1] += urna.obtenerVotosPorCandidato(2);
            candi[2] += urna.obtenerVotosPorCandidato(3);
            //Voto Blanco
            candi[3] += urna.obtenerVotosPorCandidato(4);
        }

        return determinarCandidatoGanador(candi);
    }
    private int determinarCandidatoGanador(int[] listaNumeros)
    {
        int may = listaNumeros[0];
        int indice = 0;
        for(int i = 1; i<4;i++)
        {
           if(listaNumeros[i]>may)
           {
               may = listaNumeros[i];
               indice = i;
           }
        }
    return indice+1;
    }
    //Retorna el porcentaje de abstencionismo.
    public float reportarAbstencionismo()
    {
        int tam = Urnas.size();
        int cantidadVotantes = 0,cantidadVotos = 0;
        for (int i = 0; i<tam;i++)
        {
            Urna urna = Urnas.get(i);
            cantidadVotantes += urna.getVotantes().size();
            cantidadVotos += urna.obtenerAsistencia();
        }

        return (cantidadVotos/cantidadVotantes)*100;
    }
}
