def consolidar_ventas(datos: list) -> dict:
  norte, sur = 0, 0
  for dato in datos:
    if dato["sede"] == "sur":
      sur += dato["total_factura"]
    elif dato["sede"] == "norte":
      norte += dato["total_factura"]
    
  return {"total_ventas": norte + sur, "total_ventas_norte": norte, "total_ventas_sur": sur}
