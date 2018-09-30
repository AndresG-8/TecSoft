package Reports;

/**
 *
 * @author Gomez
 */
public class rep_servicio {
    private String codigo, nombre, tipo, descripcion, cobro;

    public rep_servicio(String codigo, String nombre, String tipo, String descripcion, String cobro) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.cobro = cobro;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCobro() {
        return cobro;
    }

    public void setCobro(String total) {
        this.cobro = total;
    }
    
}
