package Ejercicio2;

class Comercial extends Empleado {
    private String zonaVentas;

    public Comercial(String nombre, int horasTrabajoAsignadas, double salario, String zonaVentas) {
        super(nombre, horasTrabajoAsignadas, salario);
        this.zonaVentas = zonaVentas;
    }

    @Override
    public String realizarTareas() {
        return getNombre() + " está realizando tareas comerciales en la zona de ventas " + zonaVentas + ".";
    }

    @Override
    public String toString() {
        return super.toString() + ", Zona de ventas: " + zonaVentas;
    }

    // Getter y Setter para el atributo específico
    public String getZonaVentas() {
        return zonaVentas;
    }

    public void setZonaVentas(String zonaVentas) {
        this.zonaVentas = zonaVentas;
    }
}