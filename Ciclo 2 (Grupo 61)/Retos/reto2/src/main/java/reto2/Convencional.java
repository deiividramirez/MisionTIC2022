package reto2;

public class Convencional extends Fruta{
     //Atributos 
     private static final double RECARGO_CONVENCIONALES_BASE = 0.08;
     public double recargoConvencionales;
     public int gradoAditamentos = 1;

     //Constructores 
     public Convencional(String pNombre, double pPrecio) {
          super(pNombre, pPrecio);
          this.recargoConvencionales = Convencional.RECARGO_CONVENCIONALES_BASE;        
    }

     public Convencional(String pNombre, double pPrecio, double pRecargo) {
          super(pNombre, pPrecio);
          this.recargoConvencionales = pRecargo;
    }

     public Convencional(String pNombre, double pPrecio, double pRecargo, int pGradoAditamentos) { 
          super(pNombre, pPrecio);
          this.recargoConvencionales = pRecargo;
          this.recargoConvencionales = pGradoAditamentos;
     }

     public Convencional(String pNombre, double pPrecio, double pRecargo, int pGradoAditamentos, int pGramosVenta, boolean pImportada) {
          super(pNombre, pPrecio, pGramosVenta, pImportada);
          this.recargoConvencionales = pRecargo;
          this.recargoConvencionales = pGradoAditamentos;
     }

     public Convencional(String pNombre, double pPrecio, int pGramosVenta, boolean pImportada) {
          super(pNombre, pPrecio);
          super.gramosVenta = pGramosVenta;
          super.importada = pImportada;
          this.recargoConvencionales = RECARGO_CONVENCIONALES_BASE;
     }

     //Métodos
     public double calcularPrecio(){
          double precioVenta = super.calcularPrecio();
          double precioConvencional = precioVenta * ( 1 + this.recargoConvencionales);
          precioConvencional += precioVenta * ( 0.1 * this.gradoAditamentos);
          
          return precioConvencional;
     }
}
