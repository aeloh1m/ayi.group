package com.clase26.DAO.Impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.clase26.ConexionDB.ConexionDB;
import com.clase26.DAO.ClienteDAO;
import com.clase26.Modelos.Cliente;

public class ClienteDAOImpl implements ClienteDAO {

    @Override
    public void agregarCliente(Cliente cliente) {
        String query = "INSERT INTO clientes (nombre, apellido, email, telefono, fecha_de_registro) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = ConexionDB.getConnection();
                PreparedStatement ps = connection.prepareStatement(query)) {
            connection.setAutoCommit(false);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setString(3, cliente.getEmail());
            ps.setString(4, cliente.getTelefono());
            ps.setString(5, cliente.getFechaDeRegistro());
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizarCliente(Cliente cliente) {
        String query = "UPDATE clientes SET nombre = ?, apellido = ?, email = ?, telefono = ? WHERE id_clientes = ?";
        try (Connection connection = ConexionDB.getConnection();
                PreparedStatement ps = connection.prepareStatement(query)) {
            connection.setAutoCommit(false);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setString(3, cliente.getEmail());
            ps.setString(4, cliente.getTelefono());
            ps.setInt(5, cliente.getIdCliente());
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarCliente(int id) {
        String query = "DELETE FROM clientes WHERE id_clientes = ?";
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
    public Cliente obtenerCliente(int id) {
        Cliente cliente = null;
        String query = "SELECT * FROM clientes WHERE id_clientes = ?";
        try (Connection connection = ConexionDB.getConnection();
                PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("id_clientes"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setFechaDeRegistro(rs.getString("fecha_de_registro"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cliente;
    }

    @Override
    public List<Cliente> obtenerTodosClientes() {
        List<Cliente> clientes = new ArrayList<>();
        String query = "SELECT * FROM clientes";
        try (Connection connection = ConexionDB.getConnection();
                PreparedStatement ps = connection.prepareStatement(query);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("id_clientes"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setFechaDeRegistro(rs.getString("fecha_de_registro"));
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }
}
