def promedio(*list):  return sum(list)/len(list)

def imprimir_resultados():
     global recaudoEnero, recaudoFebrero, recaudoMarzo
     Impuestos = ["Acueducto", "Alcantarillado", "Energia", "Aseo"]

     promedios = list( map( promedio, recaudoEnero, recaudoFebrero, recaudoMarzo ) )
     for i in range(4):
          print(f'''Servicio: {Impuestos[i]}
                
Recaudo Enero : {recaudoEnero[i] :,}
Recaudo Febrero : {recaudoFebrero[i] :,}
Recaudo Marzo : {recaudoMarzo[i] :,}
Promedio Recaudo Trimestre : {promedios[i] :,.0f}
Meta: {"No se alcanzó la meta del promedio de Recaudo en el Trimestre" if promedios[i] <= 500000000 else "Se alcanzó la meta del promedio de Recaudo en el Trimestre"}

======================================================''')

global recaudoEnero, recaudoFebrero, recaudoMarzo
recaudoEnero = [900000000, 600000000, 400000000, 180000000]
recaudoFebrero = [100000000, 450000000, 100000000, 200000000]
recaudoMarzo = [460000000, 120000000, 500000000, 700000000]
imprimir_resultados()