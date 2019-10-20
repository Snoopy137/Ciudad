/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import Datos.Usuarios;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Window;
import javax.swing.ImageIcon;

/**
 *
 * @author linux
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    Usuarios us;
    public Main (){
        initComponents();
        setLocationRelativeTo(null);
        setExtendedState(MAXIMIZED_BOTH);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                cerrarcesion();
            }
        });
        System.out.print("vacio");
        //jPanel1.setSize(rootPane.getSize());
    }
    public Main(Usuarios u) {
        initComponents();
        setLocationRelativeTo(null);
        setExtendedState(MAXIMIZED_BOTH);
        setTitle(u.getNombre());
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                cerrarcesion();
            }
        });
        us = u;
        System.out.print("u");
    }
    
    public Main (String privlegios,Usuarios u){
        initComponents();
        menusuarios.setVisible(false);
        setTitle(u.getNombre());
        setLocationRelativeTo(null);
        setExtendedState(MAXIMIZED_BOTH);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                cerrarcesion();
            }
        });
        us = u;
        System.out.print("privi");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menusuarios = new javax.swing.JMenuItem();
        mencambiocontrasenia = new javax.swing.JMenuItem();
        mencierrecesion = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 402, Short.MAX_VALUE)
        );

        jMenu1.setText("Control");

        menusuarios.setText("Administracion de Usuarios");
        menusuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menusuariosActionPerformed(evt);
            }
        });
        jMenu1.add(menusuarios);

        mencambiocontrasenia.setText("Cambiar Contraseña");
        mencambiocontrasenia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mencambiocontraseniaActionPerformed(evt);
            }
        });
        jMenu1.add(mencambiocontrasenia);

        mencierrecesion.setText("Cerrar Cesion");
        mencierrecesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mencierrecesionActionPerformed(evt);
            }
        });
        jMenu1.add(mencierrecesion);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mencierrecesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mencierrecesionActionPerformed
        cerrarcesion();
    }//GEN-LAST:event_mencierrecesionActionPerformed

    private void menusuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menusuariosActionPerformed
        AdministrarUsuarios adm = new AdministrarUsuarios();
        adm.setVisible(true);
    }//GEN-LAST:event_menusuariosActionPerformed

    private void mencambiocontraseniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mencambiocontraseniaActionPerformed
        CambiarContrasenia camb = new CambiarContrasenia(us);
        camb.setVisible(true);
    }//GEN-LAST:event_mencambiocontraseniaActionPerformed

    /**
     * @param args the command line arguments
     */
    
    void cerrarcesion (){
        System.gc();
        java.awt.Window win []= java.awt.Window.getWindows();
        for (Window window : Window.getWindows()){
            window.dispose();
        }
        Login log = new Login();
        log.setVisible(true);
    }
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JMenuItem mencambiocontrasenia;
    private javax.swing.JMenuItem mencierrecesion;
    private javax.swing.JMenuItem menusuarios;
    // End of variables declaration//GEN-END:variables
}
