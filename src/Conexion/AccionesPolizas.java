/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import Conexion.ConexionBase;
import Datos.ListaPolizas;
import Datos.Polizas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author linux
 */
public class AccionesPolizas {
    public static ListaPolizas buscarPolizas(int asegurado){
        ListaPolizas listPol = new ListaPolizas();
        Connection con = new ConexionBase().conectar();
        try {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM POLIZAS WHERE Asegurado = "+asegurado);
            ResultSet rs = pst.executeQuery();
            System.out.println(pst);
            while(rs.next()){
                Polizas poli = new Polizas();
                poli.setIdpolizas(rs.getInt("idPOLIZAS"));
                poli.setCompania(rs.getInt("Compania"));
                poli.setSeccion(rs.getInt("Seccion"));
                poli.setPoliza(rs.getInt("Poliza"));
                poli.setCertificado(rs.getInt("Certificado"));
                poli.setRenueva(rs.getInt("Renueva"));
                poli.setRenovadapor(rs.getInt("Renovadapor"));
                poli.setIntpoliza(rs.getInt("Intpoliza"));
                poli.setProductor(rs.getInt("Productor"));
                poli.setTipooper(rs.getInt("Tipooper"));
                poli.setFechamis(rs.getDate("Fechamis"));
                poli.setDesde(rs.getDate("Desde"));
                poli.setHasta(rs.getDate("Hasta"));
                poli.setEstado(rs.getInt("Estado"));
                poli.setFechaestado(rs.getDate("Fechaestado"));
                poli.setAsegurado(rs.getInt("Asegurado"));
                poli.setMoneda(rs.getInt("Moneda"));
                poli.setCobrador(rs.getInt("Cobrador"));
                poli.setPrima(rs.getInt("Prima"));
                poli.setPremio(rs.getInt("Premio"));
                poli.setUsuario(rs.getInt("Usuario"));
                poli.setUsuarioofi(rs.getInt("usuarioofi"));
                poli.setFormapago(rs.getInt("Formapago"));
                listPol.agregaPolizas(poli);
            }
            rs.close();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccionesPolizas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listPol;
    }
    
    public static void main (String [] args){
            ListaPolizas pol = buscarPolizas(1023129);
        for(int i=0;i<pol.getZise();i++){
            System.out.println(pol.getPoliza(i).getAsegurado()+" "+pol.getPoliza(i).getPoliza());
        }
    }
}
