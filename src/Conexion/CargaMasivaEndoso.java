/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import Datos.Endoso;
import Datos.Hilo;
import Datos.ListadoEndosos;
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
public class CargaMasivaEndoso extends Hilo {

    private Progreso pro;
    private ListadoEndosos listend;

    public CargaMasivaEndoso(Progreso pro, ArrayList<Endoso> listend) {
        this.pro = pro;
        this.listend = new ListadoEndosos(listend);
    }

    @Override
    public void execute() {
        pro.crono.start();
        pro.siguiendo(true);
        pro.barres(false);
        pro.proceso("Conectando con base de datos");
        Connection con = ConexionBase.conectar();
        pro.proceso("Conectado");
        try {
            double porcentaje1 = 1.0 / listend.getSize() * 100;
            double porcentaje = 0.0;
            String insert = "INSERT INTO ENDOSOS (idENDOSOS,COMPANIA,SECCION,POLIZA,"
                    + "CERTIFICADO,ENDOSO,FECHAMIS,DESDE,HASTA,"
                    + "TIPOENDOSO,MOTIVO,PLAN,ASEGURADO,MONEDA,SUMA,PRIMA,CODPRODUCTO,"
                    + "USUARIO,USUARIOOFI) VALUES";
            StringBuilder sb = new StringBuilder(insert);
            pro.proceso("Procesando datos");
            pro.siguiendo(false);
            pro.barres(true);
            pro.progreso(0);
            for (int i = 0; i < listend.getSize(); i++) {
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
                Endoso end = listend.getEndoso(i);
                Object hasta = "NULL";
                if (end.getHasta() != null)hasta = " '" + new java.sql.Date(end.getHasta().getTime()) + "'";
                StringBuilder append = sb.append("(").append(0).append(",").append(end.getCompania()).append(",").append(end.getSeccion()).append(",").append(end.getPoliza()).append(",").append(end.getCertificado()).
                        append(",").
                        append(end.getEndoso()).append(",").
                        append("'").append(end.getFechaemis()).append("',").append("'").append(end.getDesde()).
                        append("',").
                        append(hasta).append(",'").append(end.getTipoendoso()).append("',").append(end.getMotivo()).append(",'").append(end.getPlan()).
                        append("',").
                        append(end.getAsegurado()).append(",").append(end.getMoneda()).append(",").append(end.getSuma()).append(",").append(end.getPrima()).
                        append(",").
                        append(end.getCodproducto()).append(",").append(end.getUsuario()).append(",").append(end.getUsuarioofi());
                if (i != listend.getSize() - 1) {
                    sb.append(",");
                }
                pro.progreso((int) Math.round(porcentaje));
                pro.cant(String.valueOf(i + 1) + " registros procesados de " + listend.getSize());
            }
            sb.append("ON DUPLICATE key UPDATE COMPANIA=values(COMPANIA),SECCION=values(SECCION),POLIZA=values(POLIZA),"
                            + "CERTIFICADO=values(CERTIFICADO),ENDOSO=values(ENDOSO),FECHAMIS=values(FECHAMIS),DESDE=values(DESDE),HASTA=values(HASTA),"
                            + "TIPOENDOSO=values(TIPOENDOSO),MOTIVO=values(MOTIVO),PLAN=values(PLAN),ASEGURADO=values(ASEGURADO),MONEDA=values(MONEDA),"
                            + "SUMA=values(SUMA),PRIMA=values(PRIMA),CODPRODUCTO=values(CODPRODUCTO),USUARIO=values(USUARIO),USUARIOOFI=values(USUARIOOFI);");
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
            con.close();
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
