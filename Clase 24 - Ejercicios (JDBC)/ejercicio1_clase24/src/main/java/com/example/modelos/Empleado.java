package com.example.modelos;

public class Empleado {
    private int idEmpleado;   // id_empleado
    private String nombreEmpleado; // nombre_empleado
    private Integer idTarea;  // Optional: FK to tareas (if applicable)

    // Constructor
    public Empleado(int idEmpleado, String nombreEmpleado, Integer idTarea) {
        this.idEmpleado = idEmpleado;
        this.nombreEmpleado = nombreEmpleado;
        this.idTarea = idTarea;
    }

    // Getters and Setters
    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public Integer getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(Integer idTarea) {
        this.idTarea = idTarea;
    }
}
