public class Factura {
    private int idFactura;
    private int tipoFacturaId;
    private int socioId;
    private Date fechaEmision;
    private double montoTotal;
    private int estadoFacturaId;

    // Constructor
    public Factura(int idFactura, int tipoFacturaId, int socioId, Date fechaEmision, double montoTotal, int estadoFacturaId) {
        this.idFactura = idFactura;
        this.tipoFacturaId = tipoFacturaId;
        this.socioId = socioId;
        this.fechaEmision = fechaEmision;
        this.montoTotal = montoTotal;
        this.estadoFacturaId = estadoFacturaId;
    }

    // Getters y Setters
    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public int getTipoFacturaId() {
        return tipoFacturaId;
    }

    public void setTipoFacturaId(int tipoFacturaId) {
        this.tipoFacturaId = tipoFacturaId;
    }

    public int getSocioId() {
        return socioId;
    }

    public void setSocioId(int socioId) {
        this.socioId = socioId;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public int getEstadoFacturaId() {
        return estadoFacturaId;
    }

    public void setEstadoFacturaId(int estadoFacturaId) {
        this.estadoFacturaId = estadoFacturaId;
    }
}
