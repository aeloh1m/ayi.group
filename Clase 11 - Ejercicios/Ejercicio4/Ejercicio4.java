package Ejercicio4;
/*
 * Realizar un programa de Java
Se solicita:
- Crear la clase Médico (nombre, especialidad, nro de matrícula) ok
- Crear la clase Administrativo (legajo, nombre, departamento) ok
- Crear la interfaz Servicio ok
- Hacer que dichas clases implementan la interfaz servicio (Inventar
metodos). ok
- Cargar datos de ambas clases.
- Se puede utilizar la clase Scanner o BufferedReader.
- Realizar validaciones correspondientes.
- Cargar los datos de los médicos en un vector.
- Cargar los datos de los administrativos en un vector.
- Ingresar el tamaño de ambos vectores por teclado.
- Mostrar datos de ambos vectores
- Ordenar los datos del vector de médicos por matrícula.
- Ordenar los datos del vector de administrativos por legajo.
- Mostrar los datos de ambos vector.

*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Vector;
import java.util.Comparator;

public class Ejercicio4 {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int i = 0, tamañoMedicos = 0, tamañoAdministrativos = 0;

        while (true) {
            try {
                System.out.print("Ingrese el tamaño del vector de médicos: ");
                tamañoMedicos = Integer.parseInt(reader.readLine());
                if (tamañoMedicos > 0) {
                    break;
                } else {
                    System.out.println("El tamaño debe ser un número positivo.");
                }
            } catch (IOException | NumberFormatException e) {
                System.out.println("Por favor, ingrese un número entero válido.");
            }
        }

        while (true) {
            try {
                System.out.print("Ingrese el tamaño del vector de administrativos: ");
                tamañoAdministrativos = Integer.parseInt(reader.readLine());
                if (tamañoAdministrativos > 0) {
                    break;
                } else {
                    System.out.println("El tamaño debe ser un número positivo.");
                }
            } catch (IOException | NumberFormatException e) {
                System.out.println("Por favor, ingrese un número entero válido.");
            }
        }

        Vector<Medico> medicos = new Vector<>(tamañoMedicos);
        Vector<Administrativo> administrativos = new Vector<>(tamañoAdministrativos);

        for ( i = 0; i < tamañoMedicos; i++) {
            try {
                System.out.println("Ingrese los datos del médico " + (i + 1) + ":");
                System.out.print("Nombre: ");
                String nombre = reader.readLine();
                System.out.print("Especialidad: ");
                String especialidad = reader.readLine();
                String nroMatricula;
                while (true) {
                    System.out.print("Número de Matrícula: ");
                    nroMatricula = reader.readLine();
                    if (nroMatricula.matches("\\d+")) { // Validar que el número de matrícula sea numérico
                        break;
                    } else {
                        System.out.println("El número de matrícula debe ser numérico.");
                    }
                }
                medicos.add(new Medico(nombre, especialidad, nroMatricula));
            } catch (IOException e) {
                System.out.println("Error al leer los datos.");
            }
        }

        for ( i = 0; i < tamañoAdministrativos; i++) {
            try {
                System.out.println("Ingrese los datos del administrativo " + (i + 1) + ":");
                System.out.print("Legajo: ");
                String legajo = reader.readLine();
                System.out.print("Nombre: ");
                String nombre = reader.readLine();
                System.out.print("Departamento: ");
                String departamento = reader.readLine();
                administrativos.add(new Administrativo(legajo, nombre, departamento));
            } catch (IOException e) {
                System.out.println("Error al leer los datos.");
            }
        }

        System.out.println("\nDatos del vector de médicos:");
        for (Medico medico : medicos) {
            System.out.println(medico);
        }

        System.out.println("\nDatos del vector de administrativos:");
        for (Administrativo administrativo : administrativos) {
            System.out.println(administrativo);
        }

        medicos.sort(Comparator.comparing(Medico::getNroMatricula));

        administrativos.sort(Comparator.comparing(Administrativo::getLegajo));

        System.out.println("\nDatos del vector de médicos ordenado por matrícula:");
        for (Medico medico : medicos) {
            System.out.println(medico);
        }

        System.out.println("\nDatos del vector de administrativos ordenado por legajo:");
        for (Administrativo administrativo : administrativos) {
            System.out.println(administrativo);
        }

    }
}