import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MatrixExercise {
    public static void main(String[] args) {
        // Paso 1: Generar el vector de 100 números aleatorios entre 1 y 500
        List<Integer> vector = generateRandomVector(100, 1, 500);

        // Paso 2: Crear la matriz 35x11
        int rows = 35;
        int cols = 11;
        int[][] matriz = new int[rows][cols];

        // Paso 3: Llenar los primeros 100 lugares con el vector multiplicado por 3
        fillFirst100Cells(matriz, vector);

        // Paso 4: Invertir el vector y sumar pares e impares
        fillNext50Cells(matriz, vector);

        // Paso 5: Invertir los primeros 150 valores de la matriz
        fillLast150Cells(matriz);

        // Imprimir la matriz
        System.out.println("Matriz final:");
        printMatrix(matriz);
    }

    // Método para generar un vector de números aleatorios
    public static List<Integer> generateRandomVector(int size, int min, int max) {
        Random rand = new Random();
        List<Integer> vector = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            vector.add(rand.nextInt(max - min + 1) + min);
        }
        return vector;
    }

    // Método para llenar los primeros 100 lugares de la matriz
    public static void fillFirst100Cells(int[][] matriz, List<Integer> vector) {
        int index = 0;
        for (int i = 0; i < matriz.length && index < 100; i++) {
            for (int j = 0; j < matriz[i].length && index < 100; j++) {
                matriz[i][j] = vector.get(index++) * 3;
            }
        }
    }

    // Método para llenar los siguientes 50 lugares con el vector invertido
    public static void fillNext50Cells(int[][] matriz, List<Integer> vector) {
        List<Integer> reversedVector = new ArrayList<>(vector);
        Collections.reverse(reversedVector);

        int sumEven = 0;
        int sumOdd = 0;
        int index = 0;

        for (int i = 0; i < matriz.length && index < 50; i++) {
            for (int j = 0; j < matriz[i].length && index < 50; j++) {
                if (index < reversedVector.size()) {
                    matriz[i][j] = reversedVector.get(index++);
                    if (index % 2 == 0) {
                        sumEven += matriz[i][j];
                    } else {
                        sumOdd += matriz[i][j];
                    }
                } else {
                    break;
                }
            }
        }

        // Colocar las sumas en la última fila de la matriz
        int lastRow = matriz.length - 1;
        matriz[lastRow][0] = sumEven;
        if (matriz[lastRow].length > 1) {
            matriz[lastRow][1] = sumOdd;
        }
    }

    // Método para llenar los últimos 150 lugares con los primeros 150 valores invertidos
    public static void fillLast150Cells(int[][] matriz) {
        int[] first150 = new int[150];
        int index = 0;

        // Recoger los primeros 150 valores
        for (int i = 0; i < matriz.length && index < 150; i++) {
            for (int j = 0; j < matriz[i].length && index < 150; j++) {
                if (matriz[i][j] != 0) {
                    first150[index++] = matriz[i][j];
                }
            }
        }

        // Invertir los primeros 150 valores
        for (int i = 0; i < first150.length / 2; i++) {
            int temp = first150[i];
            first150[i] = first150[first150.length - 1 - i];
            first150[first150.length - 1 - i] = temp;
        }

        // Llenar los últimos 150 lugares de la matriz
        index = 0;
        for (int i = 0; i < matriz.length && index < 150; i++) {
            for (int j = 0; j < matriz[i].length && index < 150; j++) {
                if (i >= 2 && index < first150.length) {
                    matriz[i][j] = first150[index++];
                }
            }
        }
    }

    // Método para imprimir la matriz
    public static void printMatrix(int[][] matriz) {
        for (int[] row : matriz) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println(); // Nueva línea después de cada fila
        }
    }
}
