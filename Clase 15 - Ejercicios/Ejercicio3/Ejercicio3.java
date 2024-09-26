package Ejercicio3;

/*
 * Realizar un proyecto de Java con HashMap e Hilos.
Se solicita:
- Crear el HashMap para almacenar cadenas de caracteres.
- Se solicita que el usuario ingrese una cadena de caracteres por teclado
- De preferencia utilizar la clase Scanner para la lectura de datos por
teclado.
- Realizar las validaciones correspondientes al ingreso de la cadena de
caracteres, es decir que no se ingrese nada vacío.
- Dividir la cadena de texto ingresada utilizado las clases que hemos
vimos en el curso.
- Guardar cada palabra en el HashMap.
EJERCICIOS
- Generar las claves de cada uno de los datos del HashMap de forma aleatoria.
- Para trabajar con el HashMap implementar Hilos de ejecucion.
- Mostrar los datos del HashMap.

 */

import java.util.HashMap;
import java.util.Scanner;

public class Ejercicio3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nombre = scanner.nextLine();
        HashMap<String, String> diccionario = new HashMap<>();
        
        scanner.close();
    }

}
