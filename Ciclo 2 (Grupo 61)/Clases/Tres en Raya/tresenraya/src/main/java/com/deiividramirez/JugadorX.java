package com.deiividramirez;

public class JugadorX extends Jugador{

     // Constructor
     public JugadorX(String pNombre, int pMovLogico, String pMovCons) {
          super(pNombre, pMovLogico, pMovCons);
     }
     
     JugadorX(String pNombreJugador){
          super(pNombreJugador, ParametroLogico.JUGADOR_X.getValorLogico(), ParametroConsola.JUGADOR_X.getValorConsola());
      }

     // Elegir casilla superior izquierda
     public Casilla elegirCasillaSI(Tablero tablero) {
          // Casilla casillaElegida = new Casilla();
          // ArrayList<Casilla> casillasLibres = tablero.obtenerCasillasVacias();
          // casillaElegida = casillasLibres.get(0);
          // return casillaElegida;
          return tablero.obtenerCasillasVacias().get(0);
     }

     // Implementar el método abstracto
     public void estrategiaEspecifica(Tablero tablero) {
          super.realizarMovimiento( this.elegirCasillaSI(tablero), tablero );
     }
     
}
