package com.Ejercicio1_Clase29.DAO;

import com.Ejercicio1_Clase29.Modelos.Conferencia;
import java.util.List;

public interface ConferenciaDAO {
    void create(Conferencia conferencia);
    void update(Conferencia conferencia);
    void delete(int id);
    Conferencia obtener(int id);
    List<Conferencia> obtenerTodas();
}
