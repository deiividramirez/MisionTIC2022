import java.util.Scanner;

public class Ejercicio4 {
     public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);

          System.out.println("Ingrese el número para la tabla");
          int numero = sc.nextInt();

          for (int i = 0; i <= 10; i++) {
               System.out.println(numero + "*" + i + " = " + i*numero);
          }
     }
}
