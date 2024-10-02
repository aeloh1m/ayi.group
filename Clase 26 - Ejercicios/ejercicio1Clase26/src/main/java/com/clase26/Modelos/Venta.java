package com.clase26.Modelos;

import java.sql.Timestamp;

public class Venta {
    private int idVentas;
    private int clienteId;
    private Timestamp fechaDeVenta; // Usando Timestamp para manejar la fecha y hora
    private double total;
    private int metodoDePagoId;

    // Constructor
    public Venta() {
    }

    // Getters y Setters
    public int getIdVentas() {
        return idVentas;
    }

    public void setIdVentas(int idVentas) {
        this.idVentas = idVentas;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public Timestamp getFechaDeVenta() {
        return fechaDeVenta;
    }

    // Método para establecer la fecha de venta
    public void setFechaDeVenta(Timestamp fechaDeVenta) {
        this.fechaDeVenta = fechaDeVenta;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getMetodoDePagoId() {
        return metodoDePagoId;
    }

    // Método para establecer el método de pago
    public void setMetodoDePagoId(int metodoDePagoId) {
        this.metodoDePagoId = metodoDePagoId;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "idVentas=" + idVentas +
                ", clienteId=" + clienteId +
                ", fechaDeVenta=" + fechaDeVenta +
                ", total=" + total +
                ", metodoDePagoId=" + metodoDePagoId +
                '}';
    }
}
