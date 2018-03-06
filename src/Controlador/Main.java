package Controlador;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("../Vista/Menu.fxml"));
        primaryStage.setTitle("");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        if(permitirVotacion("1"))
        {
            System.out.print("Puede votar!");
        }
        else
        {
            System.out.print("Ya voto!");
        }

    }
    private boolean  permitirVotacion(String pIdentificacion)
    {
        try {

        Conexion con = new Conexion();
        Connection x = con.conectar();

        String sql = "Select * from Votante where identificacion = ?";
        PreparedStatement pst = x.prepareStatement(sql);
        pst.setString(1,"1");
        ResultSet resp = pst.executeQuery();

        while(resp.next())
        {


            if(!resp.getBoolean(3))
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        }
        catch (Exception e)
        {

        }
    return true;

    }


    public static void main(String[] args) {
        launch(args);
    }
}
