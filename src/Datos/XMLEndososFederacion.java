/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Conexion.AccionesAsegurados;
import Conexion.CargaMasivaEndoso;
import Formularios.Progreso;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author admin
 */
public class XMLEndososFederacion extends Hilo {

    private String ruta;
    private Progreso pro;
    private NodeList listaRegistro;
    private double porcentaje1;
    private double porcentaje = 0.0;
    private DocumentBuilderFactory dbf;
    private DocumentBuilder documentBuilder;
    private Document document;
    SimpleDateFormat date = new SimpleDateFormat("yyyyMMdd");

    public XMLEndososFederacion (){}
    public XMLEndososFederacion (String ruta, Progreso pro){
        this.ruta = ruta;
        this.pro = pro;
        readFile();
    }
    
    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
    
    public void readFile() {
        try {
            File archivo = new File(ruta);
            dbf = DocumentBuilderFactory.newInstance();
            documentBuilder = dbf.newDocumentBuilder();
            document = documentBuilder.parse(archivo);
            document.getDocumentElement().normalize();
            listaRegistro = document.getElementsByTagName("ROW");
            porcentaje1 = 1.0 / listaRegistro.getLength() * 100;
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(XMLPolizasFederacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(XMLPolizasFederacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XMLPolizasFederacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void execute() {
        ListaAsegurados listAseg = AccionesAsegurados.listarAsegurados();
        try {
            ArrayList <Endoso> listend = new ArrayList<>();
            ArrayList <Endoso> listend1 = new ArrayList<>();
            for (int i = 0; i < listaRegistro.getLength(); i++) {
                synchronized (super.m) {
                    while (!m.isTrue()) {
                        try {
                            m.wait();
                        } catch (InterruptedException ex) {
                            Logger.getLogger(XMLPolizasFederacion.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                porcentaje = porcentaje + porcentaje1;
                Node nodo = listaRegistro.item(i);
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nodo;
                    int seccion = 4;
                    if(!element.getAttribute("A").equals(""))seccion = Integer.parseInt(element.getAttribute("A"));
                    int poliza = Integer.parseInt(element.getAttribute("B"));
                    int certificado = 0;
                    if(!element.getAttribute("C").equals(""))certificado = Integer.parseInt(element.getAttribute("C"));
                    int endoso = 0;
                    if(!element.getAttribute("D").equals("")) endoso = Integer.parseInt(element.getAttribute("D"));
                    Date fechamis = date.parse(element.getAttribute("E"));
                    Date desde = date.parse(element.getAttribute("F"));
                    Date hasta = null;
                    if(!element.getAttribute("G").equals(""))hasta = date.parse(element.getAttribute("G"));
                    String tipoEndoso = element.getAttribute("H");
                    int motivo = Integer.parseInt(element.getAttribute("I"));
                    String plan = element.getAttribute("L");
                    int asegurado = Integer.parseInt(element.getAttribute("P"));
                    int moneda = 1;
                    if(!element.getAttribute("Q").equals(""))moneda = Integer.parseInt(element.getAttribute("Q"));
                    double suma = 0;
                    if(!element.getAttribute("V").equals(""))suma = Double.parseDouble(element.getAttribute("V"));
                    double prima = 0;
                    if(!element.getAttribute("W").equals(""))prima = Double.parseDouble(element.getAttribute("W"));
                    int codproducto = 0;
                    if(!element.getAttribute("X").equals(""))Integer.parseInt(element.getAttribute("X"));
                    int usuario = 999;
                    Endoso end = new Endoso();
                    end.setAsegurado(asegurado);
                    end.setCertificado(certificado);
                    end.setCodproducto(codproducto);
                    end.setCompania(1);
                    end.setDesde(desde);
                    end.setEndoso(endoso);
                    end.setFechaemis(fechamis);
                    end.setHasta(hasta);
                    end.setMoneda(moneda);
                    end.setMotivo(motivo);
                    end.setPlan(plan);
                    end.setPoliza(poliza);
                    end.setPrima(prima);
                    end.setSeccion(seccion);
                    end.setSuma(suma);
                    end.setTipoendoso(tipoEndoso);
                    end.setUsuario(usuario);
                    end.setTipoAsegurado(element.getAttribute("O"));
                    boolean ex = false;
                    for (int j = 0; j < listAseg.getSize(); j++) {
                        if (listAseg.getAsegurado(j).getNumasegurado()==end.getAsegurado())ex=true;
                    }
                    if(ex) listend.add(end);
                    else listend1.add(end);
                }
                pro.cant(String.valueOf(i + 1) + " registros procesados de " + listaRegistro.getLength());
                pro.progreso((int) Math.round(porcentaje));
            }
            pro.crono.stop();
            Hilo carga = new CargaMasivaEndoso(pro, listend,listend1);
            carga.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
