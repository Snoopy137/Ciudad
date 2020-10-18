/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Conexion.CargaMasivaRecibos;
import Formularios.Progreso;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.logging.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

/**
 *
 * @author linux
 */
public final class XMLRecibosFederacion extends Hilo{

    private String ruta;
    private Progreso pro;
    private NodeList listaRegistro;
    private double porcentaje1;
    private double porcentaje = 0.0;
    private DocumentBuilderFactory dbf;
    private DocumentBuilder documentBuilder;
    private Document document;
    SimpleDateFormat date = new SimpleDateFormat("yyyyMMdd");

    public XMLRecibosFederacion (){}
    public XMLRecibosFederacion (String ruta, Progreso pro){
        this.ruta = ruta;
        this.pro = pro;
        readFile();
    }
    @Override
    public void execute() {
        try {
            ArrayList<Recibos> listRecibos = new ArrayList<>();
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
                    int compania = 1;
                    int seccion = 4;
                    if (!element.getAttribute("A").equals("")) {
                        seccion = Integer.parseInt(element.getAttribute("A"));
                    }
                    int poliza = Integer.parseInt(element.getAttribute("B"));
                    int certificado = 0;
                    if (!element.getAttribute("C").equals("")) {
                        certificado = Integer.parseInt(element.getAttribute("C"));
                    }
                    int endoso = 0;
                    if (!element.getAttribute("D").equals("")) {
                        endoso = Integer.parseInt(element.getAttribute("D"));
                    }
                    Date fecvenc = date.parse(element.getAttribute("E"));
                    int estado = 1;
                    if (!element.getAttribute("F").equals("")) {
                        estado = Integer.parseInt(element.getAttribute("F"));
                    }
                    int cuota = Integer.parseInt(element.getAttribute("G"));
                    String anticipo = element.getAttribute("H");
                    Double prima = 0.0;
                    if(!element.getAttribute("I").equals("")) prima = Double.parseDouble(element.getAttribute("I"));
                    Double premio = 0.0;
                    if(!element.getAttribute("J").equals(""))Double.parseDouble(element.getAttribute("J"));
                    Recibos recibo = new Recibos(compania, seccion, poliza, certificado, endoso, fecvenc, estado, cuota, anticipo, prima, premio);
                    listRecibos.add(recibo);
                }
                pro.cant(String.valueOf(i + 1) + " registros procesados de " + listaRegistro.getLength());
                pro.progreso((int) Math.round(porcentaje));
            }
            pro.crono.stop();
            Hilo carga = new CargaMasivaRecibos(pro, listRecibos);
            carga.execute();
        } 
        catch (ParseException ex) {
            Logger.getLogger(XMLRecibosFederacion.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(XMLPolizasFederacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
