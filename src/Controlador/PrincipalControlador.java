package Controlador;

import Modelo.CentroVotacion;
import Modelo.Papeleta;
import Modelo.Urna;
import Modelo.Votante;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PrincipalControlador {
    //Controles
    @FXML
    public Button botonCerrar;
    @FXML
    public Label lblResultados;


    public void obtenerAsistencia(ActionEvent event)
    {
        CentroVotacion centro = loadCentro();
        ArrayList<Urna> listaUrnas = loadUrnas(centro.getId());
        centro.setUrnas(listaUrnas);
        float resultado = centro.reportarAbstencionismo();

        lblResultados.setText("Resultado = "+String.valueOf(100-resultado));
    }
    public void reportarDesglose(ActionEvent event)
    {

    }
    public void reportarAbstencionismo(ActionEvent event)
    {
        CentroVotacion centro = loadCentro();
        ArrayList<Urna> listaUrnas = loadUrnas(centro.getId());
        centro.setUrnas(listaUrnas);
        float resultado = centro.reportarAbstencionismo();
        lblResultados.setText("Resultado = "+String.valueOf(resultado));

    }
    public void reportarGanador(ActionEvent event)
    {
        CentroVotacion centro = loadCentro();
        ArrayList<Urna> listaUrnas = loadUrnas(centro.getId());
        centro.setUrnas(listaUrnas);

        int resp = centro.obtenerGanador();

        if (resp == 1)
        {
            lblResultados.setText("Resultado = "+"Candidato 1");
        }
        else
        {
            if (resp == 2)
            {
                lblResultados.setText("Resultado = "+"Candidato 2");
            }
            else
            {
                if (resp == 3)
                {
                    lblResultados.setText("Resultado = "+"Candidato 3");
                }
                else
                    lblResultados.setText("No existen votos aún");
            }
        }
    }
    private ArrayList<Urna> loadUrnas(int idCentro)
    {
        ArrayList<Urna> urnasCentro = new ArrayList<Urna>();

        try {

            Conexion con = new Conexion();
            Connection x = con.conectar();

            String sql = "Select * from URNA_CENTRO where ID_CENTRO = "+idCentro;
            PreparedStatement pst = x.prepareStatement(sql);
            ResultSet resp = pst.executeQuery();

            while(resp.next())
            {
                int idUrna = resp.getInt(1);

                ArrayList<Votante> listaVotantes = loadVotantes(idUrna);
                ArrayList<Papeleta> listaPapeletas = loadPapeletas(idUrna);
                Urna urna = new Urna(listaVotantes);
                urna.setVotosEmitidos(listaPapeletas);
                urnasCentro.add(urna);
            }
            return urnasCentro;

        }
        catch (Exception e)
        {
            return null;
        }
    }
    private ArrayList<Papeleta> loadPapeletas(int idUrna)
    {
        ArrayList<Papeleta> listaPapeletas = new ArrayList<Papeleta>();
        try
        {
            Conexion con = new Conexion();
            Connection x = con.conectar();

            String sql = "Select * from PAPELETA where ID_URNA = "+idUrna;
            PreparedStatement pst = x.prepareStatement(sql);
            ResultSet resp = pst.executeQuery();
            while(resp.next())
            {
                int votoSeleccionado = resp.getInt(1);
                int ID_URNA = resp.getInt(2);

                Papeleta papeleta = new Papeleta(votoSeleccionado,ID_URNA);
                listaPapeletas.add(papeleta);
            }
            return listaPapeletas;

        }catch(Exception e)
        {
            return null;
        }
    }
    private ArrayList<Votante> loadVotantes(int idUrna)
    {
        ArrayList<Votante> listaVotantes = new ArrayList<Votante>();
        try
        {
            Conexion con = new Conexion();
            Connection x = con.conectar();

            String sql = "Select * from URNA_VOTANTE where ID_URNA = "+idUrna;
            PreparedStatement pst = x.prepareStatement(sql);
            ResultSet resp = pst.executeQuery();
            while(resp.next())
            {
                int idVotante = resp.getInt(2);
                Votante votante = loadVotante(idVotante);
                listaVotantes.add(votante);
            }

            return listaVotantes;

        }
        catch (Exception e)
        {
            return null;
        }
    }
    private Votante loadVotante(int id)
    {
        try
        {
            Conexion con = new Conexion();
            Connection x = con.conectar();

            String sql = "Select * from VOTANTE where IDENTIFICACION = "+id;
            PreparedStatement pst = x.prepareStatement(sql);
            ResultSet resp = pst.executeQuery();
            while(resp.next())
            {
                String identificacion = resp.getString(1);
                String nombre = resp.getString(2);
                boolean estado = resp.getBoolean(3);
                Votante votante = new Votante(nombre,identificacion);
                votante.setEstadoVoto(estado);

                return votante;
            }

        }
        catch (Exception e)
        {
            return null;
        }
        return null;
    }
    private CentroVotacion loadCentro ()
    {
        try {

            Conexion con = new Conexion();
            Connection x = con.conectar();

            String sql = "Select * from Centro_Votacion";
            PreparedStatement pst = x.prepareStatement(sql);
            ResultSet resp = pst.executeQuery();

            while(resp.next())
            {
                int index = resp.getInt(1);
                String nombre = resp.getString(2);

                CentroVotacion centro = new CentroVotacion(nombre,index);
                x.close();
                return centro;
            }

        }
        catch (Exception e)
        {
            return null;
        }
        return null;
    }
}