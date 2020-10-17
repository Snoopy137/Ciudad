/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.util.Date;

/**
 *
 * @author linux
 */
public class Recibos {
    private int ID;
    private int compania;
    private int seccion;
    private int poliza;
    private int certificado;
    private int endoso;
    private Date fecvenc;
    private int estado;
    private int cuota;
    private String anticipo;
    private double premio;
    private double prima;

    public Recibos() {
    }

    public Recibos(int compania, int seccion, int poliza, int certificado, int endoso, Date fecvenc, int estado, int cuota, String anticipo, double premio, double prima) {
        this.ID = ID;
        this.compania = compania;
        this.seccion = seccion;
        this.poliza = poliza;
        this.certificado = certificado;
        this.endoso = endoso;
        this.fecvenc = fecvenc;
        this.estado = estado;
        this.cuota = cuota;
        this.anticipo = anticipo;
        this.premio = premio;
        this.prima = prima;
    }

    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getCompania() {
        return compania;
    }

    public void setCompania(int compania) {
        this.compania = compania;
    }

    public int getSeccion() {
        return seccion;
    }

    public void setSeccion(int seccion) {
        this.seccion = seccion;
    }

    public int getPoliza() {
        return poliza;
    }

    public void setPoliza(int poliza) {
        this.poliza = poliza;
    }

    public int getCertificado() {
        return certificado;
    }

    public void setCertificado(int certificado) {
        this.certificado = certificado;
    }

    public int getEndoso() {
        return endoso;
    }

    public void setEndoso(int endoso) {
        this.endoso = endoso;
    }

    public Date getFecvenc() {
        return fecvenc;
    }

    public void setFecvenc(Date fecvenc) {
        this.fecvenc = fecvenc;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getCuota() {
        return cuota;
    }

    public void setCuota(int cuota) {
        this.cuota = cuota;
    }

    public String getAnticipo() {
        return anticipo;
    }

    public void setAnticipo(String anticipo) {
        this.anticipo = anticipo;
    }

    public double getPremio() {
        return premio;
    }

    public void setPremio(double premio) {
        this.premio = premio;
    }

    public double getPrima() {
        return prima;
    }

    public void setPrima(double prima) {
        this.prima = prima;
    }
    
}
