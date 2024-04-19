/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DTO;

/**
 *
 * @author Mati
 */
public class AgenteDTO {
    private int placa;
    private CiudadanoDTO ciudadano;
    private String password;
    private String enlaceFotografico;

    /**
     * @param placa
     * @param ciudadano
     * @param password
     * @param enlaceFotografico 
     */
    public AgenteDTO(int placa, CiudadanoDTO ciudadano, String password, String enlaceFotografico) {
        this.placa = placa;
        this.ciudadano = ciudadano;
        this.password = password;
        this.enlaceFotografico = enlaceFotografico;
    }

    public int getPlaca() {
        return placa;
    }

    public void setId(int placa) {
        this.placa = placa;
    }

    public CiudadanoDTO getCiudadano() {
        return ciudadano;
    }

    public void setCiudadano(CiudadanoDTO ciudadano) {
        this.ciudadano = ciudadano;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEnlaceFotografico() {
        return enlaceFotografico;
    }

    public void setEnlaceFotografico(String enlaceFotografico) {
        this.enlaceFotografico = enlaceFotografico;
    }

    @Override
    public String toString() {
        return "AgenteDTO{" + "placa=" + placa + ", ciudadano=" + ciudadano + "enlaceFotografico=" + enlaceFotografico + '}';
    }
    
    
    
}