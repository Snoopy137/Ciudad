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
        Connection con = ConexionBase.conectar();
        int resultado = 4;
        try {
        for (int i = 0; i<lispol.getZise();i++){
            Polizas pol = lispol.getPoliza(i);
            PreparedStatement pstm = con.prepareStatement("INSERT INTO polizas VALUES ("+0+",'"+pol.getNumpoliza()+"',"
                    + " "+pol.getIdcompanias()+",'"+pol.getNombreCompania()+"',"+pol.getIdseccion()+",'"+pol.getNombreseccion()+"',"
                    + " "+pol.getNumero()+", '"+pol.getEndoso()+"' ");
            resultado = pstm.executeUpdate();
            if (resultado != 1){
                break;
                }
            }
        return resultado;
        }
        catch (Exception e){
            e.printStackTrace();
            return resultado;
        }
    }
}
