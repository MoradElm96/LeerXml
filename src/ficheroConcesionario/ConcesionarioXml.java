/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficheroConcesionario;

import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Morad
 */
public class ConcesionarioXml {
    
    public static void main(String[] args) {
        
        File f = new File("concesionario.xml");
        ArrayList<Coche> lista= new ArrayList<>();
        Coche coche;
        
        
        //trycatch
        
        try{
            
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            
            //javax
            DocumentBuilder db = dbf.newDocumentBuilder();
            
             //org
            Document d = db.parse(f);
            //accede al nodo raiz y normaliza el documento para evitar espacios 
            d.getDocumentElement().normalize();
            
            NodeList nodeList = d.getElementsByTagName("coche");//importar con org
            System.out.println("Numero de coches  " + nodeList.getLength());
            
            //procedemos a leer su contenido
            
            for(int i=0; i<nodeList.getLength(); i++){
                
                Node node= nodeList.item(i);//import con org
                
                if(node.getNodeType()== Node.ELEMENT_NODE){
                    Element elemento= (Element) node;//import con org
                    /*
                    System.out.println(" \nCoche id: " + elemento.getAttribute("id"));
                    
                    System.out.println(" Marca: "+ elemento.getElementsByTagName("marca").item(0).getTextContent());
                    System.out.println(" Modelo: "+ elemento.getElementsByTagName("modelo").item(0).getTextContent());
                    System.out.println(" Cilindrada: "+ elemento.getElementsByTagName("cilindrada").item(0).getTextContent());
                    */
                    String id =   elemento.getAttribute("id") ;
                    String marca = elemento.getElementsByTagName("marca").item(0).getTextContent();
                    String modelo = elemento.getElementsByTagName("modelo").item(0).getTextContent();
                    double cilindrada = Double.parseDouble(elemento.getElementsByTagName("cilindrada").item(0).getTextContent());
                    
                    //guardamos un nuevo objeto en la lista
                    coche = new Coche(id, marca, modelo, cilindrada);
                    lista.add(coche);
                     
                }
                  
            }
            
            
            
            
        
    }catch(Exception e){
    e.printStackTrace();
    }
        //recorremos la lista y la mostramos por pantalla
        for (Coche coche1 : lista) {
            
            System.out.println(coche1);
            
        }
        
    }
    
}
