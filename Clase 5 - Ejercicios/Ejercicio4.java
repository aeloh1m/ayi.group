/*
 * Realizar un programa que lea dos cadenas de caracteres ingresada por
teclado.
Se solicita:
- Verificar que en cada una de las cadenas ingresadas, haya valores numéricos. En
caso de que una cadena no contenga un valor numérico, solicitar el ingreso de la
misma nuevamente.
- De preferencia utilizar para la lectura de datos por teclado la clase
BufferedReader.
- Extraer los valores numéricos de cada una de las cadenas. (Se
deben extraer todos juntos, uno a continuación del otro).
EJERCICIOS
Por ejemplo:
“El número 1 más el número 2 es igual al número 3, y si le restamos el número
1, quedaría como resultado el número 2”
Extracción:
12312
- Verificar si los valores numéricos extraídos de las cadenas son narcisistas
(Número que es igual a la suma de sus dígitos cada uno elevado a la potencia de
la cantidad de dígitos en el número).
EJERCICIOS
Por ejemplo:
153
1^3 + 5^3 + 3^3 = 1 + 125 + 27 = 153
- Si son narcisistas, sumar dichos números e informar su resultado.
- Si no son narcisistas, informar con un mensaje.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Ejercicio4 {
    public static void verificarCadena(String input) throws IllegalArgumentException {
        boolean contieneNumero = false;

        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                contieneNumero = true;
                break;
            }
        }

        if (!contieneNumero) {
            throw new IllegalArgumentException("Las cadenas deben contener al menos un número cada una.");
        }
    }

    public static String extraerNumeros(String input) {
        StringBuilder numerosExtraidos = new StringBuilder();
        StringBuilder numeroTemporal = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                numeroTemporal.append(c);
            } else {
                if (numeroTemporal.length() > 0) {
                    numerosExtraidos.append(numeroTemporal);
                    numeroTemporal.setLength(0); // Resetea el número temporal
                }
            }
        }

        if (numeroTemporal.length() > 0) {
            numerosExtraidos.append(numeroTemporal);
        }

        return numerosExtraidos.toString();
    }

    public static boolean esNarcicista(int numero) {
        double suma = 0;
        String numeroParseado = "";
        char indexDe;

        numeroParseado = Integer.toString(numero);

        for (int i = 0; i < numeroParseado.length(); i++) {
            indexDe = numeroParseado.charAt(i); // Toma individualmente cada número y va parseando entre tipos
            int digit = Character.getNumericValue(indexDe);
            suma += Math.pow(digit, numeroParseado.length());
        }

        if (numero == suma) {
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) throws IOException {
        String cadenasConcatenadas = "";
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.print("Escriba la primer cadena: ");
            String cadenaUno = entrada.readLine();
            System.out.print("Escriba la segunda cadena: ");
            String cadenaDos = entrada.readLine();

            try {
                verificarCadena(cadenaUno);
                verificarCadena(cadenaDos);
                cadenasConcatenadas = cadenaUno.concat(cadenaDos);
                System.out.println("Extracción: " + extraerNumeros(cadenasConcatenadas));

                if (esNarcicista(Integer.parseInt(extraerNumeros(cadenasConcatenadas)))) {
                    System.out.println("La suma da como resultado un número narcicista y es: "
                            + Integer.parseInt(extraerNumeros(cadenasConcatenadas)));
                } else {
                    System.out.println("Los números extraídos no son narcisistas.");
                }

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer la entrada: " + e.getMessage());
        }

    }
}
