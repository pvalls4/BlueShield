package model.DTO;

public class TokensDTO {
    // Atributos
    private int id;
    private String token;
    private Estado estado;
    private Tipo tipo;

    // Enum para el estado del token
    public enum Estado {
        USADO,
        CADUCADO,
        ACTIVO
    }

    // Enum para el tipo de token
    public enum Tipo {
        REGISTRO,
        PETICION
    }

    /**
     * 
     * @param id
     * @param token
     * @param estado
     * @param tipo 
     */
    public TokensDTO(int id, String token, Estado estado, Tipo tipo) {
        this.id = id;
        this.token = token;
        this.estado = estado;
        this.tipo = tipo;
    }

    /**
     * 
     * @param token
     * @param estado
     * @param tipo 
     */
    public TokensDTO(String token, Estado estado, Tipo tipo) {
        this.token = token;
        this.estado = estado;
        this.tipo = tipo;
    }
    
    public int getId() {
        return id;
    }

    public String getToken() {
        return token;
    }

    public Estado getEstado() {
        return estado;
    }

    public Tipo getTipo() {
        return tipo;
    }

    // Métodos setters
    public void setId(int id) {
        this.id = id;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "TokensDTO{" + "id=" + id + ", token=" + token + ", estado=" + estado + ", tipo=" + tipo + '}';
    }

    
}

