/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import Datos.Cobradores;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author linux
 */
public class AccionesCobrador {
    
    public static int inserta(Cobradores cobr){
        int resultado = 0;
        Connection con = ConexionBase.conectar();
        try {
            
            PreparedStatement pst;
            pst = con.prepareStatement("INSERT INTO COBRADOR (idCOBRADOR, NOMBRE, "
                    + "COMISION, OBSERV) VALUES "
                    + "(0, '"+cobr.getNombrecobrador()+"',"+cobr.getComisioncobrador()+","
                            + "'"+cobr.getObservcobrador()+"')");
                    
                    
        resultado = pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccionesCobrador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
    public static boolean existe(String nombre){
        boolean resultado = false;
        try {
            Connection con = ConexionBase.conectar();
            PreparedStatement pst = con.prepareStatement("SELECT NOMBRE FROM COBRADOR WHERE NOMBRE LIKE '%"+nombre+"%' ");
            ResultSet rs = pst.executeQuery();
            if(rs.next())resultado = true;
        } catch (SQLException ex) {
            Logger.getLogger(AccionesCobrador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
    public static ArrayList<Cobradores> buscacobrador (int row, String nombre){
        Connection con = new ConexionBase().conectar();
        String filtro = "WHERE NombreCobrador like '%" + nombre +"%'";
		if (row != 0){
			filtro = filtro + " AND id = " + row;      
		}
                
                ArrayList<Cobradores> cobr = new ArrayList<>();
                try{
                    Statement stmt = con.createStatement();
	            ResultSet r = stmt.executeQuery("SELECT * FROM cobrador "+ filtro +"ORDER BY NombreCobrador");
		    ResultSetMetaData rm = r.getMetaData();
                    
                    while (r.next()){
                            Cobradores c = new Cobradores();
                            c.setIdcobrador(r.getInt("ID"));
                            c.setNombre(r.getString("Nombre"));
                            
                            cobr.add(c);
                        }
                }
                catch (Exception e){
                    e.printStackTrace();
                    ConexionBase.desconectar();
                }
                ConexionBase.desconectar();
                    return cobr;
    }
}
