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
public class ListadoAutos {
    private ArrayList <Autos> listadoAutos;
    
    public ListadoAutos (ArrayList<Autos> listadoAutos){
        this.listadoAutos = listadoAutos;
    }
    
    public ListadoAutos (){
        this.listadoAutos = new ArrayList <> ();
    }
    
    public int getSize(){
        return listadoAutos.size();
    }
    
    public void clean(){
        listadoAutos.clear();
    }
    
    public ArrayList<Autos> getAutos(){
        return listadoAutos;
    }
    
    public Autos getAuto(int i){
        return listadoAutos.get(i);
    }
    
    public void setAutos(ArrayList <Autos> listadoAutos){
        this.listadoAutos = listadoAutos;
    }
    
    public void agregaAuto (Autos auto){
        listadoAutos.add(auto);
    }
}
