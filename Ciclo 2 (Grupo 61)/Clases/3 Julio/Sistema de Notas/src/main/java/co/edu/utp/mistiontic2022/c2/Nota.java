package co.edu.utp.mistiontic2022.c2;

public class Nota {
     // Atributos
     private int escala100;
     private double escala5;
     private String cualitativa;
     // private String nombre;

     // Constructores
     Nota() {
          this.escala100 = 0;
          this.escala5 = 0;
          this.cualitativa = "F";
     }

     Nota(int pEscala100) {
          this.escala100 = pEscala100;
          this.escala5 = pEscala100 / 20;
          if(pEscala100 >= 60){
              this.cualitativa = "Aprobado";
          }else{
              this.cualitativa = "Reprobado";
          }
     }

     Nota(double pEscala5) {
          this.escala5 = pEscala5;
          this.escala100 = (int)pEscala5 * 20;
          if(pEscala5 >= 2.95){
              this.cualitativa = "Aprobado";
          }
          else{
              this.cualitativa = "Reprobado";
          }
     }
     Nota(double pEscala5, int pEscala100, String pCualitativo) {
          this.escala5 = pEscala5;
          this.escala100 = pEscala100;
          this.cualitativa = pCualitativo;
      }

      // Funciones
     public void mostrarNotaConsola() {
          System.out.println("-----InfoNota-------");
          System.out.println("Valor Escala 5 -> " + this.escala5);
          System.out.println("Valor Escala 100 -> " + this.escala100);
          System.out.println("Cualitativa  -> " + this.cualitativa);
     }

     // Getter (Quienes devuelven el valor de una variable privada)
     public String getCualitativa() {
          return cualitativa;
     }

     public int getEscala100() {
          return escala100;
     }
  
     public double getEscala5() {
          return escala5;
     }

     // Setter (Quienes cambian el valor de una variable)
     public void setCualitativa(String cualitativa) {
          this.cualitativa = cualitativa;
     }
  
     public void setEscala100(int escala100) {
          this.escala100 = escala100;
     }
  
     public void setEscala5(double escala5) {
          this.escala5 = escala5;
     }
}
