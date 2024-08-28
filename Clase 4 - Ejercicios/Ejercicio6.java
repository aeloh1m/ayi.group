import java.io.Console;

class Ejercicio6 {

    public static void main(String[] args) {
        Console console = System.console();

        if (console == null) {
            System.out.println("Error al ejecutar consola.");
            return;
        }

        String texto = console.readLine("Escriba algo: ");
        System.out.println("Lo que escribió pasado a mayúsculas: " + texto.toUpperCase());

    }
}