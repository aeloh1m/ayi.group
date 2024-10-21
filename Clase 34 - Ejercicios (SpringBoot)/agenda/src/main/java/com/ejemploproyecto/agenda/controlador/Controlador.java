package com.ejemploproyecto.agenda.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controlador {

    @GetMapping("/mi-html")
    public String mostrarHtml() {
        return "mi-pagina"; // Nombre del archivo HTML sin extensión
    }
}
