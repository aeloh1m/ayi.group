
// Dado dos números enteros aleatorios, descubrir el mayor número.
import java.util.Random;
import java.lang.Math;

class Ejercicio2 {

    public static void main(String[] args) {
        Random random = new Random();
        int numeroAleatorio = random.nextInt(100);
        int numeroAleatorio2 = random.nextInt(100);

        System.out.println("El número mayor entre " + numeroAleatorio + " y " + numeroAleatorio2
                + " es: " + Math.max(numeroAleatorio, numeroAleatorio2));

    }
}