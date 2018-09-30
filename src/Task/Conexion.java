/**
 * Esta clase sera la encargada de controlar todas las Conexiones y pasarlas a
 * las demas clases. Asi se usara una sola conexion para toda la aplicacion
 * TENER EN  CUENTA LA CLASE TAREAS_BD DEL PROYECTO PPI
 */

package Task;

import View.JDialog_Errores;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.*;
import java.util.List;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Gomez
 */
public class Conexion {
    //se declaran variables protegidas que seran utiles cuando se requiera usar los metodos
    //propios de la clase
    protected Statement st;
    protected ResultSet rs;
    protected Connection con;

    //se declara un constructor inicializando con null
    public Conexion() {
        con = null;
    }
    //Este metodo es el encargado de conectar la aplicacion con la base de datos
    public void conectar(){
        //String url = "jdbc:sqlserver://localhost:1433;databaseName=[NOMBRE_BD];user=[USUARIO];password=[CONTRASEÑA]";
        String url = "jdbc:sqlserver://;databaseName=dma;integratedSecurity=true;";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(url);
        } catch (SQLException | ClassNotFoundException e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            JDialog_Errores err = new JDialog_Errores("Error con el driver a nivel principal", errors.toString());
            err.setVisible(true);
        } 
    }
    
    public Statement getSt() {
        return st;
    }

    public void setSt(Statement st) {
        this.st = st;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    //ESTOS METODOS SON GENERALES!!
    //Con este metodo se cargan las grillas que existan en la aplicacion 
    public void cargar(String sql, DefaultTableModel modelo) {
        try {
            setSt(getCon().createStatement());
            setRs(getSt().executeQuery(sql));
            
            ResultSetMetaData metadatos = getRs().getMetaData();
            
            int num_col = metadatos.getColumnCount();
            
            modelo.setRowCount(0);
            //se ponen los titulos con los nombres de cada campo en la base de datos
            Object titulos[] = new Object[num_col];
            for(int i=0; i < num_col; i++){
                titulos[i] = metadatos.getColumnLabel(i + 1);
            }
            modelo.setColumnIdentifiers(titulos);
            //se llenan todos los campos obtenidos en la tabla
            while(getRs().next()){
                //selecciona fila por fila 
                Object fila[] = new Object[num_col];
                for(int i=0; i < num_col; i++){
                    fila[i] = getRs().getObject(i + 1);
                }
                modelo.addRow(fila);
            }
            getRs().close();
            
        } catch (Exception e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            JDialog_Errores err = new JDialog_Errores("Error cargando la tabla", errors.toString());
            err.setVisible(true);
        }
    }
    //carga al inicio de la aplicacion las citas del dia y los cambios de aceite programados
    public int cargar_alarma(String sql) {
       int rpta = 0;
        try {
            setSt(getCon().createStatement());
            setRs(getSt().executeQuery(sql));
            while(getRs().next()){
                rpta = rpta + 1;
            }
            getRs().close();
        } catch (Exception e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            JDialog_Errores err = new JDialog_Errores("Error cargando la alarma", errors.toString());
            err.setVisible(true);
        }
        return rpta;
    }
     //carga desde el dialog agenda las citas del dia y desde el dialog aceite los cambios programados 
    //para el dia actual 
    public boolean cargar_alarm_tabla(String sql, DefaultTableModel modelo) {
        boolean rpta = false;
         try {
            setSt(getCon().createStatement());
            setRs(getSt().executeQuery(sql));
            
            ResultSetMetaData metadatos = getRs().getMetaData();
            
            int num_col = metadatos.getColumnCount();
            
            modelo.setRowCount(0);
            //se ponen los titulos con los nombres de cada campo en la base de datos
            Object titulos[] = new Object[num_col];
            for(int i=0; i < num_col; i++){
                titulos[i] = metadatos.getColumnLabel(i + 1);
            }
            modelo.setColumnIdentifiers(titulos);
            //se llenan todos los campos obtenidos en la tabla
            while(getRs().next()){
                rpta = true;
                //selecciona fila por fila 
                Object fila[] = new Object[num_col];
                for(int i=0; i < num_col; i++){
                    fila[i] = getRs().getObject(i + 1);
                }
                modelo.addRow(fila);
            }
            getRs().close();
            
        } catch (Exception e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            JDialog_Errores err = new JDialog_Errores("Error cargando las citas del día", errors.toString());
            err.setVisible(true);
        }
       return rpta;
    }
    
    //METODO PARA GUARDAR LA IMAGEN EN EL DIRECTORIO
    public boolean salvar(imagenes img) {
        return img.salvar(con);
    }
     
    public boolean modificar(imagenes img) {
        return img.modificar(con);
    }
    
    public boolean recuperar(imagenes img) {
        return img.recuperar(con);
    }
    
    /**
     * Metodos encargados de manipular las tareas respectivas a cada objeto
     * @param cli
     * @return 
     */
    //Objeto cliente
    public boolean guardarCliente(cliente cli){
        return cli.guardar(con);
    }
    
    public boolean verificarCliente(cliente cli) {
        return cli.verificar(con);
    }
    //se lama desde cliente_general. busca los datos del cliente en base a la cedula
    public boolean cargar_datos(cliente cli){
        return cli.cargar_datos(con);
    }
    
    public boolean modificar_cliente(cliente cli){
        return cli.modificar(con);
    }
    
    public boolean eliminar_cliente(cliente cli){
        return cli.eliminar(con);
    }
    
    //Objeto empresa
    public boolean guardarEmpresa(empresa emp){
        return emp.guardar(con);
    }
    
    public boolean verificarEmpresa(empresa emp) {
        return emp.verificar(con);
    }
    //carga desde cliente_general para cargar datos de la empresa
    public boolean cargar_dts_e(empresa emp){
        return emp.cargar_datos(con);
    }
    
    public boolean modificar_empresa(empresa emp){
        return emp.modificar(con);
    }
    
    public boolean eliminar_empresa(empresa emp){
        return emp.eliminar(con);
    }
    //Objeto Moto
    public boolean guardarMoto(moto mot){
        return mot.guardar(con);
    }
    
    public boolean verificarMoto(moto mot) {
        return mot.verificar(con);
    }
    //carga desde cliente_general para buscar los datos de la moto
    public boolean cargar_dts_m(moto mot){
        return mot.cargar_datos(con);
    }
    
    public boolean modificar_moto(moto mot){
        return mot.modificar(con);
    }
    
    public boolean eliminar_moto(moto mot){
        return mot.eliminar(con);
    }
    
    
   //Objeto busqueda de cliente-id
    public boolean hay_empresa(bus_cli bc) {
        return bc.hay_empresa(con);
    }
    //Objeto busqueda de cliente-nombre
    public boolean hay_empresa_nombre(bus_cli bc) {
        return bc.hay_empresa_nombre(con);
    }
    //Objeto busqueda moto-placa
    public boolean hay_empresa_moto(bus_cli bc) {
        return bc.hay_empresa_moto(con);
    }
    //Objeto busqueda empresa-nit
    public boolean hay_empresa_emp(bus_cli bc) {
        return bc.hay_empresa_emp(con);
    }
     //Objeto busqueda empresa-razon_social
    public boolean hay_empresa_rz(bus_cli bc) {
        return bc.hay_empresa_rz(con);
    }
    
     //Objeto Lista_ser
    public boolean guardar_ser(lista_servicio ls){
        return ls.guardar(con);
    }
    
    public boolean verificar_ser(lista_servicio ls) {
        return ls.verificar(con);
    }
    
    public boolean modificar_lista_ser(lista_servicio ls){
        return ls.modificar(con);
    }
    
    public boolean eliminar_lista_ser(lista_servicio ls){
        return ls.eliminar(con);
    }
    
    //Objeto servicio
    public boolean guardar_servicio(servicio ser){
        return ser.guardar(con);
    }
    
    public int ultimo_registro(servicio ser){
        return ser.ultimo_registro(con);
        //la llamada al metodo me deveria devolver un entero... 
    }
    
    public boolean eliminar_servicio(servicio ser){
        return ser.eliminar(con);
    }
    
//    public boolean verificar_servicio(servicio ser) {
//        return ser.verificar(con);
//    }
    
    //Objeto detalle_servicio
    public boolean guardar_det_ser(detalle_servicio det){
        return det.guardar(con);
    }
    
    //Objeto premiacion
    public boolean hay_premio(premiacion pre){
        return pre.procedimiento(con);
    }
    
    //objeto fidelizacion
    public boolean hay_fid(fidelizacion fid){
        return fid.procedimiento(con);
    }
    
    //Objeto de servicio_temporal
    public boolean guardar_ser_tem(servicio_temp temp){
        return temp.guardar(con);
    }
    
    public boolean eliminar_ser_tem(servicio_temp temp){
        return temp.eliminarServicio_temp(con);
    }
    
    //Objeto Agenda
    public boolean guardar_cita(agenda cita){
        return cita.guardar(con);
    }
    
    public boolean modificar_agenda(agenda cita){
        return cita.modificar(con);
    }
    
    public boolean eliminar_agenda(agenda cita){
        return cita.eliminar(con);
    }
    
    //Ojeto imagenes
//    public int cant_imagenes(imagenes img){
//        return img.cant_imagenes(con);
//    }
    
    public boolean modificar_imagen(imagenes img){
        return img.modificar(con);
    }
    
    //Objeto reportes
    //CARGA EL REPORTE DE SERVICIOS
    public boolean cargar_reporte(Reportes rep){
        return rep.cargar(con);
    }
    //CARGA EL REPORTE DE DETALLE SERVICIOS
    public boolean cargar_param(Reportes rep){
        return rep.cargar_param(con);
    }
    //CARGA EL REPORTE DE SERVICIOS DIARIOS
    public boolean cargar_dia(Reportes rep){
        return rep.cargar_dia(con);
    }
   //CARGA EL REPORTE DE TODOS LOS CLIENTES
    public boolean cargar_clientes(Reportes rep){
        return rep.cargar_clientes(con);
    }
    //CARGA EL BIG REPORT
    public boolean cargar_big_report(Reportes rep){
        return rep.cargar_big_report(con);
    }
    //reporte usados desde la aplicacion, reemplaza los imprimir
    //POR AHORA VEO QUE SOLO LO USA JFRAME_SERVICIO
    public boolean cargar_servicio(Reportes rep, List lista){
        return rep.cargar_servicio(con, lista);
    }
    
    //OBJETO ACEITE
    public boolean guardar_aceite(aceite oil){
        return oil.guardar(con);
    }
    //MODIFICA ACEITE
    public boolean modificar_aceite(aceite oil){
        return oil.modificar(con);
    }
    // ELIMINA EL ACEITE SELECCIONADO :D  
    public boolean eliminar_aceite(aceite oil){
        return oil.eliminar(con);
    }
    
}
