package com.clase26.DAO;
import java.util.List;

import com.clase26.Modelos.Cliente;

public interface ClienteDAO {
    void agregarCliente(Cliente cliente);
    void actualizarCliente(Cliente cliente);
    void eliminarCliente(int id);
    Cliente obtenerCliente(int id);
    List<Cliente> obtenerTodosClientes();
}
