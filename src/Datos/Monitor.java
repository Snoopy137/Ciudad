/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AlanDec
 */
public class Monitor {
    public static boolean exec = true;
    
    public static boolean isTrue (){
        return exec;
    }
    
    public static void setExec(boolean exec){
        Monitor.exec = exec;
    }
    public synchronized void play (){
        exec = true;
        this.notify();
    }
}
