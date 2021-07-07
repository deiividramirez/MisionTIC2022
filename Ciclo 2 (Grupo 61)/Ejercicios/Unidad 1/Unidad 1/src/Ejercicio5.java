import java.util.Random;
import java.util.Scanner;

public class Ejercicio5 {
     public static void main(String[] args) {
          Random random = new Random();
          int aleatorio = random.nextInt(100);
          Scanner sc = new Scanner(System.in);
          while (true) {
               
               System.out.println("\nAdivine el número...");
               int guess = sc.nextInt();

               if ( guess == aleatorio ) {
                    System.out.println("CORRECTO, LO LOGRÓ!");
                    break;
               }
               else if ( guess < aleatorio ) {
                    System.out.println("El número es mayor...");
               }
               else {
                    System.out.println("El número es menor...");
               }
          }
     }
}
