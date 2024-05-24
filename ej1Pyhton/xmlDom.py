import xml.dom.minidom

# Parsear el archivo XML
xml_file = 'boe.xml'  # Reemplaza con la ruta de tu archivo XML
dom = xml.dom.minidom.parse(xml_file)

# Obtener la raíz del documento XML
root = dom.documentElement

# Función para imprimir los elementos y sus atributos
def print_elements(node, indent=""):
    if node.nodeType == node.ELEMENT_NODE:
        print(f"{indent}Elemento: {node.tagName}")
        attrs = node.attributes
        if attrs:
            print(f"{indent}Atributos:")
            for attr_name, attr_value in attrs.items():
                print(f"{indent}{attr_name}: {attr_value.value}")
    
    # Recorrer los hijos del nodo actual
    for child in node.childNodes:
        print_elements(child, indent + "  ")

# Imprimir los elementos y atributos comenzando desde la raíz
print_elements(root)

