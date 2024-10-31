package com.demorest.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.demorest.Services.IClientesService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.demorest.Entities.Cliente;

@RestController
public class ClientesController {

    @Autowired
    @Lazy
    @Qualifier("JSON")
    private IClientesService iClientesService;

    @GetMapping("/mensaje/{nombre}")
    public String mensaje(@PathVariable String nombre) {
        return "Hola " + nombre + " este es el curso de Java, Spring Boot, ReactJs y NodeJs";
    }

    @GetMapping(value = "/clientes-html", produces = MediaType.TEXT_HTML_VALUE)
    public String getClientesHtml() {
        StringBuilder sb = new StringBuilder();
        sb.append(
                "<html><head><title>Clientes</title></head><body><table><tr><th>Nro Cliente</th><th>Nombre</th><th>Apellido</th></tr>");
        return sb.toString();
    }

    @GetMapping("/clientes")
    public List<Cliente> listarClientes() {
        return iClientesService.listarClientes();
    }

    @GetMapping("/{nroCliente}")
    public ResponseEntity<Cliente> obtenerCliente(@PathVariable int nroCliente) {
        Cliente cliente = iClientesService.obtenerClientePorId(nroCliente);
        if (cliente == null) {
            return ResponseEntity.notFound().build(); // Retorna 404 si no se encuentra el cliente
        }
        return ResponseEntity.ok(cliente); // Retorna 200 OK con el cliente
    }

}
