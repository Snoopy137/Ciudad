/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import Datos.ListaUsuarios;
import Datos.Usuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

/**
 *
 * @author linux
 */
public class AccionesUsuarios {
    
    public static int inserta(Usuarios u){
        int status = 0;
        String nombre = u.getNombre();
        String apellido = u.getApellido();
        String usuario = u.getUsuario();
        String contrasenia = u.getContrasenia();
        String privilejios = u.getPriviliegios();
        String correo = u.getCorreo();
        
        try{
            Connection con = new ConexionBase().conectar();
            PreparedStatement existe = con.prepareStatement("SELECT * FROM usuarios WHERE Usuario = '"+usuario+"' ");
            PreparedStatement psmt = con.prepareStatement("INSERT INTO usuarios VALUES ('"+0+"','"+nombre+"','"+apellido+"','"+correo+"','"+usuario+"','"+contrasenia+"'"
                    + ",'"+privilejios+"' )");
            ResultSet siex = existe.executeQuery();
            if (siex.next()){
                javax.swing.JOptionPane.showMessageDialog(null, "El usuario ya existe!","Informacion",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                status = psmt.executeUpdate();
                ConexionBase.desconectar();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        ConexionBase.desconectar();
        return status;
    }
    
    public static Usuarios validacion (Usuarios u){
        Usuarios us = null;
        String usuario = u.getUsuario();
        String contrasenia = u.getContrasenia();
        String privilejios = u.getPriviliegios();
        
        try{
            Connection con = new ConexionBase().conectar();
            PreparedStatement valida = con.prepareStatement("SELECT * FROM usuarios WHERE Usuario = '"+usuario+"'"
                   );
            ResultSet rs = valida.executeQuery();
            if (rs.next()){ 
                us = new Usuarios();
                us.setPriviliegios(rs.getString("privilegios"));
                us.setContrasenia(new String (rs.getString("Contrasenia").toCharArray()));
                us.setIdusuario(rs.getInt("idusuarios"));
                us.setNombre(rs.getString("Nombre"));
                us.setUsuario(rs.getString("Usuario"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return us;
    }
    
    public static int modifica (Usuarios u){
        int status = 0;
        int id = u.getIdusuario();
        String nombre = u.getNombre();
        String usuario = u.getUsuario();
        String contrasenia = u.getContrasenia();
        String privilejios = u.getPriviliegios();
        
        try{
            Connection con = new ConexionBase().conectar();
            PreparedStatement pst = con.prepareStatement("UPDATE usuarios SET Nombre = '"+nombre+"', Usuario ='"+usuario+"'"
                    + ",Contrasenia = '"+contrasenia+"', Privilegios = '"+privilejios+"' WHERE idusuarios = "+id+" ");
            status = pst.executeUpdate();
            ConexionBase.desconectar();
            
        }
        catch(Exception e){
            e.printStackTrace();
            ConexionBase.desconectar();
        }
        return status;
    }
    
    public static ListaUsuarios BuscaUsuario (int row, String nombre){
        Connection con = new ConexionBase().conectar();
        String filtro = "WHERE Nombre like '%" + nombre +"%'";
		if (row != 0){
			filtro = filtro + " AND nrosocio = " + row;      
		}
                ListaUsuarios list = new ListaUsuarios();
                
                try{
                    Statement stmt = con.createStatement();
			ResultSet r = stmt.executeQuery("SELECT * FROM usuarios "+ filtro +"ORDER BY Nombre");
			ResultSetMetaData rm = r.getMetaData();
                        
                        while (r.next()){
                            Usuarios u = new Usuarios();
                            u.setIdusuario(r.getInt("idusuarios"));
                            u.setNombre(r.getString("Nombre"));
                            u.setApellido(r.getString("Apellido"));
                            u.setUsuario(r.getString("Usuario"));
                            u.setContrasenia(r.getString("Contrasenia"));
                            u.setPriviliegios(r.getString("Privilegios"));
                            
                            list.agregaUsaurio(u);
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
    
    public static Usuarios Busqueda(int usu){
        Connection con = new ConexionBase().conectar();
        Usuarios u = new Usuarios();
        try{
            PreparedStatement pst = con.prepareStatement("SELECT * FROM usuarios WHERE idusuarios = "+usu);
            ResultSet rs = pst.executeQuery();
            if (rs.next()){
                u.setIdusuario(rs.getInt("idusuarios"));
                u.setNombre(rs.getString("Nombre"));
                u.setApellido(rs.getString("Apellido"));
                u.setCorreo(rs.getString("Mail"));
                u.setUsuario(rs.getString("Usuario"));
                u.setContrasenia(rs.getString("Contrasenia"));
                u.setPriviliegios(rs.getString("Privilegios"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
            ConexionBase.desconectar();
        }
        ConexionBase.desconectar();
        return u;
    }
    
    public static int cambiarcontrasenia(Usuarios u,String contraseniavieja, String contrasenia){
        int id = u.getIdusuario();
        Connection con = new ConexionBase().conectar();
        int resultado = 0;
        try{
            PreparedStatement siex = con.prepareStatement("SELECT * FROM usuarios WHERE ID ="+id+" AND Contrasenia = '"+contraseniavieja+"' ");
            ResultSet rs = siex.executeQuery();
            if (rs.next()){
            System.out.println("UPDATE usuarios SET Contrasenia ='"+contrasenia+"' WHERE ID = "+id);    
            PreparedStatement pst = con.prepareStatement("UPDATE usuarios SET Contrasenia ='"+contrasenia+"' WHERE ID = "+id);
            resultado = 1;
            }
            else {
                javax.swing.JOptionPane.showMessageDialog(null, "Contraseña incorrecta","Sin permisos",javax.swing.JOptionPane.ERROR_MESSAGE);
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
