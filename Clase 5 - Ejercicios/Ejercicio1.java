/*
 * Se tiene un vector de tamaño 100 de números aleatorios (Valores entre 1 y
500)
Se solicita:
● Crear una matriz 35x11
● En la matriz, en los primeros 100 lugares, guardar los datos del vector
multiplicado por 3.
● En los siguientes 50 lugares, agregar los datos del vector en forma
inversa y sumando las posiciones pares con las impares, agregar dicho
resultado a la matriz.
● En los últimos 150 lugares, agregar los primeros 150 celdas de la matriz
pero en forma invertida.
 * 
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Random;

class Ejercicio1 {





    public int matrix(int num) {

        int[][] matriz = new int[35][11];
        List<Integer> arrayRandoms = new ArrayList<>(100),
         siguientes50Lugares = new ArrayList<>(50);
          
        int i, j, k, filas = matriz.length, columnas = matriz[0].length, ultimaColumna = matriz.length -1, recorrerMatriz = 0, sumarPar = 0, sumarImpar = 0;


        // Crear Array con números randoms
        Random random = new Random();

        for (k = 0; k < 100; k++) {
            int numeroRandom = random.nextInt(500) + 1;  // Número random del 1 al 500
            arrayRandoms.add(numeroRandom);
        }

        // Añadir números randoms
        for(i = 0; i < filas; i++)
        {
            for(j = 0; j < columnas; j++ )
            {
                if(recorrerMatriz < arrayRandoms.size())
                {

                    matriz[i][j] = arrayRandoms.get(recorrerMatriz++) * 3;
                }
                else{
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

        for(i = 50; i < filas; i++)
        {
            for(j = 50; j < matriz[i].length; j++ )
            {
                if(recorrerMatriz < arrayRandoms.size())
                {
                    if (i % 2 == 0) {
                        sumarPar += arrayRandoms.get(i);
                    } else {
                        sumarImpar += arrayRandoms.get(i);
                    }

                    matriz[ultimaColumna][0] = sumarPar;
                if (matriz[ultimaColumna].length > 1) {
                matriz[ultimaColumna][1] = sumarImpar;
                }
                }
                else{
                    break;
                }

            }
        }

        // Añadir pares e impares

        // for (i = 0; i < siguientes50Lugares.size(); i++)
        // {
        //     siguientes50Lugares.add()
        // }

        // for(i = 0; i < filas; i++)
        // {
        //     for(j = 0; j < columnas; j++ )
        //     {
        //         matriz[ultimaColumna][0] = sumarPar;
        //         if (matriz[ultimaColumna].length > 1) {
        //         matriz[ultimaColumna][1] = sumarImpar;
        //         }

        //     }
        // }



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