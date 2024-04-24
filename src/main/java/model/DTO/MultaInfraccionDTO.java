package model.DTO;

/**
 *
 * @author Mati
 */
public class MultaInfraccionDTO {
    private MultaDTO multa;
    private InfraccionDTO infraccion;

    public MultaInfraccionDTO(MultaDTO multa, InfraccionDTO infraccion) {
        this.multa = multa;
        this.infraccion = infraccion;
    }

    public MultaDTO getMulta() {
        return multa;
    }

    public void setMulta(MultaDTO multa) {
        this.multa = multa;
    }

    public InfraccionDTO getInfraccion() {
        return infraccion;
    }

    public void setInfraccion(InfraccionDTO infraccion) {
        this.infraccion = infraccion;
    }
    
}
