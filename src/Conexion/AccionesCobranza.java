/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import Datos.Cobranza;
import Datos.ListaCobranzas;
import Formularios.CargaMasivaCobranza;
import static Formularios.CargaMasivaCobranza.conteo;
import static Formularios.CargaMasivaCobranza.setProggres;
import Formularios.Progreso;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
            Connection con = new ConexionBase().conectar();
            
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
                Connection con = new ConexionBase().conectar();
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
    
    public static void pruebacargamasiva1(ListaCobranzas listcob, Progreso pro) {
        pro.crono.start();
        pro.siguiendo(true);
        pro.barres(false);
        pro.proceso("Conectando con base de datos");
        Connection con = new ConexionBase().conectar();
        pro.proceso("Conectado");
        class carga implements Runnable {

            @Override
            public void run() {
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
                        if (i!=listcob.getSize()-1){
                            sb.append(",");
                        }
                        pro.progreso((int) porcentaje);
                        pro.cant(String.valueOf(i+1)+" registros procesados de "+listcob.getSize());
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
                    ConexionBase.desconectar();
                } 
                catch (SQLException ex) {
                    Logger.getLogger(AccionesCobranza.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        Thread t = new Thread(new carga());
        t.start();
    }
    
    public static void main(String[] args) {
        Connection con = new ConexionBase().conectar();
        try {
            System.out.println("conectado");
            PreparedStatement pst = con.prepareStatement("DELETE FROM POLIZAS");
            System.out.println("consulta creada");
            pst.executeUpdate();
            ConexionBase.desconectar();
        } 
        catch (SQLException ex) {
            Logger.getLogger(AccionesCobranza.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
