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

    public static void CargaMasiva(ListaAsegurados listaseg, Progreso pro) {
        pro.crono.start();
        pro.proceso("Procesando datos");
        class Carga implements Runnable {

            @Override
            public void run() {
                try {
                    String insert = "INSERT INTO asegurados (Numaseg,Nombre,Domicilio,"
                            + "DomicilioCobro,Localidad,CodPostal,DNITipo,DNINro,"
                            + "Tele1,Tele2,Tele3,FecNac,CUIL,"
                            + "Actividad,Mail,Estado,Cobrador,Observ,ALTA,BAJA,Usuario,Fecha)VALUES\n ";
                    double porcentaje1 = 1.0 / listaseg.getSize() * 100;
                    double porcentaje = 0.0;
                    Connection con = ConexionBase.conectar();
                    StringBuilder sb = new StringBuilder(insert);
                    for (int i = 0; i < listaseg.getSize(); i++) {
                        Object date = "NULL";
                        porcentaje = porcentaje + porcentaje1;
                        Asegurados A = listaseg.getAsegurado(i);
                        if (A.getBaja() != null) {
                            date = "'" + A.getBaja() + "'";
                        }
                        sb.append("(" +A.getNumasegurado() + ","
                                + " '" + A.getNombreasegurado().replace("'", "\\'") +"', '" + A.getDomicilioasegurado() + "','" + A.getDomiciliocobroasegurado() + "',"
                                + " '" + A.getLocalidad() + "','" + A.getCodigopostal() + "','" + A.getDNItipo() + "'," + A.getDNInumero() + ","
                                + " '" + A.getTele1() + "','" + A.getTele2() + "','" + A.getTele3() + "','" + A.getFechanac() + "'," + A.getCuil() + ","
                                + " '" + A.getActividad() + "','" + A.getMail() + "','" + A.getEstado() + "'," + A.getCobrador() + ",'" + A.getObservaciones() + "',"
                                + " '" + A.getAlta() + "'," + date + ", 999 ,'" + A.getModificado() + "' ) ") ;
                        if (i!=listaseg.getSize()-1){
                            sb.append(", \n");
                        }
                        pro.progreso((int) porcentaje);
                        pro.cant(String.valueOf(i+1)+" registros procesados de "+listaseg.getSize());
                    }
                    sb.append("ON DUPLICATE key UPDATE Nombre=values(Nombre),Domicilio=values(Domicilio),DomicilioCobro=values(DomicilioCobro),"
                            + "Localidad=values(Localidad),CodPostal=values(CodPostal),DNITipo=values(DNITipo),DNINro=values(DNINro),Tele1=values(Tele1),"
                            + "Tele2=values(Tele2),Tele3=values(Tele3),FecNac=values(FecNac),CUIL=values(CUIL),Actividad=values(Actividad),"
                            + "Mail=values(Mail),Estado=values(Estado),Cobrador=values(cobrador),Observ=values(Observ),ALTA=values(ALTA),BAJA=values(BAJA),"
                            + "Usuario=values(Usuario),Fecha=values(Fecha);");
                    PreparedStatement pst = con.prepareStatement(sb.toString());
                    pro.siguiendo(true);
                    pro.proceso("Conectando Con Base de datos");
                    int resultado = pst.executeUpdate();
                    pro.siguiendo(false);
                    pro.proceso("Proceso Completado");
                    pro.dispose();
                    pro.crono.stop();
                }
                catch (SQLException e) {
                    e.printStackTrace();
                    ConexionBase.desconectar();
                }
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
    
    public static ListaAsegurados buscarAsegurados(String nombre, int DNI){
        ListaAsegurados asegList = new ListaAsegurados();
        Connection con = ConexionBase.conectar();
        if(!nombre.equals(""))nombre="%"+nombre+"%";
        String cond = "OR";
        if(!nombre.equals("") && DNI != 0)cond="AND";
        try {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM asegurados WHERE nombre LIKE '"+nombre+"' "+cond+" DNINro LIKE '"+DNI+"%'");
            System.out.println(pst.toString());
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                Asegurados aseg = new Asegurados();
                aseg.setNombreasegurado(rs.getString("nombre"));
                aseg.setActividad(rs.getNString("Actividad"));
                aseg.setAlta(rs.getDate("ALTA"));
                asegList.agregaAsegurado(aseg);
            }
            con.close();
            rs.close();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccionesAsegurados.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return asegList;
    }
    
    public static void main (String []ags){
        ListaAsegurados asegList=buscarAsegurados ("al",18);
        for(int i=0;i<asegList.getSize();i++){
            System.out.println(asegList.getAsegurado(i).getAlta()+" "+asegList.getAsegurado(i).getNombreasegurado());
        }
        System.out.println(asegList.getSize());
    }
}
