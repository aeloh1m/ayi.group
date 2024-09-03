/*
 * Realizar un programa de Java que lea por teclado datos numéricos y lo
almacene en un vector, el tamaño también debe ser ingresado por teclado.
Se solicita:
● Realizar las validaciones correspondientes (Excepciones de ingreso de
datos)
● Se puede utilizar la clase Scanner o BufferedReader para la entrada de
datos por teclado.
● Mostrar los datos del vector
● Informar la cantidad de números narcisistas ingresados.
● Recorrer el vector y guardarlo sus datos en una lista de tipo LinkedList
● Informar la cantidad de datos de la lista.
● En una cola, agregar los datos pares de la lista
● En una pila, agregar los datos impares de la lista
● Informar datos de cada una de las estructuras de datos.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Vector;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Ejercicio1 {

    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static int validateInput(String input, BufferedReader entrada) throws IOException {
        int numberParsed = 0;
        while (true) {
            if (isInteger(input)) {
                break;
            } else {

                System.out.print("Por favor ingrese un número entero para continuar: ");
                input = entrada.readLine();
            }
        }
        numberParsed = Integer.parseInt(input);
        return numberParsed;
    }

    public static boolean isNarcissist(int numero) {
        double sum = 0;
        String numberParsed = "";
        char indexOf;

        numberParsed = Integer.toString(numero);

        for (int i = 0; i < numberParsed.length(); i++) {
            indexOf = numberParsed.charAt(i); // Toma individualmente cada número y va parseando entre tipos
            int digit = Character.getNumericValue(indexOf);
            sum += Math.pow(digit, numberParsed.length());
        }

        if (numero == sum) {
            return true;
        } else {

            return false;
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        int i = 0, inputRead = 0, validar = 0, tamaño = 0, conteoNarcisistas = 0;
        Vector<Integer> vector = new Vector<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        Queue<Integer> cola = new LinkedList<>();
        Stack<Integer> pila = new Stack<>();

        try {
            System.out.print("Ingrese el tamaño para el vector: ");
            String input = entrada.readLine();

            inputRead = validateInput(input, entrada);
            System.out.println("El tamaño del vector es: " + inputRead);
            tamaño = inputRead;
            for (i = 1; i <= tamaño; i++) {
                System.out.println("Por favor ingrese el dato n° " + i + ": ");
                input = entrada.readLine();

                if (isInteger(input)) {
                    validar = Integer.parseInt(input);
                    vector.add(validar);

                } else {
                    System.out.println("¡Error!, debe ingresar un número entero. ");
                    validar = (i == 0) ? 0 : (i--);
                }
            }

            System.out.println("Datos ingresados en el vector: ");

            for (i = 0; i < vector.size(); i++) {
                System.out.println( i+1+ ": " + vector.get(i));
                linkedList.add(vector.get(i));
                if (isNarcissist(vector.get(i))) {
                    conteoNarcisistas++;
                }
            }
            System.out.println("\n" +"La cantidad de números narcisistas es de: " + conteoNarcisistas + "\n");

            for (Integer num : linkedList) {
                if (num % 2 == 0) {
                    cola.add(num);
                } else if (num % 3 == 0) {
                    pila.add(num);
                }
            }

            System.out.println("Los elementos en el vector son: " + vector +
                    "\n" + "Los elementos en la linkedList son: " + linkedList + "\n"
                    + "Los elementos en la cola son: " + cola + "\n"
                    + "Los elementos en la pila son: " + pila);

        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer la entrada: " + e.getMessage());
        }

    }
}
