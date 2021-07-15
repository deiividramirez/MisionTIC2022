package com.deiividramirez;

import java.util.ArrayList;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "BIENVENIDO..." );
        Tablero tablero = new Tablero();
        JugadorX jugadorX = new JugadorX("Juan", 10, "X");

        tablero.mostrarTablero();

        jugadorX.estrategiaAleatoria(tablero);

        tablero.mostrarTablero();
    }
}
