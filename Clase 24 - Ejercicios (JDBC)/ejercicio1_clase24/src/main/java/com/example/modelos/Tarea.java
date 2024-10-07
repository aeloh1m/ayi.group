package com.example.modelos;

public class Tarea {
    private int idTarea;      
    private boolean estadoTarea; 
    private String descripcion; 

    public Tarea(int idTarea, boolean estadoTarea, String descripcion) {
        this.idTarea = idTarea;
        this.estadoTarea = estadoTarea;
        this.descripcion = descripcion;
    }

    public int getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(int idTarea) {
        this.idTarea = idTarea;
    }

    public boolean isEstadoTarea() {
        return estadoTarea;
    }

    public void setEstadoTarea(boolean estadoTarea) {
        this.estadoTarea = estadoTarea;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
