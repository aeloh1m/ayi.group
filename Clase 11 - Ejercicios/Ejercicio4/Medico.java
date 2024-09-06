package Ejercicio4;

public class Medico implements Servicio {
    private String nombre;
    private String especialidad;
    private String nroMatricula;

    // Constructor
    public Medico(String nombre, String especialidad, String nroMatricula) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.nroMatricula = nroMatricula;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getNroMatricula() {
        return nroMatricula;
    }

    public void setNroMatricula(String nroMatricula) {
        this.nroMatricula = nroMatricula;
    }

    @Override
    public void atender() {
        System.out.println("Médico " + nombre + " está atendiendo en su especialidad: " + especialidad);
    }

    @Override
    public String reportar() {
        return "Médico: " + nombre + ", Especialidad: " + especialidad + ", Matrícula: " + nroMatricula;
    }

    @Override
    public String toString() {
        return reportar();
    }
}
