import numpy as np
import pandas as pd

def examen(ruta_archivo_csv: str) -> dict:
     try:
          return pd.read_csv(ruta_archivo_csv)
     except:
          print("No es posible leer los Datos, verifique la ruta")

