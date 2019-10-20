/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Conexion.ConexionBase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

/**
 *
 * @author linux
 */
public class AccionesPolizas {
    public static ListaPolizas BuscaPolizas (int idpoliza, String nombre){
        Connection con =ConexionBase.conectar();
        String filtro = "WHERE nombrecompania like '%" + nombre +"%'";
		if (idpoliza != 0){
			filtro = filtro + " AND idpolizas = " + idpoliza;      
		}
                ListaPolizas list = new ListaPolizas();
                
                try{
                    Statement stmt = con.createStatement();
			ResultSet r = stmt.executeQuery("SELECT * FROM polizas "+ filtro);
			ResultSetMetaData rm = r.getMetaData();
                        
                        while (r.next()){
                            Polizas pol = new Polizas();
                            pol.setIdpolizas(r.getInt("idpolizas"));
                            pol.setNumpoliza(r.getInt("numpoliza"));
                            pol.setIdcompanias(r.getInt("idcompania"));
                            pol.setNombreCompania(r.getString("nombrecompania"));
                            pol.setIdseccion(r.getInt("idseccion"));
                            pol.setNombreseccion(r.getString("nomsec"));
                            pol.setNumero(r.getInt("numero"));
                            pol.setEndoso(r.getString("endoso"));
                            //pol.setVigenciadesde(r.getDate("vigenciadesde"));
                            //pol.setVigenciahasta(r.getDate("vigenciahasta"));
                            //pol.setDiapago(r.getDate("fechapago"));
                            //pol.setFechapago(r.getDate("diapago"));
                            
                            list.agregaPolizas(pol);
                        }
                        ConexionBase.desconectar();
                        return list;
                }
                catch (Exception e){
                    e.printStackTrace();
                    ConexionBase.desconectar();
                    return list;
                }
    }
    
    public static int agregaMasivaPolizas(ListaPolizas lispol){
        
    }
}
