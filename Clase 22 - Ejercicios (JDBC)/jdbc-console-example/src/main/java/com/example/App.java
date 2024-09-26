package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.BufferedReader;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        System.out.println("Ruta actual: " + System.getProperty("user.dir"));
        String url = "jdbc:mysql://localhost:3306/ejercicio1_clase22",
                user = "root",
                password = "admin",
                nombre_usuario = ""; 

        int loop = 1, opcion = 0;

        // Establish connection
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {

            BufferedReader entrada = new BufferedReader(new java.io.InputStreamReader(System.in));

            do {
                System.out.println("Opciones \n 1. Agregar Usuario \n 2. Listar Usuarios \n 3. Salir");
                opcion = Integer.parseInt(entrada.readLine());
                while (opcion > 3 || opcion < 1) {
                    System.out.println("Opción no válida, intente nuevamente: \n");
                    opcion = Integer.parseInt(entrada.readLine());
                }

                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese el nombre del usuario: ");
                        nombre_usuario = entrada.readLine();
                        String insertQuery = "INSERT INTO usuarios (nombre_usuario) VALUES ('" + nombre_usuario + "')";
                        stmt.executeUpdate(insertQuery);
                        System.out.println("Usuario agregado exitosamente.");
                        break;

                    case 2:
                        // Crea un nuevo ResultSet cada vez que se lista
                        String query = "SELECT * FROM usuarios";
                        try (ResultSet rs = stmt.executeQuery(query)) {
                            while (rs.next()) {
                                int id_usuario = rs.getInt("id_usuario");
                                nombre_usuario = rs.getString("nombre_usuario");
                                System.out.println("ID: " + id_usuario + ", Name: " + nombre_usuario);
                            }
                        } // El ResultSet se cierra automáticamente acá
                        break;

                    case 3:
                        loop = 0;
                        break;

                    default:
                        break;
                }

            } while (loop == 1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
