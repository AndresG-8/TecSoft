/**
 * En esta clase se instancia una conexión a la base de datos
 * y se hacen consultas 
 */
package Login2;

import View.JFrame_Principal;
import javax.swing.JOptionPane;

/**
 *
 * @author Gomez
 */
public class Login extends javax.swing.JFrame {
    //se crea una variable "con" del tipo "Conexion"
    Conexion con; //ver Conexion.java en este mismo paquete
    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        //se ubica la ventana en el centro de la pantall
        setLocationRelativeTo(null);
        //se crea un nuevo objeto de la clase conexion 
        con = new Conexion();
        //se usa el metodo "conectar" de la clase "conexion" mediante el objeto creado
        con.conectar(); 
       /* char c = {;
        txtJPass.setEchoChar(c);*/
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtJPass = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/accept.png"))); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        btnAceptar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                btnAceptarKeyTyped(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancel.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        btnCancelar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                btnCancelarKeyTyped(evt);
            }
        });

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Logo2Reducido2.png"))); // NOI18N

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtJPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtJPassKeyTyped(evt);
            }
        });

        jLabel1.setText("USUARIO:");

        jLabel2.setText("PASSWORD:");

        txtUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUserKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtJPass, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtJPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar)))
                .addGap(46, 46, 46))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        //llamado al metodo aceptar en esta misma clase
        aceptar();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        //se cierra la conexión a la base de datos
        con.setCon(null);
        //sale del sistema
        System.exit(0);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtUserKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserKeyTyped
        //declara una variable donde almacena las pulsaciones del teclado mientras el foco este 
        //en el JTextField del usuario
        char caracter = evt.getKeyChar();
        //el caracter se convierte en un número (cada pulsación del teclado representa un número)
        int numero = (int)(caracter);
        //el 10 en este caso representa la pulsación de la tecla ENTER o INTRO
        if(numero == 10){
            //se le pasa el foco al JTextField de la cntraseña
            txtJPass.requestFocus();
        } 
    }//GEN-LAST:event_txtUserKeyTyped

    private void txtJPassKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtJPassKeyTyped
        int caracter = evt.getKeyChar();
        int numero = (int)(caracter);
        if(numero == 10){
            btnAceptar.requestFocus();
        }
    }//GEN-LAST:event_txtJPassKeyTyped

    private void btnAceptarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAceptarKeyTyped
        int caracter = evt.getKeyChar();
        int numero = (int)(caracter);
        if(numero == 10){
            btnAceptar.doClick();
        }
    }//GEN-LAST:event_btnAceptarKeyTyped

    private void btnCancelarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCancelarKeyTyped
        int caracter = evt.getKeyChar();
        int numero = (int)(caracter);
        if(numero == 10){
            btnCancelar.doClick();
        }
    }//GEN-LAST:event_btnCancelarKeyTyped

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtJPass;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables

    public void aceptar(){
        //se verifica que los campos de usuario y contraseña tengan algo
        if( !"".equals(txtUser.getText()) && !"".equals(txtJPass.getText()) ){ 
            //se obtiene el texto de la contraseña y lo pasamos a String
            String psw = new String (txtJPass.getPassword());
            String pass, user;
            //se valida que si haya conexión a la base de datos
            if(con.getCon() != null){
                //se obtiene el texto del JTextField correspondiente al  usuario
                user = txtUser.getText();
                //la contraseña que se habia pasado a string, ahora se encripta
                pass = EncriptadoMD5.encriptaEnMD5(psw); //Ver EncriptadoMD5.java en este mismo paquete
                //se crea un objeto de la clase "Logon"
                Logon log = new Logon();
                //con el objeto "log" se accede al metodo para establecer el usuario y la contraseña
                log.setUser(user);
                log.setPass(pass);
                //ahora se le pasa a la conexion el usuario, y desde alli se enviara a la clase Logon que lo valida
                //contra la base de datos
                if(con.validar_user(log)){
                    //si todo ha ido bien, se muestra el JFrame inicial de la aplicación
                    JFrame_Principal frame = new JFrame_Principal(log.getUser());//ver JFrame_Principal en el paquete "View"
                    frame.setVisible(true);
                    //se cierrra la conexión que se creo al lanzar la aplicación
                    con.setCon(null);
                    //se 'desecha' este JFrame para el recolector de basura de java
                    this.dispose();
                }else{
                    //en caso de error se le muestra mensaje diciendo que erró es su intento de ingreso
                    JOptionPane.showMessageDialog(this, "Usuario o Contraseña incorrectos");
                    txtUser.setText("");
                    txtJPass.setText("");
                    txtUser.requestFocus();
                }
            }else{
                JOptionPane.showMessageDialog(this, "La conexión a la base de datos esta cerrada");
            }
        }else{
            JOptionPane.showMessageDialog(this, "¡Todos los campos son obligatorios!");
        }
    }
}