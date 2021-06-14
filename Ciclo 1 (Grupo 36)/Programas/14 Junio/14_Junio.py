from tkinter import *
import tkinter.messagebox
import sqlite3

# CREAMOS LAS FUNCIONES PARA LLAMARLAS DESDE EL MENU ARCHIVO
def abrir():
    tkinter.messagebox.showinfo("Mensaje", "Dio CLic en la opcion Abrir")

# Funcnion crear televisor
def crearTelevisor():
     conexion = sqlite3.connect("electrodomesticos.s3db")
     cursor = conexion.cursor()
     cursor.execute("insert into televisores (marca,modelo) values ('" +
                    marcaTv.get()+"','"+modeloTv.get()+"')")
     conexion.commit()
     conexion.close()
     tkinter.messagebox.showinfo("Mensaje", "Televisor guardado con exito!")
