package com.clase25.dao;

import com.clase25.modelos.Organizador;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrganizadorDAOImpl implements OrganizadorDAO {
    private final String URL = "jdbc:mysql://localhost:3306/ejercicio_clase25";
    private final String USER = "root"; 
    private final String PASSWORD = "admin";

    @Override
    public void insertarOrganizador(Organizador organizador) {
        String query = "INSERT INTO organizadores (nombre, contacto, desc_organizacion, id_evento) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, organizador.getNombre());
            pstmt.setString(2, organizador.getContacto());
            pstmt.setString(3, organizador.getDescOrganizacion());
            pstmt.setObject(4, organizador.getIdEvento(), Types.INTEGER);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Organizador> consultarOrganizadores() {
        List<Organizador> organizadores = new ArrayList<>();
        String query = "SELECT * FROM organizadores";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Organizador organizador = new Organizador();
                organizador.setId(rs.getInt("id_organizador"));
                organizador.setNombre(rs.getString("nombre"));
                organizador.setContacto(rs.getString("contacto"));
                organizador.setDescOrganizacion(rs.getString("desc_organizacion"));
                organizador.setIdEvento(rs.getObject("id_evento", Integer.class));
                organizadores.add(organizador);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return organizadores;
    }

    @Override
    public void eliminarOrganizadores() {
        String query = "DELETE FROM organizadores";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

