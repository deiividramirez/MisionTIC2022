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