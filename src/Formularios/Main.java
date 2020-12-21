/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import Conexion.ConexionBase;
import Datos.Usuarios;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Window;

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
        if(ConexionBase.con == null)ConexionBase.conectar();
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                cerrarcesion();
            }
        });
    }
    public Main(Usuarios u) {
        initComponents();
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                cerrarcesion();
            }
        });
        us = u;
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
        jPanel1 = new javax.swing.JPanel();
        richLabel1 = new Label.RichLabel();
        jPanel3 = new javax.swing.JPanel();
        customTextField1 = new componentesnuestros.CustomTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menusuarios = new javax.swing.JMenuItem();
        mencambiocontrasenia = new javax.swing.JMenuItem();
        mencierrecesion = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setExtendedState(6);

        richLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        richLabel1.setText("ASEGURADOS");
        richLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        richLabel1.setMouseovercolor(new java.awt.Color(0, 204, 204));
        richLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                richLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(richLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(richLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 609, Short.MAX_VALUE))
        );

        customTextField1.setText("customTextField1");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(224, 224, 224)
                .addComponent(customTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(637, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addComponent(customTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void richLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_richLabel1MouseClicked
        Formularios.Asegurados aseg = new Asegurados();
        aseg.setSize(jPanel3.getWidth(), jPanel3.getHeight());
        jPanel3.removeAll();
        jPanel3.add(aseg);
        aseg.revalidate();
        aseg.pideFoco();
    }//GEN-LAST:event_richLabel1MouseClicked

    private void mencierrecesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mencierrecesionActionPerformed
        cerrarcesion();
    }//GEN-LAST:event_mencierrecesionActionPerformed

    private void mencambiocontraseniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mencambiocontraseniaActionPerformed
        CambiarContrasenia camb = new CambiarContrasenia(us);
        camb.setVisible(true);
    }//GEN-LAST:event_mencambiocontraseniaActionPerformed

    private void menusuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menusuariosActionPerformed
        AdministrarUsuarios adm = new AdministrarUsuarios();
        adm.setVisible(true);
    }//GEN-LAST:event_menusuariosActionPerformed

    /**
     * @param args the command line arguments
     */
    
    void cerrarcesion (){
        System.gc();
        java.awt.Window win []= java.awt.Window.getWindows();
        for (Window window : Window.getWindows()){
            window.dispose();
        }
        ConexionBase.desconectar();
        Login log = new Login();
        log.setVisible(true);
    }
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        System.setProperty("apple.laf.useScreenMenuBar", "true");
        FlatLightLaf.install();
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
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
    private componentesnuestros.CustomTextField customTextField1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JMenuItem mencambiocontrasenia;
    private javax.swing.JMenuItem mencierrecesion;
    private javax.swing.JMenuItem menusuarios;
    private Label.RichLabel richLabel1;
    // End of variables declaration//GEN-END:variables
}
