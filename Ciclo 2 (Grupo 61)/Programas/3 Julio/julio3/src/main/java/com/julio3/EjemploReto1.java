package com.julio3;

import java.util.Arrays;

public class EjemploReto1 {
     // Función que saca promedios con datos de cualquier tamaño
     public static double promedio(double[] notas) {
          double suma = 0;
          for (double i: notas) {
               suma += i;
          }
          return suma / notas.length;
     }

     // Función que calcula el promedio de las notas de los quices
     public static double notas_quices(double[] notas) {
          // Ordeno el array para saber quien es el menor
          Arrays.sort(notas);

          // Creo el array de las mejores notas con un tamaño menor al de las notas
          double[] MejoresNotas = new double[notas.length - 1];

          // Quito la primer nota, quien es la menor
          for (int i = 1; i < notas.length; i++) {
               MejoresNotas[i-1] = notas[i];
          }

          // Retorno el promedio de las mejores notas
          return promedio(MejoresNotas);
     }

     public static void main(String[] args){
          // Creo un array de las notas
          double[] notas = {2.0, 4.0, 5.0, 7.0, 10.0};

          // Pido el promedio de las mejores notas
          double promedio = notas_quices(notas);

          // Imprimo el promedio
          System.out.println(promedio);
     }
}
