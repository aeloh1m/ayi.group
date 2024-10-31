package com.demorest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
2) Crear un proyecto de Spring:
● El proyecto debe ser de tipo MVC
● Deberá enviar el título (“Listado de Empleados y Sucursales”) desde el
controlador.
● Crear una base de datos con la tabla Empleados (legajo, nombre, apellido,
nro de sucursal), también crear la tabla Sucursales (número de sucursal,
nombre, dirección, barrio)
● Utilizar el motor de base de datos que prefieran
● Mostrar los datos de los empleados y sucursales en la vista html en formato
de tabla.
 */

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}