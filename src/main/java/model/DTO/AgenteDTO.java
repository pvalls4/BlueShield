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
    private String rango;
    private boolean isAdmin;

    /**
     * @param ciudadano
     * @param password
     * @param enlaceFotografico 
     * @param rango 
     */
    public AgenteDTO(CiudadanoDTO ciudadano, String password, String enlaceFotografico, String rango, boolean isAdmin) {
        this.ciudadano = ciudadano;
        this.password = password;
        this.enlaceFotografico = enlaceFotografico;
        this.rango = rango;
        this.isAdmin = isAdmin;
    }
    
    /**
     * @param placa
     * @param ciudadano
     * @param password
     * @param enlaceFotografico 
     * @param rango 
     */
    public AgenteDTO(int placa, CiudadanoDTO ciudadano, String password, String enlaceFotografico, String rango, boolean isAdmin) {
        this.placa = placa;
        this.ciudadano = ciudadano;
        this.password = password;
        this.enlaceFotografico = enlaceFotografico;
        this.rango = rango;
        this.isAdmin = isAdmin;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
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

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
    
    @Override
    public String toString() {
        return "AgenteDTO{" + "placa=" + placa + ", ciudadano=" + ciudadano + ", enlaceFotografico=" + enlaceFotografico + ", rango: " + rango + ", isAdmin:" + isAdmin +'}';
    }
    
    
    
}