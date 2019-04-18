/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gio.co.seguros.Servicios;

/**
 *
 * @author manu
 */
public class Servicios {
    
    private int hospitalNumero;
    private String servicios;

    public Servicios(int hospitalNumero, String servicios) {
        this.hospitalNumero = hospitalNumero;
        this.servicios = servicios;
    }

    public int getHospitalNumero() {
        return hospitalNumero;
    }

    public void setHospitalNumero(int hospitalNumero) {
        this.hospitalNumero = hospitalNumero;
    }

    public String getServicios() {
        return servicios;
    }

    public void setServicios(String servicios) {
        this.servicios = servicios;
    }
    
    
    
    
}


