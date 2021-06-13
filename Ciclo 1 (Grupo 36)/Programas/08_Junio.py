# Ejercicio 1 :
equipos = ["America", "Millonarios", "Tolima", "Cali", "Junior", "Medellin"]
filtro = list(map( lambda x: x[0] == "T", equipos ))
print(filtro)

# Ejercicio 2:
equipos = ["América", "Millonarios", "Tolima", "Cali", "Junior", "Medellin"]
filtro = list(filter( lambda x: x[0] == "T",  equipos))
print(filtro)

# Ejercicio 3:
productos = [100000, 250000, 300000, 3000000]
filtro = list(map( lambda x: x*1.05, productos))
print(filtro)

## Ejercicios UNIDAD 4 - iMaster

# Ejercicio 1:
frase = "Tengo cosas que hacer"
lista = list(map( len, frase.split(" ") ))
print(lista)

# Ejercicio 2:
from functools import reduce
lista = [1,2,3]
nume = int(reduce(lambda x, y: str(x) + "" + str(y), lista))
print(nume)

# Ejercicio 3
equipos = ["América", "Millonarios", "Tolima", "Cali", "Junior", "Medellin"]
filtro = list(filter( lambda x: x[0] == "T",  equipos))
print(filtro)

# Ejercicio 4
listas = [['A', 'a'],['B','b'] ]
concat = ["-".join(lista) for lista in listas]
print(concat)

# Ejercicio 5
lista = [12, 13, 14, 15]
dic = {lista: i+1 for i, lista in enumerate(lista)}
print(dic)

# Ejercicio 6
lista = [12, 13, 14, 15, 5, 6, 7]
dic = {lista: i+1 for i, lista in enumerate(lista)}
print([i for i in dic if dic[i] == i])
