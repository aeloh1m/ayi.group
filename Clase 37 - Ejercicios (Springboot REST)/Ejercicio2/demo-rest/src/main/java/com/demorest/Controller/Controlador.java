package com.demorest.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class Controlador {

    @GetMapping("/mensaje/{nombre}")
    public String mensaje(@PathVariable String nombre) {
        return "Hola " + nombre + " este es el curso de Java, Spring Boot, ReactJs y NodeJs";
    }

}
