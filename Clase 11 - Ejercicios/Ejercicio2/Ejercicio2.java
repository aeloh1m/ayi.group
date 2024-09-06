package Ejercicio2;

/*
 *  Se tiene un HashMap donde las claves son los nombres y los valores son las
puntuaciones en un juego.
Se solicita:
- Crear un objeto Jugadores con los atributos (nombre y puntuaciones)
- Cargar datos de los objetos por teclado.
- Asignar los datos de cada objeto en un HashMap.
- De preferencia utilizar la clase BufferedReader para la carga de datos
por teclado.
- Crear un ArrayList que contenga todos los nombres de los jugadores.
- Crear un LinkedList con los datos de todos los jugadores que tengan
letras vocales en sus nombres.
- Mostrar los datos del ArrayList y del LinkedList
 */
import java.util.HashMap;
import java.util.ArrayList;
import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Ejercicio2 {

    public static LinkedList<Jugador> cargarJugadoresVocales(HashMap<String, Integer> jugadores) {
        LinkedList<Jugador> jugadoresVocales = new LinkedList<>();
        for (String nombre : jugadores.keySet()) {
            if (nombre.matches(".*[aeiouAEIOU].*")) {
                Jugador jugador = new Jugador(nombre, jugadores.get(nombre));
                jugadoresVocales.add(jugador);
            }
        }
        return jugadoresVocales;
    }

    public static void main(String[] args) throws IOException {

        int i;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> jugadores = new HashMap<>();
        ArrayList<String> nombres = new ArrayList<>();
        LinkedList<Jugador> jugadoresVocales = new LinkedList<>();

        try {
            System.out.print("Ingrese el tamaño para la cantidad de jugadores: ");

            String input = entrada.readLine();

            Integer.parseInt(input);
            for (i = 0; i < Integer.parseInt(input); i++) {
                System.out.print("Ingrese el nombre del jugador " + i + ":");
                String nombre = entrada.readLine();
                System.out.print("Ingrese la puntuación del jugador " + i + ":");
                String puntuacion = entrada.readLine();
                jugadores.put(nombre, Integer.parseInt(puntuacion));
                nombres.add(nombre);
            }
            jugadoresVocales = cargarJugadoresVocales(jugadores);
            System.out.print("Datos del ArrayList (nombres de los jugadores): " + nombres + "\n" +
                    "Datos del LinkedList (jugadores que tengan letras vocales en sus nombres): " + jugadoresVocales);

        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer la entrada: " + e.getMessage());
        }

    }

}
