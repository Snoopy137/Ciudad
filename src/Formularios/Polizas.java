/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Formularios;

import Conexion.AccionesPolizas;
import Datos.ListaPolizas;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author linux
 */
public class Polizas extends javax.swing.JFrame {

    private int asegurado = 0;
    /** Creates new form Polizas */
    public Polizas(int asegurado) {
        this.asegurado = asegurado;
        initComponents();
        llenarTabla();
    }

    public Polizas() {
        initComponents();
        llenarTabla();
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo1 = new Panel.Fondo();
        jScrollPane1 = new javax.swing.JScrollPane();
        TBLpolizas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        fondo1.setBackgroundpicture(new javax.swing.ImageIcon("C:\\Users\\edude\\OneDrive\\Documentos\\StandUp 2014\\397533_10203538515047926_1094767427_n.jpg")); // NOI18N

        TBLpolizas.setAutoCreateRowSorter(true);
        TBLpolizas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TBLpolizas.getTableHeader().setReorderingAllowed(false);
        TBLpolizas.setFocusable(false);
        TBLpolizas.setDefaultEditor(Object.class, null);
        jScrollPane1.setViewportView(TBLpolizas);

        javax.swing.GroupLayout fondo1Layout = new javax.swing.GroupLayout(fondo1);
        fondo1.setLayout(fondo1Layout);
        fondo1Layout.setHorizontalGroup(
            fondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1774, Short.MAX_VALUE)
        );
        fondo1Layout.setVerticalGroup(
            fondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondo1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 544, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void llenarTabla(){
        DefaultTableModel poli = new DefaultTableModel();
        poli.addColumn("Compañía");
        poli.addColumn("Sección");
        poli.addColumn("Póliza");
        poli.addColumn("Certificado");
        poli.addColumn("Renueva");
        poli.addColumn("Productor");
        poli.addColumn("Fecha de Emision");
        poli.addColumn("Desde");
        poli.addColumn("Hasta");
        poli.addColumn("Estado");
        poli.addColumn("Fecha de estado");
        poli.addColumn("Asegurado");
        poli.addColumn("Moneda");
        poli.addColumn("Cobrador");
        poli.addColumn("Prima");
        poli.addColumn("Premio");
        TBLpolizas.setModel(poli);
        ListaPolizas listPol = AccionesPolizas.buscarPolizas(asegurado);
        for (int i=0;i<listPol.getZise();i++){
            Object [] o = null;            
            poli.addRow(o);
            poli.setValueAt(listPol.getPoliza(i).getCompania(),i, 0);
            poli.setValueAt(listPol.getPoliza(i).getSeccion(), i, 1);
            poli.setValueAt(listPol.getPoliza(i).getPoliza(), i, 2);
            poli.setValueAt(listPol.getPoliza(i).getCertificado(), i, 3);
            poli.setValueAt(listPol.getPoliza(i).getRenueva(), i, 4);
            poli.setValueAt(listPol.getPoliza(i).getProductor(), i, 5);
            poli.setValueAt(listPol.getPoliza(i).getFechamis(), i, 6);
            poli.setValueAt(listPol.getPoliza(i).getDesde(), i, 7);
            poli.setValueAt(listPol.getPoliza(i).getHasta(), i, 8);
            poli.setValueAt(listPol.getPoliza(i).getEstado(), i, 9);
            poli.setValueAt(listPol.getPoliza(i).getFechaestado(), i, 10);
            poli.setValueAt(listPol.getPoliza(i).getAsegurado(), i, 11);
            poli.setValueAt(listPol.getPoliza(i).getMoneda(), i, 12);
            poli.setValueAt(listPol.getPoliza(i).getCobrador(), i, 13);
            poli.setValueAt(listPol.getPoliza(i).getPrima(), i, 14);
            poli.setValueAt(listPol.getPoliza(i).getPremio(), i, 15);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            /* Set the Nimbus look and feel */
            //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
            /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
            * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
            */
            //</editor-fold>
            UIManager.setLookAndFeel("com.formdev.flatlaf.FlatDarkLaf");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Polizas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Polizas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Polizas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Polizas.class.getName()).log(Level.SEVERE, null, ex);
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Polizas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TBLpolizas;
    private Panel.Fondo fondo1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
