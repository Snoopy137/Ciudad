/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import Datos.Asegurados;
import Datos.ListaAsegurados;
import Datos.Usuarios;
import Formularios.CargaMasivaAsegurados;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

/**
 *
 * @author linux
 */
public class AccionesAsegurados {

    public static int insertaAsegurado(Asegurados A) {
        int resultado = 0;
        Connection con = ConexionBase.conectar();
        try {
            PreparedStatement pstex = con.prepareStatement("SELECT * FROM asegurados WHERE Numaseg = " + A.getNumasegurado());
            ResultSet rs = pstex.executeQuery();
            if (rs.next()) {
                resultado = 2;
                return resultado;
            } 
            else {
                PreparedStatement pst = con.prepareStatement("INSERT INTO asegurados VALUES (" + 0 + ", " + A.getNumasegurado() + ","
                        + " '" + A.getNombreasegurado() + "', '" + A.getDomicilioasegurado() + "','" + A.getDomiciliocobroasegurado() + "',"
                        + " '" + A.getLocalidad() + "','" + A.getCodigopostal() + "','" + A.getDNItipo() + "'," + A.getDNInumero() + ","
                        + " '" + A.getTele1() + "','" + A.getTele2() + "','" + A.getTele3() + "','" + A.getFechanac() + "'," + A.getCuil() + ","
                        + " '" + A.getActividad() + "','" + A.getMail() + "','" + A.getEstado() + "'," + A.getCobrador() + ",'" + A.getObservaciones() + "',"
                        + " '" + A.getAlta() + "','" + A.getBaja() + "'," + A.getUsu() + ",'" + A.getModificado() + "' ) ");
                resultado = pst.executeUpdate();
                ConexionBase.desconectar();
                return resultado;

            }
        } 
        catch (Exception e) {
            e.printStackTrace();
            ConexionBase.desconectar();
        }
        ConexionBase.desconectar();
        return resultado;
    }

    public static void CargaMasiva(ListaAsegurados listaseg) {
        crono.start();
        class Carga implements Runnable {
            String nuevonom;

            @Override
            public void run() {
                double porcentaje1 = 1.0 / listaseg.getSize() * 100;
                double porcentaje = 0.0;
                Connection con = ConexionBase.conectar();
                for (int i = 0; i < listaseg.getSize(); i++) {
                    Object date = "NULL";
                    porcentaje = porcentaje + porcentaje1;
                    Asegurados A = listaseg.getAsegurado(i);
                    if(A.getBaja()!=null){
                        date = "'"+A.getBaja()+"'";
                    }
                    try {
                        PreparedStatement pstex = con.prepareStatement("SELECT * FROM asegurados WHERE Numaseg = " + A.getNumasegurado());
                        ResultSet rs = pstex.executeQuery();
                        if (rs.next()) {
                            PreparedStatement pst = con.prepareStatement("UPDATE asegurados SET Numaseg = " + A.getNumasegurado() + ","
                                    + " Nombre = '" + A.getNombreasegurado() + "',Domicilio= '" + A.getDomicilioasegurado() + "', DomicilioCobro='" + A.getDomiciliocobroasegurado() + "',"
                                    + " Localidad='" + A.getLocalidad() + "',CodPostal='" + A.getCodigopostal() + "',DNITipo='" + A.getDNItipo() + "',DNINro=" + A.getDNInumero() + ","
                                    + " Tele1='" + A.getTele1() + "',Tele2='" + A.getTele2() + "',Tele3='" + A.getTele3() + "',FecNac='" + A.getFechanac() + "',CUIL=" + A.getCuil() + ","
                                    + " Actividad='" + A.getActividad() + "',Mail='" + A.getMail() + "',Estado='" + A.getEstado() + "',Cobrador=" + A.getCobrador() + ",Observ=" + A.getObservaciones() + ","
                                    + " ALTA='" + A.getAlta() + "',BAJA=" + date + ",Usuario=999,Fecha='" + A.getModificado() + "' WHERE Numaseg = "+A.getNumasegurado());
                            int resultado = pst.executeUpdate();

                        } 
                        else {
                            PreparedStatement pst = con.prepareStatement("INSERT INTO asegurados VALUES (" + 0 + ", " + A.getNumasegurado() + ","
                                    + " '" + A.getNombreasegurado() + "', '" + A.getDomicilioasegurado() + "','" + A.getDomiciliocobroasegurado() + "',"
                                    + " '" + A.getLocalidad() + "','" + A.getCodigopostal() + "','" + A.getDNItipo() + "'," + A.getDNInumero() + ","
                                    + " '" + A.getTele1() + "','" + A.getTele2() + "','" + A.getTele3() + "','" + A.getFechanac() + "'," + A.getCuil() + ","
                                    + " '" + A.getActividad() + "','" + A.getMail() + "','" + A.getEstado() + "'," + A.getCobrador() + "," + A.getObservaciones() + ","
                                    + " '" + A.getAlta() + "'," + date + ",999,'" + A.getModificado() + "' ) ");
                            int resultado = pst.executeUpdate();
                        }
                    } 
                    catch (Exception e) {
                        e.printStackTrace();
                        String excepcion = A.getNombreasegurado();
                        for(int l=0;l<excepcion.length();l++){
                            char comilla = excepcion.charAt(l);
                            if(Character.toString(comilla).equals("\'")){
                                nuevonom = excepcion.substring(0, l)+"\\"+excepcion.substring(l,excepcion.length());
                            }
                        }
                        try {
                        PreparedStatement pstex = con.prepareStatement("SELECT * FROM asegurados WHERE Numaseg = " + A.getNumasegurado());
                        ResultSet rs = pstex.executeQuery();
                            if (rs.next()) {
                                PreparedStatement pst = con.prepareStatement("UPDATE asegurados SET Numaseg = " + A.getNumasegurado() + ","
                                    + " Nombre = '" + nuevonom + "',Domicilio= '" + A.getDomicilioasegurado() + "', DomicilioCobro='" + A.getDomiciliocobroasegurado() + "',"
                                    + " Localidad='" + A.getLocalidad() + "',CodPostal='" + A.getCodigopostal() + "',DNITipo='" + A.getDNItipo() + "',DNINro=" + A.getDNInumero() + ","
                                    + " Tele1='" + A.getTele1() + "',Tele2='" + A.getTele2() + "',Tele3='" + A.getTele3() + "',FecNac='" + A.getFechanac() + "',CUIL=" + A.getCuil() + ","
                                    + " Actividad='" + A.getActividad() + "',Mail='" + A.getMail() + "',Estado='" + A.getEstado() + "',Cobrador=" + A.getCobrador() + ",Observ=" + A.getObservaciones() + ","
                                    + " ALTA='" + A.getAlta() + "',BAJA=" + date + ",Usuario=999,Fecha='" + A.getModificado() + "' WHERE Numaseg = "+A.getNumasegurado());
                                int resultado = pst.executeUpdate();
                            } 
                            else {
                                PreparedStatement pst = con.prepareStatement("INSERT INTO asegurados VALUES (" + 0 + ", " + A.getNumasegurado() + ","
                                    + " '" + nuevonom + "', '" + A.getDomicilioasegurado() + "','" + A.getDomiciliocobroasegurado() + "',"
                                    + " '" + A.getLocalidad() + "','" + A.getCodigopostal() + "','" + A.getDNItipo() + "'," + A.getDNInumero() + ","
                                    + " '" + A.getTele1() + "','" + A.getTele2() + "','" + A.getTele3() + "','" + A.getFechanac() + "'," + A.getCuil() + ","
                                    + " '" + A.getActividad() + "','" + A.getMail() + "','" + A.getEstado() + "'," + A.getCobrador() + "," + A.getObservaciones() + ","
                                    + " '" + A.getAlta() + "'," + date + ",999,'" + A.getModificado() + "' ) ");
                                int resultado = pst.executeUpdate();
                            }
                        }
                        catch (Exception e1){
                            e1.printStackTrace();
                        }
                    }
                    CargaMasivaAsegurados.setProggres((int) porcentaje);
                    CargaMasivaAsegurados.setLabel(String.valueOf(i));
                }
                ConexionBase.desconectar();
                System.out.println("Proceso terminado");
                crono.stop();
            }

        }
        Thread t = new Thread(new Carga());
        t.start();
    }

