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
public class MultaDTO {
    private int id;
    private Date fecha_emision;
    private Date fecha_limite;
    private double importe_total;
    private String observaciones;
    private String ubicacion;
    private boolean isPagado;
    private AgenteDTO agente;
    private CiudadanoDTO ciudadano;
    private VehiculoDTO vehiculo;

    /**
     * @param id
     * @param fecha_emision
     * @param fecha_limite
     * @param importe_total
     * @param observaciones
     * @param isPagado
     * @param agente
     * @param ciudadano
     * @param vehiculo 
     */
    public MultaDTO(int id, Date fecha_emision, Date fecha_limite, double importe_total, String observaciones, String ubicacion, boolean isPagado, AgenteDTO agente, CiudadanoDTO ciudadano, VehiculoDTO vehiculo) {
        this.id = id;
        this.fecha_emision = fecha_emision;
        this.fecha_limite = fecha_limite;
        this.importe_total = importe_total;
        this.observaciones = observaciones;
        this.ubicacion = ubicacion;
        this.isPagado = isPagado;
        this.agente = agente;
        this.ciudadano = ciudadano;
        this.vehiculo = vehiculo;
    }

    /**
     * @param id
     * @param fecha_emision
     * @param fecha_limite
     * @param importe_total
     * @param observaciones
     * @param isPagado
     * @param agente
     * @param ciudadano 
     */
    public MultaDTO(int id, Date fecha_emision, Date fecha_limite, double importe_total, String observaciones, String ubicacion, boolean isPagado, AgenteDTO agente, CiudadanoDTO ciudadano) {
        this.id = id;
        this.fecha_emision = fecha_emision;
        this.fecha_limite = fecha_limite;
        this.importe_total = importe_total;
        this.observaciones = observaciones;
        this.ubicacion = ubicacion;
        this.isPagado = isPagado;
        this.agente = agente;
        this.ciudadano = ciudadano;
    }

    /**
     * @param fecha_emision
     * @param fecha_limite
     * @param importe_total
     * @param observaciones
     * @param isPagado
     * @param agente
     * @param ciudadano
     * @param vehiculo 
     */
    public MultaDTO(Date fecha_emision, Date fecha_limite, double importe_total, String observaciones, String ubicacion, boolean isPagado, AgenteDTO agente, CiudadanoDTO ciudadano, VehiculoDTO vehiculo) {
        this.fecha_emision = fecha_emision;
        this.fecha_limite = fecha_limite;
        this.importe_total = importe_total;
        this.observaciones = observaciones;
        this.ubicacion = ubicacion;
        this.isPagado = isPagado;
        this.agente = agente;
        this.ciudadano = ciudadano;
        this.vehiculo = vehiculo;
    }

    /**
     * @param fecha_emision
     * @param fecha_limite
     * @param importe_total
     * @param observaciones
     * @param isPagado
     * @param agente
     * @param ciudadano 
     */
    public MultaDTO(Date fecha_emision, Date fecha_limite, double importe_total, String observaciones, String ubicacion, boolean isPagado, AgenteDTO agente, CiudadanoDTO ciudadano) {
        this.fecha_emision = fecha_emision;
        this.fecha_limite = fecha_limite;
        this.importe_total = importe_total;
        this.observaciones = observaciones;
        this.ubicacion = ubicacion;
        this.isPagado = isPagado;
        this.agente = agente;
        this.ciudadano = ciudadano;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha_emision() {
        return fecha_emision;
    }

    public void setFecha_emision(Date fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    public Date getFecha_limite() {
        return fecha_limite;
    }

    public void setFecha_limite(Date fecha_limite) {
        this.fecha_limite = fecha_limite;
    }

    public double getImporte_total() {
        return importe_total;
    }

    public void setImporte_total(double importe_total) {
        this.importe_total = importe_total;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public boolean isIsPagado() {
        return isPagado;
    }

    public void setIsPagado(boolean isPagado) {
        this.isPagado = isPagado;
    }

    public AgenteDTO getAgente() {
        return agente;
    }

    public void setAgente(AgenteDTO agente) {
        this.agente = agente;
    }

    public CiudadanoDTO getCiudadano() {
        return ciudadano;
    }

    public void setCiudadano(CiudadanoDTO ciudadano) {
        this.ciudadano = ciudadano;
    }

    public VehiculoDTO getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(VehiculoDTO vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public String toString() {
        return "MultaDTO{" + "id=" + id + ", fecha_emision=" + fecha_emision + ", fecha_limite=" + fecha_limite + ", importe_total=" + importe_total + ", observaciones=" + observaciones + ", isPagado=" + isPagado + ", agente=" + agente + ", ciudadano=" + ciudadano + ", vehiculo=" + vehiculo + '}';
    }
    
}
