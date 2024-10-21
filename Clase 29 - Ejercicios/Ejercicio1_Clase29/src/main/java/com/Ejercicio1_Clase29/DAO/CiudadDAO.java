package com.Ejercicio1_Clase29.DAO;

import com.Ejercicio1_Clase29.Modelos.Ciudad;
import java.util.List;

public interface CiudadDAO {
    void create(Ciudad ciudad);
    void update(Ciudad ciudad);
    void delete(int codigo);
    Ciudad obtener(int codigo);
    List<Ciudad> obtenerTodas();
}
