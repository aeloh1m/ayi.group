package com.example.modelos;

import java.util.Date;

public class Proyecto {
    private int idProyecto;       // id_proyecto
    private String nombreProyecto; // nombre_proyecto
    private Date fechaInicio;      // fecha_inicio

    // Constructor
    public Proyecto(int idProyecto, String nombreProyecto, Date fechaInicio) {
        this.idProyecto = idProyecto;
        this.nombreProyecto = nombreProyecto;
        this.fechaInicio = fechaInicio;
    }

    // Getters and Setters
    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
}
