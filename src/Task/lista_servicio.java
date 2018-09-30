/**
 */

package Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Gomez
 */
public class lista_servicio {
    protected String nombre_ser, tipo_ser, diag_inicial;
    int cod_ser;

    /*
    create table lista_servicio (
    cod_ser int primary key identity(1, 1),
    nombre_ser varchar(25) not null,
    tipo_ser varchar(50) null, --si es un servicio o una cotizacion
    diag_inicial varchar(150) null
    ) */
    public lista_servicio() {
        this.cod_ser = 0;
        this.nombre_ser = null;
        this.tipo_ser = null;
        this.diag_inicial = null; 
    }

    public String getNombre_ser() {
        return nombre_ser;
    }

    public void setNombre_ser(String nombre_ser) {
        this.nombre_ser = nombre_ser;
    }

    public String getTipo_ser() {
        return tipo_ser;
    }

    public void setTipo_ser(String tipo_ser) {
        this.tipo_ser = tipo_ser;
    }

    public String getDiag_inicial() {
        return diag_inicial;
    }

    public void setDiag_inicial(String diag_inicial) {
        this.diag_inicial = diag_inicial;
    }

    public int getCod_ser() {
        return cod_ser;
    }

    public void setCod_ser(int cod_ser) {
        this.cod_ser = cod_ser;
    }
    
    public boolean guardar(Connection con) {
       boolean rpta = false;
        try {
            String sql = "INSERT INTO [lista_servicio]([nombre_ser], [tipo_ser], [diag_inicial]) VALUES(?, ?, ?)";
          
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, getNombre_ser());
            ps.setString(2, getTipo_ser());
            ps.setString(3, getDiag_inicial());
            if(!ps.execute()){
                rpta = true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error guardando la lista de servicios\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
        }
       return rpta;
    }

    boolean verificar(Connection con) {
        boolean resp = false;
        try
        {
            String sql= "SELECT cod_ser, nombre_ser, tipo_ser FROM lista_servicio WHERE tipo_ser = ?" ;
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, getTipo_ser());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                resp = true;
                setCod_ser(rs.getInt(1));
                setNombre_ser(rs.getString(2));
                setTipo_ser(rs.getString(3));
            } 
            ps.close();
       }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error verificando la lista de servicios\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
       } 
       return resp;
    }
    
    public boolean modificar(Connection con){
        boolean resp = false;
        try{
            String sql = "UPDATE [lista_servicio] SET [nombre_ser] = ?,[tipo_ser] = ?,[diag_inicial] = ? WHERE cod_ser = ?";
            PreparedStatement ps = con.prepareStatement(sql);            
            ps.setString(1, getNombre_ser());
            ps.setString(2, getTipo_ser());
            ps.setString(3, getDiag_inicial());
            ps.setInt(4, getCod_ser());
            if(ps.executeUpdate() != 0){
                resp = true;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error modificando el servicio\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
        }
                
        return resp;
    }
    
    public boolean eliminar(Connection con){
        boolean rpta = false;
        try {
            String sql = "DELETE FROM [lista_servicio] WHERE cod_ser = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, getCod_ser());
            if(ps.executeUpdate() != 0){
                rpta = true;
            }
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error eliminando el servicio\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
        }
        return rpta;
    }
}
