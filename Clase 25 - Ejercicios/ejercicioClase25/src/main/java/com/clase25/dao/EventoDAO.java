package com.clase25.dao;
import com.clase25.modelos.Evento;
import com.clase25.modelos.EventoParticipante;

import java.util.List;

public interface EventoDAO {
    void insertarEvento(Evento evento);
    List<Evento> consultarEventos();
     List<EventoParticipante> consultarEventosParticipantes();
    void eliminarEventos();
}