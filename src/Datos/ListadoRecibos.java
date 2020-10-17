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
public class ListadoRecibos {
    private ArrayList <Recibos>listarecibos;

    public ListadoRecibos(ArrayList<Recibos> listarecibos) {
        this.listarecibos = listarecibos;
    }
    
    public ListadoRecibos(){
        super();
        this.listarecibos=new ArrayList <Recibos>();
    }
    
    public int getSize(){
        return listarecibos.size();
    }
    
    public void clean (){
        listarecibos.clear();
    }
    
    public ArrayList<Recibos> getRecibos(){
        return listarecibos;
    }
    
    public Recibos getRecibo(int i){
        return listarecibos.get(i);
    }
    
    public void setRecibos(ArrayList<Recibos> listarecibos){
        this.listarecibos=listarecibos;
    }
    
    public void agregaRecibo (Recibos recibo){
        listarecibos.add(recibo);
    }
}
