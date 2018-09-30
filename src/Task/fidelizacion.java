/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Task;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Gomez
 */
public class fidelizacion {
    int cod_fid, num_veces, cod_reg;
    double id;
    /*
    create table fidelizacion (
cod_fid int primary key identity(1, 1),
num_veces tinyint,
id bigint null,
cod_reg int null,
foreign key(id) references cliente(id) on delete cascade on update cascade,
foreign key(cod_reg) references servicio(cod_reg) 
)
   */
    
    public fidelizacion() {
        this.cod_fid = 0;
        this.num_veces = 0;
        this.cod_reg = 0;
        this.id = 0.0;
    }

    public int getCod_fid() {
        return cod_fid;
    }

    public void setCod_fid(int cod_fid) {
        this.cod_fid = cod_fid;
    }

    public int getNum_veces() {
        return num_veces;
    }

    public void setNum_veces(int num_veces) {
        this.num_veces = num_veces;
    }

    public int getCod_reg() {
        return cod_reg;
    }

    public void setCod_reg(int cod_reg) {
        this.cod_reg = cod_reg;
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    boolean procedimiento(Connection con){
        boolean rpta = false;
        try {
            //exec sp_in_fidelizacion 'plk-123', 2015001
            CallableStatement cst = con.prepareCall("{call sp_in_fidelizacion(?, ?)}") ;
            // CallableStatement cst = con.prepareCall("{call sp_in_premiacion (}") ;
            cst.setDouble(1, getId());
            //este ultimo es lo que me va a retornar.
            cst.registerOutParameter(2, java.sql.Types.INTEGER);
            cst.execute();
            rpta = true;
            //se guarda lo que se recupero en el tercer parametro
            setNum_veces(cst.getInt(2));
            //si la cantidad es 0 este debe coger el codigo y la placa y guardar un nuevo registro
            if(getNum_veces() == 0){
                //si es igual a cero, guarde una nueva premiacion
                //YA GUARDO UN NUEVO SERVICIO... SE DEBE SUMAR UNO APENAS LOS GUARDE
                if(guardar(con) == false){
                    JOptionPane.showMessageDialog(null, "Error agregando el nuevo cliente a la Fidelización.");
                }
            }else if((getNum_veces() >= 1) && (getNum_veces() <= 14)){//HAY QUE AUMENTARLOOO
                //si es mayor a cero y menor que 3 que le sume 1
                if(sumar(con) == false){
                    JOptionPane.showMessageDialog(null, "Fidelizacion Errada.");
                }
            }else if(getNum_veces() > 14){//ACA SE DEBE ALTERAR PARA QUE EL ADMIN DEL SISTEMA DETERMINE CUANTO DEBE SER
                //y si ya se paso de 5 que saque un mensaje avisando del premio
                JOptionPane.showMessageDialog(null, "¡FELICIDADES! El cliente ha ganado un premio por su fidelidad");
                //el mensaje ya no se muestra mas. luego se reinicia el contador a cero.
                if(reinicio(con)){
                    JOptionPane.showMessageDialog(null, "Se ha reiniciado el contador de servicios para la fidelización");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error cargando las fidelizaciones\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
        }
        return rpta;
    }
    
    
    public boolean guardar(Connection con) {
       boolean rpta = false;
        try {
            String sql = "INSERT INTO [fidelizacion] ([num_veces], [id]) VALUES (?, ?)";        
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, getNum_veces()+1);
            ps.setDouble(2, getId());
            if(!ps.execute()){
                rpta = true;
            }
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Error guardando la fidelización\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
        }
       return rpta;
    }
    
    public boolean sumar(Connection con){
        boolean rpta = false;
        try {
            String sql = "UPDATE [fidelizacion] SET [num_veces] = ? WHERE [id] = ?";           
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, getNum_veces()+1);
            ps.setDouble(2, getId());
            if(!ps.execute()){
                rpta = true;
            }
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error intentando sumar a la fidelización\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
        }
        return rpta;
    }
    
    boolean reinicio(Connection con) {
        boolean rpta = false;
        try {
            String sql = "UPDATE [fidelizacion] SET [num_veces] = 0 WHERE [id] = ?";           
            PreparedStatement ps = con.prepareStatement(sql);
            //ps.setInt(1, getCant_veces());
            ps.setDouble(1, getId());
            if(!ps.execute()){
                rpta = true;
            }
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error reiciando la fidelización\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
        }
        return rpta;
    }
    
}
