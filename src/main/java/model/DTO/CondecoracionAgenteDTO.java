package model.DTO;

import java.sql.Date;

public class CondecoracionAgenteDTO {
    private CondecoracionDTO condecoracion;
    private AgenteDTO agente;
    private Date fecha_emision;

    /**
     * @param condecoracion
     * @param agente
     * @param fecha_emision 
     */
    public CondecoracionAgenteDTO(CondecoracionDTO condecoracion, AgenteDTO agente, Date fecha_emision) {
        this.condecoracion = condecoracion;
        this.agente = agente;
        this.fecha_emision = fecha_emision;
    }

    public CondecoracionDTO getCondecoracion() {
        return condecoracion;
    }

    public void setCondecoracion(CondecoracionDTO condecoracion) {
        this.condecoracion = condecoracion;
    }

    public AgenteDTO getAgente() {
        return agente;
    }

    public void setAgente(AgenteDTO agente) {
        this.agente = agente;
    }

    public Date getFecha_emision() {
        return fecha_emision;
    }

    public void setFecha_emision(Date fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    @Override
    public String toString() {
        return "CondecoracionAgenteDTO{" + "condecoracion=" + condecoracion + ", agente=" + agente + ", fecha_emision=" + fecha_emision + '}';
    }
    
    

}