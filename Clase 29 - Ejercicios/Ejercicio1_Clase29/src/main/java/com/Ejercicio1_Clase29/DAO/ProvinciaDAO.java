package com.Ejercicio1_Clase29.DAO;

import com.Ejercicio1_Clase29.Modelos.Provincia;
import java.util.List;

public interface ProvinciaDAO {
    void create(Provincia provincia);
    void update(Provincia provincia);
    void delete(int codigo);
    Provincia obtener(int codigo);
    List<Provincia> obtenerTodos();
}
