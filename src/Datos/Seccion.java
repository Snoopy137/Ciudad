/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author AlanDec
 */
public class Seccion {
    private int idSECCIONES;
    private String nombre;
    private String nombreReducido;

    public Seccion() {
    }

    public Seccion(int idSECCIONES, String nombre, String nombreReducido) {
        this.idSECCIONES = idSECCIONES;
        this.nombre = nombre;
        this.nombreReducido = nombreReducido;
    }

    public int getIdSECCIONES() {
        return idSECCIONES;
    }

    public void setIdSECCIONES(int idSECCIONES) {
        this.idSECCIONES = idSECCIONES;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreReducido() {
        return nombreReducido;
    }

    public void setNombreReducido(String nombreReducido) {
        this.nombreReducido = nombreReducido;
    }
    
    
}
