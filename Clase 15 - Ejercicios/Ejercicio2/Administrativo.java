package Ejercicio2;

class Administrativo extends Empleado {
    private String area;

    public Administrativo(String nombre, int horasTrabajoAsignadas, double salario, String area) {
        super(nombre, horasTrabajoAsignadas, salario);
        this.area = area;
    }

    @Override
    public String realizarTareas() {
        return getNombre() + " está realizando tareas administrativas en el área de " + area + ".";
    }

    @Override
    public String toString() {
        return super.toString() + ", Área: " + area;
    }

    // Getter y Setter para el atributo específico
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
