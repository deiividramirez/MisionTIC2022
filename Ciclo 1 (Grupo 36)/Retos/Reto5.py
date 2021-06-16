import numpy as np
import pandas as pd

def examen(ruta_archivo_csv: str) -> dict:
     try:
          archivo = pd.read_csv( ruta_archivo_csv )
     except:
          print("No es posible leer los Datos, verifique la ruta")
     
     tabla = archivo.groupby("sexo").agg(np.mean)
     
     dic = archivo.to_dict()
     
     return f"""
{tabla}

{dic}
"""


print(examen('https://raw.githubusercontent.com/pepija/mintic-p36/main/examen_hemoglobina.csv'))