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
    private Long DNI;
    private ListaAsegurados listAseg;

    public ListaAsegurados getListAseg() {
        return listAseg;
    }

    public void setListAseg(ListaAsegurados listAseg) {
        this.listAseg = listAseg;
    }

    public BuscarAsegurados(String nombre, Long DNI) {
        this.nombre = nombre;
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getDNI() {
        return DNI;
    }

    public void setDNI(Long DNI) {
        this.DNI = DNI;
    } 
    
    @Override
    public void execute() {
        ListaAsegurados asegList = new ListaAsegurados();
        if(!nombre.equals(""))nombre=nombre+"%";
        String cond = "OR";
        if(!nombre.equals("") && DNI != 100000001)cond="AND";
        if(nombre.equals("") && DNI == 100000001)nombre="%"+nombre+"%";
        try {
            PreparedStatement pst = ConexionBase.con.prepareStatement("SELECT Nombre,DNINro,Tele1 FROM asegurados WHERE nombre LIKE '"+nombre.replaceAll("'","\\''")+"' "+cond+" DNINro LIKE '"+DNI+"%' ORDER BY Nombre");
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                Asegurados aseg = new Asegurados();
                aseg.setNombreasegurado(rs.getString("Nombre"));
                aseg.setDNInumero(rs.getLong("DNINro"));
                aseg.setTele1(rs.getString("Tele1"));
                asegList.agregaAsegurado(aseg);
            }
            rs.close();
            pst.close();
            setListAseg(asegList);
        } catch (SQLException ex) {
            Logger.getLogger(AccionesAsegurados.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
