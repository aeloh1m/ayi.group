package Ejercicio1;

public class ClaseThreadSumaVectores extends Thread {

    private int[] vector1;
    private int[] vector2;
    private int[] resultado;
    private int inicio;
    private int fin;

    // Constructor
    public ClaseThreadSumaVectores(String nombre, int[] vector1, int[] vector2, int[] resultado, int inicio, int fin) {
        super(nombre);
        this.vector1 = vector1;
        this.vector2 = vector2;
        this.resultado = resultado;
        this.inicio = inicio;
        this.fin = fin;
    }

    @Override
    public void run() {
        for (int i = inicio; i < fin; i++) {
            if (i < vector1.length && i < vector2.length && i < resultado.length) {
                resultado[i] = vector1[i] + vector2[i];
            } else {
                System.out.println("Índice fuera de los límites: " + i);
            }
        }
    }
}
