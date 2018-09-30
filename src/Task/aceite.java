/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Task;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import javax.swing.JOptionPane;
//import java.sql.ResultSet;

/**
 *
 * @author Gomez
 */
public class aceite {
       /*
aceite VARCHAR(25) NOT NULL, 
marca VARCHAR(25) NULL, 
cantidad INT NOT NULL, 
ult_cambio DATE, 
km_actual INT NOT NULL, 
estado SMALLINT NOT NULL, 
km_prox_cambio INT NOT NULL,--se calcula en base a km_actual y estado
fecha_prox_cambio DATE NOT NULL, --se calcula en base a km_diarios
nombre VARCHAR(40) NOT NULL,
placa VARCHAR(15) NOT NULL,*/
    
    int cod_aceite, cantidad, km_actual, estado, km_prox_cambio;
    String aceite, marca, placa, nombre;
    Date ult_cambio, fecha_prox_cambio;

    public aceite() {
        this.cod_aceite = 0;
        this.cantidad = 0;
        this.km_actual = 0;
        this.estado = 0;
        this.km_prox_cambio = 0;
        this.aceite = null;
        this.marca = null;
        this.placa = null;
        this.ult_cambio = null;
        this.fecha_prox_cambio = null;
    }  

    public int getCod_aceite() {
        return cod_aceite;
    }

    public void setCod_aceite(int cod_aceite) {
        this.cod_aceite = cod_aceite;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getKm_actual() {
        return km_actual;
    }

    public void setKm_actual(int km_actual) {
        this.km_actual = km_actual;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getKm_prox_cambio() {
        return km_prox_cambio;
    }

    public void setKm_prox_cambio(int km_prox_cambio) {
        this.km_prox_cambio = km_prox_cambio;
    }

    public String getAceite() {
        return aceite;
    }

    public void setAceite(String aceite) {
        this.aceite = aceite;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Date getUlt_cambio() {
        return ult_cambio;
    }

    public void setUlt_cambio(Date ult_cambio) {
        this.ult_cambio = ult_cambio;
    }

    public Date getFecha_prox_cambio() {
        return fecha_prox_cambio;
    }

    public void setFecha_prox_cambio(Date fecha_prox_cambio) {
        this.fecha_prox_cambio = fecha_prox_cambio;
    }
    
    boolean guardar(Connection con){
        boolean rpta = false;
        try {
            CallableStatement cst = con.prepareCall("{call sp_in_aceite(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}") ;
           
            cst.setString(1, getAceite());
            cst.setString(2, getMarca());
            cst.setInt(3, getCantidad());
            cst.setDate(4, getUlt_cambio());
            cst.setInt(5, getKm_actual());
            cst.setInt(6, getEstado());
            cst.setInt(7, getKm_prox_cambio());
            cst.setDate(8, getFecha_prox_cambio());
            cst.setString(9, getPlaca());
            cst.setString(10, getNombre());
            //este ultimo es lo que me va a retornar.
            //cst.registerOutParameter(11, java.sql.Types.INTEGER);
            cst.execute();
            rpta = true;
            cst.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error guardando los datos sobre el aceite\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
        }
        return rpta;
    }
   
    public boolean modificar(Connection con){
        boolean resp = false;
        try{
            CallableStatement cst = con.prepareCall("{call sp_up_aceite(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}") ;
           
            cst.setString(1, getAceite());
            cst.setString(2, getMarca());
            cst.setInt(3, getCantidad());
            cst.setDate(4, getUlt_cambio());
            cst.setInt(5, getKm_actual());
            cst.setInt(6, getEstado());
            cst.setInt(7, getKm_prox_cambio());
            cst.setDate(8, getFecha_prox_cambio());
            cst.setString(9, getPlaca());
            cst.setString(10, getNombre());
            //este ultimo es lo que me va a retornar.
            //cst.registerOutParameter(11, java.sql.Types.INTEGER);
            cst.execute();
            resp = true;
            cst.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error modificando los datos sobre el aceite\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
        }
                
        return resp;
    }
    
    public boolean eliminar(Connection con){
        boolean rpta = false;
        try {
            CallableStatement cst = con.prepareCall("{call sp_del_aceite(?)}") ;
            cst.setInt(1, getCod_aceite());
            cst.execute();
            rpta = true;
            cst.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error eliminando los datos sobre el aceite\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
        }
        return rpta;
    }
    //CUANDO LLEGA EL DIA DE HACER ALGO POR X CLIENTE
    //SE RECUPERAN LOS DATOS PRINCIPALES
    

}
