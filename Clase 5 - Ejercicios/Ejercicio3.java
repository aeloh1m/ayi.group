/*
 * ) Se solicita realizar un programa que lea por teclado un número entero
 * (Rango
 * entre 1 y 5000) y devuelva el mismo número pero en romano
 * EJERCICIOS
 * Ejemplo de entrada:
 * 3
 * 77
 * 1002
 * Ejemplo de salida
 * III
 * LXXVII
 * MII
 * El programa tiene que funcionar para todos los casos posibles en el
 * rango dado.
 */

 import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class Ejercicio3 {
    // Método para converti3 un número entero a un número romano
    public String intToRoman(int num) {
        // Mapa de valores romanos y sus símbolos
        Map<Integer, String> romanMap = new LinkedHashMap<>();
        romanMap.put(1000, "M");
        romanMap.put(900, "CM");
        romanMap.put(500, "D");
        romanMap.put(400, "CD");
        romanMap.put(100, "C");
        romanMap.put(90, "XC");
        romanMap.put(50, "L");
        romanMap.put(40, "XL");
        romanMap.put(10, "X");
        romanMap.put(9, "IX");
        romanMap.put(5, "V");
        romanMap.put(4, "IV");
        romanMap.put(1, "I");

        StringBuilder roman = new StringBuilder();

        // Convertir el número entero a romano
        for (Map.Entry<Integer, String> entry : romanMap.entrySet()) {
            int value = entry.getKey();
            String symbol = entry.getValue();

            while (num >= value) {
                roman.append(symbol);
                num -= value;
            }
        }

        return roman.toString();
    }

    public static void main(String[] args) {
        Ejercicio3 ejercicio3 = new Ejercicio3();

        // Crear un BufferedReader para leer la entrada del usuario
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            // Solicitar al usuario que ingrese un número entero
            System.out.print("Introduce un número entero: ");
            int input = Integer.parseInt(reader.readLine());

            // Verificar que el número esté en el rango válido para números romanos
            if (input < 1 || input > 3999) {
                System.out.println("Por favor, introduce un número entre 1 y 3999.");
            } else {
                // Llamar al método intToRoman con la entrada del usuario y mostrar el resultado
                String result = ejercicio3.intToRoman(input);
                System.out.println("El número romano es: " + result);
            }

        } catch (IOException e) {
            System.out.println("Error al leer la entrada del usuario.");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Por favor, introduce un número entero válido.");
        }
    }
}
