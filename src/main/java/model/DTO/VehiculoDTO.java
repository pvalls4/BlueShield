package model.DTO;

public class VehiculoDTO {

    private String bastidor;
    private String matricula;
    private CiudadanoDTO ciudadano;
    private ModeloDTO modelo;

    /**
     * 
     * @param bastidor
     * @param matricula
     * @param ciudadano
     * @param modelo 
     */
    public VehiculoDTO(String bastidor, String matricula, CiudadanoDTO ciudadano, ModeloDTO modelo) {
        this.bastidor = bastidor;
        this.matricula = matricula;
        this.ciudadano = ciudadano;
        this.modelo = modelo;
    }

    /**
     * 
     * @param matricula
     * @param ciudadano
     * @param modelo 
     */
    public VehiculoDTO(String matricula, CiudadanoDTO ciudadano, ModeloDTO modelo) {
        this.matricula = matricula;
        this.ciudadano = ciudadano;
        this.modelo = modelo;
    }

    public String getBastidor() {
        return bastidor;
    }

    public void setBastidor(String bastidor) {
        this.bastidor = bastidor;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public CiudadanoDTO getCiudadano() {
        return ciudadano;
    }

    public void setCiudadano(CiudadanoDTO ciudadano) {
        this.ciudadano = ciudadano;
    }

    public ModeloDTO getModelo() {
        return modelo;
    }

    public void setModelo(ModeloDTO modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "VehiculoDTO{" + "bastidor=" + bastidor + ", matricula=" + matricula + ", ciudadano=" + ciudadano + ", modelo=" + modelo + '}';
    }
    
}
