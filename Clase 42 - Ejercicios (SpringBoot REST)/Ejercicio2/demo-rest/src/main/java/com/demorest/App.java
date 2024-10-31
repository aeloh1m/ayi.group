package com.demorest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 Crear un proyecto de Spring:
● El proyecto debe ser de tipo REST.
● Se debe crear un objeto Clientes (nro de clientes, nombre,
apellido).
● Enviar los datos del cliente desde el controlador, utilizando
el formato HTML.
● Visualizarlo el proyecto en el navegador.
● Visualizarlo también utilizando la herramienta de Postman.
 */

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}