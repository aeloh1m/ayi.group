package com.example.dao;

import com.example.modelo.Usuario;

import java.sql.SQLException;
import java.util.List;

public interface UsuarioDAO {
    void agregarUsuario(Usuario usuario) throws SQLException;
    List<Usuario> listarUsuarios() throws SQLException;
}
