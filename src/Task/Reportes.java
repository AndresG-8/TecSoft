package Task;

//el reporte(plantilla de reporte) se crea con el wizard design, luego se coge el 
//archivo .jasper y se pasa al dir raiz de la aplicacion

//estos dos son para cargar el reporte en la aplicacion. 
import View.JDialog_Errores;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author Gomez
 */
public class Reportes {
     Conexion con;
    double id, cobro;
    
    //declaracion de los datos temporales del cliente
    String placa, linea,  nombreC, apellidoC,  nit, razon_social;
    double idC, telC, celC, telE;
    
    public Reportes() {
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public double getCobro() {
        return cobro;
    }

    public void setCobro(double cobro) {
        this.cobro = cobro;
    }

    //metodos para almacenar el cliente temporalmente recuperado de la base de datos
    //y pasarlos al reporte
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public String getNombreC() {
        return nombreC;
    }

    public void setNombreC(String nombreC) {
        this.nombreC = nombreC;
    }

    public String getApellidoC() {
        return apellidoC;
    }

    public void setApellidoC(String apellidoC) {
        this.apellidoC = apellidoC;
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

    public double getIdC() {
        return idC;
    }

    public void setIdC(double idC) {
        this.idC = idC;
    }

    public double getTelC() {
        return telC;
    }

    public void setTelC(double telC) {
        this.telC = telC;
    }

    public double getCelC() {
        return celC;
    }

    public void setCelC(double celC) {
        this.celC = celC;
    }

    public double getTelE() {
        return telE;
    }

    public void setTelE(double telE) {
        this.telE = telE;
    }
    //CARGA EL REPORTE DE SERVICIOS
    public boolean cargar(Connection con){
        boolean rpta = false;
        try {
           JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile("Cliente_Servicio.jasper");          
           //este es el reporte ya con datos cargados desde la bd
           JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null, con);
           //estas es para mostrar el reporte creado
           JasperViewer.viewReport(jasperPrint, false);
           rpta = true;
        } catch (Exception e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            JDialog_Errores err = new JDialog_Errores("Error creando el reporte", errors.toString());
            err.setVisible(true);
        }
        return rpta;
    }
    //Carga un reporte con el parametro de entrada para obtener un resultado
    //CARGA EL REPORTE DE DETALLE SERVICIOS
    public boolean cargar_param(Connection con){
        boolean rpta = false;
        try {
            if(total(con)){
                //para agregar un parametro de entrada al reporte
                Map parametro = new HashMap();
                parametro.put("identificacion", getId());
                parametro.put("total", getCobro());
                //carga la plantilla
                JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile("Det_Servicio.jasper");          

                //este es el reporte ya con datos cargados desde la bd
                JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametro, con);
                //esta es para mostrar el reporte creado y alli se dan las opciones de impresion y demas
                JasperViewer.viewReport(jasperPrint, false);
                rpta = true;
            }else{
            JOptionPane.showMessageDialog(null, "El cliente no presenta servicio alguno\n", "Total fail", JOptionPane.INFORMATION_MESSAGE );    
            }
        } catch (Exception e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            JDialog_Errores err = new JDialog_Errores("Error creando el reporte", errors.toString());
            err.setVisible(true);
        }
        return rpta;
    }
   //CARGA EL REPORTE DE SERVICIOS DIARIOS
    public boolean cargar_dia(Connection con){
        boolean rpta = false;
        try {
            if(total_dia(con)){
                //para agregar un parametro de entrada al reporte
                Map parametro = new HashMap();
                parametro.put("total", getCobro());
                //carga la plantilla
                JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile("Reporte_Dia.jasper");          

                //este es el reporte ya con datos cargados desde la bd
                JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametro, con);
                //esta es para mostrar el reporte creado y alli se dan las opciones de impresion y demas
                JasperViewer.viewReport(jasperPrint, false);
                rpta = true;
            }
        } catch (Exception e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            JDialog_Errores err = new JDialog_Errores("Error creando el reporte", errors.toString());
            err.setVisible(true);
        }
        return rpta;
    }
    //CARGA EL REPORTE DE TODOS LOS CLIENTES
    public boolean cargar_clientes(Connection con){
        boolean rpta = false;
        try {
           JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile("Clientes.jasper");          
           //este es el reporte ya con datos cargados desde la bd
           JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null, con);
           //estas es para mostrar el reporte creado
           JasperViewer.viewReport(jasperPrint, false);
           rpta = true;
        } catch (Exception e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            JDialog_Errores err = new JDialog_Errores("Error creando el reporte", errors.toString());
            err.setVisible(true);
        }
        return rpta;
    }
    //CARGA EL TOTAL PARA EL REPORTE DE SERVICIOS GENERALES, Y PARA DETALLE_SERVICIO 
    boolean total(Connection con) {
        boolean resp = false;
        try{
            String sql= "SELECT (SUM(cobro)) as 'Total' FROM cliente inner join moto on cliente.id = moto.id\n" +
                "inner join servicio on moto.placa = servicio.placa inner join detalle_ser on servicio.cod_reg = detalle_ser.cod_reg\n" +
                "WHERE cliente.id = ?" ;
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, getId());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                resp = true;
                setCobro(rs.getDouble(1));
            } 
            ps.close();
            rs.close();
       }catch(Exception e){
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            JDialog_Errores err = new JDialog_Errores("Error cargando el total", errors.toString());
            err.setVisible(true);
        } 
       return resp;
    }
    //CARGA EL TOTAL PARA LOS SERVICIOS DE EL DIA ACTUAL
     boolean total_dia(Connection con) {
        boolean resp = false;
        try{
            String sql= "SELECT SUM(detalle_ser.cobro) AS total\n" +
                "FROM cliente INNER JOIN moto ON cliente.id = moto.id\n" +
                "INNER JOIN servicio ON moto.placa = servicio.placa\n" +
                "INNER JOIN detalle_ser ON servicio.cod_reg = detalle_ser.cod_reg\n" +
                "WHERE CONVERT(DATE, servicio.fecha) = CONVERT(DATE, GETDATE())" ;
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                resp = true;
                setCobro(rs.getDouble(1));
            } 
            ps.close();
            rs.close();
       }catch(Exception e){
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            JDialog_Errores err = new JDialog_Errores("Error cargando el total de los servicios", errors.toString());
            err.setVisible(true);
        } 
       return resp;
    }
     //CARGA EL BIG REPORT
     //REPORTE MODERNIZADO PARA NUEVA FORMA DE IMPRESION :D
    public boolean cargar_big_report(Connection con){
        boolean rpta = false;
        try {
            if(cliente(con)){
                //para agregar un parametro de entrada al reporte
                Map parametro = new HashMap();
                parametro.put("id", getId());//parametro de entrada con el que usca los datos
                //ADEMAS DEL PARAMETRO ID CON EL CUAL SE BUSCAN LOS DATOS, SE LE DAN ESTOS
                //PARAMETROS QUE SON LOS DEL CLIENTE
                parametro.put("placa", getPlaca());
                parametro.put("linea", getLinea());
                parametro.put("idc", getIdC());
                parametro.put("nombrec", getNombreC());
                parametro.put("apellidoc", getApellidoC());
                parametro.put("telc", getTelC());
                parametro.put("celc", getCelC());
                parametro.put("nit", getNit());
                parametro.put("razon_social", getRazon_social());
                parametro.put("tele", getTelE());
                //carga la plantilla
                JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile("Big_Report.jasper");          

                //este es el reporte ya con datos cargados desde la bd
                JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametro, con);
                //esta es para mostrar el reporte creado y alli se dan las opciones de impresion y demas
                JasperViewer.viewReport(jasperPrint, false);
                rpta = true;
            }else{
                JOptionPane.showMessageDialog(null, "Hubo un error cargando el cliente", "Cliente fail", JOptionPane.INFORMATION_MESSAGE );
            }
        } catch (Exception e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            JDialog_Errores err = new JDialog_Errores("Error cargando el reporte", errors.toString());
            err.setVisible(true);
        }
        return rpta;
    }
    //CARGA LOSD DATOS GENERALES DE X CLIENTE. USADO PARA CABEZA DE HOHA DE IMPRESION TIPO SUBCONSUTLA 
    boolean cliente(Connection con) {
        boolean resp = false;
        try{
            //verificamos que el cliente tenga o no alguna empresa.
            //si la tiene ejecuta el comando para que muestre los datos de esta
            //si no la tiene, ejecuta el comando que la exime
            if(hay_empresa(con) == true){
                /*si el cliente tiene empresa*/ 
                String sql= "SELECT moto.placa, moto.linea,\n" +
                "cliente.id, cliente.nombre, cliente.apellido1, cliente.tel1, cliente.cel1,\n" +
                "empresa.nit, empresa.razon_social, empresa.tel1\n" +
                "FROM empresa INNER JOIN cliente ON empresa.nit = cliente.nit\n" +
                "INNER JOIN moto ON cliente.id = moto.id\n" +
                "WHERE cliente.id = ?" ;
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setDouble(1, getId());
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    setPlaca(rs.getString(1));
                    setLinea(rs.getString(2));
                    setIdC(rs.getDouble(3));
                    setNombreC(rs.getString(4));
                    setApellidoC(rs.getString(5));
                    setTelC(rs.getDouble(6));
                    setCelC(rs.getDouble(7));
                    setNit(rs.getString(8));
                    setRazon_social(rs.getString(9));
                    setTelE(rs.getDouble(10));
                    resp = true;
                } 
                ps.close();
                rs.close();
            }else{
                String sql= "SELECT moto.placa, moto.linea,\n" +
                "cliente.id, cliente.nombre, cliente.apellido1, cliente.tel1, cliente.cel1\n" +
                "FROM cliente INNER JOIN moto ON cliente.id = moto.id\n" +
                "WHERE cliente.id = ?" ;
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setDouble(1, getId());
                ResultSet rs = ps.executeQuery();/*desde aca salta el error*/
                if(rs.next()){
                    setPlaca(rs.getString(1));
                    setLinea(rs.getString(2));
                    setIdC(rs.getDouble(3));
                    setNombreC(rs.getString(4));
                    setApellidoC(rs.getString(5));
                    setTelC(rs.getDouble(6));
                    setCelC(rs.getDouble(7));
                    resp = true;
                } 
                ps.close();
                rs.close();
            }
       }catch(Exception e){
            e.printStackTrace();
        /*   StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            JDialog_Errores err = new JDialog_Errores("Error cargando el cliente en el reporte", errors.toString());
            err.setVisible(true);*/
       } 
       return resp;
    }
    //cargar las impresioras?NO SE PASA LA CONEXION SINO EL MODELO DE LA TABLA
    public boolean cargar_servicio(Connection con,  List lista){
        boolean rpta = false;
        try {
            if(cliente(con)){
                Map parametro = new HashMap();
                parametro.put("placa", getPlaca());
                parametro.put("linea", getLinea());
                parametro.put("idc", getIdC());
                parametro.put("nombrec", getNombreC());
                parametro.put("apellidoc", getApellidoC());
                parametro.put("telc", getTelC());
                parametro.put("celc", getCelC());
                parametro.put("nit", getNit());
                parametro.put("razon_social", getRazon_social());
                parametro.put("tele", getTelE());
                parametro.put("total", getCobro());
                //carga las tablas en el jasper
                //JRTableModelDataSource tabledata = new JRTableModelDataSource(modelo);
                    //AUN NO CARGA EL JTABLE EN EL REPORTE... PORQUE? SI YA ESTA TODO BN.
                JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile("Reporte_Ser.jasper");          
                //este es el reporte ya con datos cargados desde la bd
                JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametro, new JRBeanCollectionDataSource(lista));
                //estas es para mostrar el reporte creado
                JasperViewer.viewReport(jasperPrint, false);
                rpta = true;
            }
        } catch (Exception e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            JDialog_Errores err = new JDialog_Errores("Error creando el reporte", errors.toString());
            err.setVisible(true);
        }
        return rpta;
    }

    boolean hay_empresa(Connection con){
        boolean resp = false;
        try{
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
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            JDialog_Errores err = new JDialog_Errores("Error creando el reporte", errors.toString());
            err.setVisible(true);
       } 
       return resp;
    }
    
}
