package com.deiividramirez;

import java.util.ArrayList;

public class Jugador {
     
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
     public Casilla elegirCasillaAleatoria(ArrayList<Casilla> casillasLibres) {
          
          Casilla casillaElegida = new Casilla();

          int MIN = 0;
          int MAX = casillasLibres.size();
          int indiceElegido = MIN + (int)( Math.random() * (MAX-MIN) );
          
          casillaElegida = casillasLibres.get( indiceElegido );

          return casillaElegida;
     
     }

     public void realizarMovimiento(Casilla casilla, Tablero tablero) {
          int fila = casilla.getFila();
          int col = casilla.getColumna();
          tablero.casillas[fila][col].aplicarJugada(this.movimientoLogico, this.movimientoConsola);
     }

}
