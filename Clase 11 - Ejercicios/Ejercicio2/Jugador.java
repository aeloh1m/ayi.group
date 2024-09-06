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

public class Jugador {
    private String nombre;
    private int puntuaciones;

    public Jugador(String nombre, int puntuaciones) {
        this.nombre = nombre;
        this.puntuaciones = puntuaciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntuaciones() {
        return puntuaciones;
    }

    public void setPuntuaciones(int puntuaciones) {
        this.puntuaciones = puntuaciones;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", puntuaciones=" + puntuaciones +
                '}';
    }
}
