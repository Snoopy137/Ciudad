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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        pro.crono.start();
        pro.siguiendo(true);
        pro.barres(false);
        pro.proceso("Conectando con base de datos");
        Connection con = new ConexionBase().conectar();
        pro.proceso("Conectado");
        try {
            double porcentaje1 = 1.0 / listaAutos.getSize() * 100;
            double porcentaje = 0.0;
            String insert = "INSERT INTO AUTOS (idAUTOS,COMPANIA,SECCION,POLIZA,"
                    + "ENDOSO,CERTIFICADO,ITEM,COBERTURA,MARCA,MODELO,PATENTE,ANIO,MOTOR,CHASIS,"
                    + "ACCESORIOS,OBVSERV) VALUES\n";
            StringBuilder sb = new StringBuilder(insert);
            pro.proceso("Procesando datos");
            pro.siguiendo(false);
            pro.barres(true);
            pro.progreso(0);
            for (int i = 0; i < listaAutos.getSize(); i++) {
                synchronized (super.m) {
                    while (!m.isTrue()) {
                        try {
                            m.wait();
                        } catch (InterruptedException ex) {
                            Logger.getLogger(CargaMasivaCobranza1.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                porcentaje = porcentaje + porcentaje1;
                Autos auto = listaAutos.getAuto(i);
                sb.append("(").append("0,").
                        append(auto.getCompania()).append(",").
                        append(auto.getSeccion()).append(",").
                        append(auto.getPoliza()).append(",").
                        append(auto.getEndoso()).append(",").
                        append(auto.getCertificado()).append(",").
                        append(auto.getItem()).append(",").
                        append("'").append(auto.getCobertura()).append("',").
                        append("'").append(auto.getMarca()).append("',").
                        append("'").append(auto.getModelo()).append("',").
                        append("'").append(auto.getPatente()).append("',").
                        append(auto.getAnio()).append(",").
                        append("'").append(auto.getMotor()).append("',").
                        append("'").append(auto.getChasis()).append("',").
                        append("'").append(auto.getAccesorios()).append("',").
                        append("'").append(auto.getObvserv()).append("')\n");
                if (i != listaAutos.getSize() - 1) {
                    sb.append(",");
                }
                pro.progreso((int) Math.round(porcentaje));
                pro.cant(String.valueOf(i + 1) + " registros procesados de " + listaAutos.getSize());
            }
            sb.append("ON DUPLICATE key UPDATE COMPANIA=values(COMPANIA),SECCION=values(SECCION),POLIZA=values(POLIZA),"
                    + "CERTIFICADO=values(CERTIFICADO),ENDOSO=values(ENDOSO),ITEM=values(ITEM),COBERTURA=values(COBERTURA),"
                    + "MARCA=values(MARCA),MODELO=values(MODELO),PATENTE=values(PATENTE),ANIO=values(ANIO),MOTOR=values(MOTOR),"
                    + "CHASIS=values(CHASIS),ACCESORIOS=values(ACCESORIOS),OBVSERV=values(OBVSERV);");
            insert = sb.toString();
            PreparedStatement pst = con.prepareStatement(insert);
            pro.siguiendo(true);
            pro.barres(false);
            pro.proceso("Escribiendo datos en base");
            int resultado = pst.executeUpdate();
            pro.siguiendo(false);
            pro.barres(true);
            pro.proceso("Proceso completado");
            pro.crono.stop();
            pst.close();
            ConexionBase.desconectar();
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}
