/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author CA
 */
public class VehiculoDTO {

    private String id;
    private int bastidor;
    private ModeloDTO modelo;
    private String enlaceFotografico;

    public VehiculoDTO(String id, int bastidor, ModeloDTO modelo, String enlaceFotografico) {
        this.id = id;
        this.bastidor = bastidor;
        this.modelo = modelo;
        this.enlaceFotografico = enlaceFotografico;
    }
    
    public VehiculoDTO(int bastidor, ModeloDTO modelo, String enlaceFotografico) {
        this.bastidor = bastidor;
        this.modelo = modelo;
        this.enlaceFotografico = enlaceFotografico;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getBastidor() {
        return bastidor;
    }

    public void setBastidor(int bastidor) {
        this.bastidor = bastidor;
    }

    public ModeloDTO getModelo() {
        return modelo;
    }

    public void setModelo(ModeloDTO modelo) {
        this.modelo = modelo;
    }

    public String getEnlaceFotografico() {
        return enlaceFotografico;
    }

    public void setEnlaceFotografico(String enlaceFotografico) {
        this.enlaceFotografico = enlaceFotografico;
    }

    @Override
    public String toString() {
        return "VehiculoDTO{" + "id=" + id + ", bastidor=" + bastidor + ", modelo=" + modelo + ", enlaceFotografico=" + enlaceFotografico + '}';
    }
    
    
    
}
