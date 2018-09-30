/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Task;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
//import java.sql.ResultSet;

/**
 *
 * @author Gomez
 */
public class agenda {
    /*
    create table agenda (
cod_cita int primary key identity(1, 1),
nombre varchar(20) not null,
descripcion varchar(50) null,
fecha_inicial datetime default getdate() not null,
fechar_entrega datetime null,
aplazar tinyint null,
placa varchar(15) not null,
foreign key(placa) references moto(placa) on delete cascade on update cascade
)
    */
    int cod_cita;
    String nombre, descripcion, placa, hora_entrega;
    Date fecha_inicial, fecha_entrega;

    public agenda() {
        this.cod_cita = 0;
        this.hora_entrega = null;
        this.nombre = null;
        this.descripcion = null;
        this.placa = null;
        this.fecha_inicial = null;
        this.fecha_entrega = null;
    }

    public int getCod_cita() {
        return cod_cita;
    }

    public void setCod_cita(int cod_cita) {
        this.cod_cita = cod_cita;
    }

    public String getHora_entrega() {
        return hora_entrega;
    }

    public void setHora_entrega(String hora_entrega) {
        this.hora_entrega = hora_entrega;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Date getFecha_inicial() {
        return fecha_inicial;
    }

    public void setFecha_inicial(Date fecha_inicial) {
        this.fecha_inicial = fecha_inicial;
    }

    public Date getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(Date fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }
     
    public boolean guardar(Connection con) {
       boolean rpta = false;
        try {
            String sql = "INSERT INTO agenda([nombre], [descripcion], [fecha_entrega], [hora_entrega], [placa]) VALUES(?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, descripcion);
            ps.setDate(3, fecha_entrega);
            ps.setString(4, hora_entrega);
            ps.setString(5, placa);
            if(!ps.execute()){
                rpta = true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error guardando la cita\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
        }
       return rpta;
    }
  
    public boolean modificar(Connection con){
        boolean resp = false;
        try{
            

            String sql = "UPDATE [agenda] SET [nombre] = ?,[descripcion] = ?,[fecha_entrega] = ?,[hora_entrega] = ?,[placa] = ? WHERE cod_cita = ?";
            PreparedStatement ps = con.prepareStatement(sql);            
            ps.setString(1, getNombre());
            ps.setString(2, getDescripcion());
            ps.setDate(3, getFecha_entrega());
            ps.setString(4, getHora_entrega());
            ps.setString(5, getPlaca());
            ps.setInt(6, getCod_cita());
            if(ps.executeUpdate() != 0){
                resp = true;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error modificando la cita\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
        }
                
        return resp;
    }
    
    public boolean eliminar(Connection con){
        boolean rpta = false;
        try {
            String sql = "DELETE FROM [agenda] WHERE cod_cita = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, getCod_cita());
            if(ps.executeUpdate() != 0){
                rpta = true;
            }
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error eliminando la cita\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
        }
        return rpta;
    }
}
