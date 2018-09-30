/**
 * Este paquete sera el encargado de realizar la autenticación con la base de datos 
 * para poder conceder el acceso al sistema.
 */
package Login2;

import View.JDialog_Errores;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.*;

/**
 *
 * @author Gomez
 */

public class Conexion {
    
//    protected Statement st;
//    protected ResultSet rs;
    //se decalra una variable protegida del tipo "Connection" en la cual se alamcenara 
    //la conexion con la base de datos
    protected Connection con;
    
    //protected final String url = "jdbc:sqlserver://localhost:1433; databaseName = LOGIN; user = JavaAdmin; password = Admin123*";
    
    protected final String url = "jdbc:sqlserver://;database=LOGIN;integratedSecurity=true;";
    //para la seguridad integrada se usa una dll, ubicada en el JDK/bin o en cualquier otro lugar
    //dicha dll es sqljdbc_auth.dll que se encuentra en Microsoft JDBC Driver 6.0 for SQL Server
    //o 6.4, https://www.microsoft.com/en-us/download/details.aspx?id=11774
    
    //constructor de la clase, inicializando la conexion en null
    public Conexion() {
        con = null;
    }
    
    //esto es definido por las cadenas de conexion del JDBC
    public void conectar(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(url);
        } catch (SQLException | ClassNotFoundException e) {
            //debido a que en la aplicacion pueden haber muchos errores, se creo un form donde se muestren 
            //con el "StringWritter" se recolecta la salida en un buffer que luego puede ser usado para
            //construir un string
            StringWriter errors = new StringWriter();
            //"printStackTrace" devuelve un objeto PrintWriter con el cual se 'escribira' en el "StringWriter"
            //el error devuelto
            e.printStackTrace(new PrintWriter(errors)); 
            //se instancia el JFrame de errores y se le pasa el problema encontrado
            //convirtiendo el "StringWritter" en un string, luego se hace visible
            JDialog_Errores err = new JDialog_Errores("Error con el driver", errors.toString());
            err.setVisible(true);
        } 
    }

//    public Statement getSt() {
//        return st;
//    }
//
//    public void setSt(Statement st) {
//        this.st = st;
//    }
//
//    public ResultSet getRs() {
//        return rs;
//    }
//
//    public void setRs(ResultSet rs) {
//        this.rs = rs;
//    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
    
    public boolean validar_user(Logon log) {
        return log.validar_user(con);
    }
    
    public boolean existe_user(Logon log) {
        return log.existe_user(con);
    }
    
    public boolean crear_user(Logon log) {
        return log.crear_user(con);
    }
    
    public boolean eliminar_user(Logon log) {
        return log.eliminar_user(con);
    }
    
}
