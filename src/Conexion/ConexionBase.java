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
    static String usuario = "alandec";
    static String password = "2wsx3edc";
    static String url = "jdbc:mysql://db4free.net:3306/";
    static String basee = "ciudad";
    
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
