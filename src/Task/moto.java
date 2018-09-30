/**
 * Esta clase se encarga de manipular las tareas pertinentes a la moto
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
public class moto {
    String placa, marca, linea, color;
    double id;
    int modelo, cilindraje;
    /*
    create table moto (
placa varchar(15),
marca varchar(15) null,
linea varchar(15) null,
modelo smallint null,
cilindraje smallint null,
color varchar(25) null,
id bigint not null,
primary key(placa),
foreign key(id) references cliente(id) on delete cascade on update cascade
)
    */

    public moto() {
        this.placa = null;
        this.marca = null;
        this.linea = null;
        this.color = null;
        this.id = 0;
        this.modelo = 0;
        this.cilindraje = 0;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }
    
    public boolean guardar(Connection con) {
       boolean rpta = false;
        try {
            String sql = "INSERT INTO [moto]([placa],[marca],[linea],[modelo],[cilindraje],[color],[id])\n" +
                            " VALUES(?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, getPlaca());
            ps.setString(2, getMarca());
            ps.setString(3, getLinea());
            ps.setInt(4, getModelo());
            ps.setInt(5, getCilindraje());
            ps.setString(6, getColor());
            ps.setDouble(7, getId());
            if(!ps.execute()){
                rpta = true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error guardando la moto\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
        }
       return rpta;
    }

    boolean verificar(Connection con) {
        boolean resp = false;
        try
        {
            String sql= "SELECT placa, marca, id FROM moto WHERE placa = ?" ;
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, getPlaca());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                resp = true;
                setPlaca(rs.getString(1));
                setMarca(rs.getString(2));
                setId(rs.getDouble(3));
            } 
            ps.close();
       }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error verificando los datos de la moto\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
       } 
       return resp;
    }
   
    boolean cargar_datos(Connection con) {
        boolean resp = false;
        try
        {
            String sql= "SELECT [placa],[marca],[linea],[modelo],[cilindraje],[color],[id] FROM [dbo].[moto] WHERE id = ?" ;
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, getId());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){//muestra solo una moto; que pasa si tiene mas de una moto?
                resp = true;
                setPlaca(rs.getString(1));
                setMarca(rs.getString(2));
                setLinea(rs.getString(3));
                setModelo(rs.getInt(4));
                setCilindraje(rs.getInt(5));
                setColor(rs.getString(6));
                setId(rs.getDouble(7));
            } 
            ps.close();
       }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al tratar de cargar los datos de la moto\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
       } 
       return resp;
    }
    
    //para modificar
    public boolean modificar(Connection con){
        boolean resp = false;
        try{
            String sql = "UPDATE [moto] SET [placa] = ?, [marca] = ?,  [linea] = ?,[modelo] = ?,\n" +
            "   [cilindraje] = ?,[color] = ? ,[id] = ? WHERE [placa] = ?";
            PreparedStatement ps = con.prepareStatement(sql);            
            ps.setString(1, getPlaca());
            ps.setString(2, getMarca());
            ps.setString(3, getLinea());
            ps.setInt(4, getModelo());
            ps.setInt(5, getCilindraje());
            ps.setString(6, getColor());
            ps.setDouble(7, getId());
            ps.setString(8, JDialog_Cliente_General.placa_s);
            if(ps.executeUpdate() != 0){
                resp = true;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error modificando los datos de la moto\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
        }
                
        return resp;
    }
    
    public boolean eliminar(Connection con){
        boolean rpta = false;
        try {
            String sql = "DELETE FROM [moto] WHERE placa = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, getPlaca());
            if(ps.executeUpdate() != 0){
                rpta = true;
            }
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error eliminando los datos de la moto\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
        }
        return rpta;
    }
}
