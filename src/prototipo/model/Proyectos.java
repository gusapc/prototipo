package prototipo.model;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author GusAPC
 */
public class Proyectos {
    private String nombre;
    private Long ID;
    private String descripcion;
    private Double costo;

    public Proyectos(){}
    
    public Proyectos(String nombre, Long ID, String descripcion, Double costo){
        this.nombre = nombre;
        this.ID = ID;
        this.descripcion = descripcion;
        this.costo = costo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }
}
