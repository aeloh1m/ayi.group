

public class Inscripcion {
    private int idInscripcion;
    private int socioId;
    private int actividadId;
    private Date fechaInscripcion;

    // Constructor
    public Inscripcion(int idInscripcion, int socioId, int actividadId, Date fechaInscripcion) {
        this.idInscripcion = idInscripcion;
        this.socioId = socioId;
        this.actividadId = actividadId;
        this.fechaInscripcion = fechaInscripcion;
    }

    // Getters y Setters
    public int getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public int getSocioId() {
        return socioId;
    }

    public void setSocioId(int socioId) {
        this.socioId = socioId;
    }

    public int getActividadId() {
        return actividadId;
    }

    public void setActividadId(int actividadId) {
        this.actividadId = actividadId;
    }

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }
}
