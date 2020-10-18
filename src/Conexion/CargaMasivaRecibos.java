/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import Datos.Hilo;
import Datos.ListadoRecibos;
import Datos.Recibos;
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
public class CargaMasivaRecibos extends Hilo{
    private Progreso pro;
    private ListadoRecibos listaRecibos;

    public CargaMasivaRecibos(Progreso pro, ArrayList<Recibos> listaRecibos) {
        this.pro = pro;
        this.listaRecibos = new ListadoRecibos(listaRecibos);
    }

    @Override
    public void execute() {
        pro.crono.start();
        pro.siguiendo(true);
        pro.barres(false);
        pro.proceso("Conectando con base de datos");
        //Connection con = ConexionBase.con;
        Connection con = ConexionBase.conectar();
        pro.proceso("Conectado");
        try {
            double porcentaje1 = 1.0 / listaRecibos.getSize() * 100;
            double porcentaje = 0.0;
            String insert = "INSERT INTO RECIBOS (idRECIBOS,COMPANIA,SECCION,POLIZA,"
                    + "CERTIFICADO,ENDOSO,FECVENC,"
                    + "ESTADO,CUOTA,ANTICIPO,PREMIO,PRIMA) VALUES";
            StringBuilder sb = new StringBuilder(insert);
            pro.proceso("Procesando datos");
            pro.siguiendo(false);
            pro.barres(true);
            pro.progreso(0);
            for (int i = 0; i < listaRecibos.getSize(); i++) {
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
                Recibos recibo = listaRecibos.getRecibo(i);
                StringBuilder append = sb.append("(").
                        append(0).append(",").
                        append(recibo.getCompania()).
                        append(",").append(recibo.getSeccion()).
                        append(",").append(recibo.getPoliza()).
                        append(",").append(recibo.getCertificado()).
                        append(",").append(recibo.getEndoso()).
                        append(",'").append(new java.sql.Date(recibo.getFecvenc().getTime())).
                        append("',").append(recibo.getEstado()).
                        append(",").append(recibo.getCuota()).append(",").
                        append("'").append(recibo.getAnticipo()).
                        append("',").append(recibo.getPremio()).
                        append(",").append(recibo.getPrima()).append(")");
                if (i != listaRecibos.getSize() - 1) {
                    sb.append(",");
                }
                pro.progreso((int) Math.round(porcentaje));
                pro.cant(String.valueOf(i + 1) + " registros procesados de " + listaRecibos.getSize());
            }
            sb.append("ON DUPLICATE key UPDATE COMPANIA=values(COMPANIA),SECCION=values(SECCION),POLIZA=values(POLIZA),"
                            + "CERTIFICADO=values(CERTIFICADO),ENDOSO=values(ENDOSO),FECVENC=values(FECVENC),ESTADO=values(ESTADO),CUOTA=values(CUOTA),"
                            + "ANTICIPO=values(ANTICIPO),PREMIO=values(PREMIO),PRIMA=values(PRIMA);");
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
