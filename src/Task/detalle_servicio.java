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
public class detalle_servicio {

    private int cod_ds, cod_reg, cod_ser;
    private String procedimiento;
    private double cobro;

    /*
    create table detalle_ser (
    cod_ds int primary key identity(1, 1),
    cod_reg int not null,
    cod_ser int not null,
    procedimiento varchar(150) null,
    cobro float null,
    foreign key(cod_reg) references servicio(cod_reg) on delete cascade on update cascade,
    foreign key(cod_ser) references lista_servicio(cod_ser) on delete no action on update cascade
    )
     */
    public detalle_servicio() {
        this.cod_ds = 0;
        this.cod_reg = 0;
        this.cod_ser = 0;
        this.procedimiento = null;
        this.cobro = 0;
    }

    public int getCod_ds() {
        return cod_ds;
    }

    public void setCod_ds(int cod_ds) {
        this.cod_ds = cod_ds;
    }

    public int getCod_reg() {
        return cod_reg;
    }

    public void setCod_reg(int cod_reg) {
        this.cod_reg = cod_reg;
    }

    public int getCod_ser() {
        return cod_ser;
    }

    public void setCod_ser(int cod_ser) {
        this.cod_ser = cod_ser;
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
            String sql = "INSERT INTO [detalle_ser]([cod_reg], [cod_ser], [procedimiento], [cobro]) VALUES(?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, getCod_reg());
            ps.setInt(2, getCod_ser());
            ps.setString(3, getProcedimiento());
            ps.setDouble(4, getCobro());
            if(!ps.execute()){
                rpta = true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error guardando los detalles del servicio\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
        }
       return rpta;
    }
}
