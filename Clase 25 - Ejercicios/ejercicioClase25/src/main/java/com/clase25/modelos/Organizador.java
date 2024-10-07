package com.clase25.modelos;

public class Organizador {
    private int id;
    private String nombre;
    private String contacto;
    private String descOrganizacion;
    private Integer idEvento; // Puede ser null si no hay evento

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

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getDescOrganizacion() {
        return descOrganizacion;
    }

    public void setDescOrganizacion(String descOrganizacion) {
        this.descOrganizacion = descOrganizacion;
    }

    public Integer getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Integer idEvento) {
        this.idEvento = idEvento;
    }
}
