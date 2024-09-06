package Ejercicio4;

public class Administrativo implements Servicio {
    private String legajo;
    private String nombre;
    private String departamento;

    // Constructor
    public Administrativo(String legajo, String nombre, String departamento) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.departamento = departamento;
    }

    // Getters y Setters
    public String getLegajo() {
        return legajo;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public void atender() {
        System.out.println("Administrativo " + nombre + " está gestionando tareas del departamento: " + departamento);
    }

    @Override
    public String reportar() {
        return "Administrativo: " + nombre + ", Legajo: " + legajo + ", Departamento: " + departamento;
    }

    @Override
    public String toString() {
        return reportar();
    }
}
