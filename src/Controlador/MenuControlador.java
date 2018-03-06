package Controlador;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import javafx.event.ActionEvent;

public class MenuControlador {

    public Button btnAdmin;
    public Button btnVotante;

    public void abrirPrincipal(javafx.event.ActionEvent event){
       try{

            FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("../Vista/Principal.fxml"));
            Parent root1= (Parent)fxmlLoader.load();

            Stage stage= new Stage();

            stage.setScene(new Scene(root1));

            stage.show();

            // stage = (Stage) btnAdmin.getScene().getWindow();

            // stage.close();
        } catch (Exception e){
            System.out.print(e.toString());
        }
    }


    public void abrirPapeleta(ActionEvent event){
        try{

            FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("../Vista/Papeleta.fxml"));
            Parent root1= (Parent)fxmlLoader.load();

            Stage stage= new Stage();

            stage.setScene(new Scene(root1));

            stage.show();

            // stage = (Stage) btnAdmin.getScene().getWindow();

            // stage.close();

        } catch (Exception e){
            System.out.print(e.toString());
        }

    }


}
