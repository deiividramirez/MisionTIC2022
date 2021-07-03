import json

def Leer(ruta="listadoTareas.json"):
    try:
        with open(ruta, "r") as archivo:
            return json.load(archivo)
    except:
        print("Hubo un error al cargar el archivo")
        Escribir({})
        return Leer()

def Escribir(ListaTareas, ruta="listadoTareas.json"):
    try:
        with open(ruta, "w") as archivo:
            archivo.write( json.dumps(ListaTareas) )
        return True
    except: 
        print("Hubo un error al escribir el archivo")
        return False
    
def Crear(Nombre, Tarea, ListaTareas = Leer()):
    ListaTareas[Nombre] = Tarea
    Escribir(ListaTareas)

def Eliminar(Nombre, ListaTareas = Leer()):
    ListaTareas.pop(Nombre)
    Escribir(ListaTareas)