package com.example.dao;

import com.example.modelos.Tarea;

import java.sql.SQLException;
import java.util.List;

public interface TareaDAO {
    void agregarTarea(Tarea tarea) throws SQLException;
    List<Tarea> listarTareas() throws SQLException;
    Tarea obtenerTareaPorId(int id) throws SQLException;
    void actualizarTarea(Tarea tarea) throws SQLException;
    void eliminarTarea(int id) throws SQLException;
}
