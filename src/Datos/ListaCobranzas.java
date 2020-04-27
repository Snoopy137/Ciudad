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
public class ListaCobranzas {
    
    private ArrayList <Cobranza> listacobranzas;
    
    public ListaCobranzas (ArrayList <Cobranza> listacobranzas){
        super();
        this.listacobranzas=listacobranzas;
    }
    
    public ListaCobranzas (){
        super();
        this.listacobranzas = new ArrayList <Cobranza>();
    }
    
    public int getSize(){
        return listacobranzas.size();
    }
    
    public void clean(){
        listacobranzas.clear();
    }
    
    public Cobranza getCobranza (int i){
        return listacobranzas.get(i);
    }
    
    public ArrayList<Cobranza> getCobranza(){
        return listacobranzas;
    }
    
    public void setCobranzas (ArrayList<Cobranza> listacobranzas){
        this.listacobranzas = listacobranzas;
    }
    
    public void agregaCobrazna (Cobranza cob){
        listacobranzas.add(cob);
    }
}
