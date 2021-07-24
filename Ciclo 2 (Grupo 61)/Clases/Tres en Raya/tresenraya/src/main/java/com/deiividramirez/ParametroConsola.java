package com.deiividramirez;

public enum ParametroConsola {
     //Valores consola Jugadores
    JUGADOR_O("O"), JUGADOR_X("X");

    //Atributo que representa el valor
    private String valorConsola;

    //Constructor
    ParametroConsola(String pValorConsola){
        this.valorConsola = pValorConsola;
    }

    //Getter
    public String getValorConsola() {
        return valorConsola;
    }
}
