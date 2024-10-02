package com.clase26.DAO.Impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.clase26.ConexionDB.ConexionDB;
import com.clase26.DAO.VentaDAO;
import com.clase26.Modelos.Venta;

public class VentaDAOImpl implements VentaDAO {

    @Override
    public void agregarVenta(Venta venta) {
        String query = "INSERT INTO ventas (cliente_id, fecha_de_venta, total, met_de_pago_id) VALUES (?, ?, ?, ?)";
        Connection connection = null; // Declarar la conexión aquí
        try {
            connection = ConexionDB.getConnection();
            connection.setAutoCommit(false);
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setInt(1, venta.getClienteId());
                ps.setTimestamp(2, venta.getFechaDeVenta()); // Cambiado a Timestamp
                ps.setDouble(3, venta.getTotal());
                ps.setInt(4, venta.getMetodoDePagoId()); // Cambiado a metodoDePagoId
                ps.executeUpdate();
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            // Si ocurre un error, revertir la transacción
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }
        } finally {
            if (connection != null) {
                try {
                    connection.close(); // Cerrar la conexión
                } catch (SQLException closeEx) {
                    closeEx.printStackTrace();
                }
            }
        }
    }

    @Override
    public void actualizarVenta(Venta venta) {
        String query = "UPDATE ventas SET cliente_id = ?, fecha_de_venta = ?, total = ?, met_de_pago_id = ? WHERE id_ventas = ?";
        Connection connection = null; // Declarar la conexión aquí
        try {
            connection = ConexionDB.getConnection();
            connection.setAutoCommit(false);
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setInt(1, venta.getClienteId());
                ps.setTimestamp(2, venta.getFechaDeVenta()); // Cambiado a Timestamp
                ps.setDouble(3, venta.getTotal());
                ps.setInt(4, venta.getMetodoDePagoId()); // Cambiado a metodoDePagoId
                ps.setInt(5, venta.getIdVentas()); // Cambiado a getIdVentas()
                ps.executeUpdate();
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            // Si ocurre un error, revertir la transacción
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }
        } finally {
            if (connection != null) {
                try {
                    connection.close(); // Cerrar la conexión
                } catch (SQLException closeEx) {
                    closeEx.printStackTrace();
                }
            }
        }
    }

    @Override
    public void eliminarVenta(int id) {
        String query = "DELETE FROM ventas WHERE id_ventas = ?";
        Connection connection = null; // Declarar la conexión aquí
        try {
            connection = ConexionDB.getConnection();
            connection.setAutoCommit(false);
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setInt(1, id);
                ps.executeUpdate();
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            // Si ocurre un error, revertir la transacción
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }
        } finally {
            if (connection != null) {
                try {
                    connection.close(); // Cerrar la conexión
                } catch (SQLException closeEx) {
                    closeEx.printStackTrace();
                }
            }
        }
    }

    @Override
    public Venta obtenerVenta(int id) {
        Venta venta = null;
        String query = "SELECT * FROM ventas WHERE id_ventas = ?";
        try (Connection connection = ConexionDB.getConnection(); // Usar try-with-resources para la conexión
             PreparedStatement ps = connection.prepareStatement(query)) {
             
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                venta = new Venta();
                venta.setIdVentas(rs.getInt("id_ventas"));
                venta.setClienteId(rs.getInt("cliente_id"));
                venta.setFechaDeVenta(rs.getTimestamp("fecha_de_venta")); // Cambiado a Timestamp
                venta.setTotal(rs.getDouble("total"));
                venta.setMetodoDePagoId(rs.getInt("met_de_pago_id")); // Cambiado a metodoDePagoId
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return venta;
    }

    @Override
    public List<Venta> obtenerTodasVentas() {
        List<Venta> ventas = new ArrayList<>();
        String query = "SELECT * FROM ventas";
        try (Connection connection = ConexionDB.getConnection(); // Usar try-with-resources para la conexión
             PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
             
            while (rs.next()) {
                Venta venta = new Venta();
                venta.setIdVentas(rs.getInt("id_ventas"));
                venta.setClienteId(rs.getInt("cliente_id"));
                venta.setFechaDeVenta(rs.getTimestamp("fecha_de_venta")); // Cambiado a Timestamp
                venta.setTotal(rs.getDouble("total"));
                venta.setMetodoDePagoId(rs.getInt("met_de_pago_id")); // Cambiado a metodoDePagoId
                ventas.add(venta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ventas;
    }
}
