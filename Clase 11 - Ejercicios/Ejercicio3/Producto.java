package Ejercicio3;

public class Producto {
    private String codigoEan;
    private String codigoPlu;
    private String nombre;
    private String descripcion;
    private double precio;

    public Producto(String codigoEan, String codigoPlu, String nombre, String descripcion, double precio) {
        this.codigoEan = codigoEan;
        this.codigoPlu = codigoPlu;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public String getCodigoEan() {
        return codigoEan;
    }

    public void setCodigoEan(String codigoEan) {
        this.codigoEan = codigoEan;
    }

    public String getCodigoPlu() {
        return codigoPlu;
    }

    public void setCodigoPlu(String codigoPlu) {
        this.codigoPlu = codigoPlu;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // Método toString para representar el objeto en forma de cadena
    @Override
    public String toString() {
        return "Producto{" +
                "codigoEan='" + codigoEan + '\'' +
                ", codigoPlu='" + codigoPlu + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                '}';
    }
}
