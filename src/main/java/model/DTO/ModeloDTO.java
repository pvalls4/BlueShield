package model.DTO;

public class ModeloDTO {

    private int id;
    private String nombreModelo;
    private String nombreMarca;

    /**
     * 
     * @param id
     * @param nombreModelo
     * @param nombreMarca 
     */
    public ModeloDTO(int id, String nombreModelo, String nombreMarca) {
        this.id = id;
        this.nombreModelo = nombreModelo;
        this.nombreMarca = nombreMarca;
    }
    
    /**
     * 
     * @param nombreModelo
     * @param nombreMarca 
     */
    public ModeloDTO(String nombreModelo, String nombreMarca) {
        this.nombreModelo = nombreModelo;
        this.nombreMarca = nombreMarca;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreModelo() {
        return nombreModelo;
    }

    public void setNombreModelo(String nombreModelo) {
        this.nombreModelo = nombreModelo;
    }

    public String getNombreMarca() {
        return nombreMarca;
    }

    public void setNombreMarca(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }

    @Override
    public String toString() {
        return "ModeloDTO{" + "id=" + id + ", nombreModelo=" + nombreModelo + ", nombreMarca=" + nombreMarca + '}';
    }
    
    
}