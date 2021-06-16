def promedio(*list): return sum(list)/len(list)

def prueba():
        recaudoEnero = [200000000, 300000000, 500000000, 100000000]
        recaudoFebrero = [120000000, 450000000, 600000000, 800000000]
        recaudoMarzo = [350000000, 300000000, 500000000, 700000000]
        return list( map( promedio, recaudoEnero, recaudoFebrero, recaudoMarzo ) )

def imprimir_resultados():
     Impuestos = ["Acueducto", "Alcantarillado", "Energia", "Aseo"]
     for i in range(4):
          print(f'''Servicio: {Impuestos[i]}

Recaudo Enero : {recaudoEnero[i] :,}
Recaudo Febrero : {recaudoFebrero[i] :,}
Recaudo Marzo : {recaudoMarzo[i] :,} 
Promedio Recaudo Trimestre : {prueba()[i] :,.0f}
Meta: {"No se alcanzó la meta del promedio de Recaudo en el Trimestre" if prueba()[i] <= 500000000 else "Se alcanzó la meta del promedio de Recaudo en el Trimestre"}

======================================================''')



global recaudoEnero, recaudoFebrero, recaudoMarzo
recaudoEnero = [900000000, 600000000, 400000000, 180000000]
recaudoFebrero = [100000000, 450000000, 100000000, 200000000]
recaudoMarzo = [460000000, 120000000, 500000000, 700000000]
imprimir_resultados()