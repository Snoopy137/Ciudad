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
public class Cobradores {
    private int idcobrador;
    private String nombrecobrador;
    private double comisioncobrador;
    private String observcobrador;
            
     public Cobradores(){}
     public Cobradores (int id, String nombre, int comision, String observ){
        this.idcobrador = id;
        this.nombrecobrador = nombre;
        this.comisioncobrador = comision;
        this.observcobrador = observ;
    }
    
    public String getNombre() {
        return nombrecobrador;
    }
    
    
    
    public int getIdcobrador() {
        return idcobrador;
    }

    public void setIdcobrador(int idcobrador) {
        this.idcobrador = idcobrador;
    }

    public String getNombrecobrador() {
        return nombrecobrador;
    }
     public void setComisioncobrador(double comisioncobrador) {
        this.comisioncobrador = comisioncobrador;
    }

       public double getComisioncobrador() {
        return comisioncobrador;
    }
       public String getObservcobrador() {
        return observcobrador;
    }
       public void setObserv(String observcobrador) {
        this.observcobrador = observcobrador;
    }
       
       public void setNombre (String nombrecobrador){
           this.nombrecobrador = nombrecobrador;
       }
    }
