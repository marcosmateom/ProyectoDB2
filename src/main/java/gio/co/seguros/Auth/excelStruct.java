/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gio.co.seguros.Auth;

/**
 *
 * @author migue
 */
public class excelStruct {
    public int hospital;
    public String servicio;
    public String dpi;
    public String fecha;
    public int monto;
    public double porcentaje;
    public int idCita;
    public int idAuth;

    public excelStruct(int hospital, String servicio, String dpi, String fecha, int monto, double porcentaje, int idCita, int idAuth) {
        this.hospital = hospital;
        this.servicio = servicio;
        this.dpi = dpi;
        this.fecha = fecha;
        this.monto = monto;
        this.porcentaje = porcentaje;
        this.idCita = idCita;
        this.idAuth = idAuth;
    }

    public int getHospital() {
        return hospital;
    }

    public void setHospital(int hospital) {
        this.hospital = hospital;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public int getIdAuth() {
        return idAuth;
    }

    public void setIdAuth(int idAuth) {
        this.idAuth = idAuth;
    }
    
    
}
