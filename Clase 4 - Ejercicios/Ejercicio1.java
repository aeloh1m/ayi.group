// Dado un número, descubrir si es par o impar.

public class Ejercicio1 {

    public int parImpar(int num) {

        System.out.println("'1' = Es par; '0' = No es par");

        if (num % 2 == 0) {
            return 1;
        } else {
            return 0;
        }

    }

    public static void main(String[] args) {

        Ejercicio1 instancia = new Ejercicio1();
        int num = 8;
        System.out.println("rta= " + instancia.parImpar(num));

    }
}