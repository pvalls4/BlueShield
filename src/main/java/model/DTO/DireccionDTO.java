package model.DTO;

public class DireccionDTO {
    
    private int id;
    private String municipio;
    private String codigoPostal;
    private String calle;
    private String piso;
    private String puerta;
    private int numero;
        
    
    /**
     * 
     * @param id
     * @param municipio
     * @param codigoPostal
     * @param calle
     * @param piso
     * @param puerta
     * @param numero 
     */
    
    public DireccionDTO(int id, String municipio, String codigoPostal, String calle, String piso, String puerta, int numero) {
        this.id = id;
        this.municipio = municipio;
        this.codigoPostal = codigoPostal;
        this.calle = calle;
        this.piso = piso;
        this.puerta = puerta;
        this.numero = numero;
    }
    
    /**
     * 
     * @param municipio
     * @param codigoPostal
     * @param calle
     * @param piso
     * @param puerta
     * @param numero 
     */
    
    public DireccionDTO(String municipio, String codigoPostal, String calle, String piso, String puerta, int numero) {
        this.municipio = municipio;
        this.codigoPostal = codigoPostal;
        this.calle = calle;
        this.piso = piso;
        this.puerta = puerta;
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getPuerta() {
        return puerta;
    }

    public void setPuerta(String puerta) {
        this.puerta = puerta;
    }

    @Override
    public String toString() {
        return "DireccionDTO{" + "id=" + id + ", municipio=" + municipio + ", codigoPostal=" + codigoPostal + ", calle=" + calle + ", piso=" + piso + ", puerta=" + puerta + ", numero=" + numero + '}';
    }
    
}
