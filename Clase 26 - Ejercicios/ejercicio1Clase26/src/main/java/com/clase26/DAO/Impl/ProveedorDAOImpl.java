package com.clase26.DAO.Impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.clase26.ConexionDB.ConexionDB;
import com.clase26.DAO.ProveedorDAO;
import com.clase26.Modelos.Proveedor;

public class ProveedorDAOImpl implements ProveedorDAO {

    @Override
    public void agregarProveedor(Proveedor proveedor) {
        String query = "INSERT INTO proveedores (nombre, razon_social, contacto, direccion, email, telefono) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = ConexionDB.getConnection();
                PreparedStatement ps = connection.prepareStatement(query)) {
            connection.setAutoCommit(false);
            ps.setString(1, proveedor.getNombre());
            ps.setString(2, proveedor.getRazonSocial());
            ps.setString(3, proveedor.getContacto());
            ps.setString(4, proveedor.getDireccion());
            ps.setString(5, proveedor.getEmail());
            ps.setString(6, proveedor.getTelefono());
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizarProveedor(Proveedor proveedor) {
        String query = "UPDATE proveedores SET nombre = ?, razon_social = ?, contacto = ?, direccion = ?, email = ?, telefono = ? WHERE id_proveedor = ?";
        try (Connection connection = ConexionDB.getConnection();
                PreparedStatement ps = connection.prepareStatement(query)) {
            connection.setAutoCommit(false);
            ps.setString(1, proveedor.getNombre());
            ps.setString(2, proveedor.getRazonSocial());
            ps.setString(3, proveedor.getContacto());
            ps.setString(4, proveedor.getDireccion());
            ps.setString(5, proveedor.getEmail());
            ps.setString(6, proveedor.getTelefono());
            ps.setInt(7, proveedor.getIdProveedor());
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarProveedor(int id) {
        String query = "DELETE FROM proveedores WHERE id_proveedor = ?";
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
    public Proveedor obtenerProveedor(int id) {
        Proveedor proveedor = null;
        String query = "SELECT * FROM proveedores WHERE id_proveedor = ?";
        try (Connection connection = ConexionDB.getConnection();
                PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                proveedor = new Proveedor();
                proveedor.setIdProveedor(rs.getInt("id_proveedor"));
                proveedor.setNombre(rs.getString("nombre"));
                proveedor.setRazonSocial(rs.getString("razon_social"));
                proveedor.setContacto(rs.getString("contacto"));
                proveedor.setDireccion(rs.getString("direccion"));
                proveedor.setEmail(rs.getString("email"));
                proveedor.setTelefono(rs.getString("telefono"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return proveedor;
    }

    @Override
    public List<Proveedor> obtenerTodosProveedores() {
        List<Proveedor> proveedores = new ArrayList<>();
        String query = "SELECT * FROM proveedores";
        try (Connection connection = ConexionDB.getConnection();
                PreparedStatement ps = connection.prepareStatement(query);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Proveedor proveedor = new Proveedor();
                proveedor.setIdProveedor(rs.getInt("id_proveedor"));
                proveedor.setNombre(rs.getString("nombre"));
                proveedor.setRazonSocial(rs.getString("razon_social"));
                proveedor.setContacto(rs.getString("contacto"));
                proveedor.setDireccion(rs.getString("direccion"));
                proveedor.setEmail(rs.getString("email"));
                proveedor.setTelefono(rs.getString("telefono"));
                proveedores.add(proveedor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return proveedores;
    }
}
