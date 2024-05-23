import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;

public class xmldom {
    public static void main(String[] args) {
        try {
            // Crear una instancia de DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // Habilitar la validación DTD
            factory.setValidating(true);
            factory.setNamespaceAware(true);

            // Crear un DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parsear el archivo XML
            Document document = builder.parse(new File("ej01_2.xml"));

            // Normalizar el documento XML
            document.getDocumentElement().normalize();

            // Obtener el elemento raíz
            Element root = document.getDocumentElement();
            System.out.println("Elemento raíz: " + root.getNodeName());

            // Obtener y mostrar elementos del documento
            NodeList nList = document.getElementsByTagName("TITULO");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nElemento actual: " + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Título: " + eElement.getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
