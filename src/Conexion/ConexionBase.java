/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author linux
 */
public class ConexionBase {
    static Connection con = null;
    static String usuario = "sql10289579";
        static String password = "ZXTTkkSudQ";
    static String url = "jdbc:mysql://sql10.freesqldatabase.com:3306/";
    static String basee = "sql10289579";
    
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
}
