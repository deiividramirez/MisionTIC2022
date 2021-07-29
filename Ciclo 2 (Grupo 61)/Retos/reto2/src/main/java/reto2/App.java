package reto2;

import java.util.ArrayList;

public class App 
{
    public static void main( String[] args )
    {
        ArrayList<Fruta> frutas = new ArrayList<>();
        frutas.add(new Fruta("Sandía", 3.8, 2000, true));
        frutas.add(new Convencional("Granadilla", 4.0, 0.1, 2, 400, true));
        frutas.add(new Organica("Pitaya", 2.0, 280));
        frutas.add(new Organica("Uchuva", 1.7, 95)); 
        frutas.add(new Organica("Banano", 6.0, 0.1, 0.06));
        Venta ventas = new Venta(frutas);
        ventas.mostrarTotales(); 
    }
}
