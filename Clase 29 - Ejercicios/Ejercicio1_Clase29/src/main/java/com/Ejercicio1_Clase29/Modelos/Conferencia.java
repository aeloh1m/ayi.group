package com.Ejercicio1_Clase29.Modelos;

import java.util.Date;

public class Conferencia {
    private int id;
    private int expositoraId;
    private String tematica;
    private Date fechaHora;
    private int duracion; // Duración en minutos

    public Conferencia() {}

    public Conferencia(int id, int expositoraId, String tematica, Date fechaHora, int duracion) {
        this.id = id;
        this.expositoraId = expositoraId;
        this.tematica = tematica;
        this.fechaHora = fechaHora;
        this.duracion = duracion;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getExpositoraId() {
        return expositoraId;
    }

    public void setExpositoraId(int expositoraId) {
        this.expositoraId = expositoraId;
    }

    public String getTematica() {
        return tematica;
    }

    public void setTematica(String tematica) {
        this.tematica = tematica;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
}
