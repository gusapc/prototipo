package prototipo.model;

/**
 *
 * @author GusAPC
 */
public class CriterioHasProyecto {
    private long idProyecto;
    private long idCriterio;
    private String valor;
    private long calificacion;

    public CriterioHasProyecto(){}
    
    public CriterioHasProyecto(long idProyecto, long idCriterio, String valor){
        this.idProyecto = idProyecto;
        this.idCriterio = idCriterio;
        this.valor = valor;
    }

    public long getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(long idProyecto) {
        this.idProyecto = idProyecto;
    }

    public long getIdCriterio() {
        return idCriterio;
    }

    public void setIdCriterio(long idCriterio) {
        this.idCriterio = idCriterio;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    /**
     * @return the calificacion
     */
    public long getCalificacion() {
        return calificacion;
    }

    /**
     * @param calificacion the calificacion to set
     */
    public void setCalificacion(long calificacion) {
        this.calificacion = calificacion;
    }

}
