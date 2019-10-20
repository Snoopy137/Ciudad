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
public class ListaCompanias {
    private ArrayList <Companias>listacompanias;
    
    public ListaCompanias (ArrayList <Companias>listacompanias){
        super();
        this.listacompanias=listacompanias;
    }
    
    public ListaCompanias (){
        super();
        this.listacompanias=new ArrayList <Companias>();
    }
    
    public int getSize(){
        return listacompanias.size();
    }
    
    public void clean (){
        listacompanias.clear();
    }
    
    public ArrayList<Companias> getCompania(){
        return listacompanias;
    }
    
    public Companias getCompania(int i){
        return listacompanias.get(i);
    }
    public void setCompanias(ArrayList<Companias> listacompanias){
        this.listacompanias=listacompanias;
    }
    
    public void agregaCompania (Companias comp){
        listacompanias.add(comp);
    }
}
