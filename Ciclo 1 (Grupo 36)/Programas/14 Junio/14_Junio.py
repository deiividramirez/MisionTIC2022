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
     # Funcion Buscar Televisor

def buscarTelevisor():
     conexion = sqlite3.connect("electrodomesticos.s3db")
     cursor = conexion.cursor()
     sql = "select idTelevisor,marca , modelo from televisores where idTelevisor=" + codigoTv.get()
     cursor.execute(sql)
     for televisores in cursor:
          codigo = televisores[0]
          marcaTv.set(televisores[1])
          modeloTv.set(televisores[2])
     # Funcion Modificar Televisor

def modificarTelevisor():
     conexion = sqlite3.connect("electrodomesticos.s3db")
     cursor = conexion.cursor()

     marca = marcaTv.get()
     modelo = modeloTv.get()
     sql = "update televisores set marca='"+marca+"',modelo='" + \
     modelo+"' where idTelevisor="+codigoTv.get()
     cursor.execute(sql)
     conexion.commit()
     conexion.close()
     tkinter.messagebox.showinfo("Mensaje", "Televisor modificado con exito!"
     )
     # Funcion Modificar Televisor

def eliminarTelevisor():
     conexion = sqlite3.connect("electrodomesticos.s3db")
     cursor = conexion.cursor()
     sql = "delete from televisores where idTelevisor="+codigoTv.get()
     cursor.execute(sql)
     conexion.commit()
     conexion.close()
     tkinter.messagebox.showinfo("Mensaje", "Televisor eliminado con exito!")

def verTelevisores():
     ventanaVer = Tk()
     # Le damos la dimension a la ventana nuevo
     #geometry("ancho x alto + posX + posY")
     ventanaVer.geometry("300x300+100+100")
     # titulo de la ventana
     ventanaVer.title("Listado de Televisores")
     conexion = sqlite3.connect("electrodomesticos.s3db")
     cursor = conexion.cursor()
     sql = "select * from televisores order by marca"
     cursor.execute(sql)
     listaTv = Listbox(ventanaVer, width=40)
     for row in cursor:
          listaTv.insert(END, row)
          listaTv.place(x=10, y=40)
     conexion.close()

##################################################
# borra cajas de texto
#campo_de_texto.delete(0, END)
# llevar el curso

# entrada.icursor(0)
##################################################
# CREAMOS LA VENTANA DEL MENU PRINCIPAL
# Creamos la ventana televisores
ventana = Tk()
# Le damos la dimension a la ventana nuevo
#geometry("ancho x alto + posX + posY")
ventana.geometry("650x300+100+100")
# titulo de la ventana
ventana.title("Televisores")
# Creamos la etiqueta que sirve de titulo del formulario
lblTitulo = Label(ventana, text="Registro de Televisores")
# creamos el Marco 1 con Titulo
marco1 = tkinter.Frame(ventana, bd=5, relief="groove")
# creamos el Marco 2 con la imagen
marco2 = tkinter.Frame(ventana, bd=5, relief="groove")
# creamos Campos de texto (Entrada de Datos)
codigoTv = StringVar()
marcaTv = StringVar()
modeloTv = StringVar()
# creamos etiquetas de los campos de entrada
lblCodigoTv = Label(marco1, text="Codigo :", font=(
"Agency FB", 14), fg="blue", background="yellow")
txtCodigo = Entry(marco1, textvariable=codigoTv, width=25)
lblMarcaTv = Label(marco1, text="Marca :", font=(
"Agency FB", 14), fg="blue", background="yellow")
txtMarca = Entry(marco1, textvariable=marcaTv, width=25)
lblModeloTv = Label(marco1, text="Modelo:", font=(
"Agency FB", 14), fg="blue", background="yellow")
txtModelo = Entry(marco1, textvariable=modeloTv, width=25)
# posicionar el titulo del formulario Registro de Televisores
lblTitulo.grid(row=0, column=1, pady=5)
# posicionar el marco 1 - sus etiquetas y texto de entrada
marco1.grid(padx=10, pady=10, row=1, column=1)

lblCodigoTv.grid(row=0, column=1)
txtCodigo.grid(row=0, column=2, padx=10)

lblMarcaTv.grid(row=1, column=1)
txtMarca.grid(row=1, column=2, padx=10)
lblModeloTv.grid(row=2, column=1)
txtModelo.grid(row=2, column=2, padx=10)
# Crear Botones
btnGuardar = Button(ventana, text="Guardar", command=crearTelevisor, font=(
"Agency FB", 14), width=10).place(x=300, y=20)
btnBuscar = Button(ventana, text="Buscar", command=buscarTelevisor, font=(
"Agency FB", 14), width=10).place(x=300, y=70)
btnModificar = Button(ventana, text="Modificar", command=modificarTelevisor,
font=(
"Agency FB", 14), width=10).place(x=300, y=120)
btnEliminar = Button(ventana, text="Eliminar", command=eliminarTelevisor, font=("Agency FB", 14), width=10).place(x=300, y=170)
btnVer = Button(ventana, text="Ver", command=verTelevisores,
font=("Agency FB", 14), width=10).place(x=300, y=220)
foto = PhotoImage(file="televisor.gif")
lblImagen = Label(ventana, height=200, width=200,
image=foto).place(x=400, y=20)

print("MarcaTv", txtMarca)
ventana.mainloop()