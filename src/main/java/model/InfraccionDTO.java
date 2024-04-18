
package model;

public class InfraccionDTO {
    
    private int id;
    private String articulo;
    private String titulo;
    private String descripcion;
    private float importe;

    public InfraccionDTO(int id, String articulo, String titulo, String descripcion, float importe) {
        this.id = id;
        this.articulo = articulo;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.importe = importe;
    }

    public InfraccionDTO(String articulo, String titulo, String descripcion, float importe) {
        this.articulo = articulo;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.importe = importe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
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

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

    @Override
    public String toString() {
        return "InfraccionDTO{" + "id=" + id + ", articulo=" + articulo + ", titulo=" + titulo + ", descripcion=" + descripcion + ", importe=" + importe + '}';
    }
    
    
}
