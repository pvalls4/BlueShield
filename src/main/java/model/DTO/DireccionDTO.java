
package model.DTO;

public class DireccionDTO {
    
    private int id;
    private String municipio;
    private int codigoPostal;
    private String calle;
    private byte piso;
    private short puerta;
    private short numero;
    
    public DireccionDTO(int id, String municipio, int codigoPostal, String calle, byte piso, short puerta, short numero) {
        this.id = id;
        this.municipio = municipio;
        this.codigoPostal = codigoPostal;
        this.calle = calle;
        this.piso = piso;
        this.puerta = puerta;
        this.numero = numero;
    }

    public DireccionDTO(String municipio, int codigoPostal, String calle, byte piso, short puerta, short numero) {
        this.municipio = municipio;
        this.codigoPostal = codigoPostal;
        this.calle = calle;
        this.piso = piso;
        this.puerta = puerta;
        this.numero = numero;
    }

    public short getNumero() {
        return numero;
    }

    public void setNumero(short numero) {
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

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public byte getPiso() {
        return piso;
    }

    public void setPiso(byte piso) {
        this.piso = piso;
    }

    public short getPuerta() {
        return puerta;
    }

    public void setPuerta(short puerta) {
        this.puerta = puerta;
    }

    @Override
    public String toString() {
        return "DireccionDTO{" + "id=" + id + ", municipio=" + municipio + ", codigoPostal=" + codigoPostal + ", calle=" + calle + ", piso=" + piso + ", puerta=" + puerta + ", numero=" + numero + '}';
    }
    
}
