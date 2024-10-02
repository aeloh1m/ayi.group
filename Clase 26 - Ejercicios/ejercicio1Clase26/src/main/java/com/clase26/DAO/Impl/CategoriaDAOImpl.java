package com.clase26.DAO.Impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.clase26.ConexionDB.ConexionDB;
import com.clase26.DAO.CategoriaDAO;
import com.clase26.Modelos.Categoria;

public class CategoriaDAOImpl implements CategoriaDAO {

    @Override
    public void agregarCategoria(Categoria categoria) {
        String query = "INSERT INTO categorias (descripcion) VALUES (?)";
        try (Connection connection = ConexionDB.getConnection();
                PreparedStatement ps = connection.prepareStatement(query)) {
            connection.setAutoCommit(false);
            ps.setString(1, categoria.getDescripcion());
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizarCategoria(Categoria categoria) {
        String query = "UPDATE categorias SET descripcion = ? WHERE id_categoria = ?";
        try (Connection connection = ConexionDB.getConnection();
                PreparedStatement ps = connection.prepareStatement(query)) {
            connection.setAutoCommit(false);
            ps.setString(1, categoria.getDescripcion());
            ps.setInt(2, categoria.getIdCategoria());
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarCategoria(int id) {
        String query = "DELETE FROM categorias WHERE id_categoria = ?";
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
    public Categoria obtenerCategoria(int id) {
        Categoria categoria = null;
        String query = "SELECT * FROM categorias WHERE id_categoria = ?";
        try (Connection connection = ConexionDB.getConnection();
                PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt("id_categoria"));
                categoria.setDescripcion(rs.getString("descripcion"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoria;
    }

    @Override
    public List<Categoria> obtenerTodasCategorias() {
        List<Categoria> categorias = new ArrayList<>();
        String query = "SELECT * FROM categorias";
        try (Connection connection = ConexionDB.getConnection();
                PreparedStatement ps = connection.prepareStatement(query);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt("id_categoria"));
                categoria.setDescripcion(rs.getString("descripcion"));
                categorias.add(categoria);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categorias;
    }
}
