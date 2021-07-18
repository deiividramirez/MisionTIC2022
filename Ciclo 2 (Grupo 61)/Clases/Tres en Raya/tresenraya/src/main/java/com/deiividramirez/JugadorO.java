package com.deiividramirez;

import java.util.ArrayList;

public class JugadorO extends Jugador{

     // Constructor
     public JugadorO(String pNombre, int pMovLogico, String pMovCons) {
          super(pNombre, pMovLogico, pMovCons);
     }

     JugadorO(String pNombreJugador){
          super(pNombreJugador, ParametroLogico.JUGADOR_O.getValorLogico(), ParametroConsola.JUGADOR_O.getValorConsola());
      }

     // Elegir casilla superior izquierda
     public Casilla elegirCasillaID(Tablero tablero) {
          ArrayList<Casilla> casillasLibres = tablero.obtenerCasillasVacias();
          return casillasLibres.get( casillasLibres.size()-1 );
     }

     // Implementar el método abstracto
     public void estrategiaEspecifica(Tablero tablero) {
          double estrategiaElegida = Math.random();//Aleatorio entre 0.0 y 1.0
          if(estrategiaElegida > 0.5 ){
               super.estrategiaAleatoria(tablero);
               //System.out.println("Aleatorio elegido");
          }else{
               super.realizarMovimiento(this.elegirCasillaID(tablero), tablero);
               //System.out.println("ID elegido");
          }
     }
     
}

