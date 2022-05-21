/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficheroNotas;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
 * @author Morad
 */
public class LeecturaAlumnos {
    
    public static void main(String[] args) {
        
        ArrayList<Alumno> lista = new ArrayList<>();
        Alumno al;
        
        File f = new File("notas.xml");
        
         String id,nombre;
    int nota1,nota2,proyecto,practica;
        
        try {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        
        DocumentBuilder db = dbf.newDocumentBuilder();
        
        Document d = db.parse(f);
        
        
        
        d.getDocumentElement().normalize();
        
        NodeList nodelista = d.getElementsByTagName("alumno");
        System.out.println("Numero de alumnos " + nodelista.getLength());
        
            for (int i = 0; i < nodelista.getLength(); i++) {
                Node node = nodelista.item(i);
                
                if(node.getNodeType() == Node.ELEMENT_NODE){
                Element element =(Element) node.getChildNodes();
                
                id =element.getAttribute("id");
                nombre = element.getElementsByTagName("nombre").item(0).getTextContent();
                nota1 = Integer.parseInt(element.getElementsByTagName("nota1").item(0).getTextContent());
                
                nota2 = Integer.parseInt(element.getElementsByTagName("nota2").item(0).getTextContent());
                proyecto = Integer.parseInt(element.getElementsByTagName("proyecto").item(0).getTextContent());
                practica = Integer.parseInt(element.getElementsByTagName("practica").item(0).getTextContent());
                
                al = new Alumno(id, nombre, nota1, nota2, proyecto, practica);
                lista.add(al);
                
                
                }
                
                
            }
            
            
            
            for (Alumno alumno : lista) {
                
                System.out.println(alumno);
                //probamos a trabajar con la lista
                int suma = alumno.nota1 + alumno.nota2;
                
                
                
            }
        
        
            
            
            
            
            
        
        }catch(IOException | ParserConfigurationException | SAXException e){}
        
        
        
    }
           
    
}
