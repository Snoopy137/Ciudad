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
public class ListaPolizas {
    
    private ArrayList <Polizas>listapolizas;
    
    public ListaPolizas (ArrayList <Polizas> listapolizas){
        this.listapolizas = listapolizas;
    }
    
    public ListaPolizas (){
        this.listapolizas = new ArrayList <Polizas>();
    }
    
    public int getZise(){
        return listapolizas.size();
    }
    
    public void clean (){
        listapolizas.clear();
    }
    
    public ArrayList<Polizas> getlistapolizas(){
        return listapolizas;
    }
    
    public Polizas getPoliza (int i){
        return listapolizas.get(i);
    }
    
    public void setPolizas (ArrayList <Polizas> listapolizas){
        this.listapolizas = listapolizas;
    }
    
    public void agregaPolizas (Polizas pol){
        this.listapolizas.add(pol);
    }
}
