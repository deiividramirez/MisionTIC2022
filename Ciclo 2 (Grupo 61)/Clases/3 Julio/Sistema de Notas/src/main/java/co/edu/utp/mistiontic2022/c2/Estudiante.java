package co.edu.utp.mistiontic2022.c2;

public class Estudiante {
     private int codigo;
     private String nombres;
     private String apellidos;
     private int semestreActual;
     private String genero;

     public Estudiante(int codigo, String nombres, String apellidos, int semestreActual, String genero) {
          this.codigo = codigo;
          this.nombres = nombres;
          this.apellidos = apellidos;
          this.semestreActual = semestreActual;
          this.genero = genero;
     }
}
