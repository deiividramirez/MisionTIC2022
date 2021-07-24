package com.retouno;

public class VentaProyecto {
     
     int pTiempo; 
     double pMonto;
     double pInteres;
     
     public double calcularInteresSimple() { 
          return Math.round(pMonto * pTiempo * pInteres / 100);
     } 
          
     public double calcularInteresCompuesto(){
          return Math.round(pMonto * ( Math.pow( (1+pInteres/100), pTiempo) - 1 ));
     } 

     public String compararInversion(){
          double diferencia = Math.round( calcularInteresCompuesto() - calcularInteresSimple() );
          if (diferencia == 0){
               return "No se obtuvo diferencia entre las proyecciones, revisar los parámetros de entrada.";
          }
          else{
               return compararInversion(pTiempo, pMonto, pInteres);
          }

     }

     public String compararInversion(int pTiempo, double pMonto, double pInteres){
          this.pTiempo = pTiempo;
          this.pMonto = pMonto;
          this.pInteres = pInteres;
          double diferencia = Math.round( calcularInteresCompuesto() - calcularInteresSimple() );
          if (diferencia == 0){
               return compararInversion();
          }
          else{
               return "La diferencia entre la proyección de interés compuesto e interés simple es: $" + diferencia;
          }
     }

     public VentaProyecto(){
          this.pTiempo = 0;
          this.pMonto = 0;
          this.pInteres = 0;
          compararInversion();
     }

     public VentaProyecto(int pTiempo, double pMonto, double pInteres) {
          this.pTiempo = pTiempo;
          this.pMonto = pMonto;
          this.pInteres = pInteres;
          compararInversion(pTiempo, pMonto, pInteres);
     }
}
