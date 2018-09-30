/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Task;

import View.JDialog_Cliente_General;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Gomez
 */
public class imagenes {
    int codigo_img;
    String nombre, placa;
    String ruta;//este se usa para alamcenar la ruta de las imagenes
    
    public static int cod_ima1;
    public static int cod_ima2;
    public static int cod_ima3;
    public static int cod_ima4;
    
    public static String ruta1;
    public static String ruta2;
    public static String ruta3;
    public static String ruta4;
    
    public static String nombre1;
    public static String nombre2;
    public static String nombre3;
    public static String nombre4;
    /*
    create table imagenes (
    codigo_img int primary key identity(1, 1),
    nombre varchar(40) null,
    imagen image not null,
    longitud int null,
    placa varchar(15) not null,
    foreign key(placa) references moto(placa) on delete cascade on update cascade
    )
     */
    public imagenes() {
        this.codigo_img = 0;
        this.nombre = null;
        this.placa = null;
    }

    public int getCodigo_img() {
        return codigo_img;
    }

    public void setCodigo_img(int codigo_img) {
        this.codigo_img = codigo_img;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
    
    //ESTOS METODOS SE ENCARGAN DE LAS IMAGENES EN EL DIRECTORIO
    //HASTA AHORA VEO QUE LO USAN CLIENTE_GENREAL,
    public boolean recuperar(Connection con){
    boolean rpta = false;
        int cont = 0;
        try {
            String sql = "SELECT cod_img, nombre, ruta FROM imagen_dir WHERE placa = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, getPlaca());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                setCodigo_img(rs.getInt(1));//retorna cod_img
                setNombre(rs.getString(2));
                setRuta(rs.getString(3));
                //TENEMOS QUE CREAR LA IMAGEN EN EL MOMENTO
                //ASI SE CARGA, PERO DEBEMOS ALMACENAR LA RUTA POR SI SE
                //DESEA CAMBIAR ALGUN DATOS
                ImageIcon ic = new ImageIcon(getRuta());
                Icon icono = new ImageIcon(ic.getImage().getScaledInstance(JDialog_Cliente_General.jLabel53.getWidth(), JDialog_Cliente_General.jLabel53.getHeight(), Image.SCALE_DEFAULT) );
               
                if(cont == 0){
                    JDialog_Cliente_General.jLabel53.setIcon(icono);
                    nombre1 = getNombre();
                    //requiero el codigo por si necesito actualizar la imagen
                    cod_ima1 = getCodigo_img();
                    ruta1 = getRuta();
                }else if(cont == 1){
                    //EN VES DE CARGAR UN ICON, QUE CARGUE EL PATH
                    JDialog_Cliente_General.jLabel54.setIcon(icono);
                    nombre2 = getNombre();
                    cod_ima2 = getCodigo_img();
                    ruta2 = getRuta();
                }else if(cont == 2){
                    JDialog_Cliente_General.jLabel55.setIcon(icono);
                    nombre3 = getNombre();
                    cod_ima3 = getCodigo_img();
                    ruta3 = getRuta();
                }else if(cont == 3){
                    JDialog_Cliente_General.jLabel56.setIcon(icono);
                    nombre4 = getNombre();
                    cod_ima4 = getCodigo_img();
                    ruta4 = getRuta();
                }
                cont = cont +1;
                rpta = true;
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error cargando la imagen\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
        }
       return rpta;
    }
    //GUARDA LAS IMAGENES EN UN DIRECTORIO 
    public boolean salvar(Connection con){
        String sentenciaSQL = "INSERT INTO imagen_dir (nombre, ruta, placa) VALUES(?, ?, ?)";//para guardar los datos
        boolean rpta = false;//bandera
        try {
            PreparedStatement pst = con.prepareStatement(sentenciaSQL);//se prepara la sentencia SQL que se va a usar pasandole la conexion
           //nombre del archivo
            pst.setString(1, getNombre());
           //ruta de la imagen
            pst.setString(2, getRuta());
            pst.setString(3, getPlaca());
           //ps.executeUpdate(); que diferencia hay entre estas dos opciones?
            if(!pst.execute()){//probando esto y no el update
                rpta = true;
            }
           pst.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error guardando\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return rpta;
    }
    //RECUPERAR DESDE LA BASE DE DATOS, LA INFORMACION RESPECTO A X CLIENTE  
    public boolean modificar(Connection con){
        boolean rpta = false;
        try {
           String sentenciaSQL = "UPDATE [imagen_dir] SET [nombre] = ?, [ruta] = ?, [placa] = ? WHERE cod_img = ?";//para guardar los datos
           PreparedStatement ps = con.prepareStatement(sentenciaSQL);//se prepara la sentencia SQL que se va a usar pasandole la conexion
           //nombre del archivo
           ps.setString(1, getNombre());
           //Ruta de la imagen a guardar
           ps.setString(2, getRuta());
           //placa de la imagen
           ps.setString(3, getPlaca());
           //la placa de la moto propietaria
           ps.setInt(4, getCodigo_img());
           //ps.executeUpdate(); que diferencia hay entre estas dos opciones?
           if(ps.executeUpdate() != 0){
                rpta = true;
            }
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error modificando la imagen\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
        }
        return rpta;
    }
}
