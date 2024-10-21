package com.Ejercicio1_Clase29.DAO.Impl;

import com.Ejercicio1_Clase29.DAO.PersonaDAO;
import com.Ejercicio1_Clase29.Modelos.Persona;
import com.Ejercicio1_Clase29.ConexionDB.ConexionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class PersonaDAOImpl implements PersonaDAO {

    @Override
    public void agregarPersona(Persona persona) {
        String query = "INSERT INTO personas (numero_documento, nombre, apellido, ciudad_reside, provincia_reside) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = ConexionDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, persona.getNumeroDocumento());
            ps.setString(2, persona.getNombre());
            ps.setString(3, persona.getApellido());
            ps.setInt(4, persona.getCiudadReside());
            ps.setInt(5, persona.getProvinciaReside());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizarPersona(Persona persona) {
        String query = "UPDATE personas SET nombre = ?, apellido = ?, ciudad_reside = ?, provincia_reside = ? WHERE numero_documento = ?";
        try (Connection connection = ConexionDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, persona.getNombre());
            ps.setString(2, persona.getApellido());
            ps.setInt(3, persona.getCiudadReside());
            ps.setInt(4, persona.getProvinciaReside());
            ps.setInt(5, persona.getNumeroDocumento());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarPersona(int numeroDocumento) {
        String query = "DELETE FROM personas WHERE numero_documento = ?";
        try (Connection connection = ConexionDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, numeroDocumento);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Persona obtenerPersona(int numeroDocumento) {
        Persona persona = null;
        String query = "SELECT * FROM personas WHERE numero_documento = ?";
        try (Connection connection = ConexionDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, numeroDocumento);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                persona = new Persona();
                persona.setNumeroDocumento(rs.getInt("numero_documento"));
                persona.setNombre(rs.getString("nombre"));
                persona.setApellido(rs.getString("apellido"));
                persona.setCiudadReside(rs.getInt("ciudad_reside"));
                persona.setProvinciaReside(rs.getInt("provincia_reside"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return persona;
    }

    @Override
    public List<Persona> obtenerTodasPersonas() {
        List<Persona> personas = new ArrayList<>();
        String query = "SELECT * FROM personas";
        try (Connection connection = ConexionDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Persona persona = new Persona();
                persona.setNumeroDocumento(rs.getInt("numero_documento"));
                persona.setNombre(rs.getString("nombre"));
                persona.setApellido(rs.getString("apellido"));
                persona.setCiudadReside(rs.getInt("ciudad_reside"));
                persona.setProvinciaReside(rs.getInt("provincia_reside"));
                personas.add(persona);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personas;
    }
}