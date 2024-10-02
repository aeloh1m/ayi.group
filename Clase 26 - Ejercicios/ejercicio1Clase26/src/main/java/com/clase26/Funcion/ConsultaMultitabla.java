package com.clase26.Funcion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.clase26.ConexionDB.ConexionDB;

public class ConsultaMultitabla {
    

    public List<String> obtenerVentasConDetalles() {
        List<String> resultados = new ArrayList<>();
        String query = "SELECT v.id_ventas, c.nombre, d.cant_vendida, d.precio_de_venta " +
                       "FROM ventas v " +
                       "JOIN clientes c ON v.cliente_id = c.id_clientes " +
                       "JOIN detalles_de_ventas d ON v.id_ventas = d.id_venta";

        try (Connection connection = ConexionDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String resultado = "Venta ID: " + rs.getInt("id_ventas") +
                                   ", Cliente: " + rs.getString("nombre") +
                                   ", Cantidad Vendida: " + rs.getInt("cant_vendida") +
                                   ", Precio de Venta: " + rs.getDouble("precio_de_venta");
                resultados.add(resultado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultados;
    }
}
