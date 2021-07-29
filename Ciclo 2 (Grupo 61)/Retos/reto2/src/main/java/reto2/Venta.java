package reto2;

import java.util.ArrayList;

public class Venta {
     //Atributos 
     private int totalFrutas;
     private int totalFrutasConvencionales = 0;
     private int totalFrutasOrganicas = 0;
     private ArrayList<Fruta> listaFrutas = new ArrayList<Fruta>();
     private int verduraObsequio = -1;

     //Constructor
     public Venta(ArrayList<Fruta> pListaFrutas) {
          this.listaFrutas = pListaFrutas;
     }

     //Requerimiento principal -> Realizar los cálculos de la venta o pedido 
     public void mostrarTotales() { 

          int numConvencionales = 0;
          int numOrganicas = 0;

          for (int i = 0; i < listaFrutas.size(); i++) {
               if ( listaFrutas.get(i) instanceof Convencional ) {
                    numConvencionales ++;
                    this.totalFrutasConvencionales += listaFrutas.get(i).calcularPrecio();
               }
               else if ( listaFrutas.get(i) instanceof Organica ) {
                    numOrganicas ++;
                    this.totalFrutasOrganicas += listaFrutas.get(i).calcularPrecio();
                    if(this.verduraObsequio == -1){
                         this.verduraObsequio = i;
                    }
                    else{                    
                         if( this.listaFrutas.get(this.verduraObsequio).calcularPrecio() >  this.listaFrutas.get(i).calcularPrecio() ) {
                             this.verduraObsequio = i;
                         }
                     }    
               }
               else {
                    this.totalFrutas += listaFrutas.get(i).calcularPrecio();
               }
          }
          
          //Cálculo valor total de la compra
          double totalCompra = this.totalFrutas + this.totalFrutasConvencionales + this.totalFrutasOrganicas;
          //Primera parte de la salida
          System.out.println("Valor frutas cultivo convencional = " + this.totalFrutasConvencionales);
          System.out.println("Valor frutas cultivo orgánico = " + this.totalFrutasOrganicas);
          // Condiciones para reportar obsequio
          // 1) Mayor número de productos orgánicos
          // 2) Por lo menos un obsequio cargado en los atributos del pedido después de revisión del listado if(condiciones){
          // Descontar el 50% del producto orgánico de mayor valor 
          
          if(numOrganicas > numConvencionales){

               String nombreObsequio = listaFrutas.get(this.verduraObsequio).getNombre();
               double descuento = listaFrutas.get(this.verduraObsequio).calcularPrecio() / 2;
               
               System.out.println("Se han descontado " + descuento + " en el ítem " + nombreObsequio + " tipo orgánico");
           }
     

     //Parte final 
     System.out.println("Valor total compra = " + (totalFrutas + totalCompra));
     } 

}