/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Conexion.CargaMasivaAutos;
import Formularios.Progreso;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
 * @author linux
 */
public class XMLAutosFederacion extends Hilo{

    private String ruta;
    private Progreso pro;
    private NodeList listaRegistro;
    private double porcentaje1;
    private double porcentaje = 0.0;
    private DocumentBuilderFactory dbf;
    private DocumentBuilder documentBuilder;
    private Document document;
    SimpleDateFormat date = new SimpleDateFormat("yyyyMMdd");

    public XMLAutosFederacion (){}
    public XMLAutosFederacion (String ruta, Progreso pro){
        this.ruta = ruta;
        this.pro = pro;
        readFile();
    }
    @Override
    public void execute() {
        ArrayList<Autos> listAutos = new ArrayList<>();
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
                int seccion = Integer.parseInt(element.getAttribute("A"));
                int poliza = Integer.parseInt(element.getAttribute("B"));
                
                Autos auto = new Autos();
                listAutos.add(auto);
            }
            pro.cant(String.valueOf(i + 1) + " registros procesados de " + listaRegistro.getLength());
            pro.progreso((int) Math.round(porcentaje));
        }
        pro.crono.stop();
        Hilo carga = new CargaMasivaAutos(pro, listAutos);
        carga.execute();
    }
    
    private void readFile() {
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
