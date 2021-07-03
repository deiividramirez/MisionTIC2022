package com.junio30;

import java.util.*;

public class Ejercicio1 {

     /* 
     Cuando la función tiene "void" es una función que
     no devuelve absolutamente nada. Pueden tener variables
     que entran pero nunca sale nada, no retorna ningún valor.
     */
     public static void saludo(){
          // Función que da la bienvenida :3
          System.out.println("Bienvenido, App número de la suerte");
     }

     public static void reporte(int numeroSuerte){
          // Función que despide y que da el número de la suerte generado
          System.out.println("\nEl número de la suerte es: " + numeroSuerte);
          System.out.println("Gracias por usar nuestra App.");
     }

     /* 
     En este caso la función tiene "String" porque lo que retorna
     un texto en específico.
     */
     public static String leerFecha(){
          /* 
          Función que abre el escaneo del sistema para poder ingresar
          textos o lo que sea, a través del teclado.
          */
          Scanner sc = new Scanner(System.in);
          System.out.println("Ingrese la fecha DD/MM/AAAA >> ");
          
          // Retorna lo que se escribió
          return sc.nextLine();
     }

     // Aquí está "int" porque porque la función retorna un entero
     public static int calculo(String fecha){
          int numeroSuerte = 0;
          
          // Parte el texto entrado en "/" como en python .split("/")
          String[] fechas = fecha.split("/");
          
          int dia = Integer.parseInt(fechas[0]);
          int mes = Integer.parseInt(fechas[1]);
          int año = Integer.parseInt(fechas[2]);

          int sumafechas = dia + mes + año;

          /*
          Aquí voy a usar módulos, para saber el residuo al dividir en 10
          Esto es, el último dígitos del número.
          Después, lo divido el 10 para correr una posición hacia la izquierda
          Esto nos asegura que en algún momento, se llegará al 0, por eso
          el while tiene la condición de mientras el número sea mayor que 0
          */
          while ( sumafechas > 0 ){
               numeroSuerte += sumafechas % 10;
               sumafechas = sumafechas / 10;
          }

          // Se retorna el número de la suerte
          return numeroSuerte;
     }

     // Función principal que se ejecuta
     public static void main(String args[]){
          /*
          Saluda con la función Saludo
          Llama a la función leerFecha y la ingresa en la función calculo
          para obtener el número de la suerte
          Y por último, hacemos el reporte imprimiento el número de la suerte.
          */
          saludo();
          int numeroSuerte = calculo( leerFecha() );
          reporte(numeroSuerte);
     }
}
