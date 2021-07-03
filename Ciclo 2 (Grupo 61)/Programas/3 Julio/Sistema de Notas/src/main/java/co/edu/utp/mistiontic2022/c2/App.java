package co.edu.utp.mistiontic2022.c2;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Nota NotaFinal = new Nota(4.12, 10, "A");
        // System.out.println("NotaVacía");
        // System.out.println("Valor Escala 5 -> " + NotaFinal.getEscala5());
        // System.out.println("Valor Escala 100 -> " + NotaFinal.getEscala100());
        // System.out.println("Cualitativa  -> " + NotaFinal.getCualitativa());
        NotaFinal.mostrarNotaConsola();

        // Cambio de nota desde la clase
        NotaFinal.setCualitativa("C");
        NotaFinal.mostrarNotaConsola();

    }
}
