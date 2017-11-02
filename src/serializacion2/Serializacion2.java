/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializacion2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

/**
 *
 * @author oracle
 */
public class Serializacion2 {

    /**
     * @param args the command line arguments
     */
    
    static XMLStreamWriter xmls;
    static XMLOutputFactory outputFactory = XMLOutputFactory.newFactory();
    
    static File arcxml = new File("/home/oracle/NetBeansProjects/serializacion2xml/products.xml");
    static File archivo = new File ("/home/oracle/NetBeansProjects/xmlReader/array.txt");
    
    static String[]cod={"obj1","obj2","obj3"};
    static int[]des={0,1,2};
    static int[]prezo={0,1,2};

    
    public static void main(String[] args) throws IOException, XMLStreamException {
        // TODO code application logic here
        product obj1 = new product(cod[0],des[0],prezo[0]);
        product obj2 = new product(cod[1],des[1],prezo[1]);
        product obj3 = new product(cod[2],des[2],prezo[2]);
       
        xmlandarray(obj1, obj2, obj3, arcxml, archivo);
        
    }

    static void xmlandarray(product p1, product p2, product p3, File arcxml, File archivo) throws XMLStreamException{
        try {
            XMLInputFactory lec=XMLInputFactory.newInstance();
            XMLStreamReader red=lec.createXMLStreamReader(new FileInputStream(arcxml));      
            while (red.hasNext()){
                int eventType=red.next();
                switch (eventType){
                    case XMLStreamReader.START_DOCUMENT:
                        break;
                    case XMLStreamReader.START_ELEMENT:
                        System.out.println(red.getLocalName());
                        if (red.getAttributeCount()>0){
                            System.out.println(red.getAttributeName(0)+"="+red.getAttributeValue(0));
                        }
                        break;
                    case XMLStreamReader.CHARACTERS:
                        System.out.println(red.getText());
                        break;
                    case XMLStreamReader.END_ELEMENT:
                        break;
                }
            }
        } catch (XMLStreamException ex) {
            Logger.getLogger(Serializacion2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Serializacion2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
              ObjectOutputStream esc = new ObjectOutputStream(new FileOutputStream(archivo));
              esc.writeObject(p1);
              esc.writeObject(p2);
              esc.writeObject(p3);
              esc.writeObject(null);
              esc.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Serializacion2.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Serializacion2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    
}
    
    