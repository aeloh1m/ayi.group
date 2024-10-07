public class EstadoFactura {
    private int idEstadoFactura;
    private String descripcion;

    // Constructor
    public EstadoFactura(int idEstadoFactura, String descripcion) {
        this.idEstadoFactura = idEstadoFactura;
        this.descripcion = descripcion;
    }

    public int getIdEstadoFactura() {
        return idEstadoFactura;
    }

    public void setIdEstadoFactura(int idEstadoFactura) {
        this.idEstadoFactura = idEstadoFactura;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
