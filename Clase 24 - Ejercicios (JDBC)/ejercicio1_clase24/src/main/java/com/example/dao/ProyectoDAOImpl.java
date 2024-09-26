package com.example.dao;

import com.example.modelos.Proyecto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProyectoDAOImpl implements ProyectoDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/ejercicio1_clase24";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";

    @Override
    public void agregarProyecto(Proyecto proyecto) throws SQLException {
        String query = "INSERT INTO proyectos (id_proyecto, nombre_proyecto, fecha_inicio) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, proyecto.getIdProyecto());
            pstmt.setString(2, proyecto.getNombreProyecto());
            pstmt.setTimestamp(3, new Timestamp(proyecto.getFechaInicio().getTime()));
            pstmt.executeUpdate();
        }
    }

    @Override
    public List<Proyecto> listarProyectos() throws SQLException {
        List<Proyecto> proyectos = new ArrayList<>();
        String query = "SELECT * FROM proyectos";
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rset = stmt.executeQuery(query)) {
             
            while (rset.next()) {
                int id = rset.getInt("id_proyecto");
                String nombre = rset.getString("nombre_proyecto");
                Timestamp fechaInicio = rset.getTimestamp("fecha_inicio");
                proyectos.add(new Proyecto(id, nombre, fechaInicio));
            }
        }
        return proyectos;
    }

    @Override
    public Proyecto obtenerProyectoPorId(int id) throws SQLException {
        String query = "SELECT * FROM proyectos WHERE id_proyecto = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            try (ResultSet rset = pstmt.executeQuery()) {
                if (rset.next()) {
                    String nombre = rset.getString("nombre_proyecto");
                    Timestamp fechaInicio = rset.getTimestamp("fecha_inicio");
                    return new Proyecto(id, nombre, fechaInicio);
                }
            }
        }
        return null; // Return null if not found
    }
    @Override
    public void actualizarProyecto(Proyecto proyecto) throws SQLException {
        String query = "UPDATE proyectos SET nombre_proyecto = ?, fecha_inicio = ? WHERE id_proyecto = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, proyecto.getNombreProyecto());
            pstmt.setTimestamp(2, new Timestamp(proyecto.getFechaInicio().getTime()));
            pstmt.setInt(3, proyecto.getIdProyecto());
            pstmt.executeUpdate();
        }
    }

    @Override
    public void eliminarProyecto(int id) throws SQLException {
        String query = "DELETE FROM proyectos WHERE id_proyecto = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }
}
