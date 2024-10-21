package com.Ejercicio1_Clase29.DAO.Impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.Ejercicio1_Clase29.ConexionDB.ConexionDB;
import com.Ejercicio1_Clase29.DAO.ConferenciaDAO;
import com.Ejercicio1_Clase29.Modelos.Conferencia;

public class ConferenciaDAOImpl implements ConferenciaDAO {

    @Override
    public void create(Conferencia conferencia) {
        String query = "INSERT INTO conferencias (expositora, tematica, fecha_hora, duracion) VALUES (?, ?, ?, ?)";
        try (Connection connection = ConexionDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, conferencia.getExpositora());
            ps.setString(2, conferencia.getTematica());
            ps.setTimestamp(3, Timestamp.valueOf(conferencia.getFechaHora()));
            ps.setInt(4, conferencia.getDuracion());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Conferencia conferencia) {
        String query = "UPDATE conferencias SET expositora = ?, tematica = ?, fecha_hora = ?, duracion = ? WHERE id = ?";
        try (Connection connection = ConexionDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, conferencia.getExpositoraId());
            ps.setString(2, conferencia.getTematica());
            ps.setTimestamp(3, Timestamp.valueOf(conferencia.getFechaHora().atZone(java.time.ZoneId.systemDefault()).toLocalDateTime()));
            ps.setInt(4, conferencia.getDuracion());
            ps.setInt(5, conferencia.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }    @Override
    public void delete(int id) {
        String query = "DELETE FROM conferencias WHERE id = ?";
        try (Connection connection = ConexionDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Conferencia obtener(int id) {
        Conferencia conferencia = null;
        String query = "SELECT * FROM conferencias WHERE id = ?";
        try (Connection connection = ConexionDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                conferencia = new Conferencia();
                conferencia.setId(rs.getInt("id"));
                conferencia.setExpositoraId(rs.getInt("expositora"));
                conferencia.setTematica(rs.getString("tematica"));
                conferencia.setFechaHora(rs.getTimestamp("fecha_hora").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
                conferencia.setDuracion(rs.getInt("duracion"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conferencia;
    }
    @Override
    public List<Conferencia> obtenerTodas() {
        List<Conferencia> conferencias = new ArrayList<>();
        String query = "SELECT * FROM conferencias";
        try (Connection connection = ConexionDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Conferencia conferencia = new Conferencia();
                conferencia.setId(rs.getInt("id"));
                conferencia.setExpositora(rs.getInt("expositora"));
                conferencia.setTematica(rs.getString("tematica"));
                conferencia.setFechaHora(rs.getTimestamp("fecha_hora").toLocalDateTime());
                conferencia.setDuracion(rs.getInt("duracion"));
                conferencias.add(conferencia);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conferencias;
    }
}
