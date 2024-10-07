package com.clase25.dao;
import com.clase25.modelos.Inscripcion;
import java.util.List;

public interface InscripcionDAO {
    void insertarInscripcion(Inscripcion inscripcion);
    List<Inscripcion> consultarInscripciones();
    void eliminarInscripciones();
}
