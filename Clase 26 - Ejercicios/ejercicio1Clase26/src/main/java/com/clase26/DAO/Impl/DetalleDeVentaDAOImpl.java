package com.clase26.DAO.Impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.clase26.ConexionDB.ConexionDB;
import com.clase26.DAO.DetalleDeVentaDAO;
import com.clase26.Modelos.DetalleDeVenta;

public class DetalleDeVentaDAOImpl implements DetalleDeVentaDAO {

    @Override
    public void agregarDetalleDeVenta(DetalleDeVenta detalle) {
        String query = "INSERT INTO detalles_de_ventas (id_producto, id_venta, cant_vendida, precio_de_venta) VALUES (?, ?, ?, ?)";
        try (Connection connection = ConexionDB.getConnection();
                PreparedStatement ps = connection.prepareStatement(query)) {
            connection.setAutoCommit(false);
            ps.setInt(1, detalle.getIdProducto());
            ps.setInt(2, detalle.getIdVenta());
            ps.setInt(3, detalle.getCantVendida());
            ps.setDouble(4, detalle.getPrecioDeVenta());
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizarDetalleDeVenta(DetalleDeVenta detalle) {
        String query = "UPDATE detalles_de_ventas SET id_producto = ?, id_venta = ?, cant_vendida = ?, precio_de_venta = ? WHERE id_detalles_de_venta = ?";
        try (Connection connection = ConexionDB.getConnection();
                PreparedStatement ps = connection.prepareStatement(query)) {
            connection.setAutoCommit(false);
            ps.setInt(1, detalle.getIdProducto());
            ps.setInt(2, detalle.getIdVenta());
            ps.setInt(3, detalle.getCantVendida());
            ps.setDouble(4, detalle.getPrecioDeVenta());
            ps.setInt(5, detalle.getIdDetalleDeVenta());
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarDetalleDeVenta(int id) {
        String query = "DELETE FROM detalles_de_ventas WHERE id_detalles_de_venta = ?";
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
    public DetalleDeVenta obtenerDetalleDeVenta(int id) {
        DetalleDeVenta detalle = null;
        String query = "SELECT * FROM detalles_de_ventas WHERE id_detalles_de_venta = ?";
        try (Connection connection = ConexionDB.getConnection();
                PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                detalle = new DetalleDeVenta();
                detalle.setIdDetalleDeVenta(rs.getInt("id_detalles_de_venta"));
                detalle.setIdProducto(rs.getInt("id_producto"));
                detalle.setIdVenta(rs.getInt("id_venta"));
                detalle.setCantVendida(rs.getInt("cant_vendida"));
                detalle.setPrecioDeVenta(rs.getDouble("precio_de_venta"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return detalle;
    }

    @Override
    public List<DetalleDeVenta> obtenerTodosDetallesDeVenta() {
        List<DetalleDeVenta> detalles = new ArrayList<>();
        String query = "SELECT * FROM detalles_de_ventas";
        try (Connection connection = ConexionDB.getConnection();
                PreparedStatement ps = connection.prepareStatement(query);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                DetalleDeVenta detalle = new DetalleDeVenta();
                detalle.setIdDetalleDeVenta(rs.getInt("id_detalles_de_venta"));
                detalle.setIdProducto(rs.getInt("id_producto"));
                detalle.setIdVenta(rs.getInt("id_venta"));
                detalle.setCantVendida(rs.getInt("cant_vendida"));
                detalle.setPrecioDeVenta(rs.getDouble("precio_de_venta"));
                detalles.add(detalle);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return detalles;
    }
}
