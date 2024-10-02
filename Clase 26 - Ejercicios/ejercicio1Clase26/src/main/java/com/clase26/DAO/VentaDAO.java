package com.clase26.DAO;

import java.util.List;

import com.clase26.Modelos.Venta;

public interface VentaDAO {
    void agregarVenta(Venta venta);
    void actualizarVenta(Venta venta);
    void eliminarVenta(int id);
    Venta obtenerVenta(int id);
    List<Venta> obtenerTodasVentas();
}
