/*Realizar un programa de Java que cargue por teclado datos numéricos en
un vector, el tamaño del vector debe ser ingresado por teclado también.
Solicitar el ingreso de un numero, realizar la búsqueda secuencial dentro del
arreglo, informar si el numero esta dentro del vector.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Vector;
import java.util.Random;

public class Ejercicio2 {

    public static void main(String[] args) throws IOException {

        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        Random random = new Random();


        try {
            System.out.print("Ingrese tamaño del vector: ");
            String input = entrada.readLine();
            int number = Integer.parseInt(input);
            Vector<Integer> vector = new Vector<>(number);

            int i = 0, randomNumber = 0, min = 1, max = 100;
            
            // Add random numbers to the Vector
            for (i = 0; i < number; i++) {
                // Generate a random integer between min (inclusive) and max (exclusive)
                randomNumber = random.nextInt(max - min) + min;
                vector.add(randomNumber);
            }

            System.out.print("Ingrese número a buscar dentro: ");
            String inputNumero = entrada.readLine();
            number = Integer.parseInt(inputNumero);

            for(Object num : vector)
            {
                System.out.println(num);

            }

        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer la entrada: " + e.getMessage());
        }

    }
}
