package com.clase26.Modelos;

public class MetodoDePago {
    private int idMetodoDePago;
    private String descripcion;

    // Getters y Setters
    public int getIdMetodoDePago() {
        return idMetodoDePago;
    }

    public void setIdMetodoDePago(int idMetodoDePago) {
        this.idMetodoDePago = idMetodoDePago;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "MetodoDePago{" +
                "idMetodoDePago=" + idMetodoDePago +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
