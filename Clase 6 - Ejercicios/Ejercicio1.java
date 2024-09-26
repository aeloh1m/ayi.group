/*
 * Desarrollar un programa que lea por teclado una cadena de caracteres.
Se solicita:
a) Para la lectura de datos por teclado, utilizar los flujos de entrada /
 salida (Clase BufferedReader e InputStreamReader) ok
b) Extraer las palabras del texto (BreakIterator) y guardarlas en un
 ArrayList. Excluir los espacios en blanco.
 c) Recorrer el ArrayList y verificar aquellas palabras que son
 palindromas (Aquellas palabras que se leen igual de izquierda a
 derecha).
EJERCICIOS
d) Guardar las palabras palíndromas en un LinkedList.
e) Informar la cantidad de palabras palíndromas encontradas
f) Informar la cantidad de palabras que no son palindromas
g) Eliminar dichas palabras palíndromas del ArrayLIst
h) Mostrar el tamaño del ArrayList sin utilizar la función size()
i) Limpiar el ArrayList
j) Mostrar el tamaño del LinkedList sin utilizar la función size()
EJERCICIOS
k) Limpiar el LinkedList
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.text.BreakIterator;
import java.util.Locale;

public class Ejercicio1 {

    public static void main(String[] args) throws IOException {

        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Escriba algo: ");
            String texto = entrada.readLine();
            BreakIterator breaker = BreakIterator.getWordInstance(Locale.getDefault());
            breaker.setText(texto);


        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer la entrada: " + e.getMessage());
        }

    }
}