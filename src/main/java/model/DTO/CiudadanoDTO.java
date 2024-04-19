/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DTO;

import java.sql.Date;

/**
 *
 * @author Mati
 */
public class CiudadanoDTO {
    private String dni;
    private String nombre;
    private String apellidos;
    private Date fecha_nacimiento;
    private int telefono;
    private String email;
    private boolean isDeceased;
    private String enlaceFotografico;
    private DireccionDTO direccion;

    /**
     * @param dni
     * @param nombre
     * @param apellidos
     * @param fecha_nacimiento
     * @param telefono
     * @param email
     * @param isDeceased
     * @param direccion
     * @param enlaceFotografico 
     */
    public CiudadanoDTO(String dni, String nombre, String apellidos, Date fecha_nacimiento, int telefono, String email, boolean isDeceased, DireccionDTO direccion, String enlaceFotografico) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fecha_nacimiento = fecha_nacimiento;
        this.telefono = telefono;
        this.email = email;
        this.isDeceased = isDeceased;
        this.enlaceFotografico = enlaceFotografico;
        this.direccion = direccion;
    }
    
    /**
     * @param dni
     * @param nombre
     * @param apellidos
     * @param fecha_nacimiento
     * @param telefono
     * @param email
     * @param isDeceased
     * @param enlaceFotografico 
     */
    public CiudadanoDTO(String dni, String nombre, String apellidos, Date fecha_nacimiento, int telefono, String email, boolean isDeceased, String enlaceFotografico) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fecha_nacimiento = fecha_nacimiento;
        this.telefono = telefono;
        this.email = email;
        this.isDeceased = isDeceased;
        this.enlaceFotografico = enlaceFotografico;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isIsDeceased() {
        return isDeceased;
    }

    public void setIsDeceased(boolean isDeceased) {
        this.isDeceased = isDeceased;
    }

    public String getEnlaceFotografico() {
        return enlaceFotografico;
    }

    public void setEnlaceFotografico(String enlaceFotografico) {
        this.enlaceFotografico = enlaceFotografico;
    }

    public DireccionDTO getDireccion() {
        return direccion;
    }

    public void setDireccion(DireccionDTO direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "CiudadanoDTO{" + "dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", fecha_nacimiento=" + fecha_nacimiento + ", telefono=" + telefono + ", email=" + email + ", isDeceased=" + isDeceased + ", enlaceFotografico=" + enlaceFotografico + ", direccion=" + direccion + '}';
    }
    
    

   
    
    
    
}
