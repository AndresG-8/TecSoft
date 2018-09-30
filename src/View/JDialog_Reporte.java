/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package View;

import Task.Conexion;
import Task.Reportes;
import Task.cliente;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author Gomez
 */
public class JDialog_Reporte extends javax.swing.JDialog {
    Conexion con;
    /**
     * Creates new form JDialog_Reporte
     * @param parent
     * @param modal
     */
    public JDialog_Reporte(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public JDialog_Reporte(java.awt.Frame parent, boolean modal, Conexion con) {
        super(parent, modal);
        initComponents();
        setResizable(false);
        this.setLocationRelativeTo(null);
        this.con = con;
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
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cart_go.png"))); // NOI18N
        jButton1.setText("Servicios");
        jButton1.setToolTipText("TODOS los servicios prestados");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jButton1KeyTyped(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/book_addresses.png"))); // NOI18N
        jButton2.setText("Detalle Servicios");
        jButton2.setToolTipText("De x Cliente");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jButton2KeyTyped(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/chart_curve.png"))); // NOI18N
        jButton3.setText("Servicios Diarios");
        jButton3.setToolTipText("Carga los servicios de HOY");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jButton3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jButton3KeyTyped(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/report_user.png"))); // NOI18N
        jButton4.setText("Clientes");
        jButton4.setToolTipText("Reporte de TODOS los clientes en la base de datos");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jButton4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jButton4KeyTyped(evt);
            }
        });

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Logo2Reducido2.png"))); // NOI18N

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancel.png"))); // NOI18N
        jButton5.setText("Cancelar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jButton5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jButton5KeyTyped(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/book_open.png"))); // NOI18N
        jButton6.setText("Big Report");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jButton6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jButton6KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //CARGA EL REPORTE DE SERVICIOS.
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//        if(JOptionPane.showConfirmDialog(this, "¿Esta seguro que desea cargar reporte de Servicios?", "salir", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0){
//                
//        }
        Reportes rep = new Reportes();
        if(con.cargar_reporte(rep) == false){
            JOptionPane.showMessageDialog(null, "No se pudo cargar el reporte especificado");
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    //CARGA EL REPORTE DE DETALLE SERVICIOS
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String x = JOptionPane.showInputDialog(this, "Ingrese el número de la Identificación", "Identificación", JOptionPane.QUESTION_MESSAGE);
        if((x != null) && (!"".equals(x))){
            cliente cli = new cliente();
            cli.setId(Double.parseDouble(x));
            if(con.verificarCliente(cli)){
                try {
                    int cedula = Integer.parseInt(x);
                    Reportes rep = new Reportes();
                    rep.setId(cedula);
                    if(con.cargar_param(rep) == false){
                        JOptionPane.showMessageDialog(null, "No se pudo cargar el Reporte");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error creando o cargando el reporte\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
                }
            }else{
                JOptionPane.showMessageDialog(this,"El cliente identificado con: "+ x + " NO existe en la base de datos");
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    //CARGA EL REPORTE DE SERVICIOS DIARIOS
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try {
            Reportes rep = new Reportes();
            if(con.cargar_dia(rep) == false){
                JOptionPane.showMessageDialog(null, "No se pudo cargar el reporte del día");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error creando el reporte\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
        }
    }//GEN-LAST:event_jButton3ActionPerformed
    //CARGA EL REPORTE DE TODOS LOS CLIENTES
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            Reportes rep = new Reportes();
            if(con.cargar_clientes(rep) == false){
                JOptionPane.showMessageDialog(null, "No se pudo cargar el reporte de los clientes");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error creando el reporte\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed
    //CARGA EL BIG REPORT
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        String x = JOptionPane.showInputDialog(this, "Ingrese el número de la Identificación", "Identificación", JOptionPane.QUESTION_MESSAGE);
        if((x != null) && (!"".equals(x))){
            cliente cli = new cliente();
            cli.setId(Double.parseDouble(x));
            if(con.verificarCliente(cli)){
                try {
                    int cedula = Integer.parseInt(x);
                    Reportes rep = new Reportes();
                    rep.setId(cedula);
                    if(con.cargar_big_report(rep) == false){
                        JOptionPane.showMessageDialog(null, "No se pudo cargar el Big Report");
                    }
                } catch (Exception e) {
                    StringWriter errors = new StringWriter();
                    e.printStackTrace(new PrintWriter(errors));
                    JDialog_Errores err = new JDialog_Errores("Error creando el reporte", errors.toString());
                    err.setVisible(true);
                }
            }else{
                JOptionPane.showMessageDialog(this,"El cliente identificado con: "+ x + " NO existe en la base de datos");
            }
        }
    }//GEN-LAST:event_jButton6ActionPerformed
//*******EVENTOS DEL TECLADO
    private void jButton6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton6KeyTyped
        char caracter = evt.getKeyChar();
        int numero = (int)(caracter);
        if(numero == 10){
            jButton6.doClick();
        }
    }//GEN-LAST:event_jButton6KeyTyped

    private void jButton1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyTyped
        char caracter = evt.getKeyChar();
        int numero = (int)(caracter);
        if(numero == 10){
            jButton1.doClick();
        }
    }//GEN-LAST:event_jButton1KeyTyped

    private void jButton2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton2KeyTyped
        char caracter = evt.getKeyChar();
        int numero = (int)(caracter);
        if(numero == 10){
            jButton2.doClick();
        }
    }//GEN-LAST:event_jButton2KeyTyped

    private void jButton3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton3KeyTyped
        char caracter = evt.getKeyChar();
        int numero = (int)(caracter);
        if(numero == 10){
            jButton3.doClick();
        }
    }//GEN-LAST:event_jButton3KeyTyped

    private void jButton4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton4KeyTyped
        char caracter = evt.getKeyChar();
        int numero = (int)(caracter);
        if(numero == 10){
            jButton4.doClick();
        }
    }//GEN-LAST:event_jButton4KeyTyped

    private void jButton5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton5KeyTyped
        char caracter = evt.getKeyChar();
        int numero = (int)(caracter);
        if(numero == 10){
            jButton5.doClick();
        }
    }//GEN-LAST:event_jButton5KeyTyped
//*******TERMINA EVENTOS DEL TECLADO
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
            java.util.logging.Logger.getLogger(JDialog_Reporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDialog_Reporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDialog_Reporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDialog_Reporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDialog_Reporte dialog = new JDialog_Reporte(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel13;
    // End of variables declaration//GEN-END:variables
}