/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AlanDec
 */
public class pruebapausa {
    int o = 1;

    public int getO() {
        return o;
    }

    public void setO(int o) {
        this.o = o;
    }
    
    synchronized void aviso(prueba p){
        if (o != 0){
            p.setCorriendo(true);
            this.notify();
        }
    }
    
    synchronized void espera (prueba p){
        if (o == 0){
            try {
                p.setCorriendo(false);
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(pruebapausa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
