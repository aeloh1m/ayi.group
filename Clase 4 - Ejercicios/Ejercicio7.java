
/*
 * Crear un programa que solicite el ingreso de un número, se deberá multiplicar dicho
número por la constante PI, luego informar el resultado.
 */
import java.io.Console;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Ejercicio7 {

    public static void main(String[] args) {
        String numeroString, numeroParseado;
        
        Console console = System.console();

        Pattern pattern = Pattern.compile("[^0-9.]");

        if (console == null) {
            System.out.println("Error al ejecutar consola.");
            return;
        }

        numeroString = console.readLine("Introduce un número a multiplicar por π : ");
        Matcher matcher = pattern.matcher(numeroString);
        numeroParseado = matcher.replaceAll("");
        System.out.println("Número introducido: " + numeroParseado);

        if (numeroParseado.contains(".")) {
            Double numeroDouble = Double.parseDouble(numeroString);
            System.out.println("Resultado: " + Math.PI * numeroDouble);
            ;
        } else {
            Integer numero = Integer.parseInt(numeroString);
            System.out.println("Resultado: " + Math.PI * numero);
            ;

        }

    }
}