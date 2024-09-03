
/*

Leer una cadena de caracteres desde las clases BufferedReader e InputStreamReader
y luego mostrar dicha cadena hasta la mitad.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Ejercicio5 {

    public static void main(String[] args) throws IOException {

        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.print("Escriba algo: ");
            String texto = entrada.readLine();
            System.out.println("Mitad de lo escrito introducido: " + texto.substring(0, texto.length() / 2));

        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer la entrada: " + e.getMessage());
        }

    }
}
