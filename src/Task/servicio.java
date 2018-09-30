/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Task;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Gomez
 */
public class servicio {
    
    private String placa;
    private String tipo_ser;
    private Date fecha;
    private int cod_reg;
    private String resp;

    /*
    create table servicio (
    cod_reg int primary key identity(1, 1),
    fecha datetime default getdate() not null,
    placa varchar(15) not null,
    tipo_ser varchar(12) not null,
    foreign key(placa) references moto(placa) on delete cascade on update cascade
    )
     */
    public servicio() {
        this.placa = null;
        this.tipo_ser = null;
        this.fecha = null;
        this.cod_reg = 0;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipo_ser() {
        return tipo_ser;
    }

    public void setTipo_ser(String tipo_ser) {
        this.tipo_ser = tipo_ser;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCod_reg() {
        return cod_reg;
    }

    public void setCod_reg(int cod_reg) {
        this.cod_reg = cod_reg;
    }

    public String getResp() {
        return resp;
    }

    public void setResp(String resp) {
        this.resp = resp;
    }
    
    public boolean guardar(Connection con) {
       boolean rpta = false;
        try {
            String sql = "INSERT INTO [servicio] ([placa], [tipo_ser], [responsable]) VALUES(?, ?, ?)";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, getPlaca());
            ps.setString(2, getTipo_ser());
            ps.setString(3, getResp());
            if(!ps.execute()){
                rpta = true;
//                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error guardando el servicio\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
        }
       return rpta;
    }
    
    int ultimo_registro(Connection con) {
        int resp = 0;
        try
        {
            String sql= "SELECT MAX(cod_reg) FROM servicio" ;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                resp = rs.getInt(1);
            }
            st.close();
       }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error intentando de recuperar el ultimo registro\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
       } 
       return resp;
    }
    //usado por ahora para eliminar una cotizacion desde el servicio
    public boolean eliminar(Connection con) {
       boolean rpta = false;
        try {
            String sql = "DELETE FROM servicio WHERE cod_reg = ?";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt( 1, getCod_reg() );
            if(!ps.execute()){
                rpta = true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error eliminando\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
        }
       return rpta;
    }
}
