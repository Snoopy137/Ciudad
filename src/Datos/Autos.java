/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author linux
 */
public class Autos {
    private int ID;
    private int compania;
    private int seccion;
    private int poliza;
    private int endoso;
    private int certificado;
    private String cobertura;
    private int item;
    private String marca;
    private String modelo;
    private String patente;
    private int anio;
    private String motor;
    private String chasis;
    private String accesorios;
    private String obvserv;

    public Autos() {
    }

    public Autos(int compania, int seccion, int poliza, int endoso, int certificado, String marca, String modelo, String patente, int anio, String motor, String chasis) {
        this.compania = compania;
        this.seccion = seccion;
        this.poliza = poliza;
        this.endoso = endoso;
        this.certificado = certificado;
        this.marca = marca;
        this.modelo = modelo;
        this.patente = patente;
        this.anio = anio;
        this.motor = motor;
        this.chasis = chasis;
    }
    
    public Autos(int ID, int compania, int seccion, int poliza, int endoso, int certificado, String cobertura, int item, String marca, String modelo, String patente, int anio, String motor, String chasis, String accesorios, String obvserv) {
        this.ID = ID;
        this.compania = compania;
        this.seccion = seccion;
        this.poliza = poliza;
        this.endoso = endoso;
        this.certificado = certificado;
        this.cobertura = cobertura;
        this.item = item;
        this.marca = marca;
        this.modelo = modelo;
        this.patente = patente;
        this.anio = anio;
        this.motor = motor;
        this.chasis = chasis;
        this.accesorios = accesorios;
        this.obvserv = obvserv;
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

    public int getEndoso() {
        return endoso;
    }

    public void setEndoso(int endoso) {
        this.endoso = endoso;
    }

    public int getCertificado() {
        return certificado;
    }

    public void setCertificado(int certificado) {
        this.certificado = certificado;
    }

    public String getCobertura() {
        return cobertura;
    }

    public void setCobertura(String cobertura) {
        this.cobertura = cobertura;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getChasis() {
        return chasis;
    }

    public void setChasis(String chasis) {
        this.chasis = chasis;
    }

    public String getAccesorios() {
        return accesorios;
    }

    public void setAccesorios(String accesorios) {
        this.accesorios = accesorios;
    }

    public String getObvserv() {
        return obvserv;
    }

    public void setObvserv(String obvserv) {
        this.obvserv = obvserv;
    }
    
    
}
