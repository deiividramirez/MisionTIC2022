'''
Una empresa liquida trimestralmente la comisión (4%)  que 
han ganado los vendedores en el periodo, adicionalmente 
se requiere calcular el promedio de las ventas en el 
periodo por vendedor, la comisión de cada mes, total de 
la comisión y el promedio general de ventas.

Vendedor	Calos Andrade	Carmen Nieto	Sandra Torres
Enero 	20000000	6300123	4000000
Febrero	600000	5000000	70000000
Marzo	400000	200000	1000000

Imprimir por pantalla la información de la siguiente manera:

Vendedor: Carlos Andrade
Ventas Enero: $ 0000000
Comisión Enero: $ 000000
--------------------------------------------------------
Ventas Febrero: $ 0000000
Comisión febrero: $ 000000
--------------------------------------------------------
Ventas Marzo: $ 0000000
Comisión marzo : $ 000000
---------------------------------------------------------------------
Promedio de ventas del vendedor en el trimestre $ 0000000
Total Comisión del vendedor: $ 000000000
Promedio general de ventas en el trimestre: $ 0000000000
'''

from statistics import mean

def liquidarComision( dic:dict ):
     ventas = [dic["Enero"], dic["Febrero"], dic["Marzo"]]
     comision = list( map( lambda x: x*.04, ventas) )
     print(
f'''
Vendedor: {dic["Vendedor"]}
Ventas Enero: ${ventas[0] :,}
Comisión Enero: ${comision[0] :,}
--------------------------------------------------------
Ventas Febrero: ${ventas[1] :,}
Comisión febrero: ${comision[1] :,}
--------------------------------------------------------
Ventas Marzo: ${ventas[2] :,}
Comisión marzo : ${comision[2] :,}
--------------------------------------------------------
Promedio de ventas del vendedor en el trimestre ${mean( ventas ) :,.0f}
Total Comisión del vendedor: ${sum(comision) :,}
'''
     )
     return mean(ventas)


dic = [
     {
          'Vendedor': "Calos Andrade",
          'Enero': 20000000,
          'Febrero':  600000,
          'Marzo': 400000
     },
     {
          'Vendedor': "Carmen Nieto",
          'Enero': 4000000,
          'Febrero':  5000000,
          'Marzo': 200000
     },
     {
          'Vendedor': "Sandra Torres",
          'Enero': 4000000,
          'Febrero':  70000000,
          'Marzo': 1000000
     }
]

liquidacion = list( map( liquidarComision, dic ) )
print(f'''
Promedio general de ventas en el trimestre: ${mean(liquidacion) :,.0f}
''')