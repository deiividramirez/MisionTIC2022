def definir_beca(dato: dict):
    if dato["promedio"] >= 3.5 and dato["estrato"] <= 2:
        a = {"estudiante": dato["estudiante"], "tipoBeca": "La Beca incluye sostenimiento económico y el pago del 100 por ciento de los costos académicos."}
    
    elif dato["promedio"] >= 4 and dato["estrato"] == 3:
        a = {"estudiante": dato["estudiante"], "tipoBeca": "La Beca de estudio cubre el 70 por ciento de los costos académicos"}

    elif dato["promedio"] >= 3.5 and dato["estrato"] == 3:
        a = {"estudiante": dato["estudiante"], "tipoBeca": "La Beca de estudio cubre el 40 por ciento de los costos académicos"}
    
    elif dato["promedio"] >= 4 and dato["estrato"] == 4:
        a = {"estudiante": dato["estudiante"], "tipoBeca": "La Beca de estudio cubre el 30 por ciento de los costos académicos"}
        
    return a

def asignacion_becas(datos: dict):
    return f'{datos["estudiante"]} - Tipo Beca: {datos["tipoBeca"]}'
