package com.ejercicios_clase45;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ejercicios_clase45.entities.Persona;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // Create a Scanner object to read input
        Scanner scanner = new Scanner(System.in);
        String nombre, apellido;
        // Prompt the user for their name
        System.out.print("Ingrese su nombre: ");
        nombre = scanner.nextLine();

        // Prompt the user for their age
        System.out.print("Ingrese su apellido: ");
        apellido = scanner.nextLine();

        // PARTE DE HIBERNATE
        // Crear un objeto User con los datos del usuario
        Persona nuevaPersona = new Persona();
        nuevaPersona.setNombre(nombre);
        nuevaPersona.setApellido(apellido);

        // Crear SessionFactory de Hibernate
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml") // Cargar la configuración de Hibernate
                .addAnnotatedClass(Persona.class) // Indicar la clase de entidad
                .buildSessionFactory();

        // Crear una sesión
        Session session = factory.openSession();

        try {
            // Iniciar una transacción
            session.beginTransaction();

            // Guardar el nuevo usuario en la base de datos
            session.save(nuevaPersona);

            // Confirmar la transacción
            session.getTransaction().commit();

            System.out.println("¡Persona agregada exitosamente!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cerrar la sesión y el factory
            session.close();
            factory.close();
        }

        scanner.close();
    }
}
