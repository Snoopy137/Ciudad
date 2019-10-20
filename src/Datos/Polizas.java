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
public class Polizas {
    private int idpolizas;
    private int numpoliza;
    private int idcompanias;
    private String nombreCompania;
    private int idseccion;
    private String nombreseccion;
    private int numero;
    private String endoso;
    private Date vigenciadesde;
    private Date vigenciahasta;
    private Date fechapago;
    private Date diapago;

    public Polizas() {
    }

    public Polizas(int idpolizas, int idcompanias, String nombreCompania, int idseccion, String nombreseccion, int numero, String endoso, Date vigenciadesde, Date vigenciahasta, Date fechapago, Date diapago) {
        this.idpolizas = idpolizas;
        this.idcompanias = idcompanias;
        this.nombreCompania = nombreCompania;
        this.idseccion = idseccion;
        this.nombreseccion = nombreseccion;
        this.numero = numero;
        this.endoso = endoso;
        this.vigenciadesde = vigenciadesde;
        this.vigenciahasta = vigenciahasta;
        this.fechapago = fechapago;
        this.diapago = diapago;
    }

    public int getNumpoliza() {
        return numpoliza;
    }

    public void setNumpoliza(int numpoliza) {
        this.numpoliza = numpoliza;
    }

    
    public int getIdpolizas() {
        return idpolizas;
    }

    public void setIdpolizas(int idpolizas) {
        this.idpolizas = idpolizas;
    }

    public int getIdcompanias() {
        return idcompanias;
    }

    public void setIdcompanias(int idcompanias) {
        this.idcompanias = idcompanias;
    }

    public String getNombreCompania() {
        return nombreCompania;
    }

    public void setNombreCompania(String nombreCompania) {
        this.nombreCompania = nombreCompania;
    }

    public int getIdseccion() {
        return idseccion;
    }

    public void setIdseccion(int idseccion) {
        this.idseccion = idseccion;
    }

    public String getNombreseccion() {
        return nombreseccion;
    }

    public void setNombreseccion(String nombreseccion) {
        this.nombreseccion = nombreseccion;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getEndoso() {
        return endoso;
    }

    public void setEndoso(String endoso) {
        this.endoso = endoso;
    }

    public Date getVigenciadesde() {
        return vigenciadesde;
    }

    public void setVigenciadesde(Date vigenciadesde) {
        this.vigenciadesde = vigenciadesde;
    }

    public Date getVigenciahasta() {
        return vigenciahasta;
    }

    public void setVigenciahasta(Date vigenciahasta) {
        this.vigenciahasta = vigenciahasta;
    }

    public Date getFechapago() {
        return fechapago;
    }

    public void setFechapago(Date fechapago) {
        this.fechapago = fechapago;
    }

    public Date getDiapago() {
        return diapago;
    }

    public void setDiapago(Date diapago) {
        this.diapago = diapago;
    }
    
    
}
