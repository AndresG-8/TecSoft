/**
 * Esta clase es la empresa. Encargada del intercambio de los datos desde la base de datos
 * hacia la aplicacion.
 */

package Task;

import View.JDialog_Cliente_General;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Gomez
 */
public class empresa {
    protected String nit, razon_social, dir1, dir2,  correo, url;
    protected double tel1, tel2, cel1, cel2;
    
    /*
    create table empresa (
nit varchar(15),--creo que es mejor cambiarlo
razon_social varchar(40) not null,
tel1 bigint null,
tel2 bigint null,
cel1 bigint null,
cel2 bigint null,
dir1 varchar(50) null,
dir2 varchar(50) null,
correo varchar(50) null,
url varchar(50) null,
primary key(nit)
)
    */

    public empresa() {
        this.nit = null;
        this.razon_social = null;
        this.dir1 = null;
        this.dir2 = null;
        this.correo = null;
        this.url = null;
        this.tel1 = 0;
        this.tel2 = 0;
        this.cel1 = 0;
        this.cel2 = 0;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
    
    public boolean guardar(Connection con) {
       boolean rpta = false;
        try {
            String sql = "INSERT INTO [empresa]([nit], [razon_social], [tel1], [tel2], [cel1], [cel2], [dir1], [dir2], [correo], [url])\n" +
                            "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nit);
            ps.setString(2, razon_social);
            ps.setDouble(3, tel1);
            ps.setDouble(4, tel2);
            ps.setDouble(5, cel1);
            ps.setDouble(6, cel2);
            ps.setString(7, dir1);
            ps.setString(8, dir2);
            ps.setString(9, correo);
            ps.setString(10, url);
            if(!ps.execute()){
                rpta = true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error guardando los datos de la empresa\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
        }
       return rpta;
    }

    //Verifica si el cliente existe en la base de datos
    boolean verificar(Connection con) {
        boolean resp = false;
        try
        {
            String sql= "SELECT nit, razon_social FROM empresa WHERE nit = ?" ;
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nit);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                resp = true;
                nit = rs.getString(1);
                razon_social = rs.getString(2);
            } 
            ps.close();
       }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error verificando los datos de la empresa\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
       } 
       return resp;
    }
    
    boolean cargar_datos(Connection con) {
        boolean resp = false;
        try
        {
            String sql= "SELECT [nit],[razon_social],[tel1],[tel2],[cel1],[cel2],[dir1],[dir2],[correo],[url] FROM [dbo].[empresa] WHERE nit = ?" ;
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nit);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                resp = true;
                setNit(rs.getString(1));
                setRazon_social(rs.getString(2));
                setTel1(rs.getDouble(3));
                setTel2(rs.getDouble(4));
                setCel1(rs.getDouble(5));
                setCel2(rs.getDouble(6));
                setDir1(rs.getString(7));
                setDir2(rs.getString(8));
                setCorreo(rs.getString(9));
                setUrl(rs.getString(10));
            } 
            ps.close();
       }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error cargando los datos de la empresa\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
       } 
       return resp;
    }
    
    public boolean modificar(Connection con) {
       boolean rpta = false;
        try {
            String sql = "UPDATE [empresa] SET [nit] = ?,[razon_social] = ?,[tel1] = ?,[tel2] = ?\n" +
                    "      ,[cel1] = ?,[cel2] = ?,[dir1] = ?,[dir2] = ?,[correo] = ?\n" +
                    "	  ,[url] = ? WHERE nit = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, getNit());
            ps.setString(2, getRazon_social());
            ps.setDouble(3, getTel1());
            ps.setDouble(4, getTel2());
            ps.setDouble(5, getCel1());
            ps.setDouble(6, getCel2());
            ps.setString(7, getDir1());
            ps.setString(8, getDir2());
            ps.setString(9, getCorreo());
            ps.setString(10, getUrl());
            ps.setString(11, JDialog_Cliente_General.nit_s);
            if(ps.executeUpdate() != 0){
                rpta = true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error modificando los datos de la empresa\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
        }
       return rpta;
    }
    public boolean eliminar(Connection con){
        boolean rpta = false;
        try {
            String sql = "DELETE FROM [empresa] WHERE nit = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, getNit());
            if(ps.executeUpdate() != 0){
                rpta = true;
            }
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error eliminando los datos de la empresa\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
        }
        return rpta;
    }
}
