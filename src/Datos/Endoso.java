/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.util.Date;

/**
 *
 * @author admin
 */
public class Endoso {

    private int idENDOSOS;
    private int compania;
    private int seccion;
    private int poliza;
    private int certificado;
    private int endoso;
    private Date fechaemis;
    private Date desde;
    private Date hasta;
    private String tipoendoso;
    private int motivo;
    private String plan;
    private int asegurado;
    private int moneda;
    private double suma;
    private double prima;
    private int codproducto;
    private int usuario;
    private int usuarioofi;
    private String tipoAsegurado;

    public Endoso() {
    }

    public Endoso(int idENDOSOS, int compania, int seccion, int poliza, int certificado, int endoso, Date fechaemis, Date desde, Date hasta, String tipoendoso, int motivo, String plan, int asegurado, int moneda, int suma, int prima, int codproducto, int usuario, int usuarioofi) {
        this.idENDOSOS = idENDOSOS;
        this.compania = compania;
        this.seccion = seccion;
        this.poliza = poliza;
        this.certificado = certificado;
        this.endoso = endoso;
        this.fechaemis = fechaemis;
        this.desde = desde;
        this.hasta = hasta;
        this.tipoendoso = tipoendoso;
        this.motivo = motivo;
        this.plan = plan;
        this.asegurado = asegurado;
        this.moneda = moneda;
        this.suma = suma;
        this.prima = prima;
        this.codproducto = codproducto;
        this.usuario = usuario;
        this.usuarioofi = usuarioofi;
        this.tipoAsegurado = tipoAsegurado;
    }

    public int getIdENDOSOS() {
        return idENDOSOS;
    }

    public void setIdENDOSOS(int idENDOSOS) {
        this.idENDOSOS = idENDOSOS;
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

    public Date getFechaemis() {
        return fechaemis;
    }

    public void setFechaemis(Date fechaemis) {
        this.fechaemis = fechaemis;
    }

    public Date getDesde() {
        return desde;
    }

    public void setDesde(Date desde) {
        this.desde = desde;
    }

    public Date getHasta() {
        return hasta;
    }

    public void setHasta(Date hasta) {
        this.hasta = hasta;
    }

    public String getTipoendoso() {
        return tipoendoso;
    }

    public void setTipoendoso(String tipoendoso) {
        this.tipoendoso = tipoendoso;
    }

    public int getMotivo() {
        return motivo;
    }

    public void setMotivo(int motivo) {
        this.motivo = motivo;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public int getAsegurado() {
        return asegurado;
    }

    public void setAsegurado(int asegurado) {
        this.asegurado = asegurado;
    }

    public int getMoneda() {
        return moneda;
    }

    public void setMoneda(int moneda) {
        this.moneda = moneda;
    }

    public double getSuma() {
        return suma;
    }

    public void setSuma(double suma) {
        this.suma = suma;
    }

    public double getPrima() {
        return prima;
    }

    public void setPrima(double prima) {
        this.prima = prima;
    }

    public int getCodproducto() {
        return codproducto;
    }

    public void setCodproducto(int codproducto) {
        this.codproducto = codproducto;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public int getUsuarioofi() {
        return usuarioofi;
    }

    public void setUsuarioofi(int usuarioofi) {
        this.usuarioofi = usuarioofi;
    }

    public String getTipoAsegurado() {
        return tipoAsegurado;
    }

    public void setTipoAsegurado(String tipoAsegurado) {
        this.tipoAsegurado = tipoAsegurado;
    }
}
