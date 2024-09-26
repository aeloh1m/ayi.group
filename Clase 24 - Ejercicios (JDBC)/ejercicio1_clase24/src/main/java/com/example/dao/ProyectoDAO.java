package com.example.dao;

import com.example.modelos.Proyecto;

import java.sql.SQLException;
import java.util.List;

public interface ProyectoDAO {
    void agregarProyecto(Proyecto proyecto) throws SQLException;
    List<Proyecto> listarProyectos() throws SQLException;
    Proyecto obtenerProyectoPorId(int id) throws SQLException;
    void actualizarProyecto(Proyecto proyecto) throws SQLException;
    void eliminarProyecto(int id) throws SQLException;
}
