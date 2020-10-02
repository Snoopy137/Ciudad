/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import Datos.XMLPolizasFederacion;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class ConexionBase {
    public static Connection con = null;
    static String usuario = "P29OqZKK1A";
    static String password = "hUfTTSmZxT";
    static String url = "jdbc:mysql://remotemysql.com:3306/";
    static String basee = "P29OqZKK1A";
    
    public static Connection conectar(){
        if (con==null){
            try{
                con = DriverManager.getConnection(url+basee,usuario,password);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        return con;
    }
    
    public static Connection desconectar(){
        if(con!=null){
            try{
                con.close();
                con = null;
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        return con;
    }
    
    public static void main(String[] args) throws SQLException {
        ConexionBase.conectar();
        DocumentBuilderFactory dbf;
        DocumentBuilder documentBuilder;
        NodeList listaRegistro;
        Document document;
        try {
            File archivo = new File("/home/linux/NetBeansProjects/Ciudad/Ciudad/CART_CIUDADES.xml");
            dbf = DocumentBuilderFactory.newInstance();
            documentBuilder = dbf.newDocumentBuilder();
            document = documentBuilder.parse(archivo);
            document.getDocumentElement().normalize();
            listaRegistro = document.getElementsByTagName("ROW");
            for (int i = 0; i < listaRegistro.getLength(); i++) {
                Node nodo = listaRegistro.item(i);
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nodo;
                    int provincia = Integer.parseInt(element.getAttribute("A"));
                    int codigo = Integer.parseInt(element.getAttribute("B"));
                    String nombre = element.getAttribute("C");
                    int codPostal = Integer.parseInt(element.getAttribute("D"));
                    PreparedStatement pst = ConexionBase.con.prepareStatement("INSERT INTO POSTALES VALUES (idPOSTALES,PROVINCIA,CODIGO,NOMBRE,POSTAL),"
                            + "("+(i+1)+","+provincia+","+codigo+", '"+nombre.replace("  ","").replaceAll("'", "\\'")+"',"+codPostal+")\n"
                                    + "ON DUPLICATE key ();");
                    System.out.println(pst);
                    int result = pst.executeUpdate();
                }
            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(XMLPolizasFederacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(XMLPolizasFederacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XMLPolizasFederacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
