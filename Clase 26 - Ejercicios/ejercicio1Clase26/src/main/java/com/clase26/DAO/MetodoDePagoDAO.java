package com.clase26.DAO;

import java.util.List;

import com.clase26.Modelos.MetodoDePago;

public interface MetodoDePagoDAO {
    void agregarMetodoDePago(MetodoDePago metodo);
    void actualizarMetodoDePago(MetodoDePago metodo);
    void eliminarMetodoDePago(int id);
    MetodoDePago obtenerMetodoDePago(int id);
    List<MetodoDePago> obtenerTodosMetodosDePago();
}
