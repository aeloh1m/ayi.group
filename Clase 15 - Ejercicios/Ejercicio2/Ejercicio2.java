package Ejercicio2;

/*
 * Realizar un proyecto de Java con Herencia, Polimorfismo e Hilos.
Se solicita:
- Crear clases Empleado (Atributos: nombre, horas de trabajo asignadas,
salario)
- Crear la clase Administrativo (Atributo: área)
- Crear la clase Comercial (Atributo: zona de ventas)
- Todas las clases deben tener un método declarado con el siguiente
nombre: realizarTareas(), en cada clase se deberá redefinir dicho
método.
- Utilizar hilos para cargar los datos de los empleados y para gestionar la
realización de tareas.
 */

public class Ejercicio2 extends Thread {

    public Ejercicio2() {
        super();

    }

    @Override
    public void run() {
        Administrativo admin = new Administrativo("Carlos", 40, 2500, "Recursos Humanos");
        Comercial comercial = new Comercial("Ana", 35, 3000, "Noroeste");

        System.out.println(admin);
        System.out.println(admin.realizarTareas());

        System.out.println(comercial);
        System.out.println(comercial.realizarTareas());

    }

    public static void main(String[] args) {

        Ejercicio2 hilo1 = new Ejercicio2();

        // Iniciar los hilos
        hilo1.start();

        // Crear y comenzar los hilos

        try {
            hilo1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Los datos y gestión de tareas han sido manejados correctamente a través de un hilo.");

    }

}
