package Ejercicio2;

abstract class Empleado {
    private String nombre;
    private int horasTrabajoAsignadas;
    private double salario;

    public Empleado(String nombre, int horasTrabajoAsignadas, double salario) {
        this.nombre = nombre;
        this.horasTrabajoAsignadas = horasTrabajoAsignadas;
        this.salario = salario;
    }

    public abstract String realizarTareas();

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Horas: " + horasTrabajoAsignadas + ", Salario: " + salario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHorasTrabajoAsignadas() {
        return horasTrabajoAsignadas;
    }

    public void setHorasTrabajoAsignadas(int horasTrabajoAsignadas) {
        this.horasTrabajoAsignadas = horasTrabajoAsignadas;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}



