/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import Conexion.AccionesCobrador;
import Datos.Cobradores;
//import TextField.limpiar;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Toolkit;

/**
 *
 * @author edudec
 */
public class ABMCobrador extends javax.swing.JFrame {

    /**
     * Creates new form ABMCobrador
     */
    public ABMCobrador() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtcomision = new javax.swing.JTextField();
        BTNguardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtobserv = new javax.swing.JTextArea();
        txtnombre = new componentesnuestros.CustomTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ABM COBRADOR");

        jLabel2.setText("Nombre                   :");

        jLabel3.setText("Comisión                 :");

        jLabel4.setText("Observaciones        :");

        BTNguardar.setText("Guardar");
        BTNguardar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                BTNguardarFocusLost(evt);
            }
        });
        BTNguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNguardarActionPerformed(evt);
            }
        });

        txtobserv.setColumns(20);
        txtobserv.setLineWrap(true);
        txtobserv.setRows(5);
        txtobserv.setToolTipText("Solo 200 caracteres.");
        txtobserv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtobservKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(txtobserv);

        txtnombre.setTexto(componentesnuestros.CustomTextField.Texto.LETRAMAYUSCULA);
        txtnombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtnombreFocusLost(evt);
            }
        });
        txtnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel3)
                        .addGap(15, 15, 15)
                        .addComponent(txtcomision, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(237, 237, 237)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(289, 289, 289)
                        .addComponent(BTNguardar)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtcomision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(BTNguardar)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTNguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNguardarActionPerformed
        if (validar()) guardarCobrador();
        else javax.swing.JOptionPane.showMessageDialog(this, "Hay campos requeridos vacios","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_BTNguardarActionPerformed

    
    private void txtobservKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtobservKeyTyped
      if (txtobserv.getText().length()>=200){
    evt.consume();
    Toolkit.getDefaultToolkit().beep();
      }
    }//GEN-LAST:event_txtobservKeyTyped

    private void BTNguardarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BTNguardarFocusLost
  //       private void customTextField5ActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        
    }//GEN-LAST:event_BTNguardarFocusLost
   
    private void txtnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombreActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
      
    }//GEN-LAST:event_formWindowOpened

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
//       limpiar.limpiarFormulario(this.getContentPane().getComponents());
        txtnombre.requestFocus();
    }//GEN-LAST:event_formWindowGainedFocus

    private void txtnombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtnombreFocusLost
       if (!txtnombre.getText().trim().equals("")) {
            boolean existe = AccionesCobrador.existe(txtnombre.getText());
            if (existe) {
                javax.swing.JOptionPane.showMessageDialog(this, "El cobrador ya existe", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                txtnombre.requestFocus();
                
            }
        }
    
    }//GEN-LAST:event_txtnombreFocusLost

    private void guardarCobrador(){
        Cobradores cobrador = new Cobradores();
        cobrador.setNombre(txtnombre.getText());
        cobrador.setComisioncobrador(Double.parseDouble(txtcomision.getText()));
        cobrador.setObserv(txtobserv.getText());
        
        int resultado = AccionesCobrador.inserta(cobrador);
        if (resultado == 1) javax.swing.JOptionPane.showMessageDialog(this, "Registro guardado","Exito",javax.swing.JOptionPane.INFORMATION_MESSAGE);
        else javax.swing.JOptionPane.showMessageDialog(this, "Algo salio mal!","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
        
    }
  
    private boolean validar(){
        if(txtnombre.getText().trim().equals(""))return false;
        else if (txtcomision.getText().trim().equals(""))return false;
        else return true;
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
        FlatLightLaf.install();
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ABMCobrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNguardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtcomision;
    private componentesnuestros.CustomTextField txtnombre;
    private javax.swing.JTextArea txtobserv;
    // End of variables declaration//GEN-END:variables
}
