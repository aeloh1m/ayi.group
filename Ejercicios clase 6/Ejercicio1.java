
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Locale;

class Ejercicio1 {

    public static void main(String[] args) {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> palabras = new ArrayList<>();
        LinkedList<String> palabrasPalindromas = new LinkedList<>();
        String entradaUsuario = "", esPalindroma = "";

        try {
            System.out.println("Introduce una línea de texto:");

            entradaUsuario = lector.readLine();

            System.out.println("La línea que introdujiste es: " + entradaUsuario);

            BreakIterator iterador = BreakIterator.getWordInstance(Locale.getDefault());

            iterador.setText(entradaUsuario);

            int inicio = iterador.first();
            int fin = iterador.next();

            while (fin != BreakIterator.DONE) {
                String palabra = entradaUsuario.substring(inicio, fin).trim();
                if (!palabra.isEmpty() && Character.isLetterOrDigit(palabra.charAt(0))) {
                    palabras.add(palabra);
                    System.out.println(palabra + " words");
                    for (int i = palabra.length() - 1; i >= 0; i--) { //Verificar Capicúa
                        esPalindroma += palabra.charAt(i);

                    }
                    if (esPalindroma.equals(palabra)) {
                        System.out.println("Es palindroma: " + esPalindroma);
                        palabrasPalindromas.add(esPalindroma);
                    }
                    esPalindroma = "";

                }
                inicio = fin;
                fin = iterador.next();
            }

            System.out.println("Palabras extraídas:");
            for (String palabra : palabras) {
                System.out.println(palabra);

            }
            System.out.println("Palabras extraídas palíndromas:");
            for (String palabra : palabrasPalindromas) {
                System.out.println(palabra);

            }
        } catch (IOException e) {
            System.err.println("Error al leer la entrada: " + e.getMessage());
        } finally {
            try {
                // Cerrar el BufferedReader
                lector.close();
            } catch (IOException e) {
                System.err.println("Error al cerrar el BufferedReader: " + e.getMessage());
            }
        }

    }
}
