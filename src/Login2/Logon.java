/**
 * Esta será la clase encargada de realizar las consultas a la base de datos respecto a los usuarios.
 * aclaración: se hace un pool de conexiones, por ello cada llamada a un metodo de esta clase
 * debe venir con una conexión abierta y de esta manera usar solo una conexion a la base de datos
 * para realizar las consultas pertinentes
 */
package Login2;

import View.JDialog_Errores;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Gomez
 */
public class Logon {
    String user, pass;

    public Logon() {
        this.user = null;
        this.pass =null;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    //se pone el validar aca para no tener que llamar todo eso metodos
    public boolean validar_user(Connection con){
        boolean rpta = false;
        try{
            String sql = "SELECT LOGIN, PASSWORD FROM CREDENTIAL WHERE LOGIN = ? AND PASSWORD = ?"; 
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, getUser());
            ps.setString(2, getPass());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                rpta = true;
            }
            ps.close();
            rs.close();
        }catch(SQLException e){
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            JDialog_Errores err = new JDialog_Errores("Error validando usuario", errors.toString());
            err.setVisible(true);
        }
        return rpta;
    }
    //valida que exista o no un usuario en la base de datos
    public boolean existe_user(Connection con){
        boolean rpta = false;
        try{
            String sql = "SELECT LOGIN FROM CREDENTIAL WHERE LOGIN = ?"; 
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, getUser());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                rpta = true;
            }
            rs.close();
            ps.close();
        }catch(SQLException e){
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            JDialog_Errores err = new JDialog_Errores("Error verificando usuario", errors.toString());
            err.setVisible(true);
        }
        return rpta;
    }
    //crea un usuario nuevo 
    public boolean crear_user(Connection con){
        boolean rpta = false;
        try{
            //EncriptadoMD5.encriptaEnMD5(compare1);
            String sql = "INSERT INTO CREDENTIAL VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, getUser());
            ps.setString(2, getPass());
            if(!ps.execute()){
                rpta = true;
            }
        }catch(SQLException e){
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            JDialog_Errores err = new JDialog_Errores("Error creando usuario", errors.toString());
            err.setVisible(true);
        }
        return rpta;
    }
    //elimina un usuario de acuerdo al ligin de este mismo
    public boolean eliminar_user(Connection con){
        boolean rpta = false;
        try{
            //EncriptadoMD5.encriptaEnMD5(compare1);
            String sql = "DELETE FROM CREDENTIAL WHERE LOGIN = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, getUser());
            if(!ps.execute()){
                rpta = true;
            }
        }catch(SQLException e){
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            JDialog_Errores err = new JDialog_Errores("Error eliminando el usuario", errors.toString());
            err.setVisible(true);
        }
        return rpta;
    }
}
