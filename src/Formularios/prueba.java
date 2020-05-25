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
public class prueba extends Thread {

    int i = 0;
    boolean corriendo = true;
    pruebapausa p;

    public boolean isCorriendo() {
        return corriendo;
    }

    public void setCorriendo(boolean corriendo) {
        this.corriendo = corriendo;
    }

    public pruebapausa getP() {
        return p;
    }

    public void setP(pruebapausa p) {
        this.p = p;
    }
    
    

    @Override
    public void run() {
        while (corriendo) {
            synchronized (p){
                    while (p.getO()==0){
                        try {
                            p.wait();
                        } catch (InterruptedException ex) {
                            Logger.getLogger(prueba.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
            }
            i++;
            System.out.println("hola " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(prueba.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public synchronized void pausa() {
            if (i == 0){
                corriendo = false;
                try {
                    wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(prueba.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
}
