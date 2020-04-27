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
public class Cobranza {
    
    private int IDcobranza;
    private int compania;
    private int seccion;
    private int poliza;
    private int certificado;
    private int ingreso;
    private int consecutivo;
    private Date fecha;
    private Date fechaCobro;
    private int moneda;
    private double monto;
    private int origen;
    private int usuario;
    private int intpoliza;
    private int cobrador;
    private int cobradoofi;
    private Date fechaofi;
    private String rendido;
    private int usuarioofi;

    public Cobranza(int IDcobranza, int compania, int seccion, int poliza, int certificado, int ingreso, int consecutivo, Date fecha, Date fechaCobro, int moneda, double monto, int origen, int usuario, int intpoliza, int cobrador, int cobradoofi, Date fechaofi, String rendido, int usuarioofi) {
        this.IDcobranza = IDcobranza;
        this.compania = compania;
        this.seccion = seccion;
        this.poliza = poliza;
        this.certificado = certificado;
        this.ingreso = ingreso;
        this.consecutivo = consecutivo;
        this.fecha = fecha;
        this.fechaCobro = fechaCobro;
        this.moneda = moneda;
        this.monto = monto;
        this.origen = origen;
        this.usuario = usuario;
        this.intpoliza = intpoliza;
        this.cobrador = cobrador;
        this.cobradoofi = cobradoofi;
        this.fechaofi = fechaofi;
        this.rendido = rendido;
        this.usuarioofi = usuarioofi;
    }
    
    public Cobranza (){
        
    }

    public int getIDcobranza() {
        return IDcobranza;
    }

    public void setIDcobranza(int IDcobranza) {
        this.IDcobranza = IDcobranza;
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

    public int getIngreso() {
        return ingreso;
    }

    public void setIngreso(int ingreso) {
        this.ingreso = ingreso;
    }

    public int getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(int consecutivo) {
        this.consecutivo = consecutivo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFechaCobro() {
        return fechaCobro;
    }

    public void setFechaCobro(Date fechaCobro) {
        this.fechaCobro = fechaCobro;
    }

    public int getMoneda() {
        return moneda;
    }

    public void setMoneda(int moneda) {
        this.moneda = moneda;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getOrigen() {
        return origen;
    }

    public void setOrigen(int origen) {
        this.origen = origen;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public int getIntpoliza() {
        return intpoliza;
    }

    public void setIntpoliza(int intpoliza) {
        this.intpoliza = intpoliza;
    }

    public int getCobrador() {
        return cobrador;
    }

    public void setCobrador(int cobrador) {
        this.cobrador = cobrador;
    }

    public int getCobradoofi() {
        return cobradoofi;
    }

    public void setCobradoofi(int cobradoofi) {
        this.cobradoofi = cobradoofi;
    }

    public Date getFechaofi() {
        return fechaofi;
    }

    public void setFechaofi(Date fechaofi) {
        this.fechaofi = fechaofi;
    }

    public String getRendido() {
        return rendido;
    }

    public void setRendido(String rendido) {
        this.rendido = rendido;
    }

    public int getUsuarioofi() {
        return usuarioofi;
    }

    public void setUsuarioofi(int usuarioofi) {
        this.usuarioofi = usuarioofi;
    }
    
    
}
