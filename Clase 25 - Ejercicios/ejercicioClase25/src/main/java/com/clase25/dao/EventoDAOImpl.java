package com.clase25.dao;
import com.clase25.modelos.Evento;
import com.clase25.modelos.EventoParticipante;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EventoDAOImpl implements EventoDAO {
    private final String URL = "jdbc:mysql://localhost:3306/ejercicio_clase25";
    private final String USER = "root"; 
    private final String PASSWORD = "admin"; 

    @Override
    public void insertarEvento(Evento evento) {
        String query = "INSERT INTO eventos (nombre_evento, fecha, lugar) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, evento.getNombre());
            pstmt.setTimestamp(2, Timestamp.valueOf(evento.getFecha()));
            pstmt.setString(3, evento.getLugar());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Evento> consultarEventos() {
        List<Evento> eventos = new ArrayList<>();
        String query = "SELECT * FROM eventos";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Evento evento = new Evento();
                evento.setId(rs.getInt("id_eventos"));
                evento.setNombre(rs.getString("nombre_evento"));
                evento.setFecha(rs.getTimestamp("fecha").toLocalDateTime());
                evento.setLugar(rs.getString("lugar"));
                eventos.add(evento);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eventos;
    }

    @Override
    public void eliminarEventos() {
        String query = "DELETE FROM eventos";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<EventoParticipante> consultarEventosParticipantes() {
    List<EventoParticipante> lista = new ArrayList<>();
    String query = "SELECT e.nombre_evento, p.nombre FROM eventos e " +
                   "JOIN eventos_inscripciones ei ON e.id_eventos = ei.id_evento " +
                   "JOIN inscripciones i ON ei.id_inscripto = i.id_inscripcion " +
                   "JOIN participantes p ON i.id_inscripcion = p.id_inscripcion";
    
    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {
        while (rs.next()) {
            EventoParticipante ep = new EventoParticipante();
            ep.setNombreEvento(rs.getString("nombre_evento"));
            ep.setNombreParticipante(rs.getString("nombre"));
            lista.add(ep);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return lista;
}

}

