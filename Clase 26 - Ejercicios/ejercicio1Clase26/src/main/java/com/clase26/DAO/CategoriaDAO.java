package com.clase26.DAO;

import java.util.List;

import com.clase26.Modelos.Categoria;

public interface CategoriaDAO {
    void agregarCategoria(Categoria categoria);
    void actualizarCategoria(Categoria categoria);
    void eliminarCategoria(int id);
    Categoria obtenerCategoria(int id);
    List<Categoria> obtenerTodasCategorias();
}
