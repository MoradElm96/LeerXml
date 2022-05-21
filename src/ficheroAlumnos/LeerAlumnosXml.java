/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficheroAlumnos;

import java.io.File;
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
public class LeerAlumnosXml {
    
    public static void main(String[] args) {
        
        File f = new File("empleados.xml");
        
        try {
        DocumentBuilderFactory dbf =  DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        
        Document documento = db.parse(f);//org
       
        documento.normalize();//para quitar los espacios
        
        
        //creamos el elemento
        
        Element elementoRaiz = documento.getDocumentElement();//importar con org
        
        //obtenemos la lista de los nodos que tiene la etiqueta empleado
       
        NodeList listaEmpleados = elementoRaiz.getElementsByTagName("empleado");//importar con  org
        
        System.out.println("hay : "+ listaEmpleados.getLength());
        
        //recorremos la lista
        
            for (int i = 0; i <listaEmpleados.getLength(); i++) {
                
                //se obtiene la lista de empleado tras otro
                
                Node empleado = listaEmpleados.item(i);
                
                //datos del empleado
                NodeList datosEmpleado = empleado.getChildNodes();
                
                //recorremos la lista de datos
                for (int j = 0; j <datosEmpleado.getLength(); j++) {
                    
                    Node dato = datosEmpleado.item(j);
                    //comprobamos que el dato es de tipo element
                    if(dato.getNodeType()==Node.ELEMENT_NODE){
                        //mostramos el nombre el tipo del dato
                        System.out.println(dato.getNodeName() +": ");
                        
                        Node datoContenido = dato.getFirstChild();
                        //mostramos el valor del contenido en el nodo que debe ser de tipo text
                        if(datoContenido!=null && datoContenido.getNodeType()==Node.TEXT_NODE)
                            
                            System.out.println(datoContenido.getNodeValue());
                    }
                    
                }
                
                System.out.println();
            }
        
        
        
        
        
        
        }catch(Exception e){}
        
        
        
        
        
    }
           
}
