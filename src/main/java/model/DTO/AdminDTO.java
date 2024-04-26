package model.DTO;

public class AdminDTO {

    private int id;
    private String email;
    private String password;

    /**
     * @param id
     * @param email
     * @param password
     */
    public AdminDTO(int id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    /**
     * @param email
     * @param password
     */
    public AdminDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AdminDTO{" + "id=" + id + ", email=" + email + "}";
    }

}
