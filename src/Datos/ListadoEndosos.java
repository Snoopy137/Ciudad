/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class ListadoEndosos {
    
    ArrayList<Endoso> listaEndosos;

    public ListadoEndosos() {
        listaEndosos = new ArrayList<Endoso>();
    }

    public ListadoEndosos(ArrayList<Endoso> listaEndosos) {
        this.listaEndosos = listaEndosos;
    }

    public ArrayList getListaEndosos() {
        return listaEndosos;
    }

    public void setListaEndosos(ArrayList<Endoso> listaEndosos) {
        this.listaEndosos = listaEndosos;
    }
    
    public int getSize(){
        return listaEndosos.size();
    }
    
    public void clean(){
        listaEndosos.clear();
    }
    
    public Endoso getEndoso(int i){
        return listaEndosos.get(i);
    }
    
    public void agregaEndoso(Endoso end){
        listaEndosos.add(end);
    }
}
