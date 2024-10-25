package com.demorest.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.demorest.Modelo.Cliente;

import java.util.LinkedList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class ControladorCliente {
    @GetMapping("/clientesAll")
    public String clientesAll() {
        LinkedList<Cliente> clientes = new LinkedList<>();
        clientes.add(new Cliente(1, "Juan", "Perez", "123456789"));
        clientes.add(new Cliente(2, "Maria", "Gomez", "987654321"));
        clientes.add(new Cliente(3, "Pedro", "Lopez", "456789123"));
        clientes.add(new Cliente(4, "Ana", "Martinez", "789123456"));

        return clientes.toString();

    }
}
