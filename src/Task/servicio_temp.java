/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author Gomez
 */
public class servicio_temp {
    /*
    create table servicio_temp ( --este tipo de servicio es especial para los clientes que no dejan datos
cod_reg int primary key identity(1, 1), 
fecha datetime default getdate() not null,
placa varchar(15) not null,
nom_ser_temp varchar(25) not null, 
procedimiento varchar(150) not null, 
cobro float not null
)
    */
    //variables
    String placa ,nom_ser_temp , procedimiento; 
    double cobro;
    
    public servicio_temp() {
        this.placa = null;
        this.nom_ser_temp = null;
        this.procedimiento = null;
        this.cobro =  0.0;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getNom_ser_temp() {
        return nom_ser_temp;
    }

    public void setNom_ser_temp(String nom_ser_temp) {
        this.nom_ser_temp = nom_ser_temp;
    }

    public String getProcedimiento() {
        return procedimiento;
    }

    public void setProcedimiento(String procedimiento) {
        this.procedimiento = procedimiento;
    }

    public double getCobro() {
        return cobro;
    }

    public void setCobro(double cobro) {
        this.cobro = cobro;
    }
    
    public boolean guardar(Connection con) {
       boolean rpta = false;
        try {
            String sql = "INSERT INTO [servicio_temp]([placa], [nom_ser_temp], [procedimiento], [cobro]) VALUES(?, ?, ?, ?)";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, getPlaca());
            ps.setString(2, getNom_ser_temp());
            ps.setString(3, getProcedimiento());
            ps.setDouble(4, getCobro());
            if(!ps.execute()){
                rpta = true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error guardando el servicio temporal\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
        }
       return rpta;
    }
    
    public boolean eliminarServicio_temp(Connection cn){
        boolean rpta = false;
        try {
            PreparedStatement ps = cn.prepareStatement("DELETE FROM servicio_temp WHERE placa = ?");
            ps.setString(1, placa);
            if(!ps.execute()){
                rpta = true;
            }
            ps.close();
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Error eliminando el servicio temporal\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
        }
        return rpta;
    }
    
}
