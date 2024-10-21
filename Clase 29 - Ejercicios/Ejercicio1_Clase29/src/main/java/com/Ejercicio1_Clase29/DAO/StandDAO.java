package com.Ejercicio1_Clase29.DAO;

import com.Ejercicio1_Clase29.Modelos.Stand;
import java.util.List;

public interface StandDAO {
    void create(Stand stand);
    void update(Stand stand);
    void delete(int codigo);
    Stand obtener(int codigo);
    List<Stand> obtenerTodos();
}