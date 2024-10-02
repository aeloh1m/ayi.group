package com.clase26.DAO;

import java.util.List;

import com.clase26.Modelos.Proveedor;

public interface ProveedorDAO {
    void agregarProveedor(Proveedor proveedor);
    void actualizarProveedor(Proveedor proveedor);
    void eliminarProveedor(int id);
    Proveedor obtenerProveedor(int id);
    List<Proveedor> obtenerTodosProveedores();
}
