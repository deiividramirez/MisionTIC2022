package reto2;

public class Fruta {
     
     // Atributos
     public static final int GRAMAJE_BASE_VENTA = 200;
     private String nombre;
     private double precioBase;
     protected int gramosVenta;
     protected boolean importada;

     // Constructores
     public Fruta( String pNombre, double pPrecio ) {
          this.nombre = pNombre;
          this.precioBase = pPrecio;
     } 

     public Fruta( String pNombre, double pPrecio, int pGramosVenta ) {
          this.nombre = pNombre;
          this.precioBase = pPrecio;
          this.gramosVenta = pGramosVenta < GRAMAJE_BASE_VENTA ? GRAMAJE_BASE_VENTA : pGramosVenta;
     }

     public Fruta( String pNombre, double pPrecio, int pGramosVenta, boolean pImportada ) {
          this.nombre = pNombre;
          this.precioBase = pPrecio;
          this.gramosVenta = pGramosVenta < GRAMAJE_BASE_VENTA ? GRAMAJE_BASE_VENTA : pGramosVenta;
          this.importada = pImportada;
     }

     // Metodos
     public double calcularPrecio(){
          double precioVenta = 0;
          if ( this.importada ) {
               precioVenta = (this.precioBase  * this.gramosVenta) * 1.10;
          }
          else {
               precioVenta = (this.precioBase  * this.gramosVenta);
          }
          return precioVenta;
      }

      // Setter
     public void setNombre(String nombre) {
          this.nombre = nombre;
     }

     public void setPrecioBase(double precioBase) {
          this.precioBase = precioBase;
     }

     // Getter

     public String getNombre() {
          return nombre;
     }

     public double getPrecioBase() {
          return precioBase;
     }
     
}
