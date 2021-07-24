import java.util.Scanner;

public class Ejercicio1 {

     public static double operacion(String signo, double a, double b) {
          switch (signo) {
               case "+": return a + b;
               case "-": return a - b;
               case "*": return a * b;
               case "/": return a / b;
               default:
                    System.out.println("Operación no reconocida");
                    return 0.0;
          }
     }

     public static void main(String[] args) {
          var sc = new Scanner(System.in);

          System.out.println("Ingrese la operación que desea hacer");
          String operador = sc.nextLine();

          System.out.println("Ingrese el primer número");
          double a = sc.nextDouble();

          System.out.println("Ingrese el segundo numéro");
          double b = sc.nextDouble();

          System.out.println("El resultado de la operación '" + operador + "' es >> "+ operacion(operador, a, b));
     }
}