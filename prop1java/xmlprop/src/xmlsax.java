import org.xml.sax.*;
import org.xml.sax.helpers.*;
import javax.xml.parsers.*;
import java.io.File;

public class xmlsax {
    public static void main(String[] args) {
        try {
            // Crear una instancia de SAXParserFactory
            SAXParserFactory factory = SAXParserFactory.newInstance();
            // Habilitar la validación DTD
            factory.setValidating(true);

            // Crear un SAXParser
            SAXParser saxParser = factory.newSAXParser();

            // Definir el manejador de eventos
            DefaultHandler handler = new DefaultHandler() {
                boolean titulo = false;

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    if (qName.equalsIgnoreCase("TITULO")) {
                        titulo = true;
                    }
                }

                @Override
                public void characters(char ch[], int start, int length) throws SAXException {
                    if (titulo) {
                        System.out.println("Título: " + new String(ch, start, length));
                        titulo = false;
                    }
                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    // Manejo del evento de fin de elemento
                }
            };

            // Parsear el archivo XML
            saxParser.parse(new File("ej01_2.xml"), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
