import xml.sax

# Definir un controlador de eventos SAX
class MiControladorSAX(xml.sax.ContentHandler):
    def startElement(self, name, attrs):
        print("Elemento:", name)
        print("Atributos:")
        for attr_name, attr_value in attrs.items():
            print(f"{attr_name}: {attr_value}")
    

# Crear un parser SAX y asignarle el controlador de eventos
parser = xml.sax.make_parser()
handler = MiControladorSAX()
parser.setContentHandler(handler)

# Parsear un archivo XML utilizando SAX
parser.parse('boe.xml')

