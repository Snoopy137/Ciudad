/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author linux
 */
public class Usuarios {
    private int idusuario;
    private String nombre;
    private String usuario;
    private String contrasenia;
    private String priviliegios;
    
    public Usuarios (int idusuario, String nombre, String usuario, String contrasenia, String privilegios){
        this.idusuario = idusuario;
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.priviliegios = privilegios;
    }
    
    public Usuarios(){}

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getPriviliegios() {
        return priviliegios;
    }

    public void setPriviliegios(String priviliegios) {
        this.priviliegios = priviliegios;
    }
    
    
}
