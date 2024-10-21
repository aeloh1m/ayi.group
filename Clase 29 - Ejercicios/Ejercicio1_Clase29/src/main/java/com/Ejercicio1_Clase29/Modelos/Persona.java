package com.Ejercicio1_Clase29.Modelos;


public class Persona {
    private int numeroDocumento;
    private String nombre;
    private String apellido;
    private int ciudadReside;  // Referencia a la ciudad
    private int provinciaReside; // Referencia a la provincia
    public Persona() {}

    public Persona(int numeroDocumento, String nombre, String apellido, int ciudadReside, int provinciaReside) {
        this.numeroDocumento = numeroDocumento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.ciudadReside = ciudadReside;
        this.provinciaReside = provinciaReside;
    }

    // Getters y Setters
    public int getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(int numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getCiudadReside() {
        return ciudadReside;
    }

    public void setCiudadReside(int ciudadReside) {
        this.ciudadReside = ciudadReside;
    }

    public int getProvinciaReside() {
        return provinciaReside;
    }

    public void setProvinciaReside(int provinciaReside) {
        this.provinciaReside = provinciaReside;
    }
}
