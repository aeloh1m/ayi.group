public class TipoFactura {
    private int idTipoFactura;
    private String descripcion;

    // Constructor
    public TipoFactura(int idTipoFactura, String descripcion) {
        this.idTipoFactura = idTipoFactura;
        this.descripcion = descripcion;
    }

    // Getters y Setters
    public int getIdTipoFactura() {
        return idTipoFactura;
    }

    public void setIdTipoFactura(int idTipoFactura) {
        this.idTipoFactura = idTipoFactura;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