    public static Timer crono = new Timer (1000,new ActionListener() {
        int segundos = 0;
        @Override
        public void actionPerformed(ActionEvent e) {
           segundos = segundos +1;
           CargaMasivaAsegurados.conteo(String.valueOf(segundos));
        }
    });
    
    public static void modificaAsegurado(Asegurados  A, int porcentaje, String label){
        class Modifica implements Runnable {

            @Override
            public void run() {
                Connection con = ConexionBase.conectar();
                Object date = "NULL";
                if (A.getBaja() != null) {
                    date = "'" + A.getBaja() + "'";
                }
                try {
                    PreparedStatement pst = con.prepareStatement("UPDATE asegurados SET Numaseg = " + A.getNumasegurado() + ","
                            + " Nombre = '" + A.getNombreasegurado() + "',Domicilio= '" + A.getDomicilioasegurado() + "', DomicilioCobro='" + A.getDomiciliocobroasegurado() + "',"
                            + " Localidad='" + A.getLocalidad() + "',CodPostal='" + A.getCodigopostal() + "',DNITipo='" + A.getDNItipo() + "',DNINro=" + A.getDNInumero() + ","
                            + " Tele1='" + A.getTele1() + "',Tele2='" + A.getTele2() + "',Tele3='" + A.getTele3() + "',FecNac='" + A.getFechanac() + "',CUIL=" + A.getCuil() + ","
                            + " Actividad='" + A.getActividad() + "',Mail='" + A.getMail() + "',Estado='" + A.getEstado() + "',Cobrador=" + A.getCobrador() + ",Observ=" + A.getObservaciones() + ","
                            + " ALTA='" + A.getAlta() + "',BAJA=" + date + ",Usuario=999,Fecha='" + A.getModificado() + "' WHERE Numaseg = " + A.getNumasegurado());
                    int resultado = pst.executeUpdate();
                    CargaMasivaAsegurados.setProggres(porcentaje);
                    CargaMasivaAsegurados.setLabel(label);
                    ConexionBase.desconectar();
                } 
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        Thread t = new Thread(new Modifica());
        t.start();
    }
}
