package com.clase25.dao;

import com.clase25.modelos.Participante;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ParticipanteDAOImpl implements ParticipanteDAO {
    private final String URL = "jdbc:mysql://localhost:3306/ejercicio_clase25";
    private final String USER = "root"; 
    private final String PASSWORD = "admin";

    @Override
    public void insertarParticipante(Participante participante) {
        String query = "INSERT INTO participantes (nombre, email, telefono, id_inscripcion) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, participante.getNombre());
            pstmt.setString(2, participante.getEmail());
            pstmt.setString(3, participante.getTelefono());
            pstmt.setObject(4, participante.getIdInscripcion(), Types.INTEGER);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Participante> consultarParticipantes() {
        List<Participante> participantes = new ArrayList<>();
        String query = "SELECT * FROM participantes";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Participante participante = new Participante();
                participante.setId(rs.getInt("id_participante"));
                participante.setNombre(rs.getString("nombre"));
                participante.setEmail(rs.getString("email"));
                participante.setTelefono(rs.getString("telefono"));
                participante.setIdInscripcion(rs.getObject("id_inscripcion", Integer.class));
                participantes.add(participante);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return participantes;
    }

    @Override
    public void eliminarParticipantes() {
        String query = "DELETE FROM participantes";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
