package com.clase26.DAO.Impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.clase26.ConexionDB.ConexionDB;
import com.clase26.DAO.MetodoDePagoDAO;
import com.clase26.Modelos.MetodoDePago;

public class MetodoDePagoDAOImpl implements MetodoDePagoDAO {

    @Override
    public void agregarMetodoDePago(MetodoDePago metodo) {
        String query = "INSERT INTO metodos_de_pagos (descripcion) VALUES (?)";
        try (Connection connection = ConexionDB.getConnection();
                PreparedStatement ps = connection.prepareStatement(query)) {
            connection.setAutoCommit(false);
            ps.setString(1, metodo.getDescripcion());
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizarMetodoDePago(MetodoDePago metodo) {
        String query = "UPDATE metodos_de_pagos SET descripcion = ? WHERE id_metodos_de_pago = ?";
        try (Connection connection = ConexionDB.getConnection();
                PreparedStatement ps = connection.prepareStatement(query)) {
            connection.setAutoCommit(false);
            ps.setString(1, metodo.getDescripcion());
            ps.setInt(2, metodo.getIdMetodoDePago());
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarMetodoDePago(int id) {
        String query = "DELETE FROM metodos_de_pagos WHERE id_metodos_de_pago = ?";
        try (Connection connection = ConexionDB.getConnection();
                PreparedStatement ps = connection.prepareStatement(query)) {
            connection.setAutoCommit(false);
            ps.setInt(1, id);
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public MetodoDePago obtenerMetodoDePago(int id) {
        MetodoDePago metodo = null;
        String query = "SELECT * FROM metodos_de_pagos WHERE id_metodos_de_pago = ?";
        try (Connection connection = ConexionDB.getConnection();
                PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                metodo = new MetodoDePago();
                metodo.setIdMetodoDePago(rs.getInt("id_metodos_de_pago"));
                metodo.setDescripcion(rs.getString("descripcion"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return metodo;
    }

    @Override
    public List<MetodoDePago> obtenerTodosMetodosDePago() {
        List<MetodoDePago> metodos = new ArrayList<>();
        String query = "SELECT * FROM metodos_de_pagos";
        try (Connection connection = ConexionDB.getConnection();
                PreparedStatement ps = connection.prepareStatement(query);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                MetodoDePago metodo = new MetodoDePago();
                metodo.setIdMetodoDePago(rs.getInt("id_metodos_de_pago"));
                metodo.setDescripcion(rs.getString("descripcion"));
                metodos.add(metodo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return metodos;
    }
}
