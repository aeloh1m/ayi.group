package com.demorest.Services;

import java.util.ArrayList;

// Este modo de realizar los servicios se llama "BEAN" !!

import java.util.List;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.demorest.Entities.Cliente;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Lazy
@Service("JSON")
@ConditionalOnProperty(value = "productos.condicion", havingValue = "DATOS_JSON")
public class ClientesServiceImpl implements IClientesService {

    private final List<Cliente> clientes = new ArrayList<>();

    public List<Cliente> getProductosFromJSON() {
        List<Cliente> listaClientes = null;
        try {
            listaClientes = new ObjectMapper().readValue(
                    this.getClass().getResourceAsStream("/Clientes.json"),
                    new TypeReference<List<Cliente>>() {
                    });
        } catch (java.io.IOException e) {
            throw new RuntimeException("Error al cargar clientes desde JSON", e);
        }
        return listaClientes;
    }

    @Override
    public List<Cliente> listarClientes() {
        if (clientes.isEmpty()) {
            clientes.addAll(getProductosFromJSON());
        }
        return clientes;
    }

    @Override
    public Cliente obtenerClientePorId(int id) {
        return clientes.stream()
                .filter(cliente -> cliente.getNumeroCliente() == id)
                .findFirst()
                .orElse(null); // O lanzar una excepción
    }

    @Override
    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

}
