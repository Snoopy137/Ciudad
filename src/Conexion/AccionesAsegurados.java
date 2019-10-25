/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import Datos.Asegurados;
import Datos.Usuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author linux
 */
public class AccionesAsegurados {
    
    public static int insertaAsegurado(Asegurados A){
        int resultado = 0;
        Connection con  = ConexionBase.conectar();
        try{
            PreparedStatement pstex = con.prepareStatement("SELECT * FROM asegurados WHERE Numaseg = "+A.getNumasegurado());
            ResultSet rs = pstex.executeQuery();
            if (rs.next()){
                resultado = 2;
                return resultado;
            }
            else {
                PreparedStatement pst = con.prepareStatement("INSERT INTO asegurados VALUES ("+0+", "+A.getNumasegurado()+","
                        + " '"+A.getNombreasegurado()+"', '"+A.getDomicilioasegurado()+"','"+A.getDomiciliocobroasegurado()+"',"
                        + " '"+A.getLocalidad()+"','"+A.getCodigopostal()+"','"+A.getDNItipo()+"',"+A.getDNInumero()+","
                        + " '"+A.getTele1()+"','"+A.getTele2()+"','"+A.getTele3()+"',"+A.getFechanac()+","+A.getCuil()+","
                        + " '"+A.getActividad()+"','"+A.getMail()+"','"+A.getEstado()+"',"+A.getCobrador()+",'"+A.getObservaciones()+"',"
                        + " "+A.getAlta()+","+A.getBaja()+","+A.getUsu()+","+A.getModificado()+" ");
                resultado = pst.executeUpdate();
                ConexionBase.desconectar();
                return resultado;

            }
        }
        catch (Exception e){
            e.printStackTrace();
            ConexionBase.desconectar();
        }
        ConexionBase.desconectar();
        return resultado;
    }
}
