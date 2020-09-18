/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import Datos.Asegurados;
import Datos.Hilo;
import Datos.ListaAsegurados;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class BuscarAsegurados extends Hilo{
    private String nombre;
    private int DNI;
    private ListaAsegurados listAseg;

    public ListaAsegurados getListAseg() {
        return listAseg;
    }

    public void setListAseg(ListaAsegurados listAseg) {
        this.listAseg = listAseg;
    }

    public BuscarAsegurados(String nombre, int DNI) {
        this.nombre = nombre;
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    } 
    
    @Override
    public void execute() {
        ListaAsegurados asegList = new ListaAsegurados();
        Connection con = ConexionBase.conectar();
        if(!nombre.equals(""))nombre=nombre+"%";
        String cond = "OR";
        if(!nombre.equals("") && DNI != 100000001)cond="AND";
        if(nombre.equals("") && DNI == 100000001)nombre="%"+nombre+"%";
        try {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM asegurados WHERE nombre LIKE '"+nombre.replaceAll("'","\\''")+"' "+cond+" DNINro LIKE '"+DNI+"%'");
            System.out.println(pst);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                Asegurados aseg = new Asegurados();
                aseg.setNombreasegurado(rs.getString("nombre"));
                aseg.setActividad(rs.getNString("Actividad"));
                aseg.setDNInumero(rs.getInt("DNINro"));
                aseg.setTele1(rs.getString("Tele1"));
                asegList.agregaAsegurado(aseg);
            }
            rs.close();
            pst.close();
            ConexionBase.desconectar();
            setListAseg(asegList);
        } catch (SQLException ex) {
            Logger.getLogger(AccionesAsegurados.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
