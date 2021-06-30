package com.junio30;

import java.util.*;

public class Ejercicio1 {

     public static void saludo(){
          System.out.println("Bienvenido, App número de la suerte");
     }

     public static void reporte(int numeroSuerte){
          System.out.println("\nEl número de la suerte es: " + numeroSuerte);
          System.out.println("Gracias por usar nuestra App.");
     }

     public static String leerFecha(){
          Scanner sc = new Scanner(System.in);
          System.out.println("Ingrese la fecha DD/MM/AAAA >> ");
          return sc.nextLine();
     }

     public static int calculo(String fecha){
          int numeroSuerte = 0;
          String[] fechas = fecha.split("/");
          
          int dia = Integer.parseInt(fechas[0]);
          int mes = Integer.parseInt(fechas[1]);
          int año = Integer.parseInt(fechas[2]);

          int sumafechas = dia + mes + año;

          while ( sumafechas > 0 ){
               numeroSuerte += sumafechas % 10;
               sumafechas = sumafechas / 10;
          }

          return numeroSuerte;
     }

     public static void main(String args[]){
          saludo();
          int numeroSuerte = calculo( leerFecha() );
          reporte(numeroSuerte);
     }
}
