package com.demorest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
 * Crear un proyecto de Spring:
● El proyecto debe ser de tipo MVC ok
● Deberá enviar el título (“Listado de Usuarios”) desde el controlador. ok
● Crear una base de datos con la tabla Usuario (Id_usuario, nombre, apellido)
con cualquier motor de base de datos. ok
● Mostrar los datos del usuario en la vista html en formato de tabla.
● Utilizar Lombok y Thymeleaf
● Verificar los datos con Postman, para ello agregar la anotación
RestController (Convertir de MVC a REST)
 */

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}