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
public class Credencial {
    
    private Connection con;    
    private Statement state;
    private ResultSet res;
    
    private String rfid;
    private String rut;

    public Credencial() {
    }

    public Credencial(String rfid, String rut) {
        this.rfid = rfid;
        this.rut = rut;
    }

    public String getRfid() {
        return rfid;
    }

    public void setRfid(String rfid) {
        this.rfid = rfid;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }
   
   public Credencial buscarRut(Conexion con){
        String sql ="Select * from credencial where Rut ='"+this.rut+"'";
        Credencial c1 = null;
        
        try {
            state = con.getConexion().createStatement();
            res = state.executeQuery(sql);
            if(res.next())
            {
                c1 = new Credencial();
                String nom = res.getString("Rut");
                c1.setRut(nom);
            }            
            
        } catch (SQLException ex) {
            Logger.getLogger(Alumno.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            con.cerrarConexion();
        }
        return c1;
        
        
    }
   
    public Credencial buscarRfid(Conexion con){
        String sql ="Select * from credencial where rfid ='"+this.rfid+"'";
        Credencial c1 = null;
        
        try {
            state = con.getConexion().createStatement();
            res = state.executeQuery(sql);
            if(res.next())
            {
                c1 = new Credencial();
                String rfid = res.getString("rfid");
                c1.setRfid(rfid);
                String rut = res.getString("Rut");
                c1.setRut(rut);
            }            
            
        } catch (SQLException ex) {
            Logger.getLogger(Alumno.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            con.cerrarConexion();
        }
        return c1;
        
        
    }
    
}
