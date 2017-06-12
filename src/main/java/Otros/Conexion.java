/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Otros;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jose
 */
public class Conexion {
    
    public static Conexion conexion;
    private Connection con;
    
    private String host = "jdbc:mysql://localhost:3306/pruebas?zeroDateTimeBehavior=convertToNull";
    private String user = "root";
    private String pass = "";
    
    private Conexion()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(host, user, pass);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public synchronized static Conexion saberEstado(){
        if (conexion == null)
        {
            conexion =  new Conexion(); 
        }
        return conexion;
    }
    
    public Connection getConexion()
    {
        return con;
    }
    
    public void cerrarConexion()
    {
        conexion = null;
    }
   
}
