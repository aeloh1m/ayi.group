package com.clase26.DAO;

import java.util.List;

import com.clase26.Modelos.DetalleDeVenta;

public interface DetalleDeVentaDAO {
    void agregarDetalleDeVenta(DetalleDeVenta detalle);
    void actualizarDetalleDeVenta(DetalleDeVenta detalle);
    void eliminarDetalleDeVenta(int id);
    DetalleDeVenta obtenerDetalleDeVenta(int id);
    List<DetalleDeVenta> obtenerTodosDetallesDeVenta();
}

