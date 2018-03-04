package Controlador;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Driver;

public class Conexion {
    public Conexion()
    {
        ;
    }

    public Connection conectar()
    {
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://ecRhin.ec.tec.ac.cr\\Estudiantes;" +
                    "databaseName=Votacion;" +
                    "user=hvalverde;" +
                    "password=hvalverde";
            Connection con = DriverManager.getConnection(url);
            return con;
        }
        catch(Exception e)
        {
            System.out.print("ME CAI");
        }
        return null;
    }
}
