/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import Conexion.AccionesAsegurados;
import Datos.Asegurados;
import Datos.ListaAsegurados;
import java.io.File;
import java.text.SimpleDateFormat;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.util.Date;

/**
 *
 * @author linux
 */
public class CargaMasivaAsegurados extends javax.swing.JFrame {

    /**
     * Creates new form CargaMasivaAsegurados
     */
    public CargaMasivaAsegurados() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel2 = new javax.swing.JLabel();

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 175, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(155, 155, 155)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(jLabel1))))
                .addGap(77, 77, 77))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        conteo("0");
        UIManager.put("FileChooser.cancelButtonText","Cancelar");
        JFileChooser jf = new JFileChooser();
        int decision = jf.showDialog(this, "Seleccionar");
        if(decision == jf.APPROVE_OPTION){
            String ruta = jf.getSelectedFile().getAbsolutePath();
            ListaAsegurados listaseg = new ListaAsegurados();
            try{
                File archivo = new File(ruta);
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
                Document document = documentBuilder.parse(archivo);
                document.getDocumentElement().normalize();
                System.out.println("Elemento raiz:" + document.getDocumentElement().getNodeName());
                NodeList listaRegistro = document.getElementsByTagName("ROW");
                double porcentaje1 = 1.0 / listaRegistro.getLength() * 100;
                double porcentaje = 0.0;
                Date fechanac = null;
                SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
                long cuit=0;
                //AccionesAsegurados.crono.start();
                for (int i = 0;i<listaRegistro.getLength();i++){
                    porcentaje = porcentaje + porcentaje1;
                    Date fechabaja = null;
                    Node nodo = listaRegistro.item(i);
                    if (nodo.getNodeType() == Node.ELEMENT_NODE){
                        Element element = (Element) nodo;
                        if (!element.getAttribute("AD").equals("")){
                            fechanac = new SimpleDateFormat("yyyyMMdd").parse(element.getAttribute("AD"));
                        }
                        Date fechaalta = new SimpleDateFormat("yyyyMMdd").parse(element.getAttribute("Y"));
                        if(!element.getAttribute("U").equals("")){
                            cuit = Long.parseLong(element.getAttribute("U"));
                        }
                        
                        Asegurados A = new Asegurados ();
                        A.setNumasegurado(Integer.parseInt(element.getAttribute("A")));
                        A.setNombreasegurado(element.getAttribute("B"));
                        A.setDomicilioasegurado(element.getAttribute("E")+" "+element.getAttribute("F")+" "+element.getAttribute("G")
                        +" "+element.getAttribute("H"));
                        A.setDomiciliocobroasegurado(element.getAttribute("M")+" "+element.getAttribute("N")+" "+element.getAttribute("O")
                        +" "+element.getAttribute("P"));
                        A.setLocalidad(element.getAttribute("J"));
                        A.setCodigopostal(element.getAttribute("I"));
                        A.setDNItipo(element.getAttribute("C"));
                        if (!element.getAttribute("D").equals("")){
                          A.setDNInumero(Integer.parseInt(element.getAttribute("D")));  
                        }
                        A.setTele1(element.getAttribute("K"));
                        A.setTele2(element.getAttribute("L"));
                        A.setTele3("");
                        if (fechanac != null){
                           A.setFechanac(new java.sql.Date(fechanac.getTime())); 
                        }
                        A.setCuil(cuit);
                        A.setActividad("");
                        A.setMail(element.getAttribute("AA"));
                        A.setAlta(new java.sql.Date(fechaalta.getTime()));
                        if(!element.getAttribute("Z").equals("")){
                        fechabaja = new SimpleDateFormat("yyyyMMdd").parse(element.getAttribute("Z"));
                        A.setBaja(new java.sql.Date(fechabaja.getTime()));
                        }
                        A.setUsu(null);
                        A.setModificado(new java.sql.Date(new Date().getTime()));
                        if (fechabaja == null){
                            A.setEstado("A");
                        }
                        else {
                            A.setEstado("I");
                        }
                        listaseg.agregaAsegurado(A);
                        //AccionesAsegurados.modificaAsegurado(A,(int)porcentaje,String.valueOf(i));
                    }
                }
                AccionesAsegurados.CargaMasiva(listaseg);
                //AccionesAsegurados.crono.stop();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void setProggres(int prog){
        jProgressBar1.setValue(prog);
        if(jProgressBar1.getValue()!= 100 && jProgressBar1.getValue()!=0){
            jButton1.setEnabled(false);
        }
        else {
            jButton1.setEnabled(true);
        }
    }
    
    public static void setLabel(String avance){
        jLabel1.setText(avance);
    }
    
    public static void conteo (String tiempo){
        jLabel2.setText(tiempo);
    }
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
                if ("GTK+".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CargaMasivaAsegurados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CargaMasivaAsegurados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CargaMasivaAsegurados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CargaMasivaAsegurados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CargaMasivaAsegurados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JButton jButton1;
    private static javax.swing.JLabel jLabel1;
    private static javax.swing.JLabel jLabel2;
    private static javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables
}
