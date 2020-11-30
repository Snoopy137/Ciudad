/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import static Conexion.AccionesAsegurados.crono;
import Datos.Endoso;
import Datos.Hilo;
import Datos.ListadoEndosos;
import Formularios.Progreso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AlanDec
 */
public class CargaOtrosEndosos extends Hilo{

    private Progreso pro;
    private ListadoEndosos listend;

    public CargaOtrosEndosos(Progreso pro, ListadoEndosos listend) {
        this.pro = pro;
        this.listend = listend;
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
            double porcentaje1 = 1.0 / listend.getSize() * 100;
            double porcentaje = 0.0;
            String insert = "INSERT INTO OTROSASEG (idOTROSASEG,COMPANIA,SECCION,POLIZA,"
                    + "ENDOSO,CERTIFICADO,TIPO,CODIGO) VALUES";
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
                Endoso pol = listend.getEndoso(i);
                sb.append("(").append(0).append(",")
                        .append(pol.getCompania()).append(",")
                        .append(pol.getSeccion()).append(",")
                        .append(pol.getPoliza()).append(",")
                        .append(0).append(",")
                        .append(pol.getCertificado()).append(",'")
                        .append(pol.getTipoAsegurado()).append("',")
                        .append(pol.getAsegurado()).append(")");
                if (i != listend.getSize() - 1) {
                    sb.append(",");
                }
                pro.progreso((int) Math.round(porcentaje));
                pro.cant(String.valueOf(i + 1) + " registros procesados de " + listend.getSize());
            }
            sb.append("ON DUPLICATE key UPDATE COMPANIA=values(COMPANIA),SECCION=values(SECCION),POLIZA=values(POLIZA),"
                            + "CERTIFICADO=values(CERTIFICADO),ENDOSO=values(ENDOSO),TIPO=values(TIPO),CODIGO=values(CODIGO);");
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
        } catch (SQLException ex) {
            Logger.getLogger(AccionesCobranza.class.getName()).log(Level.SEVERE, null, ex);
            pro.crono.stop();
            javax.swing.JOptionPane.showMessageDialog(null, "Sucedio un error en la carga accesoria","Error!",javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
