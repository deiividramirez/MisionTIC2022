package com.retouno;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {  	
        VentaProyecto ventaConstruccion2 = new VentaProyecto(12,150000,2.0);
        System.out.println(ventaConstruccion2.calcularInteresSimple());
        System.out.println(ventaConstruccion2.calcularInteresCompuesto());
        System.out.println(ventaConstruccion2.compararInversion());
    }
}
