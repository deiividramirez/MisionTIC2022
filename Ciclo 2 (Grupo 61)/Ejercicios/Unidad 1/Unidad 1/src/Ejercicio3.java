import java.util.Scanner;

public class Ejercicio3 {
     public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);

          System.out.println("Ingrese el número de horas trabajadas...");
          int totalHoras = sc.nextInt();

          System.out.println("Trabajó " + totalHoras + " horas y corresponde a $" + totalHoras*30000);
     }
}
