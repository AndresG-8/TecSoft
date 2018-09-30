
package Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Gomez
 */
public class bus_cli {
    double id;
    String nombre, apellido,  placa, nit, razon_social;

    public bus_cli() {
        this.id = 0;
        this.nombre = null;
        this.apellido = null;
        this.placa = null;
        this.nit = null;
        this.razon_social = null;
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
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
    //cliente-identificacion
    boolean hay_empresa(Connection con) {
        boolean resp = false;
        try
        {
            //select id, nombre, apellido1, nit from cliente where id = 10
            String sql= "SELECT nit FROM cliente WHERE id = ?" ;
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, getId());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                if(rs.getString(1) != null){
                    resp = true;
                }
            }
            ps.close();
       }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error consultando la empresa\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
       } 
       return resp;
    }
     //cliente-nombre
    boolean hay_empresa_nombre(Connection con) {
        boolean resp = false;
//        int contador = 0;
        try{
            //select id, nombre, apellido1, nit from cliente where id = 10
            String sql= "SELECT nit FROM cliente WHERE nombre = ?" ;
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, getNombre());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                if(rs.getString(1) != null){
                    resp = true;
                }
            }
            ps.close();
       }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error consultando el nombre de la empresa\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
       } 
       return resp;
    }
    //moto-placa
    boolean hay_empresa_moto(Connection con) {
        boolean resp = false;
        try
        {
            //select id, nombre, apellido1, nit from cliente where id = 10
            String sql= "SELECT nit FROM cliente INNER JOIN moto on cliente.id = moto.id where moto.placa = ?" ;
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, getPlaca());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                if(rs.getString(1) != null){
                    resp = true;
                }
            }
            ps.close();
       }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error cinsultando empresa-moto\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
       } 
       return resp;
    }
    //empresa-nit
    boolean hay_empresa_emp(Connection con) {
        boolean resp = false;
        try
        {
            //select id, nombre, apellido1, nit from cliente where id = 10
            String sql= "SELECT nit FROM empresa where nit = ?" ;
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, getNit());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                if(rs.getString(1) != null){
                    resp = true;
                }
            }
            ps.close();
       }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error consultando el nit de la empresa\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
       } 
       return resp;
    }
    //empresa-razon_social
    boolean hay_empresa_rz(Connection con) {
        boolean resp = false;
        try
        {
            String sql= "SELECT nit FROM empresa WHERE razon_social = ?" ;
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, getRazon_social());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                if(rs.getString(1) != null){
                    resp = true;
                }
            }
            ps.close();
       }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error consultando la razón social de la empresa\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
       } 
       return resp;
    }
    
}
