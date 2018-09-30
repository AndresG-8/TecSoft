/**
 * Esta clase se encarga de darle tratamiento a los datos que se insertan en la el JDialog_Cliente
 * asi, cada boton esta programado para llamar un metodo aca desigando,
 * las tareas comunes que necesite seran ejecutadas en la clase Conexion.
 * la conexion s la base de datos (si se requiere) se mandan desde el JDialog
 */

package Task;

import View.JDialog_Cliente_General;
import View.JDialog_Errores;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Gomez
 */
public class cliente {

    protected String tipo_id, nombre, apellido1, apellido2, dir1, dir2, correo, nit;
    protected double id, tel1, tel2, cel1, cel2;
    
    /*
    create table cliente (
id bigint,
tipo_id varchar(20) null,
nombre varchar(40) not null,
apellido1 varchar(20) null,
apellido2 varchar(20) null,
tel1 bigint null,
tel2 bigint null,
cel1 bigint null,
cel2 bigint null,
dir1 varchar(50) null,
dir2 varchar(50) null,
correo varchar(50) null,
nit varchar(15) null,
primary key(id),
foreign key(nit) references empresa (nit) on delete set null on update cascade
)
    */
    
    public cliente() {
        this.id = 0; 
        this.tipo_id = "";
        this.nombre = "";
        this.apellido1 = null;
        this.apellido2 = null;
        this.dir1 = null; 
        this.dir2 = null; 
        this.correo = null; 
        this.nit = null;
        this.tel1 = 0; 
        this.tel2 = 0; 
        this.cel1 = 0; 
        this.cel2 = 0;
    }

    public String getTipo_id() {
        return tipo_id;
    }

    public void setTipo_id(String tipo_id) {
        this.tipo_id = tipo_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getDir1() {
        return dir1;
    }

    public void setDir1(String dir1) {
        this.dir1 = dir1;
    }

    public String getDir2() {
        return dir2;
    }

    public void setDir2(String dir2) {
        this.dir2 = dir2;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public double getTel1() {
        return tel1;
    }

    public void setTel1(double tel1) {
        this.tel1 = tel1;
    }

    public double getTel2() {
        return tel2;
    }

    public void setTel2(double tel2) {
        this.tel2 = tel2;
    }

    public double getCel1() {
        return cel1;
    }

    public void setCel1(double cel1) {
        this.cel1 = cel1;
    }

    public double getCel2() {
        return cel2;
    }

    public void setCel2(double cel2) {
        this.cel2 = cel2;
    }
    //Guarda el cliente con los parametros, si no se insertan datos, 
    //el constructor deja los datos como inicialmente esta
    public boolean guardar(Connection con) {
       boolean rpta = false;
        try {
            String sql = "INSERT INTO cliente([id],[tipo_id] ,[nombre],[apellido1],[apellido2]\n" +
                ",[tel1],[tel2],[cel1],[cel2],[dir1],[dir2],[correo],[nit]) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, id);
            ps.setString(2, tipo_id);
            ps.setString(3, nombre);
            ps.setString(4, apellido1);
            ps.setString(5, apellido2);
            ps.setDouble(6, tel1);
            ps.setDouble(7, tel2);
            ps.setDouble(8, cel1);
            ps.setDouble(9, cel2);
            ps.setString(10, dir1);
            ps.setString(11, dir2);
            ps.setString(12, correo);
            ps.setString(13, nit);
            if(!ps.execute()){
                rpta = true;
            }
        } catch (Exception e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            JDialog_Errores err = new JDialog_Errores("Error guardando el cliente", errors.toString());
            err.setVisible(true);
        }
       return rpta;
    }

    //Verifica si el cliente existe en la base de datos. veridicacion simple.
    boolean verificar(Connection con) {
        boolean resp = false;
        try{
            String sql= "SELECT id, nombre FROM cliente WHERE id = ?" ;
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                resp = true;
                id = rs.getDouble(1);
                nombre = rs.getString(2);
            } 
            ps.close();
       }catch(Exception e){
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            JDialog_Errores err = new JDialog_Errores("Error verificando el cliente", errors.toString());
            err.setVisible(true);
        } 
       return resp;
    }
    
    //aca se creara la opcion que cargara todos los datos en los campos de ccliente_general
    
    boolean cargar_datos(Connection con) {
        boolean resp = false;
        try
        {
            String sql = "SELECT [id],[tipo_id],[nombre],[apellido1],[apellido2],[tel1],[tel2],[cel1],[cel2],[dir1],[dir2],[correo],[nit] FROM [dbo].[cliente] WHERE [id] = ?" ;
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                resp = true;
                id = rs.getDouble(1);
                tipo_id = rs.getString(2);
                nombre = rs.getString(3);
                apellido1 = rs.getString(4);
                apellido2 = rs.getString(5);
                tel1 = rs.getDouble(6);
                tel2 = rs.getDouble(7);
                cel1 = rs.getDouble(8);
                cel2 = rs.getDouble(9);
                dir1 = rs.getString(10);
                dir2 = rs.getString(11);
                correo = rs.getString(12);
                nit = rs.getString(13);
            } 
            ps.close();
       }catch(Exception e){
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            JDialog_Errores err = new JDialog_Errores("Error cargando los datos del cliente", errors.toString());
            err.setVisible(true);
       } 
       return resp;
    }
    
    //modificar los datos del cliente
    public boolean modificar(Connection con){
        boolean resp = false;
        try{//set y el campo que se quiere actualizar, where es como busca para actualizar
            String sql = "UPDATE [cliente] SET [id] = ? , [tipo_id] = ? ,[nombre] = ? ,[apellido1] = ? ,[apellido2] = ? ,\n" +
            "[tel1] = ? ,[tel2] =? ,[cel1] = ? ,[cel2] = ? ,[dir1] = ? ,[dir2] = ? ,[correo] = ? ,[nit] = ? \n" +
            " WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, getId());
            ps.setString(2, getTipo_id());
            ps.setString(3, getNombre());
            ps.setString(4, getApellido1());
            ps.setString(5, getApellido2());
            ps.setDouble(6, getTel1());
            ps.setDouble(7, getTel2());
            ps.setDouble(8, getCel1());
            ps.setDouble(9, getCel2());
            ps.setString(10, getDir1());
            ps.setString(11, getDir2());
            ps.setString(12, getCorreo());
            ps.setString(13, getNit());
            ps.setDouble(14, JDialog_Cliente_General.id_s);
            if(ps.executeUpdate() != 0){//si es cero actualiza? no lo se. probar a ver que sale
                resp = true;
            }
        }catch(Exception e){
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            JDialog_Errores err = new JDialog_Errores("Error modificando los datos del cliente", errors.toString());
            err.setVisible(true);
        }                
        return resp;
    }

    public boolean eliminar(Connection con){
        boolean rpta = false;
        try {
            String sql = "DELETE FROM [cliente] WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, getId());
            if(ps.executeUpdate() != 0){
                rpta = true;
            }
            ps.close();
        } catch (Exception e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            JDialog_Errores err = new JDialog_Errores("Error eliminando los datos del cliente", errors.toString());
            err.setVisible(true);
        }
        return rpta;
    }
}
