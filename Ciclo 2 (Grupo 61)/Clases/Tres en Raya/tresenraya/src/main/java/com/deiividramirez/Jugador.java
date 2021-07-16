package com.deiividramirez;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Jugador {

     // Atributos
     public String nombre;
     public int movimientoLogico;
     public String movimientoConsola;

     // Constructores
     public Jugador(String pNombre, int pMovLogico, String pMovCons) {
          nombre = pNombre;
          movimientoLogico = pMovLogico;
          movimientoConsola = pMovCons;
     }

     // Metodos

     // ALEATORIO
     public Casilla elegirCasillaAleatoria(Tablero tablero) {
          ArrayList<Casilla> casillasLibres = tablero.obtenerCasillasVacias();
          // Casilla casillaElegida = new Casilla();
          int MIN = 0;
          int MAX = casillasLibres.size();
          int indiceElegido = MIN + (int)( Math.random() * (MAX-MIN) );
          // casillaElegida = casillasLibres.get( indiceElegido );
          // return casillaElegida;
          return casillasLibres.get( indiceElegido );
     }

     public void estrategiaAleatoria(Tablero tablero) {
          realizarMovimiento( elegirCasillaAleatoria( tablero ), tablero );
     }

     public void realizarMovimiento(Casilla casilla, Tablero tablero) {
          int fila = casilla.getFila();
          int col = casilla.getColumna();
          tablero.casillas[fila][col].aplicarJugada(this.movimientoLogico, this.movimientoConsola);
     }

     public void estategiaManual(Tablero tablero) {
          Scanner sc = new Scanner(System.in);
          System.out.println("Ingrese fila");
          int inFila = sc.nextInt();
          System.out.println("Ingrese columna");
          int inCol = sc.nextInt();

          tablero.casillas[inFila][inCol].aplicarJugada(this.movimientoLogico, this.movimientoConsola);
          sc.close();
     }

     abstract void estrategiaEspecifica(Tablero tablero);
}
