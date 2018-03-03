package Modelo;


import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import sun.jdbc.odbc.JdbcOdbcDriver;



public class ConexionDB {

    private static Connection Con;

    public static void OpenConnection(){
        try{
            DriverManager.registerDriver(new sun.jdbc.odbc.JdbcOdbcDriver() );
            Con = DriverManager.getConnection("jdbc:odbc:pos");
            JOptionPane.showMessageDialog(null, "Connected");
        }catch (Exception e){


        }
    }

    public static void main(String arg[]){
        OpenConnection();
    }

    public static Connection GetConnection(){

        return Con;


    }﻿
}
