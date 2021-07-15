package com.deiividramirez;

import java.util.ArrayList;

public class Tablero {

     //  Atributos
     public static final int numCasillasTablero = 9;
     public static final int numFilas = 3;
     public static final int numColumnas = 3;

     public Casilla[][] casillas = new Casilla[numFilas][numColumnas];

     public Tablero() {
          for (int i = 0; i < numFilas; i++) {
               for (int j = 0; j < numColumnas; j++) {
                    casillas[i][j] = new Casilla(i, j);
                    // casillas[i][j] = new Casilla();
                    // casillas[i][j].setFila(i);
                    // casillas[i][j].setColumna(j);
               }
          }
     }

     // Metodos
     public ArrayList<Casilla> obtenerCasillasVacias() {

          ArrayList<Casilla> casillasLibres = new ArrayList<Casilla>();
          for (int i = 0; i < numFilas; i++) {
               for (int j = 0; j < numColumnas; j++) {
                    if ( casillas[i][j].getLibre() ) {
                         casillasLibres.add(casillas[i][j]);
                    }
               }
          }
          return casillasLibres;

     }

     public boolean estaLleno() {

          return this.obtenerCasillasVacias().isEmpty() ? true :  false;
          // if ( this.obtenerCasillasVacias().isEmpty() ) {
          //      return true;
          // } else {
          //      return false;
          // }

     }

     public void mostrarTablero() {
          System.out.print("\n\n");
          for (int i = 0; i < numFilas; i++) {
               for (int j = 0; j < numColumnas; j++) {
                    System.out.print(casillas[i][j].getValorConsola() + " ");
               }
               System.out.println();
          }
     }
}
