/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Otros;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jose
 */
public class Alumno {
    
    private String rut;
    private String nombre;
    private String rfid;
    
    private Connection con;
    private ResultSet res;
    private Statement state;

    public Alumno(String rut, String nombre, String rfid) {
        this.rut = rut;
        this.nombre = nombre;
        this.rfid = rfid;
    }

    public Alumno() {
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRfid() {
        return rfid;
    }

    public void setRfid(String rfid) {
        this.rfid = rfid;
    }
    
    public Alumno buscarAlumno(Conexion con){
        String sql ="Select * from alumno where rfid ='"+this.rfid+"'";
        Alumno a1 = null;
        
        try {
            state = con.getConexion().createStatement();
            res = state.executeQuery(sql);
            if(res.next())
            {
                a1 = new Alumno();
                String nom = res.getString("nombre");
                a1.setNombre(nom);
            }            
            
        } catch (SQLException ex) {
            Logger.getLogger(Alumno.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            con.cerrarConexion();
        }
        return a1;
        
        
    }
}
