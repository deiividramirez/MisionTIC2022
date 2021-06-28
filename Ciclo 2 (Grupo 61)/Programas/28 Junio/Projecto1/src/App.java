public class App {

    public static String saludo(String nombre){
        return "Hola "+nombre+" ! ";
    }

    public static void main(String[] args) throws Exception {
        var nombre = "Pedro";
        var saludar = saludo(nombre);

        System.out.println(saludar);
    }
}
