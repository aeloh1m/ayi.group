package com.clase26.Modelos;

public class DetalleDeVenta {
    private int idDetalleDeVenta;
    private int idProducto;
    private int idVenta;
    private int cantVendida;
    private double precioDeVenta;

    // Getters y Setters
    public int getIdDetalleDeVenta() {
        return idDetalleDeVenta;
    }

    public void setIdDetalleDeVenta(int idDetalleDeVenta) {
        this.idDetalleDeVenta = idDetalleDeVenta;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getCantVendida() {
        return cantVendida;
    }

    public void setCantVendida(int cantVendida) {
        this.cantVendida = cantVendida;
    }

    public double getPrecioDeVenta() {
        return precioDeVenta;
    }

    public void setPrecioDeVenta(double precioDeVenta) {
        this.precioDeVenta = precioDeVenta;
    }

    @Override
    public String toString() {
        return "DetalleDeVenta{" +
                "idDetalleDeVenta=" + idDetalleDeVenta +
                ", idProducto=" + idProducto +
                ", idVenta=" + idVenta +
                ", cantVendida=" + cantVendida +
                ", precioDeVenta=" + precioDeVenta +
                '}';
    }
}
