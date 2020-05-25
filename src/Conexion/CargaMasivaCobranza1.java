/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import static Conexion.AccionesCobranza.crono;
import Datos.Cobranza;
import Datos.ListaCobranzas;
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
public class CargaMasivaCobranza1 extends Thread {

    private Progreso pro;
    private ListaCobranzas listcob;
    private boolean pausa;

    public CargaMasivaCobranza1(Progreso pro, ListaCobranzas listcob) {
        this.pro = pro;
        this.listcob = listcob;
    }

    public boolean isPausa() {
        return pausa;
    }

    public void setPausa(boolean pausa) {
        System.out.println(pausa+" como esta");
        System.out.println(pausa+" lo que le llega");
        this.pausa = pausa;
        System.out.println(this.pausa+" así qeuda el campo de clase");
        System.out.println("---------------------------------------");
    }    

    @Override
    public void run() {
        if (pausa != false){
            pro.crono.start();
            pro.siguiendo(true);
            pro.barres(false);
            pro.proceso("Conectando con base de datos");
            Connection con = ConexionBase.conectar();
            pro.proceso("Conectado");
            try {
            double porcentaje1 = 1.0 / listcob.getSize() * 100;
            double porcentaje = 0.0;
            String insert = "INSERT INTO COBRANZA (idCOBRANZA,COMPANIA,SECCION,POLIZA,"
                    + "CERTIFICADO,INGRESO,CONSECUTIVO,FECHA,FECHACOBRO,"
                    + "MONEDA,MONTO,ORIGEN,USUARIO) VALUES";
            StringBuilder sb = new StringBuilder(insert);
            pro.proceso("Procesando datos");
            pro.siguiendo(false);
            pro.barres(true);
            pro.progreso(0);
            for (int i = 0; i < listcob.getSize(); i++) {
                Object date = "NULL";
                porcentaje = porcentaje + porcentaje1;
                Cobranza cob = listcob.getCobranza(i);
                sb.append("(").append(0).append(",").append(cob.getCompania()).append(",").append(cob.getSeccion()).append(",").
                        append(cob.getPoliza()).append(",").append(cob.getCertificado()).append(",").append(cob.getIngreso()).append(",").
                        append(cob.getConsecutivo()).append(",'").append(cob.getFecha()).append("','").append(cob.getFechaCobro()).append("', ").
                        append(cob.getMoneda()).append(",").append(cob.getMonto()).append(",").append(cob.getOrigen()).append(",").append(cob.getUsuario()).append(")");
                if (i != listcob.getSize() - 1) {
                    sb.append(",");
                }
                pro.progreso((int) porcentaje);
                pro.cant(String.valueOf(i + 1) + " registros procesados de " + listcob.getSize());
                Thread.sleep(50);
            }
            insert = sb.toString();
            sb.append(";");
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
            con.close();
        } 
        catch (SQLException ex) {
                Logger.getLogger(AccionesCobranza.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(CargaMasivaCobranza1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
