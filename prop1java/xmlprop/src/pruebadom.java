import org.w3c.dom.*;
import javax.xml.parsers.*;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import java.io.File;
import java.io.IOException;

public class pruebadom {
    public static void main(String[] args) {
        try {
            // Crear una instancia de DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // Habilitar la validación DTD
            factory.setValidating(true);
            factory.setNamespaceAware(true);

            // Crear un DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Definir un ErrorHandler para manejar errores de validación
            builder.setErrorHandler(new ErrorHandler() {
                @Override
                public void warning(SAXParseException exception) throws SAXException {
                    System.out.println("Warning: " + exception.getMessage());
                }

                @Override
                public void error(SAXParseException exception) throws SAXException {
                    System.out.println("Error: " + exception.getMessage());
                }

                @Override
                public void fatalError(SAXParseException exception) throws SAXException {
                    System.out.println("Fatal error: " + exception.getMessage());
                }
            });

            // Parsear el archivo XML
            Document document = builder.parse(new File("ej01_2.xml"));

            // Normalizar el documento XML
            document.getDocumentElement().normalize();

            // Recorrer y mostrar elementos del documento
            traverseNode(document.getDocumentElement(), "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método recursivo para recorrer y mostrar todos los nodos
    private static void traverseNode(Node node, String indent) {
        System.out.println(indent + "Node: " + node.getNodeName() + ", Value: " + node.getNodeValue());

        NamedNodeMap attributes = node.getAttributes();
        if (attributes != null) {
            for (int i = 0; i < attributes.getLength(); i++) {
                Node attr = attributes.item(i);
                System.out.println(indent + "  Attribute: " + attr.getNodeName() + ", Value: " + attr.getNodeValue());
            }
        }

        NodeList children = node.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            traverseNode(children.item(i), indent + "  ");
        }
    }
}
