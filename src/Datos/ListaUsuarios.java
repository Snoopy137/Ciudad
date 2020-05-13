/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.util.ArrayList;

/**
 *
 * @author linux
 */
public class ListaUsuarios {
    
    private ArrayList<Usuarios>listadousuario;
    
    public ListaUsuarios (ArrayList<Usuarios>listadousuario){
        super();
        listadousuario = listadousuario;
    }
    public ListaUsuarios (){
        super();
        listadousuario = new ArrayList<Usuarios>();
    }
    
    public int getSize(){
        return listadousuario.size();
    }
    
    public Usuarios getUsuario(int i){
        return listadousuario.get(i);
    }
    
    public void clean (){
        listadousuario.clear();
    }
    
    public ArrayList<Usuarios> getUsuario(){
        return listadousuario;
    }
    
    public void setUsuario(ArrayList<Usuarios> listadousuario){
        this.listadousuario=listadousuario;
    }
    public void agregaUsaurio (Usuarios u){
        listadousuario.add(u);
    }
}
