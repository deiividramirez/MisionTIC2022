from colorama import init, Fore
from statistics import mean

promedio = lambda *valores: mean(valores)

Asignatura = ["Espanol", "Matematica", "Ciencias Naturales",
              "Ciencias Sociales", "Ingles"]

nota_minima = 3
notas_primer_corte = [4, 4.5, 2, 5, 4]
notas_segundo_corte = [0, 5, 3.3, 4, 5]
notas_tercer_corte = [2, 4.5, 3, 2, 5]
notas_cuarto_corte = [1, 4, 0, 4, 3]

PromedioAsignatura = list( map( promedio, notas_primer_corte, notas_segundo_corte, notas_tercer_corte, notas_cuarto_corte ) )

PromedioFinal = round( mean( PromedioAsignatura ), 1 )

for x in range(0, len(Asignatura)) :
     print(f'''*************************************

     {Asignatura[x]}
          Nota 1: {notas_primer_corte[x]}
          Nota 2: {notas_segundo_corte[x]}
          Nota 3: {notas_tercer_corte[x]}
          Nota 4: {notas_cuarto_corte[x]}
          Promedio: {PromedioAsignatura[x]}
     {Fore.GREEN+"Va aprobando" if PromedioAsignatura[x] >= nota_minima else Fore.RED+"Va reprobando"} 
     {Fore.RESET}''')

print(f'''-------------------------------
     Promedio final: {PromedioFinal}
     Estado Final: {Fore.GREEN+"Aprueba" if PromedioFinal >= nota_minima else Fore.RED+"Reprueba"}{Fore.RESET}
-------------------------------''')