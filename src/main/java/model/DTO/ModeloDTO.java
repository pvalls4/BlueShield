package model.DTO;

public class ModeloDTO {

    private int id;
    private String marca;
    private String modelo;
    private String imagen;

    /**
     * 
     * @param id
     * @param marca
     * @param modelo
     * @param imagen 
     */
    public ModeloDTO(int id, String marca, String modelo, String imagen) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.imagen = imagen;
    }

    /**
     * 
     * @param marca
     * @param modelo
     * @param imagen 
     */
    public ModeloDTO(String marca, String modelo, String imagen) {
        this.marca = marca;
        this.modelo = modelo;
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    
    @Override
    public String toString() {
        return "ModeloDTO{" + "id=" + id + ", nombreModelo=" + modelo + ", nombreMarca=" + marca + '}';
    }
    
    
}
