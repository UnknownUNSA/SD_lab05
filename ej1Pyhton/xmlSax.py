import xml.sax

# Definir un controlador de eventos SAX
class MiControladorSAX(xml.sax.ContentHandler):
    def startElement(self, name, attrs):
        print("Elemento:", name)
        
    def characters(self, content):
        content = content.strip()
        if content:
            print("Valor:", content)

# Crear un parser SAX y asignarle el controlador de eventos
parser = xml.sax.make_parser()
handler = MiControladorSAX()
parser.setContentHandler(handler)

# Parsear un archivo XML utilizando SAX
xml_file = "boe.xml"
with open(xml_file, "r") as file:
    parser.parse(file)

