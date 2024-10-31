package com.demorest.Services;

import java.util.List;

import com.demorest.Entities.Cliente;

public interface IClientesService {
    void agregarCliente(Cliente cliente);

    List<Cliente> listarClientes(); // Asegúrate de que este método esté aquí

    Cliente obtenerClientePorId(int id); // También deberías tener esto si lo usas
}
