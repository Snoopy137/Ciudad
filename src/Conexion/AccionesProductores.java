/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import Datos.Productores;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author edudec
 */
public class AccionesProductores {
    public static ArrayList<Productores> buscaProductores(){
        ArrayList<Productores> productores = new ArrayList<>();
        try{
            Connection con = ConexionBase.conectar();
            PreparedStatement pst = con.prepareStatement("SELECT idPRODUCTORES,NOMBRE FROM PRODUCTORES ORDER BY NOMBRE");
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                Productores productor = new Productores();
                productor.setId(rs.getInt("idPRODUCTORES"));
                productor.setNombre(rs.getString("Nombre"));
                productores.add(productor);
            }
        }
        catch (Exception e){
            
        }
        return productores;
    }
}
