package com.Ejercicio1_Clase29.Modelos;

public class Stand {
    private int codigo;
    private int videojuegoId;
    private int expositorId;
    private int sectorId;
    private String dimensiones;

    public Stand() {
    }

    public Stand(int codigo, int videojuegoId, int expositorId, int sectorId, String dimensiones) {
        this.codigo = codigo;
        this.videojuegoId = videojuegoId;
        this.expositorId = expositorId;
        this.sectorId = sectorId;
        this.dimensiones = dimensiones;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getVideojuegoId() {
        return videojuegoId;
    }

    public void setVideojuegoId(int videojuegoId) {
        this.videojuegoId = videojuegoId;
    }

    public int getExpositorId() {
        return expositorId;
    }

    public void setExpositorId(int expositorId) {
        this.expositorId = expositorId;
    }

    public int getSectorId() {
        return sectorId;
    }

    public void setSectorId(int sectorId) {
        this.sectorId = sectorId;
    }

    public String getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
    }
}
