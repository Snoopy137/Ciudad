/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import Conexion.AccionesCobranza;
import Conexion.CargaMasivaCobranza1;
import Datos.Cobranza;
import Datos.Hilo;
import Datos.ListaCobranzas;
import Datos.Monitor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author linux
 */
public class CargaMasivaCobranza extends javax.swing.JFrame {

    /**
     * Creates new form CargaMasivaCobranza
     */
    
    public CargaMasivaCobranza() {
        initComponents();
    }
    
    public static void setProggres (int prog){
        jProgressBar1.setValue(prog);
    }
    
    public static void setLabel (String value){
        jLabel1.setText(value);
        if(jLabel1.getText().equals("11646")){
            jLabel4.setText("carga 11646 en "+jLabel2.getText());
        }
    }

    public static void conteo (String segundos){
        jLabel2.setText(segundos);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jf = new javax.swing.JFileChooser();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jf.setCurrentDirectory(new java.io.File("C:\\Users\\mis_p\\Documents\\NetBeansProjects\\Ciudad\\src\\Ciudad"));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Prueba");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("jLabel1");

        jProgressBar1.setStringPainted(true);

        jLabel2.setText("jLabel2");

        jButton2.setText("prueba2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setText("jLabel3");

        jLabel4.setText("jLabel4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 170, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(27, 27, 27)
                                .addComponent(jLabel1)
                                .addGap(61, 61, 61)
                                .addComponent(jButton2))
                            .addComponent(jButton1))
                        .addGap(8, 8, 8)))
                .addGap(31, 31, 31))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(156, 156, 156))
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)))
                .addGap(43, 43, 43))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        conteo("0");
        UIManager.put("FileChooser.cancelButtonText","Basta");
        int decision = jf.showDialog(this, "Seleccionar");
        if(decision == JFileChooser.APPROVE_OPTION){
            Progreso pro = new Progreso(null,false);
            pro.proceso("Procesando Archivo");
            pro.crono.start();
            jLabel3.setText("Leyendo Archivo");
            String ruta = jf.getSelectedFile().getAbsolutePath();
//            ListaCobranzas listacob = new ListaCobranzas();
            class carga implements Runnable {

                @Override
                public void run() {
                    String insert = "INSERT INTO COBRANZA (idCOBRANZA,COMPANIA,SECCION,POLIZA,"
                            + "CERTIFICADO,INGRESO,CONSECUTIVO,FECHA,FECHACOBRO,"
                            + "MONEDA,MONTO,ORIGEN,USUARIO,INTPOLIZA,"
                            + "COBRADOR,COBRADOOFI,FECHAOFI,RENDIDO,USUARIOOFI) VALUES";
                    try {
                        File archivo = new File(ruta);
                        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                        DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
                        Document document = documentBuilder.parse(archivo);
                        document.getDocumentElement().normalize();
                        System.out.println("Elemento raiz:" + document.getDocumentElement().getNodeName());
                        NodeList listaRegistro = document.getElementsByTagName("ROW");
                        double porcentaje1 = 1.0 / listaRegistro.getLength() * 100;
                        double porcentaje = 0.0;
                        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
                        long cuit = 0;
                        for (int i = 0; i < listaRegistro.getLength(); i++) {
                            porcentaje = porcentaje + porcentaje1;
                            Node nodo = listaRegistro.item(i);
                            if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                                Element element = (Element) nodo;
                                Date fecha = new SimpleDateFormat("yyyyMMdd").parse(element.getAttribute("F"));
                                Date fechacobro = new SimpleDateFormat("yyyyMMdd").parse(element.getAttribute("G"));
                                int seccion = 4;
                                int certificado = 0;
                                int moneda = 01;
                                double monto = 0;
                                int consecutivo = 0;
//                                if (!element.getAttribute("A").equals("")) {
//                                    seccion = Integer.parseInt(element.getAttribute("A"));
//                                }
//                                if (!element.getAttribute("E").equals("")) {
//                                    consecutivo = Integer.parseInt(element.getAttribute("E"));
//                                }
//                                if (!element.getAttribute("I").equals("")) {
//                                    monto = Double.parseDouble(element.getAttribute("I"));
//                                }
//                                if (!element.getAttribute("C").equals("")) {
//                                    certificado = Integer.parseInt(element.getAttribute("C"));
//                                }
//                                if (!element.getAttribute("H").equals("")) {
//                                    moneda = Integer.parseInt(element.getAttribute("H"));
//                                }
//                                Cobranza cob = new Cobranza();
//                                cob.setCompania(1);
//                                cob.setSeccion(seccion);
//                                cob.setPoliza(Integer.parseInt(element.getAttribute("B")));
//                                cob.setCertificado(certificado);
//                                cob.setIngreso(Integer.parseInt(element.getAttribute("D")));
//                                cob.setConsecutivo(consecutivo);
//                                cob.setFecha(new java.sql.Date(fecha.getTime()));
//                                cob.setFechaCobro(new java.sql.Date(fechacobro.getTime()));
//                                cob.setMoneda(moneda);
//                                cob.setMonto(monto);
//                                cob.setOrigen(Integer.parseInt(element.getAttribute("J")));
//                                cob.setUsuario(999);
//                                listacob.agregaCobrazna(cob);
                                insert = insert + "(" + 0 + "," + 1 + ","
                                        + "" + seccion + "," + Integer.parseInt(element.getAttribute("B")) + ","
                                        + "" + certificado + "," + Integer.parseInt(element.getAttribute("D")) + ","
                                        + "" + consecutivo + ",'" + new java.sql.Date(fecha.getTime()) + "',"
                                        + "'" + new java.sql.Date(fechacobro.getTime()) + "',"
                                        + " " + moneda + "," + monto + ","
                                        + "" + Integer.parseInt(element.getAttribute("J")) + "," + 999 + ","
                                        + "" + null + ","
                                        + " " + null + "," + null + ","
                                        + "" + null + "," + null + ","
                                        + "" + null + ")";
                                if (i != listaRegistro.getLength() - 1) {
                                    insert = insert + ",";
                                    CargaMasivaCobranza.setProggres((int) porcentaje);
                                    CargaMasivaCobranza.setLabel(String.valueOf(i));
                                }
                            }
                        }
                        insert = insert + ";";
                        crono.stop();
                        System.out.println(insert);
                        //AccionesCobranza.cargaMasiva(listacob);
                        //AccionesAsegurados.crono.stop();
                    }
            catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            Thread t = new Thread(new carga());
            t.start();
        }   
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        conteo("0");
        UIManager.put("FileChooser.cancelButtonText", "Cancelar");
        JFileChooser jf = new JFileChooser();
        int decision = jf.showDialog(this, "Seleccionar");
        if (decision == jf.APPROVE_OPTION) {
            Progreso pro = new Progreso(this,false);
            pro.proceso("Procesando Archivo");
            pro.setVisible(true);
            pro.crono.start();
            crono.start();
            String ruta = jf.getSelectedFile().getAbsolutePath();
            ListaCobranzas listacob = new ListaCobranzas();
            class carga extends Hilo{

                @Override
                public void execute() {
                    try {
                        File archivo = new File(ruta);
                        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                        DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
                        Document document = documentBuilder.parse(archivo);
                        document.getDocumentElement().normalize();
                        System.out.println("Elemento raiz:" + document.getDocumentElement().getNodeName());
                        NodeList listaRegistro = document.getElementsByTagName("ROW");
                        double porcentaje1 = 1.0 / listaRegistro.getLength() * 100;
                        double porcentaje = 0.0;
                        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
                        long cuit = 0;
                        for (int i = 0; i < listaRegistro.getLength(); i++) {
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
                            Node nodo = listaRegistro.item(i);
                            if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                                Element element = (Element) nodo;
                                Date fecha = new SimpleDateFormat("yyyyMMdd").parse(element.getAttribute("F"));
                                Date fechacobro = new SimpleDateFormat("yyyyMMdd").parse(element.getAttribute("G"));
                                int seccion = 4;
                                int certificado = 0;
                                int moneda = 01;
                                double monto = 0;
                                int consecutivo = 0;
                                if (!element.getAttribute("A").equals("")) {
                                    seccion = Integer.parseInt(element.getAttribute("A"));
                                }
                                if (!element.getAttribute("E").equals("")) {
                                    consecutivo = Integer.parseInt(element.getAttribute("E"));
                                }
                                if (!element.getAttribute("I").equals("")) {
                                    monto = Double.parseDouble(element.getAttribute("I"));
                                }
                                if (!element.getAttribute("C").equals("")) {
                                    certificado = Integer.parseInt(element.getAttribute("C"));
                                }
                                if (!element.getAttribute("H").equals("")) {
                                    moneda = Integer.parseInt(element.getAttribute("H"));
                                }
                                Cobranza cob = new Cobranza();
                                cob.setCompania(1);
                                cob.setSeccion(seccion);
                                cob.setPoliza(Integer.parseInt(element.getAttribute("B")));
                                cob.setCertificado(certificado);
                                cob.setIngreso(Integer.parseInt(element.getAttribute("D")));
                                cob.setConsecutivo(consecutivo);
                                cob.setFecha(new java.sql.Date(fecha.getTime()));
                                cob.setFechaCobro(new java.sql.Date(fechacobro.getTime()));
                                cob.setMoneda(moneda);
                                cob.setMonto(monto);
                                cob.setOrigen(Integer.parseInt(element.getAttribute("J")));
                                cob.setUsuario(999);
                                listacob.agregaCobrazna(cob);
                            }
                            pro.cant(String.valueOf(i+1)+" registros procesados de "+listaRegistro.getLength());
                            pro.progreso((int)porcentaje);
                        }
                        pro.crono.stop();
                        String segundos = jLabel2.getText();
                        jLabel3.setText("leido en " + segundos + " segundos");
                        Thread.interrupted();
                        //AccionesCobranza.pruebacargamasiva1(listacob,pro);
                        CargaMasivaCobranza1 car = new CargaMasivaCobranza1(pro, listacob);
                        pro.setT(car);
                        car.start();
                        AccionesCobranza.crono.stop();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                
            }
            Hilo t= new carga();
            pro.setT(t);
            t.start();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    public static Timer crono = new Timer (1000,new ActionListener() {
        int segundos = 0;
        @Override
        public void actionPerformed(ActionEvent e) {
           segundos = segundos +1;
           conteo(String.valueOf(segundos));
        }
    });
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CargaMasivaCobranza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CargaMasivaCobranza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CargaMasivaCobranza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CargaMasivaCobranza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CargaMasivaCobranza().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private static javax.swing.JLabel jLabel1;
    private static javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel jLabel3;
    private static javax.swing.JLabel jLabel4;
    private static javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JFileChooser jf;
    // End of variables declaration//GEN-END:variables
}
