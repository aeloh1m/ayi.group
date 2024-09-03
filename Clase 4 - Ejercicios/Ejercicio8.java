
/*
 * Realizar un programa que lea por teclado una cadena de caracteres, mostrar todas las
palabras por separado de dicha cadena (No incluir espacios)

 */
import java.io.Console;
import java.util.regex.Matcher;

public class Ejercicio8 {

    public static void main(String[] args) {
        Console console = System.console();

        if (console == null) {
            System.out.println("Error al ejecutar consola.");
            return;
        }

        String cadenaDeCaracteres = console.readLine("Introduzca palabras a separar por renglón: ");
        System.out.println("Palabras separadas: " + cadenaDeCaracteres.replace(" ", "\\n"));

    }
}