package com.example.dao;

import com.example.modelos.Empleado;

import java.sql.SQLException;
import java.util.List;

public interface EmpleadoDAO {
    void agregarEmpleado(Empleado empleado) throws SQLException;
    List<Empleado> listarEmpleados() throws SQLException;
    Empleado obtenerEmpleadoPorId(int id) throws SQLException;
    void actualizarEmpleado(Empleado empleado) throws SQLException;
    void eliminarEmpleado(int id) throws SQLException;
}
