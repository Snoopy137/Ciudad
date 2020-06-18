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
    private int tipoendoso;
    private int motivo;
    private int plan;
    private int asegurado;
    private int moneda;
    private int suma;
    private int prima;
    private int codproducto;
    private int usuario;
    private int usuarioofi;

    public Endoso() {
    }

    public Endoso(int idENDOSOS, int compania, int seccion, int poliza, int certificado, int endoso, Date fechaemis, Date desde, Date hasta, int tipoendoso, int motivo, int plan, int asegurado, int moneda, int suma, int prima, int codproducto, int usuario, int usuarioofi) {
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

    public int getTipoendoso() {
        return tipoendoso;
    }

    public void setTipoendoso(int tipoendoso) {
        this.tipoendoso = tipoendoso;
    }

    public int getMotivo() {
        return motivo;
    }

    public void setMotivo(int motivo) {
        this.motivo = motivo;
    }

    public int getPlan() {
        return plan;
    }

    public void setPlan(int plan) {
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

    public int getSuma() {
        return suma;
    }

    public void setSuma(int suma) {
        this.suma = suma;
    }

    public int getPrima() {
        return prima;
    }

    public void setPrima(int prima) {
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
    
    
}
