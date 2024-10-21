package com.Ejercicio1_Clase29.DAO;

import com.Ejercicio1_Clase29.Modelos.Genero;
import java.util.List;

public interface GeneroDAO {
    void create(Genero genero);

    void update(Genero genero);

    void delete(int codigo);

    Genero obtener(int codigo);

    List<Genero> obtenerTodos();
}
