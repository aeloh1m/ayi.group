package com.Ejercicio1_Clase29.DAO;

import com.Ejercicio1_Clase29.Modelos.Videojuego;
import java.util.List;

public interface VideojuegoDAO {
    void create(Videojuego videojuego);
    void update(Videojuego videojuego);
    void delete(int id);
    Videojuego obtener(int id);
    List<Videojuego> obtenerTodos();
}
