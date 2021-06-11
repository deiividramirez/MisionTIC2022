'''
En un municipio de Colombia se recauda los 
impuestos de Industria y Comercio, Predial, 
Alcohol, cigarrillos y loterías y Sobretasa 
a la gasolina. Se desea conocer el promedio 
de los recaudos por cada uno de los impuestos 
en el primer trimestre del año 2021. 
Adicionalmente se requiere saber si el promedio 
de recaudo por cada impuesto cumplió la meta 
propuesta para el trimestre. El sistema debe 
imprimir un mensaje: “Se alcanzó la meta del 
promedio de Recaudo en el Trimestre”, si el promedio 
de recudo supera los 500 millones de pesos, de 
lo contrario, el sistema debe imprimir el mensaje: 
“No se alcanzó la meta del promedio de Recaudo 
en el Trimestre”. Se debe procesar los datos 
teniendo en cuenta la siguiente información: 

1. Nombre del Impuesto: “Industria y Comercio” 
o “Predial” o “Alcohol, cigarrillos y loterías” 
o “Sobretasa a la gasolina” 
2. Mes: “Enero” o “Febrero” o “Marzo” 
3. Valor recaudado en el mes: int
'''

from statistics import mean

def Recaudo( listas ):
     IyC, Pl, Ahl, SoG = [], [], [], []
     for lista in listas:
          if lista['Impuesto'] == 'Industria y Comercio':
               IyC.append( lista['Valor'] )
          elif lista['Impuesto'] == 'Predial':
               Pl.append( lista['Valor'] )
          elif lista['Impuesto'] == 'Alcohol, cigarrillos y loterías':
               Ahl.append( lista['Valor'] )
          elif lista['Impuesto'] == 'Sobretasa a la gasolina':
               SoG.append( lista['Valor'] )
     print(
     f'''
Promedio impuestos Industria y comercio: {mean( IyC ) :,}
{"Se alcanzo la meta de recaudo" if mean( IyC ) >= 500000000 else "No se alcanzo la meta de recaudo"}

Promedio impuestos Predial: {mean( Pl ) :,}
{"Se alcanzo la meta de recaudo" if mean( Pl ) >= 500000000 else "No se alcanzo la meta de recaudo"}

Promedio impuestos Alcohol, cigarrillos y loterías: {mean( Ahl ) :,}
{"Se alcanzo la meta de recaudo" if mean( Ahl ) >= 500000000 else "No se alcanzo la meta de recaudo"}

Promedio impuestos Sobretasa a la gasolina: {mean( SoG ) :,}
{"Se alcanzo la meta de recaudo" if mean( SoG ) >= 500000000 else "No se alcanzo la meta de recaudo"}
     ''')


dic = [
     {
          'Impuesto': 'Sobretasa a la gasolina',
          'Mes': 'Enero',
          'Valor': 251422542
     },
     {
          'Impuesto': 'Predial',
          'Mes': 'Febrero',
          'Valor': 2558002542
     },
     {
          'Impuesto': 'Alcohol, cigarrillos y loterías',
          'Mes': 'Enero',
          'Valor': 2512079542
     },
     {
          'Impuesto': 'Industria y Comercio',
          'Mes': 'Marzo',
          'Valor': 242512542
     },
     {
          'Impuesto': 'Industria y Comercio',
          'Mes': 'Febrero',
          'Valor': 258512542
     },
     {
          'Impuesto': 'Predial',
          'Mes': 'Febrero',
          'Valor': 8525012542
     },
     {
          'Impuesto': 'Alcohol, cigarrillos y loterías',
          'Mes': 'Marzo',
          'Valor': 9320512542
     },
     {
          'Impuesto': 'Sobretasa a la gasolina',
          'Mes': 'Marzo',
          'Valor': 2512542
     },
     {
          'Impuesto': 'Predial',
          'Mes': 'Febrero',
          'Valor': 2512542
     },
     {
          'Impuesto': 'Alcohol, cigarrillos y loterías',
          'Mes': 'Marzo',
          'Valor': 2512542
     },
     {
          'Impuesto': 'Industria y Comercio',
          'Mes': 'Enero',
          'Valor': 2512542
     },
     {
          'Impuesto': 'Industria y Comercio',
          'Mes': 'Enero',
          'Valor': 2512542
     },
     {
          'Impuesto': 'Predial',
          'Mes': 'Enero',
          'Valor': 2512542
     },
     {
          'Impuesto': 'Alcohol, cigarrillos y loterías',
          'Mes': 'Enero',
          'Valor': 2512542
     }
]

Recaudo( dic )