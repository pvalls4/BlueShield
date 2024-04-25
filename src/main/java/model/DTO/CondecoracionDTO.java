package model.DTO;

import java.sql.Date;

public class CondecoracionDTO {
    private int id;
    private String titulo;
    private String descripcion;
    private String foto;

    /**
     * @param id
     * @param titulo
     * @param descripcion
     * @param foto 
     */
    public CondecoracionDTO(int id, String titulo, String descripcion, String foto) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.foto = foto;
    }
    
    public CondecoracionDTO(String titulo, String descripcion, String foto) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.foto = foto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "CondecoracionDTO{" + "id=" + id + ", titulo=" + titulo + ", descripcion=" + descripcion + ", foto=" + foto + '}';
    }

}