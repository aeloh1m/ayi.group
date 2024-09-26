package com.example.dao;

import com.example.modelo.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOImpl implements UsuarioDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/ejercicio1_clase22";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";

    @Override
    public void agregarUsuario(Usuario usuario) throws SQLException {
        String query = "INSERT INTO usuarios (id, nombre) VALUES (?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, usuario.getId());
            pstmt.setString(2, usuario.getNombre());
            pstmt.executeUpdate();
        }
    }

    @Override
    public List<Usuario> listarUsuarios() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        String query = "SELECT * FROM usuarios";
        
        // Obtener conexión
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rset = stmt.executeQuery(query)) {
             
            // Procesa el ResultSet dentro del bloque try
            while (rset.next()) {
                int id = rset.getInt("id");
                String nombre = rset.getString("nombre");
                usuarios.add(new Usuario(id, nombre));
            }
        } // Cierra automáticamente conn, stmt y rset
        return usuarios;
    }
}
