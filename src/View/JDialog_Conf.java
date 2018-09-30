/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package View;

import Task.Conexion;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Gomez
 */
public class JDialog_Conf extends javax.swing.JDialog {

    Conexion con;
    
    String user_dir;
    
    //Carga los properties al iniciar el modulo
    private int op, re, me, ma;
    /**
     * Creates new form JDialog_Conf
     * @param parent
     * @param modal
     */
    public JDialog_Conf(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.user_dir = System.getProperty("user.dir");
        initComponents();
    }

     public JDialog_Conf(java.awt.Frame parent, boolean modal, Conexion con) {
        super(parent, modal);
        this.user_dir = System.getProperty("user.dir");
        initComponents();
        setResizable(false);
        centrar();
        this.con = con;
    }
     
    public final void centrar(){
        Dimension pantalla = this.getToolkit().getScreenSize();
        this.setLocation(pantalla.width /2 - this.getWidth() / 2, pantalla.height / 2 - this.getHeight() / 2);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel13 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnEliminar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnCopia = new javax.swing.JButton();
        btnNuevo_User = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnExtras = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Logo2Reducido2.png"))); // NOI18N

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/user_del.png"))); // NOI18N
        btnEliminar.setText("Eliminar usuario");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/folder_database.png"))); // NOI18N
        jButton1.setText("Abrir carpeta de Copias");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancel.png"))); // NOI18N
        jButton3.setText("Salir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btnCopia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/database_save.png"))); // NOI18N
        btnCopia.setText("Crear copia de seguridad");
        btnCopia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCopiaActionPerformed(evt);
            }
        });

        btnNuevo_User.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/user_add.png"))); // NOI18N
        btnNuevo_User.setText("Crear nuevo usuario");
        btnNuevo_User.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevo_UserActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/paintcan.png"))); // NOI18N
        jButton2.setText("propiedades aceite");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnExtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/paintcan.png"))); // NOI18N
        btnExtras.setText("Recrear opciones para ejecutar la copia de seguridad");
        btnExtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnNuevo_User, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCopia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(btnExtras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo_User, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCopia, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExtras)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevo_UserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevo_UserActionPerformed
        JDialog_Acceso nuevo = new JDialog_Acceso(this, true);
        nuevo.setVisible(true);
    }//GEN-LAST:event_btnNuevo_UserActionPerformed

    private void btnCopiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCopiaActionPerformed
        if(JOptionPane.showConfirmDialog(this, "Esto creara una copia de seguridad de la Base de Datos", "copia", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE) == 0){
            //execute("D:\\BackupsSQL\\BackupTecSoft.bat"); 
           // String user_dir = System.getProperty("user.dir");
            //si existe una copia desde hacia una semana que la borre y que cree la nueva
            if(existe()){
                String opciones = "Copia de seguridad y Archivo de informe creados con exito.\n1. Ver carpeta\n2. Ver archivo de informe\n3. Cerrar\n\nIngrese la opción que desea"; 
                int opcion;
                try {
                    do {//hacer esto mientras no se le de en el cerrar
                        opcion = Integer.parseInt(JOptionPane.showInputDialog(opciones));
                        //saca un error en caso de darle cancelar. pero pasa desapercibido y 
                        //y continua la ejecucion del programa
                        switch (opcion) {
                            case 1 : opcion = 1;                              
                                execute("explorer.exe \"" + user_dir + "\\TecSoft\\Backups\""); 
                                break;
                            case 2 : opcion = 2;
                                String comando = user_dir + "\\TecSoft\\Logs\\Log_TecSoft.txt";
                                System.out.println("ejecuta2: " + comando);
                                execute( "notepad.exe \"" + comando + "\"" );
                                break;
                            case 3:
                            break;
                            default: JOptionPane.showMessageDialog(this, "Opcion no valida"); 
                        }
                    }
                    while (opcion != 3);
                } catch (NumberFormatException e) {
                    //como es una excepcion esperada, que no haga nada y listo
                }
            }else{
                JOptionPane.showMessageDialog(this, "No se ejecuto el .bat");
            }
        } 
    }//GEN-LAST:event_btnCopiaActionPerformed
    //ELIMIONAR USUARIO
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
       JDialog_Eliminar del = new JDialog_Eliminar(this, true);
       del.setVisible(true);
    }//GEN-LAST:event_btnEliminarActionPerformed
    //ABRIR CARPETA DE COPIAS
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       // String user_dir = System.getProperty("user.dir");   
        execute("explorer.exe \"" + user_dir + "\\TecSoft\\Backups\"");
    }//GEN-LAST:event_jButton1ActionPerformed
    //SALIR
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed
    // cambia las propiedades del aceite
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        rescatar_config();
        String opciones = "Elija la opcion que desea\n1. Optimo = "+op+"\n2. Regular = "+re+"\n"
                + "3. Medio = "+me+"\n4. Malo = "+ma+"\n5. Terminar\n\nIngrese la opción que desea modificar"; 
        int opcion;
        try {
            do {//hacer esto mientras no se le de en el cerrar
                opcion = Integer.parseInt(JOptionPane.showInputDialog(opciones));
                //saca un error en caso de darle cancelar. pero pasa desapercibido y c
                //y continua la ejecucion del programa
                switch (opcion) {
                    case 1 : opcion = 1;
                        try {
                            op = Integer.parseInt( JOptionPane.showInputDialog("Ingrese el nuevo valor para Optimo") );
                            salvar_config();
                        } catch (NumberFormatException e) {
                        }
                        break;
                    case 2 : opcion = 2;
                        try {
                            re = Integer.parseInt( JOptionPane.showInputDialog("Ingrese el nuevo valor para Regular") );
                            salvar_config();
                        } catch (NumberFormatException e) {
                        }
                        break;
                    case 3 : opcion = 3;
                        try {
                            me = Integer.parseInt( JOptionPane.showInputDialog("Ingrese el nuevo valor para Medio") );
                            salvar_config();
                        } catch (NumberFormatException e) {
                        }
                        break;
                    case 4 : opcion = 4;
                        try {
                            ma = Integer.parseInt( JOptionPane.showInputDialog("Ingrese el nuevo valor para Malo") );
                            salvar_config();
                        } catch (NumberFormatException e) {
                        }
                        break;
                    case 5 :
                        break;
                    default: JOptionPane.showMessageDialog(this, "Opcion no valida"); 
                }
            }
            while (opcion != 5);
        } catch (NumberFormatException e) {
            //como es una excepcion esperada, que no haga nada y listo
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnExtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExtrasActionPerformed
        //ESTO CREA LOS ARCHIVOS PARA CREAR COPIA DE LA BASE DE DATOS
        //Y UN EJECUTABLE QUE LO CORRA SIN NECESIDAD DE CREAR INSTANCIAS DE SQL POR ACÁ
// para que este funcione en windows se le deben conceder los permisos suficioente, asi:
        /**
         * control panel
         * system and secutrity
         * administrative tools
         * services
         * double click SQL Server (SQLEXPRESS) right click, properties
         * select Log On tab
         * select "Local System Account" "the default was some obtuse wndows system account"
         * OK
         * right click, STOP
         * right click, START
         * y listo 
        */
        //String user_dir = System.getProperty("user.dir");
        //String user_home = System.getProperty("user.home");
        String dir_copia = user_dir + "\\TecSoft\\Backups\\TecSoft_";
        int dia;
        String ext = ".bak";
        Calendar calendario = Calendar.getInstance();
        dia = calendario.get(Calendar.DAY_OF_WEEK);
        String nueva_ruta = dir_copia + dia + ext;
        File archivo = new File(nueva_ruta);
        if(archivo.exists()){//si el archivo existe que lo borre
            archivo.delete();
            JOptionPane.showMessageDialog(null, "Archivo eliminado con exito");
        }
        
        //para ejecutar este archivo, me toca mandarle el directorio en el cual estoy ubicado
        String dir_ejecutable = user_dir + "\\TecSoft\\Ejecutables\\BackupTecSoft.bat";
        String dir_log = user_dir + "\\TecSoft\\Logs\\Log_TecSoft.txt";
        String dir_sql = user_dir + "\\TecSoft\\SQLs\\TecSoft.sql";
        
        File archivo_ejecutable = new File(dir_ejecutable);
        File archivo_log = new File(dir_log);//esta la creo solo para abrirlo, yo no lo tengo que crear
        File archivo_sql = new File(dir_sql);
        BufferedWriter bw;
        //verificamos que exista un archivo sql capaz de crear la copia de seguridad
        try {   //si existe que lo re-escriba, si no existe que lo cree 
            bw = new BufferedWriter( new FileWriter( archivo_sql) );
            String sql_create = "DECLARE @dest nvarchar(255)\r\n" +
    "SET @dest = '" + dir_copia + "' + CAST(DATEPART(weekday, GETDATE()) AS nvarchar(1)) + '.bak'\r\n" +
    "PRINT CAST (GETDATE() AS nvarchar) + ' - COPIA DE SEGURIDAD INICIADA AL ARCHIVO: ' + @dest\r\n" +
    "BACKUP DATABASE [dma] TO  DISK = @dest WITH NOFORMAT, NOINIT, \r\n" +
    "NAME = N'dma-Full Database Backup', SKIP, NOREWIND, NOUNLOAD,  STATS = 10\r\n" +
    "GO";
            bw.write(sql_create);
            bw.close();
                   System.out.println("Archivo .sql creado correctamente");
        } catch (IOException ex) {
                Logger.getLogger(JDialog_Conf.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {  
            bw = new BufferedWriter( new FileWriter( archivo_ejecutable ) );
            String ejecutable_create = "sqlcmd.exe -S  LOCALHOST\\SQLEXPRESS -i \"" + dir_sql + "\" >> \"" + dir_log + "\"";
            //String ejecutable_create = "sqlcmd.exe -s  LOCALHOST\\SQLEXPRESS -i \"" + dir_sql + "\" >> \"" + dir_log + "\"";
            bw.write(ejecutable_create);
            bw.close();
                   System.out.println("Archivo .bat creado correctamente");
        } catch (IOException ex) {
                Logger.getLogger(JDialog_Conf.class.getName()).log(Level.SEVERE, null, ex);
        }
//        System.out.println("ejecutando el .bat");
//        execute("\""+dir_ejecutable+"\""); 
//        System.out.println(".bat termina ejeccion");
        //el proceso es el siguiente.
        //primero verifico si hay una copia de seguridad de la base de datos
        //TecSoft_#
        //si esta, la borro y prosigo 
        //luego ejecuto el archivo BackupTecSoft.bat
        //***el contenido de este ultimo es algo parecido a este:
        /*sqlcmd.exe -s  LOCALHOST\SQLEXPRESS -i "\TecSoft\SQLs\TecSoft.sql" >> "\TecSoft\Log_TecSoft.txt*/
        /*y este es el que se encarga de hacer la copia de seguridad

        lo que tengo que hacer es lo mismo, verificar si en el directorio de ejecucion hay una copia de la base de datos
        luego si existe que lo borre.
        despues tengo que ejecutar el .bat con los datos del directorio actual
        */
    }//GEN-LAST:event_btnExtrasActionPerformed
 
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
            java.util.logging.Logger.getLogger(JDialog_Conf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            JDialog_Conf dialog = new JDialog_Conf(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCopia;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnExtras;
    private javax.swing.JButton btnNuevo_User;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
//INVOCA AL CMD O CONSOLA DDOS DE WINDOWS
    private void execute(String comando){
        try {
            Process p = Runtime.getRuntime().exec(comando);
            p.waitFor();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error ejecutando los comandos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private int executecmd(String comando){
        int rpta;
        try {
            Process p = Runtime.getRuntime().exec(comando);
            rpta = p.waitFor();
        } catch (IOException | InterruptedException e) {
            rpta = -1;
            JOptionPane.showMessageDialog(this, "Error ejecutando los comandos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return rpta;
    }

    //SI EXISTE, QUE LO BORRE Y LUEGO LO CREA NUEVAMENTE
    public boolean existe(){
        boolean rpta = false;
        String directorio = user_dir + "\\TecSoft\\Backups\\TecSoft_";
        int dia;
        String ext = ".bak";
        Calendar calendario = Calendar.getInstance();
        dia = calendario.get(Calendar.DAY_OF_WEEK);
        String newRuta = directorio + dia + ext;
        File archivo = new File(newRuta);
        if(archivo.exists()){//si el archivo existe que lo borre
           if( archivo.delete() ){
               JOptionPane.showMessageDialog(this, "Recreando la copia de seguridad");
           }
        }
        //execute("\""+dir_ejecutable+"\"");        
        String comando = user_dir + "\\TecSoft\\Ejecutables\\BackupTecSoft.bat"; 
        if( executecmd( "\"" + comando + "\"" ) == 0 ){
            rpta = true;
        }
        return rpta;        
    }      
    //recupera los datos de las propiedades
    private void rescatar_config() {
        Properties prop = new Properties();
        InputStream is;
        try {//carga el archivo en el inputStream con los datos que tenga
            is = new FileInputStream(user_dir + "\\TecSoft\\configuraciones.properties");
            prop.load(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
        op = Integer.parseInt( prop.getProperty( "configuracion.optimo" ) );
        re = Integer.parseInt( prop.getProperty( "configuracion.regular" ) );
        me = Integer.parseInt( prop.getProperty( "configuracion.medio" ) );
        ma = Integer.parseInt( prop.getProperty( "configuracion.malo" ) );
    }
//SALVA EN EL PROPERTIES LOS DATOS DE LOS CAMBIOS 
    private void salvar_config(){
        Properties prop = new Properties();
        FileOutputStream os;
        //creamos el properties. lo llenamos con los datos del jtable y lo guardamos
        //prop.put("valor."+ i + j, valor);
        prop.setProperty("configuracion.optimo", (op+"") );
        prop.setProperty("configuracion.regular", (re+"") );
        prop.setProperty("configuracion.medio", (me+"") );
        prop.setProperty("configuracion.malo", (ma+"") );
        try {
            //le decimos donde guardar la informacion, en este caso el properties
            //C:\Users\Gomez\Documents\NetBeansProjects\Manipulador_de_Archivos\Configuracion.properties
            os = new FileOutputStream( user_dir + "\\TecSoft\\configuraciones.properties");
            //con este metodo almacena en la ruta de salida los cambios hechos. machacando lo existente, por lo actual
            prop.store(os, "Configuración");//el segundo es un String que le da titulo al properties
            JOptionPane.showMessageDialog(null, "Propiedades almacenadas correctamente");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //imprime por consola las variables actuales del sistema.
    private void variables(){
        System.out.println("imprimiendo caso de uso de System.");
        //muestra la ruta donde el usuario almacena sus cosas personales
        String home = System.getProperty("user.home");
        System.out.println("user.home: " + home);
        
        //muestra le directorio actual, es decir, desde donde se ejecuta el sistema
        String dir = System.getProperty("user.dir");
        System.out.println("user.dir: " + dir);
        
        //muestra el nombre de usuario, el que tiene asigando el pc
        String user_name = System.getProperty("user.name");
        System.out.println("user.name: " + user_name);
        
        //muestra el idioma en el cual instalo el sistema operativo
        String language = System.getProperty("user.language");
        System.out.println("user.language: " + language);
        
        //muestra las rutas donde se almacenan las clases y librerias del programa
        String class_path = System.getProperty("java.class.path");
        System.out.println("java.class.path: " + class_path);
        
        //muestra lso vendedores de cadena especifica
        String vendor = System.getProperty("java.vendor");
        System.out.println("java.vendor: " + vendor);
        
        //muestra le directorio donde java debe crear los archivos temporales
        String tmp = System.getProperty("java.io.tmpdir");
        System.out.println("java.io.tmpdir: " + tmp);
        
        //El directorio en el que esta instalado java
        String j_home = System.getProperty("java.home");
        System.out.println("java.home: " + j_home);
       
        //El nombre del sistema operativo
        String name = System.getProperty("os.name");
        System.out.println("os.home: " + name);
        
        //La arquitectura del  sistema operativo
        String arch = System.getProperty("os.arch");
        System.out.println("os.home: " + arch);
        
        //la version del sistema operativo
        String version = System.getProperty("os.version");
        System.out.println("os.version: " + version);
        
    } 
}