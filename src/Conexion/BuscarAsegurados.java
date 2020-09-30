/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import Datos.Asegurados;
import Datos.Hilo;
import Datos.ListaAsegurados;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    
    public Asegurados buscaAegurado (){
        Asegurados aseg = new Asegurados();
        try {
            PreparedStatement pst = ConexionBase.con.prepareStatement("SELECT * FROM asegurados, WHERE nombre = '"+nombre.replaceAll("'","\\''")+"' AND DNINro = "+DNI);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                aseg.setNombreasegurado(rs.getString("Nombre"));
                aseg.setActividad(rs.getString("Actividad"));
                aseg.setNumasegurado(rs.getInt("Numaseg"));
                aseg.setDomicilioasegurado(rs.getString("Domicilio"));
                aseg.setDomiciliocobroasegurado(rs.getString("DomicilioCobro"));
                aseg.setLocalidad(rs.getString("Localidad"));
                aseg.setCodigopostal(rs.getString("CodPostal"));
                aseg.setDNItipo(rs.getString("DNITipo"));
                aseg.setDNInumero(rs.getLong("DNINro"));
                aseg.setTele1(rs.getString("Tele1"));
                aseg.setTele1(rs.getString("Tele2"));
                aseg.setTele1(rs.getString("Tele3"));
                aseg.setFechanac(rs.getDate("FecNac"));
                aseg.setCuil(rs.getLong("CUIL"));
                aseg.setMail(rs.getString("Mail"));
                aseg.setEstado(rs.getString("Estado"));
                aseg.setCobrador(rs.getInt("Cobrador"));
                aseg.setObservaciones(rs.getString("Observ"));
                aseg.setAlta(rs.getDate("ALTA"));
                aseg.setAlta(rs.getDate("BAJA"));
                aseg.setFechanac(rs.getDate("Fecha"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BuscarAsegurados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aseg;
    }
}
