package com.clase25.dao;
import com.clase25.modelos.Participante;
import java.util.List;

public interface ParticipanteDAO {
    void insertarParticipante(Participante participante);
    List<Participante> consultarParticipantes();
    void eliminarParticipantes();
}
