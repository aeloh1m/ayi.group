package com.example.dao;

import com.example.modelos.Empleado;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAOImpl implements EmpleadoDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/ejercicio1_clase24";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";

    @Override
    public void agregarEmpleado(Empleado empleado) throws SQLException {
        String query = "INSERT INTO empleados (id_empleado, nombre_empleado, id_tarea) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, empleado.getIdEmpleado());
            pstmt.setString(2, empleado.getNombreEmpleado());
            pstmt.setObject(3, empleado.getIdTarea()); // Use setObject for nullable fields
            pstmt.executeUpdate();
        }
    }

    @Override
    public List<Empleado> listarEmpleados() throws SQLException {
        List<Empleado> empleados = new ArrayList<>();
        String query = "SELECT * FROM empleados";
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rset = stmt.executeQuery(query)) {
             
            while (rset.next()) {
                int id = rset.getInt("id_empleado");
                String nombre = rset.getString("nombre_empleado");
                Integer idTarea = rset.getObject("id_tarea") != null ? rset.getInt("id_tarea") : null;
                empleados.add(new Empleado(id, nombre, idTarea));
            }
        }
        return empleados;
    }

    @Override
    public Empleado obtenerEmpleadoPorId(int id) throws SQLException {
        String query = "SELECT * FROM empleados WHERE id_empleado = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            try (ResultSet rset = pstmt.executeQuery()) {
                if (rset.next()) {
                    String nombre = rset.getString("nombre_empleado");
                    Integer idTarea = rset.getObject("id_tarea") != null ? rset.getInt("id_tarea") : null;
                    return new Empleado(id, nombre, idTarea);
                }
            }
        }
        return null; // Return null if not found
    }

    @Override
    public void actualizarEmpleado(Empleado empleado) throws SQLException {
        String query = "UPDATE empleados SET nombre_empleado = ?, id_tarea = ? WHERE id_empleado = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, empleado.getNombreEmpleado());
            pstmt.setObject(2, empleado.getIdTarea());
            pstmt.setInt(3, empleado.getIdEmpleado());
            pstmt.executeUpdate();
        }
    }

    @Override
    public void eliminarEmpleado(int id) throws SQLException {
        String query = "DELETE FROM empleados WHERE id_empleado = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }
}
