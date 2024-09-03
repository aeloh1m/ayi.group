/*
 * Realizar un programa de Java que lea por teclado valores numéricos y los
guarde en un vector también numérico. ok
Se solicita:
- Ingresar el tamaño del vector. ok
- Los valores que se ingresen al vector tienen que ser mayores o
iguales a cero, realizar la validación correspondiente. ok
- Realizar las validaciones de carga de datos, en caso de ingresar un
caracter en vez de un numero. ok
- Mostrar los datos del vector. ok
- Ordenar el vector aplicando el metodo de ordenamiento por
burbuja. --
- Copiar los datos del vector en un LinkedList ok
- Setear todos los valores del vector en 0 (cero) ok
- Mostrar los datos del LinkedList. ok
- Quitar aquellos elementos que estén repetido en el LinkedList. ok
- Mostrar la cantidad de números que sean narcisistas en el
LinkedList. ok
- Verifica cuales son números de Keprekar y mostrarlos. (Para más
información
https://es.wikipedia.org/wiki/N%C3%BAmero_de_Kaprekar)
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Vector;
import java.util.LinkedList;
import java.util.ListIterator;

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

    public static Vector<Integer> bubbleSort(Vector<Integer> vector) {
        int n = vector.size();
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (vector.get(j) > vector.get(j + 1)) {
                    int temp = vector.get(j);
                    vector.set(j, vector.get(j + 1));
                    vector.set(j + 1, temp);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }

        return vector;
    }

    public static LinkedList<Integer> removeDuplicates(LinkedList<Integer> list) {

        LinkedList<Integer> uniqueList = new LinkedList<>();
        ListIterator<Integer> iterator = list.listIterator();

        Integer previous = iterator.hasNext() ? iterator.next() : null;
        uniqueList.add(previous);

        while (iterator.hasNext()) {
            Integer current = iterator.next();
            if (!current.equals(previous)) {
                uniqueList.add(current);
                previous = current;
            }
        }

        return uniqueList;
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

    public static boolean isKaprekar(int number) {

        long squared = (long) number * number;
        String squaredStr = Long.toString(squared);

        String numberStr = Integer.toString(number);
        int length = numberStr.length();

        String rightPartStr = squaredStr.length() > length
                ? squaredStr.substring(squaredStr.length() - length)
                : squaredStr;
        String leftPartStr = squaredStr.length() > length
                ? squaredStr.substring(0, squaredStr.length() - length)
                : "0";

        // Convertir las partes a enteros
        int rightPart = Integer.parseInt(rightPartStr);
        int leftPart = Integer.parseInt(leftPartStr);

        return (leftPart + rightPart) == number;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        int i = 0, inputRead = 0, validar = 0, tamaño = 0, conteoNarcisistas = 0, conteoKaprekars = 0;
        Vector<Integer> vector = new Vector<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

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
                    if (validar <= 0) {
                        validar = (i == 0) ? 0 : (i--);
                        System.out.println("¡Error!, debe ingresar un número mayor a cero (0). ");

                    } else {
                        vector.add(validar);

                    }

                } else {
                    System.out.println("¡Error!, debe ingresar un número entero. ");
                    validar = (i == 0) ? 0 : (i--);
                }
            }

            System.out.println("Datos ingresados en el vector: ");
            
            for (i = 0; i < vector.size(); i++) {
                System.out.println(i + 1 + ": " + vector.get(i));
                linkedList.add(vector.get(i));
                vector.set(i, 0);
            }
            bubbleSort(vector);
            

            System.out.println("Los elementos en la linkedList son: " + linkedList);

            // Para numeros narcisistas y kaprekar
            for (Integer current : linkedList) {
                if (isNarcissist(current)) {
                    conteoNarcisistas++;
                }
                if (isKaprekar(current)) {
                    conteoKaprekars++;
                }
            }

            System.out.println("Los elementos Narcisistas: " + conteoNarcisistas +
                    "\n" + "Los elementos Kaprekar: " + conteoKaprekars);

        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer la entrada: " + e.getMessage());
        }

    }
}
