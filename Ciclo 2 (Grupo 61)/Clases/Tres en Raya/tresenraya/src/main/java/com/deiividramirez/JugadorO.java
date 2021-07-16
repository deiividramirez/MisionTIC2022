package com.deiividramirez;

import java.util.ArrayList;

public class JugadorO extends Jugador{

     // Constructor
     public JugadorO(String pNombre, int pMovLogico, String pMovCons) {
          super(pNombre, pMovLogico, pMovCons);
     }

     // Elegir casilla superior izquierda
     public Casilla elegirCasillaSI(Tablero tablero) {
          ArrayList<Casilla> casillasLibres = tablero.obtenerCasillasVacias();
          return casillasLibres.get( casillasLibres.size()-1 );
     }

     // Implementar el método abstracto
     public void estrategiaEspecifica(Tablero tablero) {
          super.realizarMovimiento( this.elegirCasillaSI(tablero), tablero );
     }
     
}

