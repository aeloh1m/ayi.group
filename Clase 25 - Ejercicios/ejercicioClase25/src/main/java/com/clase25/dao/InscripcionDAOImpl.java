package com.clase25.dao;

import com.clase25.modelos.Inscripcion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InscripcionDAOImpl implements InscripcionDAO {
    private final String URL = "jdbc:mysql://localhost:3306/ejercicio_clase25";
    private final String USER = "root"; 
    private final String PASSWORD = "admin"; 

    @Override
    public void insertarInscripcion(Inscripcion inscripcion) {
        String query = "INSERT INTO inscripciones (inscripcionescol, fecha_inscripcion) VALUES (?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, inscripcion.getEstadoInscripcion());
            pstmt.setTimestamp(2, Timestamp.valueOf(inscripcion.getFechaInscripcion()));
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Inscripcion> consultarInscripciones() {
        List<Inscripcion> inscripciones = new ArrayList<>();
        String query = "SELECT * FROM inscripciones";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Inscripcion inscripcion = new Inscripcion();
                inscripcion.setId(rs.getInt("id_inscripcion"));
                inscripcion.setEstadoInscripcion(rs.getString("inscripcionescol"));
                inscripcion.setFechaInscripcion(rs.getTimestamp("fecha_inscripcion").toLocalDateTime());
                inscripciones.add(inscripcion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inscripciones;
    }

    @Override
    public void eliminarInscripciones() {
        String query = "DELETE FROM inscripciones";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
