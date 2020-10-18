/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import Datos.Autos;
import Datos.Hilo;
import Datos.ListadoAutos;
import Formularios.Progreso;
import java.util.ArrayList;

/**
 *
 * @author linux
 */
public class CargaMasivaAutos extends Hilo{

    private Progreso pro;
    private ListadoAutos listaAutos;

    public CargaMasivaAutos(Progreso pro, ArrayList<Autos> listaAutos) {
        this.pro = pro;
        this.listaAutos = new ListadoAutos(listaAutos);
    }
    @Override
    public void execute() {
        
    }
    
}
