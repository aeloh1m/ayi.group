package Ejercicio1;

/*
 * Realizar un programa de Java que cargue dos vectores con valores numéricos y realice la suma de ellos utilizando hilos.

Se solicita:
El tamaño de los vectores debe ser ingresado por teclado (Debe ser el mismo para ambos).
Los datos de ambos vectores deben ser cargados por teclado.
La suma de ambos vectores debe implementarse utilizando hilos.
El resultado de la suma de ambos vectores debe guardarse en un nuevo vector.
Para realizar la suma de ambos vectores se debe sumar la misma celda de cada uno de ellos, y ese resultado guardarlo en el vector.
Ordenar el vector resultante (Se puede utilizar cualquier metodo).

 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Ejercicio1 {

    public static int[] cargarDatos(int tamañoVector, String numVec) throws IOException {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        int[] vector = new int[tamañoVector];
        for (int i = 0; i < tamañoVector; i++) {
            System.out.print("Ingrese el valor para la posición " + (i + 1) + " del vector "+ numVec + ": ");
            String input = entrada.readLine();
            vector[i] = Integer.parseInt(input);
        }
        return vector;
    }

    public static void main(String[] args) {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        int tamañoVector = 0;

        try {
            System.out.print("Ingrese el tamaño para ambos vectores: ");
            String input = entrada.readLine();
            tamañoVector = Integer.parseInt(input);

            int[] vector1 = cargarDatos(tamañoVector, "1");
            int[] vector2 = cargarDatos(tamañoVector, "2");
            int[] resultado = new int[tamañoVector];

            // Número de hilos a utilizar
            int numHilos = 1; 
            int tamañoSegmento = tamañoVector / numHilos;

            // Crear y comenzar los hilos
            Thread[] hilos = new Thread[numHilos];
            for (int i = 0; i < numHilos; i++) {
                int inicio = i * tamañoSegmento;
                int fin = (i == numHilos - 1) ? tamañoVector : inicio + tamañoSegmento;
                hilos[i] = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int j = inicio; j < fin; j++) {
                            resultado[j] = vector1[j] + vector2[j];
                        }
                    }
                });
                hilos[i].start();
            }

            for (Thread hilo : hilos) {
                try {
                    hilo.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // Ordenar el vector resultante
            Arrays.sort(resultado);

            System.out.println("Resultado de la suma de los vectores:");
            for (int num : resultado) {
                System.out.print(num + " ");
            }
            System.out.println();

        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer la entrada: " + e.getMessage());
        }
    }
}
