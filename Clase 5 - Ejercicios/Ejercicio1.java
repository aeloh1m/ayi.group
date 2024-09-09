/*
 * Se tiene un vector de tamaño 100 de números aleatorios (Valores entre 1 y
500) ok
Se solicita:
● Crear una matriz 35x11 ok
● En la matriz, en los primeros 100 lugares, guardar los datos del vector
multiplicado por 3. ok
● En los siguientes 50 lugares, agregar los datos del vector en forma
inversa y sumando las posiciones pares con las impares, agregar dicho
resultado a la matriz. 
● En los últimos 150 lugares, agregar los primeros 150 celdas de la matriz
pero en forma invertida.
 * 
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Ejercicio1 {

    public int matrix(int num) {

        int[][] matriz = new int[35][11];
        int[] primeros150 = new int[150];

        List<Integer> arrayRandoms = new ArrayList<>(100),
                siguientes50Lugares = new ArrayList<>(50);

        int i, j, k, temp = 0, index = 0, filas = matriz.length, columnas = matriz[0].length,
                ultimaColumna = matriz.length - 1,
                recorrerMatriz = 0, sumarPar = 0, sumarImpar = 0;

        // Crear Array con números randoms
        Random random = new Random();

        for (k = 0; k < 100; k++) {
            int numeroRandom = random.nextInt(500) + 1; // Número random del 1 al 500
            arrayRandoms.add(numeroRandom);
        }

        // Añadir números randoms
        for (i = 0; i < filas; i++) {
            for (j = 0; j < columnas; j++) {
                if (recorrerMatriz < arrayRandoms.size()) {

                    matriz[i][j] = arrayRandoms.get(recorrerMatriz++) * 3; // multiplicar datos por 3
                } else {
                    break;
                }

            }
        }

        // Sumar par e impar
        for (i = 0; i < siguientes50Lugares.size() - arrayRandoms.size(); i++) {
            if (i % 2 == 0) {
                sumarPar += arrayRandoms.get(i);
            } else {
                sumarImpar += arrayRandoms.get(i);
            }
        }

        for (i = 50; i < filas; i++) {
            for (j = 50; j < matriz[i].length; j++) {
                if (recorrerMatriz < arrayRandoms.size()) {
                    if (i % 2 == 0) {
                        sumarPar += arrayRandoms.get(i);
                    } else {
                        sumarImpar += arrayRandoms.get(i);
                    }

                    matriz[ultimaColumna][0] = sumarPar;
                    if (matriz[ultimaColumna].length > 1) {
                        matriz[ultimaColumna][1] = sumarImpar;
                    }
                } else {
                    break;
                }

            }
        }

        matriz[ultimaColumna][0] = sumarPar;
        if (matriz[ultimaColumna].length > 1) {
            matriz[ultimaColumna][1] = sumarImpar;
        }

        // Recoger los primeros 150 valores
        for (i = 0; i < matriz.length && index < 150; i++) {
            for (j = 0; j < matriz[i].length && index < 150; j++) {
                if (matriz[i][j] != 0) {
                    primeros150[index++] = matriz[i][j];
                }
            }
        }

        // Invertir los primeros 150 valores
        for (i = 0; i < primeros150.length / 2; i++) {
            temp = primeros150[i];
            primeros150[i] = primeros150[primeros150.length - 1 - i];
            primeros150[primeros150.length - 1 - i] = temp;
        }

        // Llenar los últimos 150 lugares de la matriz
        index = 0;
        for (i = 0; i < matriz.length && index < 150; i++) {
            for (j = 0; j < matriz[i].length && index < 150; j++) {
                if (i >= 2 && index < primeros150.length) {
                    matriz[i][j] = primeros150[index++];
                }
            }
        }

        for (int[] row : matriz) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println(); // Salto de línea después de cada fila
        }

        return 0;

    }

    public static void main(String[] args) {

        Ejercicio1 instancia = new Ejercicio1();
        int num = 8;
        System.out.println("rta= " + instancia.matrix(num));

    }
}