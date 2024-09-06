/*
 Realizar un programa de Java, en el mismo crear un vector de valores
numéricos
Se solicita:
- Realizar la carga del tamaño del vector por teclado. ok
- Realizar la carga de los números por teclado. ok
- Realizar las validaciones correspondientes. ok
- Realizar las captura de excepciones. ok
- Mostrar los datos del vector. ok
- Ordenar el vector de menor a mayor aplicando el tema ya visto. ok
- Contar la cantidad de números que son pares e impares, informar el resultado. ok
- Mostrar los datos del vector. ok
- Volver a ordenar el vector pero en forma inversa. ok
- Mostrar los datos del vector. ok
resultado.

 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Vector;

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

    public static void seleccionDirecta(Vector<Integer> vector, String ordenamientoMayorMenor) {
        int i, j, menor, pos, tmp;
        for (i = 0; i < vector.size() - 1; i++) {
            menor = vector.get(i);
            pos = i;
            for (j = i + 1; j < vector.size(); j++) {
                if (ordenamientoMayorMenor.equals("mayorAMenor")) {
                    if (vector.get(j) > menor) {
                        menor = vector.get(j);
                        pos = j;
                    }
                } else {
                    if (vector.get(j) < menor) {
                        menor = vector.get(j);
                        pos = j;
                    }
                }
            }
            tmp = vector.get(i);
            vector.set(i, menor);
            vector.set(pos, tmp);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        int i = 0, inputRead = 0, validar = 0, tamaño = 0, numPares = 0, numImpares = 0;
        Vector<Integer> vector = new Vector<>();

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

            System.out.println("Datos ingresados en el vector: " + vector);

            seleccionDirecta(vector, "menorAMayor");

            for (Integer num : vector) {
                if (num % 2 == 0) {
                    numPares++;
                } else if (num % 3 == 0) {
                    numImpares++;
                }
            }

            System.out.println("Datos ingresados en el vector tras ordenamiento de menor a mayor: " + vector);
            System.out.println("La cantidad de numeros pares es de: " + numPares + "\n" +
                    "La cantidad de numeros impares es de: " + numImpares);

            seleccionDirecta(vector, "mayorAMenor");
            System.out.println("Datos ingresados en el vector tras ordenamiento de mayor a menor: " + vector);

        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer la entrada: " + e.getMessage());
        }

    }
}
