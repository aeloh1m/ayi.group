package com.Ejercicio1_Clase29.DAO;

import com.Ejercicio1_Clase29.Modelos.Persona;

import java.util.List;

public interface PersonaDAO {
    void agregarPersona(Persona persona);
    void actualizarPersona(Persona persona);
    void eliminarPersona(int numeroDocumento);
    Persona obtenerPersona(int numeroDocumento);
    List<Persona> obtenerTodasPersonas();
}
