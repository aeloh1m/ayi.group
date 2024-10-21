package com.Ejercicio1_Clase29.DAO.Impl;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.Ejercicio1_Clase29.ConexionDB.ConexionDB;
import com.Ejercicio1_Clase29.DAO.ProvinciaDAO;
import com.Ejercicio1_Clase29.Modelos.Provincia;


public class ProvinciaDAOImpl implements ProvinciaDAO {

    @Override
    public void create(Provincia provincia) {
        String query = "INSERT INTO provincias (codigo, descripcion) VALUES (?, ?)";
        try (Connection connection = ConexionDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, provincia.getCodigo());
            ps.setString(2, provincia.getDescripcion());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Provincia provincia) {
        String query = "UPDATE provincias SET descripcion = ? WHERE codigo = ?";
        try (Connection connection = ConexionDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, provincia.getDescripcion());
            ps.setInt(2, provincia.getCodigo());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int codigo) {
        String query = "DELETE FROM provincias WHERE codigo = ?";
        try (Connection connection = ConexionDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, codigo);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Provincia obtener(int codigo) {
        Provincia provincia = null;
        String query = "SELECT * FROM provincias WHERE codigo = ?";
        try (Connection connection = ConexionDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                provincia = new Provincia();
                provincia.setCodigo(rs.getInt("codigo"));
                provincia.setDescripcion(rs.getString("descripcion"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return provincia;
    }

    @Override
    public List<Provincia> obtenerTodos() {
        List<Provincia> provincias = new ArrayList<>();
        String query = "SELECT * FROM provincias";
        try (Connection connection = ConexionDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Provincia provincia = new Provincia();
                provincia.setCodigo(rs.getInt("codigo"));
                provincia.setDescripcion(rs.getString("descripcion"));
                provincias.add(provincia);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return provincias;
    }}
