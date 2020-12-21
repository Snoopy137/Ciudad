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
public class Companias {
    private int idcompanias;
    private String nombrecompanias;
    private String nombrereducido;
    private String url;
    private String prodcontacto;
    private String prodmail;
    private String prodtelef;
    private String cobcontacto;
    private String cobmail;
    private String cobtelef;
    private String sincontacto;
    private String sinmail;
    private String sintelef;
    private String logcontacto;
    private String logmail;
    private String logtelef;
    private int prod1;
    private String prod1usu;
    private String prod1clave;
    private int prod2;
    private String prod2usu;
    private String prod2clave;        
    private int prod3;
    private String prod3usu;
    private String prod3clave;
            
    
    public Companias(){}
    public Companias (int id, String nombre){
        this.idcompanias = id;
        this.nombrecompanias = nombre;
    }

    public Companias(int idcompanias, String nombrecompanias, String nombrereducido, String url, String prodcontacto, String prodmail, String prodtelef, String cobcontacto, String cobmail, String cobtelef, String sincontacto, String sinmail, String sintelef, String logcontacto, String logmail, String logtelef, int prod1, String prod1usu, String prod1clave, int prod2, String prod2usu, String prod2clave, int prod3, String prod3usu, String prod3clave ) {
        this.idcompanias = idcompanias;
        this.nombrecompanias = nombrecompanias;
        this.nombrereducido = nombrereducido;
        this.url = url;
        this.prodcontacto = prodcontacto;
        this.prodmail = prodmail;
        this.prodtelef = prodtelef;
        this.cobcontacto = cobcontacto;
        this.cobmail = cobmail;
        this.cobtelef = cobtelef;
        this.sincontacto = sincontacto;
        this.sinmail = sinmail;
        this.sintelef = sintelef;
        this.logcontacto = logcontacto;
        this.logmail = logmail;
        this.logtelef = logtelef;
        this.prod1 = prod1;
        this.prod1usu = prod1usu;
        this.prod1clave = prod1clave;
        this.prod2 = prod2;
        this.prod2usu = prod2usu;
        this.prod2clave = prod2clave;
        this.prod3 = prod3;
        this.prod3usu = prod3usu;
        this.prod3clave = prod3clave;
    }
    
    public String getUrl() {
        return url;
    }

    
    
    public void setUrl(String url) {
        this.url = url;
    }
    
    public int getIdcompanias() {
        return idcompanias;
    }

    public void setIdcompanias(int idcompanias) {
        this.idcompanias = idcompanias;
    }

    public String getNombrecompanias() {
        return nombrecompanias;
    }

    public void setNombrecompanias(String nombrecompanias) {
        this.nombrecompanias = nombrecompanias;
    }
    
    public String getNombrereducido() {
        return nombrereducido;
    }

    public void setNombrereducido(String nombrereducido) {
        this.nombrereducido = nombrereducido;
    }

    public String getProdcontacto() {
        return prodcontacto;
    }

    public void setProdcontacto(String prodcontacto) {
        this.prodcontacto = prodcontacto;
    }
    
    public String getProdmail() {
        return prodmail;
    }

    public void setProdmail(String prodmail) {
        this.prodmail = prodmail;
    }

    public String getProdtelef() {
        return prodtelef;
    }

    public void setProdtelef(String prodtelef) {
        this.prodtelef = prodtelef;
    }

    public String getCobcontacto() {
        return cobcontacto;
    }

    public void setCobcontacto(String cobcontacto) {
        this.cobcontacto = cobcontacto;
    }

    public String getCobmail() {
        return cobmail;
    }

    public void setCobmail(String cobmail) {
        this.cobmail = cobmail;
    }

    public String getCobtelef() {
        return cobtelef;
    }

    public void setCobtelef(String cobtelef) {
        this.cobtelef = cobtelef;
    }

    public String getSincontacto() {
        return sincontacto;
    }

    public void setSincontacto(String sincontacto) {
        this.sincontacto = sincontacto;
    }

    public String getSinmail() {
        return sinmail;
    }

    public void setSinmail(String sinmail) {
        this.sinmail = sinmail;
    }

    public String getSintelef() {
        return sintelef;
    }

    public void setSintelef(String sintelef) {
        this.sintelef = sintelef;
    }

    public String getLogcontacto() {
        return logcontacto;
    }

    public void setLogcontacto(String logcontacto) {
        this.logcontacto = logcontacto;
    }

    public String getLogmail() {
        return logmail;
    }

    public void setLogmail(String logmail) {
        this.logmail = logmail;
    }

    public String getLogtelef() {
        return logtelef;
    }

    public void setLogtelef(String logtelef) {
        this.logtelef = logtelef;
    }

    public int getProd1() {
        return prod1;
    }

    public void setProd1(int prod1) {
        this.prod1 = prod1;
    }

    public String getProd1usu() {
        return prod1usu;
    }

    public void setProd1usu(String prod1usu) {
        this.prod1usu = prod1usu;
    }

    public String getProd1clave() {
        return prod1clave;
    }

    public void setProd1clave(String prod1clave) {
        this.prod1clave = prod1clave;
    }

    public int getProd2() {
        return prod2;
    }

    public void setProd2(int prod2) {
        this.prod2 = prod2;
    }

    public String getProd2usu() {
        return prod2usu;
    }

    public void setProd2usu(String prod2usu) {
        this.prod2usu = prod2usu;
    }

    public String getProd2clave() {
        return prod2clave;
    }

    public void setProd2clave(String prod2clave) {
        this.prod2clave = prod2clave;
    }

    public int getProd3() {
        return prod3;
    }

    public void setProd3(int prod3) {
        this.prod3 = prod3;
    }

    public String getProd3usu() {
        return prod3usu;
    }

    public void setProd3usu(String prod3usu) {
        this.prod3usu = prod3usu;
    }

    public String getProd3clave() {
        return prod3clave;
    }

    public void setProd3clave(String prod3clave) {
        this.prod3clave = prod3clave;
    }
}
