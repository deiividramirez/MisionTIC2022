import java.util.Scanner;

public class Ejercicio1Diferente {
     public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);

          String a = sc.nextLine();
          double b = sc.nextDouble();

          if (a.equals("A")) {
               System.out.println("ES UNA A ");
          }
          if (b == 3.0) { 
               System.out.println("ES 3");
          }
     }
}
