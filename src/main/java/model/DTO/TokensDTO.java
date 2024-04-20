package model.DTO;

public class TokensDTO {

    private int id;
    private String token;
    private Estado estado;
    private Tipo tipo;
    private AdminDTO admin;
    private AgenteDTO agente;

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
     * @param admin
     * @param agente
     */
    public TokensDTO(int id, String token, Estado estado, Tipo tipo, AdminDTO admin, AgenteDTO agente) {
        this.id = id;
        this.token = token;
        this.estado = estado;
        this.tipo = tipo;
        this.admin = admin;
        this.agente = agente;
    }

    /**
     *
     * @param token
     * @param estado
     * @param tipo
     * @param admin
     * @param agente
     */
    public TokensDTO(String token, Estado estado, Tipo tipo, AdminDTO admin, AgenteDTO agente) {
        this.token = token;
        this.estado = estado;
        this.tipo = tipo;
        this.admin = admin;
        this.agente = agente;
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

    public AdminDTO getAdmin() {
        return admin;
    }

    public void setAdmin(AdminDTO admin) {
        this.admin = admin;
    }

    public AgenteDTO getAgente() {
        return agente;
    }

    public void setAgente(AgenteDTO agente) {
        this.agente = agente;
    }

    @Override
    public String toString() {
        return "TokensDTO{" + "id=" + id  + ", estado=" + estado + ", tipo=" + tipo + ", admin=" + admin + ", agente=" + agente + '}';
    }

}
