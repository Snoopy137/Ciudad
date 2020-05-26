package Datos;

import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AlanDec
 */
public abstract class Hilo extends Thread{
    public Monitor m = new Monitor();
    protected boolean execute = true;
    @Override
    public void run(){
        while (execute){
            synchronized (m){
                while (!m.isTrue()){
                    try {
                        m.wait();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            execute();
            terminate();
        }
    }
    
    public void pausa(){
        m.setExec(false);
    }
    
    public void play (){
        m.play();
    }
    
    public abstract void execute();
    
    public void terminate(){
        this.execute = false;
        m.play();
    }
}
