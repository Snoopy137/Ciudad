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
public class Companias {
    private int idcompanias;
    private String nombrecompanias;
    
    public Companias(){}
    public Companias (int id, String nombre){
        this.idcompanias = id;
        this.nombrecompanias = nombre;
    }

    public int getIdcompanias() {
        return idcompanias;
    }

    public void setIdcompanias(int idcompanias) {
        this.idcompanias = idcompanias;
    }

    public String getNombrecompanias() {
        return nombrecompanias;
    }

    public void setNombrecompanias(String nombrecompanias) {
        this.nombrecompanias = nombrecompanias;
    }
}
