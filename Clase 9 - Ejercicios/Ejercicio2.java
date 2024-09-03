/*
 * Realizar un programa de Java, que lea por teclado una cadena de caracteres
y luego realice varias operaciones con dicha cadena. ok
Se solicita:
- Para el ingreso de datos por teclado se pide que sean mediante la
clase Scanner. ok
- Dividir la cadena de caracteres en palabras, de preferencia utilizar la
clase StringTokenizer. 
- Guardar las palabras en un ArrayList
- Recorrer el ArrayList y mostrar todas las cadenas ingresadas.
- Verificar en cada una de las cadenas si es palindroma.
- Quitar las cadenas con longitud mayor a 5 (cinco)
- Mostrar nuevamente los datos del ArrayList.
 */

import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Ejercicio2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer una cadena de texto
        System.out.print("Ingrese una cadena de texto: ");
        String texto = scanner.nextLine();
        System.out.println("Cadena de texto ingresada: " + texto);

        scanner.nextLine(); // Consumir el salto de línea pendiente

        // Cerrar el objeto Scanner
        scanner.close();
    }
}