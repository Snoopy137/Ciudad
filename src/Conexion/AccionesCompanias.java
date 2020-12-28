/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import Datos.Companias;
import Datos.ListaCompanias;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author linux
 */
public class AccionesCompanias {
    
    public static int inserta(Companias comp){
        int resultado = 0;
        Connection con = ConexionBase.conectar();
        try {
            
            PreparedStatement pst;
            pst = con.prepareStatement("INSERT INTO COMPANIA (idCOMPANIA,NOMBRE,NOMBREREDUCIDO,URL, PRODCONTACTO, PRODMAIL, PRODTELEF, LOGCONTACTO, LOGMAIL, LOGTELEF, SINCONTACTO, SINMAIL, SINTELEF, COBCONTACTO, COBMAIL, COBTELEF, PROD1, PROD1USU, PROD1CLAVE, PROD2, PROD2USU, PROD2CLAVE, PROD3, PROD3USU, PROD3CLAVE) VALUES (0, '"+comp.getNombrecompanias()+"','"+comp.getNombrereducido()+"','"+comp.getUrl()+"','"+comp.getProdcontacto()+"','"+comp.getProdmail()+"','"+comp.getProdtelef()+"','"+comp.getLogcontacto()+"','"+comp.getLogmail()+"','"+comp.getLogtelef()+"','"+comp.getSincontacto()+"','"+comp.getSinmail()+"','"+comp.getSintelef()+"','"+comp.getCobcontacto()+"','"+comp.getCobmail()+"','"+comp.getCobtelef()+"',"+comp.getProd1()+",'"+comp.getProd1usu()+"','"+comp.getProd1clave()+"',"+comp.getProd2()+",'"+comp.getProd2usu()+"','"+comp.getProd2clave()+"',"+comp.getProd3()+",'"+comp.getProd3usu()+"','"+comp.getProd3clave()+"')");
                    
                    
        resultado = pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccionesCompanias.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
    public static boolean existe(String nombre){
        boolean resultado = false;
        try {
            Connection con = ConexionBase.conectar();
            PreparedStatement pst = con.prepareStatement("SELECT NOMBRE FROM COMPANIA WHERE NOMBRE LIKE '%"+nombre+"%' ");
            ResultSet rs = pst.executeQuery();
            if(rs.next())resultado = true;
        } catch (SQLException ex) {
            Logger.getLogger(AccionesCompanias.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
    public static List<Companias> buscarcompanias (int row, String nombre){
        Connection con = ConexionBase.conectar();
        String filtro = "WHERE NOMBRE like '%" + nombre +"%'";
		if (row != 0){
			filtro = filtro + " AND nrosocio = " + row;      
		}
                
                List<Companias> comp = new ArrayList<Companias>();
                try{
                    Statement stmt = con.createStatement();
	            ResultSet r = stmt.executeQuery("SELECT * FROM COMPANIA "+ filtro +"ORDER BY NOMBRE");
		    ResultSetMetaData rm = r.getMetaData();
                    
                    while (r.next()){
                            Companias c = new Companias();
                            c.setIdcompanias(r.getInt("idCOMPANIA"));
                            c.setNombrecompanias(r.getString("NOMBRE"));
                            c.setNombrereducido(r.getString("NOMBREREDUCIDO"));
                            comp.add(c);
                        }
                    r.close();
                    stmt.close();
                }
                catch (Exception e){
                    e.printStackTrace();
//                    ConexionBase.desconectar();
                }
//                ConexionBase.desconectar();
                    return comp;
    }
    
    public static ListaCompanias buscacompanias (int row, String nombre){
        Connection con = ConexionBase.conectar();
        String filtro = "WHERE NOMBRE like '%" + nombre +"%'";
		if (row != 0){
			filtro = filtro + " AND nrosocio = " + row;      
		}
                
                ListaCompanias comp = new ListaCompanias();
                try{
                    Statement stmt = con.createStatement();
	            ResultSet r = stmt.executeQuery("SELECT * FROM COMPANIA "+ filtro +"ORDER BY NOMBRE");
		    ResultSetMetaData rm = r.getMetaData();
                    
                    while (r.next()){
                            Companias c = new Companias();
                            c.setIdcompanias(r.getInt("idCOMPANIA"));
                            c.setNombrecompanias(r.getString("NOMBRE"));
                            c.setNombrereducido(r.getString("NOMBREREDUCIDO"));
                            comp.agregaCompania(c);
                        }
                    r.close();
                    stmt.close();
                }
                catch (Exception e){
                    e.printStackTrace();
                    ConexionBase.desconectar();
                }
                ConexionBase.desconectar();
                    return comp;
    }
}
