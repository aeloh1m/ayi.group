package Ejercicio3;
/*
 * Se deberá crear un proyecto de Java
Se solicita:
- Crear la clase Producto (código Ean, código PLU, nombre, descripción y
precio).
- Cargar por teclado el tamaño del vector.
- Generar las validaciones correspondientes.
- Cargar los datos de los Productos.
- Guardar cada uno de los Productos en un vector.
- Mostrar los datos del vector.
- Ordenar el vector aplicando el método de ordenamiento por selección
directa.
- Mostrar los datos del vector ordenado.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Vector;
import java.util.Comparator;

public class Ejercicio3 {

    public static void seleccionDirecta(Vector<Producto> vector, String ordenamiento) {
        Comparator<Producto> comparador;
        if (ordenamiento.equals("mayorAMenor")) {
            comparador = (p1, p2) -> Double.compare(p2.getPrecio(), p1.getPrecio()); // Orden descendente
        } else {
            comparador = (p1, p2) -> Double.compare(p1.getPrecio(), p2.getPrecio()); // Orden ascendente
        }

        for (int i = 0; i < vector.size() - 1; i++) {
            Producto seleccionado = vector.get(i);
            int pos = i;

            for (int j = i + 1; j < vector.size(); j++) {
                Producto actual = vector.get(j);
                if (comparador.compare(actual, seleccionado) < 0) {
                    seleccionado = actual;
                    pos = j;
                }
            }

            // Intercambiar elementos
            Producto tmp = vector.get(i);
            vector.set(i, vector.get(pos));
            vector.set(pos, tmp);
        }
    }

    public static void main(String[] args) throws IOException {
        String codigoEan,
                codigoPlu,
                nombre,
                descripcion;
        int i, tamaño;
        double precio;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        Vector<Producto> productos = new Vector<>();

        try {
            // Cargar tamaño del vector
            System.out.print("Ingrese el tamaño del vector de productos: ");
            tamaño = Integer.parseInt(entrada.readLine());

            if (tamaño <= 0) {
                System.out.println("El tamaño debe ser un número positivo.");
                return;
            }

            // Cargar datos de los productos
            for (i = 0; i < tamaño; i++) {
                System.out.println("Ingrese los datos del producto " + (i + 1) + ":");

                System.out.print("Código EAN: ");
                codigoEan = entrada.readLine();

                System.out.print("Código PLU: ");
                codigoPlu = entrada.readLine();

                System.out.print("Nombre: ");
                nombre = entrada.readLine();

                System.out.print("Descripción: ");
                descripcion = entrada.readLine();

                System.out.print("Precio: ");
                precio = Double.parseDouble(entrada.readLine());

                Producto producto = new Producto(codigoEan, codigoPlu, nombre, descripcion, precio);
                productos.add(producto);
            }

            // Mostrar datos del vector
            System.out.println("\nDatos del vector:");
            for (Producto producto : productos) {
                System.out.println(producto);
            }

            // Ordenar el vector usando el método de selección directa
            seleccionDirecta(productos, "mayorA menor");

            // Mostrar datos del vector ordenado
            System.out.println("\nDatos del vector ordenado por precio:");
            for (Producto producto : productos) {
                System.out.println(producto);
            }
        } catch (IOException e) {
            System.out.println("Error en la entrada de datos: " + e.getMessage());
        }

    }
}
