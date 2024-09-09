/*
 * Se solicita realizar un programa que solicite al usuario el ingreso de una cadena
de caracteres correspondiente a una número romano, se solicita informar de qué
número de se trata.
Recuerde la tabla de números romanos
EJERCICIOS
Ejemplo de entrada:
XX
XVII
IV
Ejemplo de salida:
20
17
4
El programa tiene que funcionar para todos los casos posibles.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ejercicio2 {
    public int romanToInt(String s) {
        Map<Character, Integer> dictionaryData = new HashMap<>();
        dictionaryData.put('I', 1);
        dictionaryData.put('V', 5);
        dictionaryData.put('X', 10);
        dictionaryData.put('L', 50);
        dictionaryData.put('C', 100);
        dictionaryData.put('D', 500);
        dictionaryData.put('M', 1000);

        Map<String, Integer> exceptions = new HashMap<>();
        exceptions.put("IV", 4);
        exceptions.put("IX", 9);
        exceptions.put("XL", 40);
        exceptions.put("XC", 90);
        exceptions.put("CD", 400);
        exceptions.put("CM", 900);

        List<String> destructuringOfNumber = new ArrayList<>();
        List<String> listToConvert = new ArrayList<>();
        List<Integer> romansToInt = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            destructuringOfNumber.add(String.valueOf(s.charAt(i)));
        }

        for (int i = 0; i < destructuringOfNumber.size(); i++) {
            if (i + 1 < destructuringOfNumber.size()) {
                String formattedNumber = destructuringOfNumber.get(i) + destructuringOfNumber.get(i + 1);
                if (exceptions.containsKey(formattedNumber)) {
                    listToConvert.add(formattedNumber);
                    destructuringOfNumber.remove(i + 1);
                } else {
                    listToConvert.add(destructuringOfNumber.get(i));
                }
            } else {
                listToConvert.add(destructuringOfNumber.get(i));
            }
        }

        Map<String, Integer> wholeData = new HashMap<>();
        for (Map.Entry<Character, Integer> entry : dictionaryData.entrySet()) {
            wholeData.put(String.valueOf(entry.getKey()), entry.getValue());
        }
        wholeData.putAll(exceptions);

        for (String item : listToConvert) {
            if (wholeData.containsKey(item)) {
                romansToInt.add(wholeData.get(item));
            }
        }

        int result = 0;
        for (int value : romansToInt) {
            result += value;
        }

        return result;
    }

    public static void main(String[] args) {
        Ejercicio2 ejercicio2 = new Ejercicio2();

        // Crear un BufferedReader para leer la entrada del usuario
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            // Solicitar al usuario que ingrese un número romano
            System.out.print("Introduce un número romano: ");
            String input = reader.readLine();

            // Llamar al método romanToInt con la entrada del usuario y mostrar el resultado
            int result = ejercicio2.romanToInt(input);
            System.out.println("El valor entero del número romano es: " + result);

        } catch (IOException e) {
            System.out.println("Error al leer la entrada del usuario.");
            e.printStackTrace();
        }
    }
}