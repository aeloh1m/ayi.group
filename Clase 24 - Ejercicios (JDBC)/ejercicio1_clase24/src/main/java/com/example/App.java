package com.example;

import com.example.dao.EmpleadoDAOImpl;
import com.example.dao.ProyectoDAOImpl;
import com.example.dao.TareaDAOImpl;
import com.example.modelos.Empleado;
import com.example.modelos.Proyecto;
import com.example.modelos.Tarea;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.BufferedReader;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        System.out.println("Ruta actual: " + System.getProperty("user.dir"));
        String url = "jdbc:mysql://localhost:3306/ejercicio1_clase24",
                user = "root",
                password = "admin";

        int loop = 1, opcion = 0;
        BufferedReader entrada = new BufferedReader(new java.io.InputStreamReader(System.in));

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            EmpleadoDAOImpl empleadoDAO = new EmpleadoDAOImpl();
            ProyectoDAOImpl proyectoDAO = new ProyectoDAOImpl();
            TareaDAOImpl tareaDAO = new TareaDAOImpl();

            do {
                System.out.println("Opciones: \n 1. Agregar Empleado \n 2. Listar Empleados \n 3. Agregar Proyecto \n 4. Listar Proyectos \n 5. Agregar Tarea \n 6. Listar Tareas \n 7. Salir");
                opcion = Integer.parseInt(entrada.readLine());
                while (opcion > 7 || opcion < 1) {
                    System.out.println("Opción no válida, intente nuevamente: ");
                    opcion = Integer.parseInt(entrada.readLine());
                }

                switch (opcion) {
                    case 1: // Agregar Empleado
                        System.out.println("Ingrese el nombre del empleado: ");
                        String nombreEmpleado = entrada.readLine();
                        empleadoDAO.agregarEmpleado(new Empleado(0, nombreEmpleado, null)); // ID autogenerado
                        System.out.println("Empleado agregado exitosamente.");
                        break;

                    case 2: // Listar Empleados
                        System.out.println("Lista de Empleados:");
                        for (Empleado empleado : empleadoDAO.listarEmpleados()) {
                            System.out.println("ID: " + empleado.getIdEmpleado() + ", Nombre: " + empleado.getNombreEmpleado());
                        }
                        break;

                    case 3: // Agregar Proyecto
                        System.out.println("Ingrese el nombre del proyecto: ");
                        String nombreProyecto = entrada.readLine();
                        System.out.println("Ingrese la fecha de inicio (YYYY-MM-DD HH:MM:SS): ");
                        String fechaInicio = entrada.readLine();
                        proyectoDAO.agregarProyecto(new Proyecto(0, nombreProyecto, java.sql.Timestamp.valueOf(fechaInicio))); // ID autogenerado
                        System.out.println("Proyecto agregado exitosamente.");
                        break;

                    case 4: // Listar Proyectos
                        System.out.println("Lista de Proyectos:");
                        for (Proyecto proyecto : proyectoDAO.listarProyectos()) {
                            System.out.println("ID: " + proyecto.getIdProyecto() + ", Nombre: " + proyecto.getNombreProyecto() + ", Fecha de Inicio: " + proyecto.getFechaInicio());
                        }
                        break;

                    case 5: // Agregar Tarea
                        System.out.println("Ingrese el estado de la tarea (true/false): ");
                        boolean estadoTarea = Boolean.parseBoolean(entrada.readLine());
                        System.out.println("Ingrese una descripción para la tarea: ");
                        String descripcionTarea = entrada.readLine();
                        tareaDAO.agregarTarea(new Tarea(0, estadoTarea, descripcionTarea)); // ID autogenerado
                        System.out.println("Tarea agregada exitosamente.");
                        break;

                    case 6: // Listar Tareas
                        System.out.println("Lista de Tareas:");
                        for (Tarea tarea : tareaDAO.listarTareas()) {
                            System.out.println("ID: " + tarea.getIdTarea() + ", Estado: " + tarea.isEstadoTarea() + ", Descripción: " + tarea.getDescripcion());
                        }
                        break;

                    case 7: // Salir
                        loop = 0;
                        break;

                    default:
                        break;
                }

            } while (loop == 1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }}
