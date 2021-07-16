package com.deiividramirez;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "BIENVENIDO..." );
        Tablero tablero = new Tablero();
        JugadorX jugadorX = new JugadorX("Juan", 10, "X");
        JugadorO jugadorO = new JugadorO("Pedro", 10, "O");

        tablero.mostrarTablero();

        jugadorX.estrategiaEspecifica(tablero);
        jugadorO.estrategiaAleatoria(tablero);
        jugadorX.estrategiaAleatoria(tablero);
        jugadorO.estrategiaEspecifica(tablero);
        jugadorX.estrategiaEspecifica(tablero);
        jugadorO.estrategiaAleatoria(tablero);
        jugadorX.estrategiaAleatoria(tablero);
        jugadorO.estrategiaEspecifica(tablero);
        


        tablero.mostrarTablero();
    }
}
