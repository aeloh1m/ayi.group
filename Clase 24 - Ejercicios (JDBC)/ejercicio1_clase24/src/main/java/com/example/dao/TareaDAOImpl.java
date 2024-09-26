package com.example.dao;

import com.example.modelos.Tarea;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TareaDAOImpl implements TareaDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/ejercicio1_clase24";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";

    @Override
    public void agregarTarea(Tarea tarea) throws SQLException {
        String query = "INSERT INTO tareas (id_tarea, estado_tarea, descripcion) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, tarea.getIdTarea());
            pstmt.setBoolean(2, tarea.isEstadoTarea());
            pstmt.setString(3, tarea.getDescripcion());
            pstmt.executeUpdate();
        }
    }

    @Override
    public List<Tarea> listarTareas() throws SQLException {
        List<Tarea> tareas = new ArrayList<>();
        String query = "SELECT * FROM tareas";
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rset = stmt.executeQuery(query)) {
             
            while (rset.next()) {
                int id = rset.getInt("id_tarea");
                boolean estado = rset.getBoolean("estado_tarea");
                String descripcion = rset.getString("descripcion");
                tareas.add(new Tarea(id, estado, descripcion));
            }
        }
        return tareas;
    }

    @Override
    public Tarea obtenerTareaPorId(int id) throws SQLException {
        String query = "SELECT * FROM tareas WHERE id_tarea = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            try (ResultSet rset = pstmt.executeQuery()) {
                if (rset.next()) {
                    boolean estado = rset.getBoolean("estado_tarea");
                    String descripcion = rset.getString("descripcion");
                    return new Tarea(id, estado, descripcion);
                }
            }
        }
        return null; // Return null if not found
    }

    @Override
    public void actualizarTarea(Tarea tarea) throws SQLException {
        String query = "UPDATE tareas SET estado_tarea = ?, descripcion = ? WHERE id_tarea = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setBoolean(1, tarea.isEstadoTarea());
            pstmt.setString(2, tarea.getDescripcion());
            pstmt.setInt(3, tarea.getIdTarea());
            pstmt.executeUpdate();
        }
    }

    @Override
    public void eliminarTarea(int id) throws SQLException {
        String query = "DELETE FROM tareas WHERE id_tarea = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }
}
