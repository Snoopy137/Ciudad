/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author linux
 */
public class ConexionBase {
    static Connection con = null;
    static String usuario = "P29OqZKK1A";
    static String password = "hUfTTSmZxT";
    static String url = "jdbc:mysql://remotemysql.com:3306/";
    static String basee = "P29OqZKK1A";
    
    public static Connection conectar(){
        if (con==null){
            try{
                con = DriverManager.getConnection(url+basee,usuario,password);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        return con;
    }
    
    public static Connection desconectar(){
        if(con!=null){
            try{
                con.close();
                con = null;
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        return con;
    }
    
    public static void main(String[] args) throws SQLException {
        PreparedStatement pst = conectar().prepareStatement("delete from COBRANZA");
        int rs = pst.executeUpdate();
        desconectar();
    }
}
