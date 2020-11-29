/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import static Conexion.AccionesCobranza.crono;
import Datos.Cobranza;
import Datos.Hilo;
import Datos.ListaPolizas;
import Datos.Polizas;
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
public class CargaMasivaPolizas extends Hilo {

    private Progreso pro;
    private ListaPolizas listpol;
    private ListaPolizas listpolotro;

    public CargaMasivaPolizas(Progreso pro, ArrayList<Polizas> listpol, ArrayList<Polizas> listpolotro) {
        this.pro = pro;
        this.listpol = new ListaPolizas(listpol);
        this.listpolotro = new ListaPolizas(listpolotro);
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
            double porcentaje1 = 1.0 / listpol.getZise() * 100;
            double porcentaje = 0.0;
            String insert = "INSERT INTO POLIZAS (idPOLIZAS,COMPANIA,SECCION,POLIZA,"
                    + "CERTIFICADO,RENUEVA,RENOVADAPOR,PRODUCTOR,FECHAMIS,"
                    + "DESDE,HASTA,ESTADO,FECHAESTADO,ASEGURADO,MONEDA,COBRADOR,USUARIO,FORMAPAGO) VALUES\n";
            StringBuilder sb = new StringBuilder(insert);
            pro.siguiendo(false);
            pro.barres(true);
            pro.progreso(0);
            for (int i = 0; i < listpol.getZise(); i++) {
                pro.proceso("Procesando datos");
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
                Polizas pol = listpol.getPoliza(i);
                Object hasta = "NULL";
                if(pol.getHasta()!= null)hasta=" '"+new java.sql.Date(pol.getHasta().getTime())+"'";
                sb.append("(").append(0).append(",")
                        .append(pol.getCompania()).append(",")
                        .append(pol.getSeccion()).append(",")
                        .append(pol.getPoliza()).append(",")
                        .append(pol.getCertificado()).append(",")
                        .append(pol.getRenueva()).append(",")
                        .append(pol.getRenovadapor()).append(",")
                        .append(pol.getProductor()).append(",'")
                        .append(new java.sql.Date(pol.getFechamis().getTime())).append("','")
                        .append(new java.sql.Date(pol.getDesde().getTime())).append("',")
                        .append(hasta).append(",")
                        .append(pol.getEstado()).append(",'"+new java.sql.Date(pol.getFechaestado().getTime())).append("',")
                        .append(pol.getAsegurado())
                        .append(",").append(pol.getMoneda()).append(",")
                        .append(pol.getCobrador()).append(",")
                        .append("999").append(",")
                        .append(pol.getFormapago())
                        .append(")\n");
                if (i != listpol.getZise() - 1) {
                    sb.append(",");
                }
                pro.progreso((int) Math.round(porcentaje));
                pro.cant(String.valueOf(i + 1) + " registros procesados de " + listpol.getZise());
            }
            sb.append("ON DUPLICATE key UPDATE COMPANIA=values(COMPANIA),SECCION=values(SECCION),POLIZA=values(POLIZA),"
                            + "CERTIFICADO=values(CERTIFICADO),RENUEVA=values(RENUEVA),RENOVADAPOR=values(RENOVADAPOR),PRODUCTOR=values(PRODUCTOR),FECHAMIS=values(FECHAMIS),"
                            + "DESDE=values(DESDE),HASTA=values(HASTA),ESTADO=values(ESTADO),FECHAESTADO=values(FECHAESTADO),ASEGURADO=values(ASEGURADO),"
                            + "MONEDA=values(MONEDA),COBRADOR=values(COBRADOR),FORMAPAGO=values(FORMAPAGO);");
            insert = sb.toString();
            PreparedStatement pst = con.prepareStatement(insert);
            pro.siguiendo(true);
            pro.barres(false);
            pro.proceso("Escribiendo datos en base");
            int resultado = pst.executeUpdate();
            pro.siguiendo(false);
            pro.barres(true);
            pro.proceso("Proceso completado");
            crono.stop();
            pro.crono.stop();
            pst.close();
            ConexionBase.desconectar();
//            Hilo otros = new CargaOtrosAseg(pro, listpolotro);
//            otros.execute();
        } catch (SQLException ex) {
            Logger.getLogger(AccionesCobranza.class.getName()).log(Level.SEVERE, null, ex);
            pro.crono.stop();
            javax.swing.JOptionPane.showMessageDialog(null, "Sucedio un error","Error!",javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
