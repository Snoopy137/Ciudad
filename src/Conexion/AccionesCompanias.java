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
import java.sql.Statement;

/**
 *
 * @author linux
 */
public class AccionesCompanias {
    
    public static int Inserta(Companias comp){
        int resultado = 0;
        Connection con = ConexionBase.conectar();
        int id = comp.getIdcompanias();
        String nombre = comp.getNombrecompanias();
        try{
            PreparedStatement siex = con.prepareStatement("SELECT * FROM companias WHERE NombreCompañia = '"+nombre+"' ");
            ResultSet rssiex = siex.executeQuery();
            if (rssiex.next()){
                javax.swing.JOptionPane.showMessageDialog(null,"La compañía ya existe","Dato duplicado",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                PreparedStatement pst = con.prepareStatement("INSERT INTO companias VALUES("+0+",'"+nombre+"' ");
                resultado = pst.executeUpdate();
            }
        }
        catch (Exception e){
            e.printStackTrace();
            ConexionBase.desconectar();
        }
        ConexionBase.desconectar();
        return resultado;
    }
    
    public static ListaCompanias buscacompanias (int row, String nombre){
        Connection con =ConexionBase.conectar();
        String filtro = "WHERE NombreCompañia like '%" + nombre +"%'";
		if (row != 0){
			filtro = filtro + " AND nrosocio = " + row;      
		}
                
                ListaCompanias comp = new ListaCompanias();
                try{
                    Statement stmt = con.createStatement();
	            ResultSet r = stmt.executeQuery("SELECT * FROM companias "+ filtro +"ORDER BY NombreCompañia");
		    ResultSetMetaData rm = r.getMetaData();
                    
                    while (r.next()){
                            Companias c = new Companias();
                            c.setIdcompanias(r.getInt("ID"));
                            c.setNombrecompanias(r.getString("NombreCompañia"));
                            
                            comp.agregaCompania(c);
                        }
                }
                catch (Exception e){
                    e.printStackTrace();
                    ConexionBase.desconectar();
                }
                ConexionBase.desconectar();
                    return comp;
    }
}
