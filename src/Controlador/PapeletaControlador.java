package Controlador;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import java.sql.*;

public class PapeletaControlador {
    @FXML
    public TextField txtId;
    @FXML
    public RadioButton rdb1;
    @FXML
    public RadioButton rdb2;
    @FXML
    public RadioButton rdb3;




    public void votar(ActionEvent event) {
        String cedula = txtId.getText();
        final ToggleGroup group = new ToggleGroup();
        rdb1.setToggleGroup(group);
        rdb2.setToggleGroup(group);
        rdb3.setToggleGroup(group);


        try {
            Conexion con = new Conexion();
            Connection x = con.conectar();

            /* Obtener el estado del voto para saber que puede votar */
            String sql = "Select * from Votante WHERE IDENTIFICACION = " + cedula;
            PreparedStatement pst = null;
            pst = x.prepareStatement(sql);
            ResultSet resp = pst.executeQuery();
            resp.next();
            boolean estadoVoto = resp.getBoolean("ESTADO_VOTO") ;

            /* Obtener el numero de urna del votante */
            sql = "SELECT ID_URNA FROM URNA_VOTANTE WHERE IDENTIFICACION =" + cedula;
            pst = x.prepareStatement(sql);
            resp = pst.executeQuery();
            resp.next();
            int num_urna = resp.getInt("ID_URNA");

            /* Obtener el candidato seleccionado */
            int candidato = obtenerVoto(group);


            if (!estadoVoto){
                //Incluir el voto
                    sql = "INSERT INTO PAPELETA VALUES( " + cedula + " , " + candidato + " )";
                    pst = x.prepareStatement(sql);
                    pst.execute();
                    //Indicar que ya votó la persona
                    sql = "UPDATE VOTANTE SET ESTADO_VOTO = 1 WHERE IDENTIFICACION = " + cedula;
                    pst = x.prepareStatement(sql);
                    pst.execute();

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Correcto");
                    alert.setHeaderText("Su voto ha sido tomado en cuenta");
                    alert.setContentText("");
                    alert.showAndWait();
                    limpiar();

            }else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("No se puede votar más de una vez");
                alert.setContentText("");
                alert.showAndWait();
                limpiar();

            };

        } catch (SQLException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("No es un usuario válido");
            alert.setContentText("");
            alert.showAndWait();
            limpiar();
        }


    }
    private int obtenerVoto(ToggleGroup group){
        int candidato = 0;
        try {
            if(rdb1 == group.getSelectedToggle()){ candidato = 1; }
            else if(rdb2 == group.getSelectedToggle()){ candidato = 2; }
            else if(rdb3 == group.getSelectedToggle()){ candidato = 3; }
        }catch (Exception e){

        }

        return candidato;
    }
    private void limpiar(){
        txtId.setText("");
        rdb1.setSelected(false);
        rdb2.setSelected(false);
        rdb3.setSelected(false);
    }


}
