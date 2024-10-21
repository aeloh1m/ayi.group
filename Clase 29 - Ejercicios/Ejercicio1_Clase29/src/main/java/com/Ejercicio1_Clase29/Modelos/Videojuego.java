package com.Ejercicio1_Clase29.Modelos;

public class Videojuego {
    private int id;
    private String nombre;
    private String descripcion;
    private int generoId;
    private int desarrolladoraId;

    public Videojuego() {}

    public Videojuego(int id, String nombre, String descripcion, int generoId, int desarrolladoraId) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.generoId = generoId;
        this.desarrolladoraId = desarrolladoraId;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getGeneroId() {
        return generoId;
    }

    public void setGeneroId(int generoId) {
        this.generoId = generoId;
    }

    public int getDesarrolladoraId() {
        return desarrolladoraId;
    }

    public void setDesarrolladoraId(int desarrolladoraId) {
        this.desarrolladoraId = desarrolladoraId;
    }
}
