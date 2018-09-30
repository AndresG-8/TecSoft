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
public class premiacion {
    
    private String placa;
    private int cod_premio, cod_ser, cant_veces;
    /*
    create table premiacion (
cod_premio int primary key identity(1, 1),
placa varchar(15),
cod_ser int,
cant_veces int not null,
foreign key(placa) references moto(placa) on delete cascade on update cascade,
foreign key(cod_ser) references lista_servicio(cod_ser) on delete cascade on update cascade
)
    */

    /*
    create table premiacion (
    cod_premio int primary key identity(1, 1),
    placa varchar(15),
    cod_ser int,
    cant_veces int not null,
    foreign key(placa) references moto(placa) on delete cascade on update cascade,
    foreign key(cod_ser) references lista_servicio(cod_ser) on delete cascade on update cascade
    )
     */
    public premiacion() {
        this.placa = null;
        this.cod_premio = 0;
        this.cod_ser = 0;
        this.cant_veces = 0;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getCod_premio() {
        return cod_premio;
    }

    public void setCod_premio(int cod_premio) {
        this.cod_premio = cod_premio;
    }

    public int getCod_ser() {
        return cod_ser;
    }

    public void setCod_ser(int cod_ser) {
        this.cod_ser = cod_ser;
    }

    public int getCant_veces() {
        return cant_veces;
    }

    public void setCant_veces(int cant_veces) {
        this.cant_veces = cant_veces;
    }
    
    
    
    boolean procedimiento(Connection con){
        boolean rpta = false;
        try {
            //exec sp_in_premiacion 'plk-123', 2015001
            CallableStatement cst = con.prepareCall("{call sp_in_premiacion(?, ?, ?)}") ;
            // CallableStatement cst = con.prepareCall("{call sp_in_premiacion (}") ;
            cst.setString(1, getPlaca());
            cst.setInt(2, getCod_ser());
            //este ultimo es lo que me va a retornar.
            cst.registerOutParameter(3, java.sql.Types.INTEGER);
            cst.execute();
            rpta = true;
            //se guarda lo que se recupero en el tercer parametro
            setCant_veces(cst.getInt(3));
            //si la cantidad es 0 este debe coger el codigo y la placa y guardar un nuevo registro
            if(getCant_veces() == 0){
                //si es igual a cero, guarde una nueva premiacion
                //YA GUARDO UN NUEVO SERVICIO... SE DEBE SUMAR UNO APENAS LOS GUARDE
                if(guardar(con)){
                    JOptionPane.showMessageDialog(null, "se guardo el nuevo servicio en la tabla de premios");
                }
            }else if((getCant_veces() >= 1) && (getCant_veces() <= 4)){
                //si es mayor a cero y menor que 5 que le sume 1
                //aca tengo duda de si al cinco exacto o a la 6
                if(sumar(con)){
                    JOptionPane.showMessageDialog(null, "se sumo 1 (uno) en la cuenta de servicios");
                }
            }else if(getCant_veces() > 4){//ACA SE DEBE ALTERAR PARA QUE EL ADMIN DEL SISTEMA DETERMINE CUANTO DEBE SER
                //y si ya se paso de 5 que saque un mensaje avisando del premio
                JOptionPane.showMessageDialog(null, "¡FELICIDADES! El cliente ha ganado un premio por su fidelidad "
                        + "\nEl servicio que se ha prestado en mas de 5 ocaciones ha sido el " + getCod_ser());
                //el mensaje ya no se muestra mas. luego se reinicia el contador a cero.
                if(reinicio(con)){
                    JOptionPane.showMessageDialog(null, "Se ha reiniciado el contador de servicios para la premiacion :D");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error guardando los datos para la premiación\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
        }
        return rpta;
    }
    
    
    public boolean guardar(Connection con) {
       boolean rpta = false;
        try {
            String sql = "INSERT INTO premiacion([placa], [cod_ser], [cant_veces]) VALUES(?, ?, ?)";           
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, getPlaca());
            ps.setInt(2, getCod_ser());
            ps.setInt(3, getCant_veces()+1);
            if(!ps.execute()){
                rpta = true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error guardando la premiación\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
        }
       return rpta;
    }
    
    public boolean sumar(Connection con){
        /*UPDATE [dbo].[premiacion]
   SET [placa] = <placa, varchar(15),>
      ,[cod_ser] = <cod_ser, int,>
      ,[cant_veces] = <cant_veces, int,>
 WHERE <Search Conditions,,>*/
        boolean rpta = false;
        try {
            String sql = "UPDATE premiacion SET [cant_veces] = ? WHERE [placa] = ? AND [cod_ser] = ?";           
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, getCant_veces()+1);
            ps.setString(2, getPlaca());
            ps.setInt(3, getCod_ser());
            if(!ps.execute()){
                rpta = true;
            }
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error sumando en la premiación\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
        }
        return rpta;
    }

    boolean reinicio(Connection con) {
        boolean rpta = false;
        try {
            String sql = "UPDATE premiacion SET [cant_veces] = 0 WHERE [placa] = ? AND [cod_ser] = ?";           
            PreparedStatement ps = con.prepareStatement(sql);
            //ps.setInt(1, getCant_veces());
            ps.setString(1, getPlaca());
            ps.setInt(2, getCod_ser());
            if(!ps.execute()){
                rpta = true;
            }
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error reiciando el contador para la premiación\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
        }
        return rpta;
    }
}
