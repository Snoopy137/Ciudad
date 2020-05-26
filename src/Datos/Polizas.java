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
public class Polizas {
    private int idpolizas;
    private int compania;
    private int seccion;
    private int poliza;
    private int certificado;
    private int renueva;
    private int renovadapor;
    private int intpoliza;
    private int productor;
    private int tipooper;
    private Date fechamis;
    private Date desde;
    private Date hasta;
    private int estado;
    private Date fechaestado;
    private int asegurado;
    private int moneda;
    private int cobrador;
    private double prima;
    private double premio;
    private int usuario;
    private int usuarioofi;
    private int formapago;
    
    public Polizas() {
    }

    public Polizas(int idpolizas, int compania, int seccion, int poliza, int certificado, int renueva, int renovadapor, int intpoliza, int productor, int tipooper, Date fechamis, Date desde, Date hasta, int estado, Date fechaestado, int asegurado, int moneda, int cobrador, double prima, double premio, int usuario, int usuarioofi, int formapago) {
        this.idpolizas = idpolizas;
        this.compania = compania;
        this.seccion = seccion;
        this.poliza = poliza;
        this.certificado = certificado;
        this.renueva = renueva;
        this.renovadapor = renovadapor;
        this.intpoliza = intpoliza;
        this.productor = productor;
        this.tipooper = tipooper;
        this.fechamis = fechamis;
        this.desde = desde;
        this.hasta = hasta;
        this.estado = estado;
        this.fechaestado = fechaestado;
        this.asegurado = asegurado;
        this.moneda = moneda;
        this.cobrador = cobrador;
        this.prima = prima;
        this.premio = premio;
        this.usuario = usuario;
        this.usuarioofi = usuarioofi;
        this.formapago = formapago;
    }

    public int getIdpolizas() {
        return idpolizas;
    }

    public void setIdpolizas(int idpolizas) {
        this.idpolizas = idpolizas;
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

    public int getRenueva() {
        return renueva;
    }

    public void setRenueva(int renueva) {
        this.renueva = renueva;
    }

    public int getRenovadapor() {
        return renovadapor;
    }

    public void setRenovadapor(int renovadapor) {
        this.renovadapor = renovadapor;
    }

    public int getIntpoliza() {
        return intpoliza;
    }

    public void setIntpoliza(int intpoliza) {
        this.intpoliza = intpoliza;
    }

    public int getProductor() {
        return productor;
    }

    public void setProductor(int productor) {
        this.productor = productor;
    }

    public int getTipooper() {
        return tipooper;
    }

    public void setTipooper(int tipooper) {
        this.tipooper = tipooper;
    }

    public Date getFechamis() {
        return fechamis;
    }

    public void setFechamis(Date fechamis) {
        this.fechamis = fechamis;
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

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Date getFechaestado() {
        return fechaestado;
    }

    public void setFechaestado(Date fechaestado) {
        this.fechaestado = fechaestado;
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

    public int getCobrador() {
        return cobrador;
    }

    public void setCobrador(int cobrador) {
        this.cobrador = cobrador;
    }

    public double getPrima() {
        return prima;
    }

    public void setPrima(double prima) {
        this.prima = prima;
    }

    public double getPremio() {
        return premio;
    }

    public void setPremio(double premio) {
        this.premio = premio;
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

    public int getFormapago() {
        return formapago;
    }

    public void setFormapago(int formapago) {
        this.formapago = formapago;
    }
}
