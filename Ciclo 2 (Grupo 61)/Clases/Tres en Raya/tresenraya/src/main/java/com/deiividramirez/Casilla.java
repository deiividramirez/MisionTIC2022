package com.deiividramirez;

public class Casilla {

     // Atributos
     private int valorLogico;
     private String ValorConsola;
     private boolean libre;
     private int fila;
     private int columna;

     // Constructores
     Casilla() {
          valorLogico = 0;
          ValorConsola = "_";
          libre = true;
          fila = 0;
          columna = 0;
     }

     public Casilla(int i, int j) {
          valorLogico = 0;
          ValorConsola = "_";
          libre = true;
          fila = i;
          columna = j;
     }

     // Metodos 
     public void aplicarJugada( int pValorLogico, String pValorConsola ) {
          this.valorLogico = pValorLogico;
          this.ValorConsola = pValorConsola;
          this.libre = false;
     }

     // Get
     
     public int getColumna() {
          return columna;
     }

     public int getFila() {
          return fila;
     }

     public String getValorConsola() {
          return ValorConsola;
     }

     public int getValorLogico() {
          return valorLogico;
     }

     public boolean getLibre() {
          return libre;
     }

     // Set 
     public void setColumna(int columna) {
          this.columna = columna;
     }
     
     public void setFila(int fila) {
          this.fila = fila;
     }

     public void setLibre(boolean libre) {
          this.libre = libre;
     }

     public void setValorConsola(String valorConsola) {
          ValorConsola = valorConsola;
     }

     public void setValorLogico(int valorLogico) {
          this.valorLogico = valorLogico;
     }
}
