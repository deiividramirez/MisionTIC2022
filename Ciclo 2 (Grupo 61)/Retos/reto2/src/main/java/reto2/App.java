package reto2;

import java.util.ArrayList;

public class App 
{
    public static void main( String[] args )
    {
        ArrayList<Fruta> frutas2 = new ArrayList<>();
        frutas2.add(new Fruta("Papaya",3.0,1900));
        frutas2.add(new Fruta("Melón",3.6,1000)); 
        frutas2.add(new Convencional("Manzana", 3.0, 400, true));
        frutas2.add(new Convencional("Naranja", 2.4, 700, false)); 
        frutas2.add(new Organica("Fresa",2.8,0.1,0.06));
        Venta ventas2 = new Venta(frutas2);
        ventas2.mostrarTotales();
    }
}
