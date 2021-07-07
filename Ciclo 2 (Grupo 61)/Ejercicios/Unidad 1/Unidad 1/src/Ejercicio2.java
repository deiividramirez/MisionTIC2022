import java.util.Scanner;

public class Ejercicio2 {

     public static boolean aprueba(double nota1, double nota2, double nota3) {
          return ( (nota1 + nota2 + nota3)/3 > 3.0 );
     }

     public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);

          System.out.println("Ingrese el nombre");
          String nombre = sc.nextLine();

          System.out.println("Ingrese la primer nota");
          double nota1 = sc.nextDouble();

          System.out.println("Ingrese la segunda nota");
          double nota2 = sc.nextDouble();

          System.out.println("Ingrese la tercera nota");
          double nota3 = sc.nextDouble();


          if ( aprueba(nota1, nota2, nota3) ) {
               System.out.println(nombre + " aprueba con !!");
          }
          else {
               System.out.println(nombre + " reprueba...");
          }

     }
}
