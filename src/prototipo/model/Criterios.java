package prototipo.model;

/**
 *
 * @author GusAPC
 */
public class Criterios {
    private int ID;
    private String nombre;
    private Boolean tipo;
    private Boolean mejor;
    private int ponderacion;
    private Boolean defaul;

    public Criterios(){}
    public Criterios(int ID, String nombre, Boolean tipo, Boolean mejor, int ponderacion, Boolean defaul){
        this.ID = ID;
        this.nombre = nombre;
        this.mejor = mejor;
        this.ponderacion = ponderacion;
        this.tipo = tipo;
        this.defaul = defaul;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getTipo() {
        return tipo;
    }

    public void setTipo(Boolean tipo) {
        this.tipo = tipo;
    }

    public int getPonderacion() {
        return ponderacion;
    }

    public void setPonderacion(int ponderacion) {
        this.ponderacion = ponderacion;
    }

    public Boolean getMejor() {
        return mejor;
    }

    public void setMejor(Boolean mejor) {
        this.mejor = mejor;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Boolean getDefaul() {
        return defaul;
    }
    
    public void setDefaul(Boolean defaul) {
        this.defaul = defaul;
    }
    
}
