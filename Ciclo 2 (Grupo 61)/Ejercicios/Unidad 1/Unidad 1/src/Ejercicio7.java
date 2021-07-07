import java.util.Scanner;

public class Ejercicio7 {
     public static boolean esPrimo(int numero) {
          int contador = 0;
          for (int i = 1; i <= numero/2; i++) {
               if (numero%i == 0) {
                    contador += 1;
               }

               if (contador >= 2) {
                    return false;
               }
          }
          return true;
     }

     public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          Scanner sc2 = new Scanner(System.in);
          boolean sino = true;
          int numero;
          String respuesta;

          while (sino) {
               System.out.println("\nIngrese el número.");
               numero = sc.nextInt();

               if ( esPrimo(numero) ) {
                    System.out.println("El número " + numero + " es primo.");
               }
               else {
                    System.out.println("El número " + numero + " no es primo.");
               }

               System.out.println("Otro número ? s/n");

               respuesta = sc2.nextLine();
               if (respuesta == "s") {
                    System.out.println("Ok...sigamos\n");
               }
               else {
                    System.out.println("\nGracias...");
                    sino = false;
               }
          }
     }
}
