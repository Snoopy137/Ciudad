/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Conexion.CargaMasivaPolizas;
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
 * @author AlanDec
 */
public class XMLPolizas extends Hilo {

    private String ruta;
    private Progreso pro;
    private NodeList listaRegistro;
    private double porcentaje1;
    private double porcentaje = 0.0;
    private DocumentBuilderFactory dbf;
    private DocumentBuilder documentBuilder;
    private Document document;
    SimpleDateFormat date = new SimpleDateFormat("yyyyMMdd");

    public XMLPolizas (){}
    public XMLPolizas (String ruta, Progreso pro){
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
            System.out.println(listaRegistro.getLength());
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(XMLPolizas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(XMLPolizas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XMLPolizas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void execute() {
        try {
            ArrayList <Polizas> polist = new ArrayList<>();
            for (int i = 0; i < listaRegistro.getLength(); i++) {
                synchronized (super.m) {
                    while (!m.isTrue()) {
                        try {
                            m.wait();
                        } catch (InterruptedException ex) {
                            Logger.getLogger(XMLPolizas.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                porcentaje = porcentaje + porcentaje1;
                Node nodo = listaRegistro.item(i);
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nodo;
                    int seccion = 4;
                    if(!element.getAttribute("A").equals("")){
                        seccion = Integer.parseInt(element.getAttribute("A"));
                    }
                    int poliza = Integer.parseInt(element.getAttribute("B"));
                    int certificado = 0;
                    if(!element.getAttribute("C").equals("")){
                        certificado = Integer.parseInt(element.getAttribute("C"));
                    }
                    int renueva = 0;
                    if (!element.getAttribute("U").equals("")){
                        renueva = Integer.parseInt(element.getAttribute("U"));
                    }
                    int renovadapor = 0;
                    if (!element.getAttribute("S").equals("")){
                        renovadapor = Integer.parseInt(element.getAttribute("S"));
                    }
                    int productor = Integer.parseInt(element.getAttribute("L"));
                    Date fechamis = date.parse(element.getAttribute("H"));
                    Date desde = date.parse(element.getAttribute("I"));
                    Date hasta = null;
                    if(!element.getAttribute("J").equals("")){
                        hasta = date.parse(element.getAttribute("J"));
                    }
                    int estado = 1;
                    if(!element.getAttribute("F").equals("")){
                        estado = Integer.parseInt(element.getAttribute("F"));
                    }
                    Date fechaestado = date.parse(element.getAttribute("G"));
                    int asegurado = Integer.parseInt(element.getAttribute("E"));
                    int moneda = 1;
                    if (!element.getAttribute("R").equals("")){
                        moneda = Integer.parseInt(element.getAttribute("R"));
                    }
                    int usuario = 999;
                    int formapago = 1;
                    if (!element.getAttribute("N").equals(""))Integer.parseInt(element.getAttribute("N"));
                    if (element.getAttribute("N").equals("")){
                        System.out.println(poliza);
                    }
                    Polizas p = new Polizas();
                    p.setAsegurado(asegurado);
                    p.setSeccion(seccion);
                    p.setRenovadapor(renovadapor);
                    p.setPoliza(poliza);
                    p.setCertificado(certificado);
                    p.setRenueva(renueva);
                    p.setProductor(productor);
                    p.setFechamis(fechamis);
                    p.setDesde(desde);
                    p.setHasta(hasta);
                    p.setEstado(estado);
                    p.setFechaestado(fechaestado);
                    p.setAsegurado(asegurado);
                    p.setMoneda(moneda);
                    p.setUsuario(usuario);
                    p.setFormapago(formapago);
                    polist.add(p);
                }
                pro.cant(String.valueOf(i + 1) + " registros procesados de " + listaRegistro.getLength());
                pro.progreso((int) Math.round(porcentaje));
            }
            pro.crono.stop();
            System.out.println("Proceso completado");
            Hilo carga = new CargaMasivaPolizas(pro, polist);
            carga.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
