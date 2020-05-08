/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import Datos.Cobranza;
import Datos.ListaCobranzas;
import Formularios.CargaMasivaCobranza;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

/**
 *
 * @author linux
 */
public class AccionesCobranza {
    
    public int insertaCobranza (Cobranza cob){
        int resultado = 0;
        try {
            Connection con = ConexionBase.conectar();
            
            PreparedStatement pst = con.prepareStatement("INSERT INTO COBRANZA VALUES ("+0+","+cob.getCompania()+","+cob.getSeccion()+","+cob.getPoliza()+","
                    + ""+cob.getCertificado()+","+cob.getIngreso()+","+cob.getConsecutivo()+","+cob.getFecha()+","+cob.getFechaCobro()+","
                            + " "+cob.getMoneda()+","+cob.getMonto()+","+cob.getOrigen()+","+cob.getUsuario()+","+cob.getIntpoliza()+","
                                    + " "+cob.getCobrador()+","+cob.getFechaofi()+",'"+cob.getRendido()+"',"+cob.getUsuarioofi()+" ");
            resultado = pst.executeUpdate();
            return resultado;
        } catch (SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(null,"Error de conexión \n"+ ex);
            Logger.getLogger(AccionesCobranza.class.getName()).log(Level.SEVERE, null, ex);
            return resultado;
        }
        finally {
            ConexionBase.desconectar();
        }
    }
    
    public static void cargaMasiva(ListaCobranzas listcob) {
        crono.start();
        class carga implements Runnable {

            @Override
            public void run() {
                double porcentaje1 = 1.0 / listcob.getSize() * 100;
                double porcentaje = 0.0;
                Connection con = ConexionBase.conectar();
                for (int i = 0; i < 50; i++) {
                    try {
                        Object date = "NULL";
                        porcentaje = porcentaje + porcentaje1;
                        Cobranza cob = listcob.getCobranza(i);
                        PreparedStatement pst = con.prepareStatement("INSERT INTO COBRANZA VALUES ("+0+","+cob.getCompania()+","+cob.getSeccion()+","+cob.getPoliza()+","
                                + ""+cob.getCertificado()+","+cob.getIngreso()+","+cob.getConsecutivo()+",'"+cob.getFecha()+"','"+cob.getFechaCobro()+"',"
                                        + " "+cob.getMoneda()+","+cob.getMonto()+","+cob.getOrigen()+","+cob.getUsuario()+","+cob.getIntpoliza()+","
                                                + " "+cob.getCobrador()+","+cob.getCobradoofi()+","+cob.getFechaofi()+","+cob.getRendido()+","+cob.getUsuarioofi()+") ");
                        int resultado = pst.executeUpdate();
                    } 
                    catch (SQLException ex) {
                        ex.printStackTrace();
                        Logger.getLogger(AccionesCobranza.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    CargaMasivaCobranza.setProggres((int) porcentaje);
                    CargaMasivaCobranza.setLabel(String.valueOf(i));
                }
                crono.stop();
            }
        }
        Thread t = new Thread(new carga());
        t.start();
    }
    
    public static Timer crono = new Timer (1000,new ActionListener() {
        int segundos = 0;
        @Override
        public void actionPerformed(ActionEvent e) {
           segundos = segundos +1;
           CargaMasivaCobranza.conteo(String.valueOf(segundos));
        }
    });
    
    public static void pruebacargamasiva1(ListaCobranzas listcob) {
        class carga implements Runnable {

            @Override
            public void run() {
                try {
                    double porcentaje1 = 1.0 / listcob.getSize() * 100;
                    double porcentaje = 0.0;
                    Connection con = ConexionBase.conectar();
                    String insert = "INSERT INTO COBRANZA (idCOBRANZA,COMPANIA,SECCION,POLIZA,"
                            + "CERTIFICADO,INGRESO,CONSECUTIVO,FECHA,FECHACOBRO,"
                            + "MONEDA,MONTO,ORIGEN,USUARIO,INTPOLIZA,"
                            + "COBRADOR,COBRADOOFI,FECHAOFI,RENDIDO,USUARIOOFI) VALUES";
                    for (int i = 0; i < listcob.getSize(); i++) {
                        Object date = "NULL";
                        porcentaje = porcentaje + porcentaje1;
                        Cobranza cob = listcob.getCobranza(i);
                        insert = insert + "(" + 0 + "," + cob.getCompania() + "," + cob.getSeccion() + "," + cob.getPoliza() + ","
                                + "" + cob.getCertificado() + "," + cob.getIngreso() + "," + cob.getConsecutivo() + ",'" + cob.getFecha() + "','" + cob.getFechaCobro() + "',"
                                + " " + cob.getMoneda() + "," + cob.getMonto() + "," + cob.getOrigen() + "," + cob.getUsuario() + "," + cob.getIntpoliza() + ","
                                + " " + cob.getCobrador() + "," + cob.getCobradoofi() + "," + cob.getFechaofi() + "," + cob.getRendido() + "," + cob.getUsuarioofi() + ")";
                        if (i!=listcob.getSize()-1){
                            insert = insert+",";
                        }
                        CargaMasivaCobranza.setProggres((int) porcentaje);
                        CargaMasivaCobranza.setLabel(String.valueOf(i));
                    }
                    insert = insert+";";
                    PreparedStatement pst = con.prepareStatement(insert);
                    int resultado = pst.executeUpdate();
                } 
                catch (SQLException ex) {
                    Logger.getLogger(AccionesCobranza.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        Thread t = new Thread(new carga());
        t.start();
    }
}
