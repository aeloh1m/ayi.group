package com.Ejercicio1_Clase29.DAO;

import com.Ejercicio1_Clase29.Modelos.Sector;
import java.util.List;

public interface SectorDAO {
    void create(Sector sector);
    void update(Sector sector);
    void delete(int codigo);
    Sector obtener(int codigo);
    List<Sector> obtenerTodos();
}
