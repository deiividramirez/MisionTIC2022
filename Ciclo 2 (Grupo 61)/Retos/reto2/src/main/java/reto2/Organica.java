package reto2;

public class Organica extends Fruta{

     // Atributos
     private static final double DESCUENTO_NACIONALES_BASE = 0.05;
     private static final int GRAMAJE_MINIMO_DESCUENTO_NACIONAL = 250;
     private static final double SUBSIDIO_BASE = 0.12;
     private double descuentoNacionales;
     private double subsidio;


     public Organica(String pNombre, double pPrecio){ 
          super(pNombre, pPrecio);
          this.descuentoNacionales = DESCUENTO_NACIONALES_BASE;
          this.subsidio = SUBSIDIO_BASE;
     } 

     public Organica(String pNombre, double pPrecio, int pGramosVenta) { 
          super(pNombre, pPrecio);
          super.gramosVenta = pGramosVenta;
          this.descuentoNacionales = DESCUENTO_NACIONALES_BASE;
          this.subsidio = SUBSIDIO_BASE;
     } 

     public Organica(String pNombre, double pPrecio, double pDescuentoNacionales) {
          super(pNombre, pPrecio);
          this.descuentoNacionales = pDescuentoNacionales;
          this.subsidio = SUBSIDIO_BASE;
     } 

     public Organica(String pNombre, double pPrecio, double pDescuentoNacionales, double pSubsidio){
          super(pNombre, pPrecio);
          this.descuentoNacionales = pDescuentoNacionales;
          this.subsidio = pSubsidio;
     } 

     public Organica(String pNombre, double pPrecio, double pDescuentoNacionales, double pSubsidio, int pGramosVenta, boolean pImportada) {
          super(pNombre, pPrecio);
          super.gramosVenta = pGramosVenta;
          super.importada = pImportada;
          this.descuentoNacionales = pDescuentoNacionales;
          this.subsidio = pSubsidio;
     }


     //Métodos
     public double calcularPrecio() { 
          double precioVenta = super.calcularPrecio();
          double precioOrganica = precioVenta * ( 1 + this.subsidio );

          if ( !super.importada  && super.gramosVenta > GRAMAJE_MINIMO_DESCUENTO_NACIONAL) {
               precioOrganica -= precioVenta * this.descuentoNacionales;
          }

          return precioOrganica;
     }

}
