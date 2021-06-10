from statistics import mean

def Ventas( dic ):
     print(f'''================================================

     Vendedor: {dic["Vendedor"]}
     Ventas Enero: $ {dic["Enero"]}
     Ventas Febrero: $ {dic["Febrero"]}
     Ventas Marzo: $ {dic["Marzo"]}
     
     Promedio de ventas en el trimestre: ${round( mean( [dic["Enero"], dic["Febrero"], dic["Marzo"]] ) )}
     '''
     )

dic = [
     {
          'Vendedor': 'Pedro Lopez',
          'Enero': 20000000,
          'Febrero': 10000000,
          'Marzo': 50000000
     },
     {
          'Vendedor': 'Martha Jaramillo',
          'Enero': 15000000,
          'Febrero': 100000000,
          'Marzo': 6000000
     },
     {
          'Vendedor': 'Sandre Pena',
          'Enero': 5000000,
          'Febrero': 8000000,
          'Marzo': 30000000
     },
     {
          'Vendedor': 'Hugo Marin',
          'Enero': 4000000,
          'Febrero': 2000000,
          'Marzo': 1000000
     }
]

list( map( Ventas, dic ) )