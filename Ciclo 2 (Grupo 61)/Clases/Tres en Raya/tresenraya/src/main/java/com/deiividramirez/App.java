package com.deiividramirez;

import java.util.ArrayList;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "BIENVENIDO..." );
        Tablero tablero = new Tablero();
        Jugador jugadorX = new Jugador("Juan", 10, "X");

        tablero.mostrarTablero();

        ArrayList<Casilla> casillasVacias = tablero.obtenerCasillasVacias();
        Casilla casillaElegida = jugadorX.elegirCasillaAleatoria(casillasVacias);
        jugadorX.realizarMovimiento(casillaElegida, tablero);

        tablero.mostrarTablero();
    }
}
