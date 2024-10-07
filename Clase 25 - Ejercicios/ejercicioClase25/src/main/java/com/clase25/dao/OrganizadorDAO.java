package com.clase25.dao;
import com.clase25.modelos.Organizador;
import java.util.List;

public interface OrganizadorDAO {
    void insertarOrganizador(Organizador organizador);
    List<Organizador> consultarOrganizadores();
    void eliminarOrganizadores();
}