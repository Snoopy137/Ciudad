/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Conexion.ConexionBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class DNITipo {
    public ArrayList<String> getDNItipo (){
        ArrayList<String> dnis = new ArrayList<String>();
        try {
            Connection con = ConexionBase.conectar();
            PreparedStatement pst = con.prepareStatement("SELECT * FROM DOCUMENTOS" );
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                String tipoDNI = rs.getString("idDOCUMENTOS")+" "+rs.getString("TIPO");
                dnis.add(tipoDNI);
            }
            rs.close();
            pst.close();
            ConexionBase.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(DNITipo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dnis;
    }
}
