/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.Date;

/**
 *
 * @author linux
 */
public class Asegurados {
    
    private int idasegurado;
    private int numasegurado;
    private String nombreasegurado;
    private String domicilioasegurado;
    private String domiciliocobroasegurado;
    private String localidad;
    private String codigopostal;
    private String DNItipo;
    private int DNInumero;
    private String tele1;
    private String tele2;
    private String tele3;
    private Date fechanac;
    private int cuil;
    private String actividad;
    private String mail;
    private String estado;
    private int cobrador;
    private String observaciones;
    private Date alta;
    private Date baja;
    private Usuarios usuario;
    private Date modificado;

    public Asegurados(int idasegurado, int numasegurado, String nombreasegurado, String domicilioasegurado, String domiciliocobroasegurado, String localidad, String codigopostal, String DNItipo, int DNInumero, String tele1, String tele2, String tele3, Date fechanac, int cuil, String actividad, String mail, String estado, int cobrador, String observaciones, Date alta, Date baja, Usuarios usu, Date modificado) {
        this.idasegurado = idasegurado;
        this.numasegurado = numasegurado;
        this.nombreasegurado = nombreasegurado;
        this.domicilioasegurado = domicilioasegurado;
        this.domiciliocobroasegurado = domiciliocobroasegurado;
        this.localidad = localidad;
        this.codigopostal = codigopostal;
        this.DNItipo = DNItipo;
        this.DNInumero = DNInumero;
        this.tele1 = tele1;
        this.tele2 = tele2;
        this.tele3 = tele3;
        this.fechanac = fechanac;
        this.cuil = cuil;
        this.actividad = actividad;
        this.mail = mail;
        this.estado = estado;
        this.cobrador = cobrador;
        this.observaciones = observaciones;
        this.alta = alta;
        this.baja = baja;
        this.usuario = usu;
        this.modificado = modificado;
    }
    
    public Asegurados(){
        
    }

    public int getIdasegurado() {
        return idasegurado;
    }

    public void setIdasegurado(int idasegurado) {
        this.idasegurado = idasegurado;
    }

    public int getNumasegurado() {
        return numasegurado;
    }

    public void setNumasegurado(int numasegurado) {
        this.numasegurado = numasegurado;
    }

    public String getNombreasegurado() {
        return nombreasegurado;
    }

    public void setNombreasegurado(String nombreasegurado) {
        this.nombreasegurado = nombreasegurado;
    }

    public String getDomicilioasegurado() {
        return domicilioasegurado;
    }

    public void setDomicilioasegurado(String domicilioasegurado) {
        this.domicilioasegurado = domicilioasegurado;
    }

    public String getDomiciliocobroasegurado() {
        return domiciliocobroasegurado;
    }

    public void setDomiciliocobroasegurado(String domiciliocobroasegurado) {
        this.domiciliocobroasegurado = domiciliocobroasegurado;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getCodigopostal() {
        return codigopostal;
    }

    public void setCodigopostal(String codigopostal) {
        this.codigopostal = codigopostal;
    }

    public String getDNItipo() {
        return DNItipo;
    }

    public void setDNItipo(String DNItipo) {
        this.DNItipo = DNItipo;
    }

    public int getDNInumero() {
        return DNInumero;
    }

    public void setDNInumero(int DNInumero) {
        this.DNInumero = DNInumero;
    }

    public String getTele1() {
        return tele1;
    }

    public void setTele1(String tele1) {
        this.tele1 = tele1;
    }

    public String getTele2() {
        return tele2;
    }

    public void setTele2(String tele2) {
        this.tele2 = tele2;
    }

    public String getTele3() {
        return tele3;
    }

    public void setTele3(String tele3) {
        this.tele3 = tele3;
    }

    public Date getFechanac() {
        return fechanac;
    }

    public void setFechanac(Date fechanac) {
        this.fechanac = fechanac;
    }

    public int getCuil() {
        return cuil;
    }

    public void setCuil(int cuil) {
        this.cuil = cuil;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCobrador() {
        return cobrador;
    }

    public void setCobrador(int cobrador) {
        this.cobrador = cobrador;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Date getAlta() {
        return alta;
    }

    public void setAlta(Date alta) {
        this.alta = alta;
    }

    public Date getBaja() {
        return baja;
    }

    public void setBaja(Date baja) {
        this.baja = baja;
    }

    public Usuarios getUsu() {
        return usuario;
    }

    public void setUsu(Usuarios usu) {
        this.usuario = usu;
    }

    public Date getModificado() {
        return modificado;
    }

    public void setModificado(Date modificado) {
        this.modificado = modificado;
    }
    
    
}
