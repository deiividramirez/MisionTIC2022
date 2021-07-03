import CRUD

while True:
     ListaTareas = CRUD.Leer()
     print("\n---------------------------------------")
     print("Aplicación CRUD")
     print("1. Adicionar Tarea")
     print("2. Consultar Tareas")
     print("3. Actualizar Tarea")
     print("4. Eliminar Tarea")
     print("5. Salir")

     opcion = input("\nIngrese una opción: ")
     print("---------------------------------------\n")
     
     if opcion == "1":
          nombre = input("Ingrese el nombre de la tarea >> ")
          descrp = input("Describa la tarea >> ")
          estado = input("Estado actual de la tarea >> ")
          try:
               tiempo = float(input("Ingrese el tiempo destinado para la tarea (minutos) >> "))
          except:
               print("Error. Tiempo debe ser un número.")
               continue
          
          CRUD.Crear(
               nombre, 
               {"Descripcion":descrp, "Estado Actual":estado, "Tiempo":tiempo}
               )
     
     elif opcion == "2":
          print("Lista de tareas guardadas:\n")
          for i, Tarea in enumerate(ListaTareas):
               print(f"{i+1}: {Tarea}:\n")
               Tarea = ListaTareas[Tarea]
               print(f"Descripción: {Tarea['Descripcion']}")
               print(f"Estado Actual: {Tarea['Estado Actual']}")
               print(f"Tiempo: {Tarea['Tiempo']}")
     
     elif opcion == "3":
          nombre = input("Ingrese el nombre de la tarea >> ")
          if nombre not in ListaTareas: print("La tarea no existe.")
          else:
               descrp = input("Describa la tarea >> ")
               estado = input("Estado actual de la tarea >> ")
               try:
                    tiempo = float(input("Ingrese el tiempo destinado para la tarea (minutos) >> "))
               except:
                    print("Error. Tiempo debe ser un número.")
                    continue
               
               CRUD.Crear(
                    nombre, 
                    {"Descripcion":descrp, "Estado Actual":estado, "Tiempo":tiempo}
                    )
     
     elif opcion == "4":
          nombre = input("Ingrese el nombre de la tarea >> ")
          if nombre not in ListaTareas: print("La tarea no existe.")
          else:
               CRUD.Eliminar(nombre)
               print("Se ha eliminado la tarea.")
     
     elif opcion == "5":
          print("\nGracias por utilizar este servicio 😁\n")
          break
     else: 
          print("\nOpción no disponible. Inténtelo de nuevo")