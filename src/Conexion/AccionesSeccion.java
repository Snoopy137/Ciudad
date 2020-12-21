/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import Datos.Seccion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AlanDec
 */
public class AccionesSeccion {
    public static List<Seccion> buscarSecciones(){
        List<Seccion> sec = new ArrayList<Seccion>();
        Connection con = ConexionBase.conectar();
        try{
            PreparedStatement pst = con.prepareStatement("SELECT * FROM SECCIONES ORDER BY NOMBRE");
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                Seccion secc = new Seccion();
                secc.setIdSECCIONES(rs.getInt("idSECCIONES"));
                secc.setNombre(rs.getString("NOMBRE"));
                secc.setNombreReducido(rs.getString("NOMBREREDUCIDO"));
                sec.add(secc);
            }
            rs.close();
            pst.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return sec;
    }
}
