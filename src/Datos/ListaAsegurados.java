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
public class ListaAsegurados {
    private ArrayList <Asegurados>listaasegurados;
    
    public ListaAsegurados (ArrayList <Asegurados>listaasegurados){
        super();
        this.listaasegurados=listaasegurados;
    }
    
    public ListaAsegurados (){
        super();
        this.listaasegurados=new ArrayList <Asegurados>();
    }
    
    public int getSize(){
        return listaasegurados.size();
    }
    
    public void clean (){
        listaasegurados.clear();
    }
    
    public ArrayList<Asegurados> getAsegurados(){
        return listaasegurados;
    }
    
    public Asegurados getAsegurado(int i){
        return listaasegurados.get(i);
    }
    
    public void setAsegurados(ArrayList<Asegurados> listaasegurados){
        this.listaasegurados=listaasegurados;
    }
    
    public void agregaAsegurado (Asegurados aseg){
        listaasegurados.add(aseg);
    }
}
