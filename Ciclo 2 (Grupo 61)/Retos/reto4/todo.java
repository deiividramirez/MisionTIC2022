import java.util.ArrayList;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class VistaRequerimientosReto4 {

    public static final ControladorRequerimientosReto4 controller = new ControladorRequerimientosReto4();
    
    public static void requerimiento1(){

        System.out.println("-----10 Proyectos Mayor Gasto-------");       

        try {

            ArrayList<ProyectoRankeadoCompras> rankingProyectosCompras = controller.consultarProyectosCompras10();

            System.out.println("ID_Proyecto Clasificación Gasto_Compras Serial");            
            
            for (ProyectoRankeadoCompras proyecto : rankingProyectosCompras) {
                
                System.out.printf("%d %s %d %s %n", 
                    proyecto.getIdProyecto(),
                    proyecto.getClasificacion(),
                    proyecto.getGastoCompras(),
                    proyecto.getSerial()
                );

            }

        } catch(SQLException e) {
            System.err.println("Ha ocurrido un error!" + e.getMessage() );
        }

    }
    
    public static void requerimiento3(){

        System.out.println("-----Ranking Descendente Bancos (Área Proyectos)-------");             

        try {

            System.out.println("Banco_Vinculado Area_Promedio");
            
            ArrayList<BancoRankeadoAreaPromedio> Bancos = controller.consultarBancosRankeadosAreaPromedio();
            for (BancoRankeadoAreaPromedio Banco : Bancos) {
                
                System.out.printf("%s %f %n", 
                    Banco.getBancoVinculado(),
                    Banco.getAreaPromedio()
                );

            }

        } catch(SQLException e) {
            System.err.println("Ha ocurrido un error!" + e.getMessage() );
        }

    }

    public static void requerimiento5(){

        System.out.println("-----Ranking Descendente Materiales Importados (Compras)-------");       

        try {    
            System.out.println("Nombre_Material Importado No_Compras");
            
            ArrayList<MaterialRankeadoCompras> materiales = controller.consultarMaterialesRankeadosCompras();
            for (MaterialRankeadoCompras material : materiales) {
                
                System.out.printf("%s %s %d %n", 
                    material.getNombreMaterial(),
                    material.getImportado(),
                    material.getNoCompras()
                );

            }

        } catch(SQLException e) {
            System.err.println("Ha ocurrido un error!" + e.getMessage() );
        }

    }
    
    public static void iniciar(){        

        boolean mainloop = true;
        Scanner lector = new Scanner(System.in);
        
        do {
            System.out.println("====Menú Líderes====");
            System.out.println("1. Listar todos los líderes");
            System.out.println("2. Consultar líder por ID");
            System.out.println("3. Guardar líder ");
            System.out.println("4. Remover líder ");
            System.out.println("5. Salir ");
            System.out.print("Ingresar opción: ");
            int opcionIngresada = lector.nextInt();
            if ( opcionIngresada == 1 ) {
                }
            else if ( opcionIngresada == 2 ) {
                System.out.println("En construcción: 2. Consultar líder por ID");
                }
            else if ( opcionIngresada == 3 ) {
                System.out.println("En construcción: 3. Guardar líder ");
                }
            else if ( opcionIngresada == 4 ) {
                System.out.println("En construcción: 4. Remover líder ");
            }
            else if ( opcionIngresada == 5 ) {
                mainloop = false;
                System.out.println("Salida exitosa.");
            }
            else {
                System.out.println("Opción inválida!");
            }

        } while(mainloop);

    }    
    
}

public class ControladorRequerimientosReto4 {

    private final ProyectoRankeadoComprasDao proyectoRankeadoComprasDao;
    private final BancoRankeadoAreaPromedioDao bancoRankeadoAreaPromedioDao;
    private final MaterialRankeadoComprasDao materialRankeadoComprasDao;    

    public ControladorRequerimientosReto4(){
        this.proyectoRankeadoComprasDao = new ProyectoRankeadoComprasDao();
        this.bancoRankeadoAreaPromedioDao = new BancoRankeadoAreaPromedioDao();        
        this.materialRankeadoComprasDao = new MaterialRankeadoComprasDao();
    }

    public ArrayList<ProyectoRankeadoCompras> consultarProyectosCompras10() throws SQLException{
        return this.proyectoRankeadoComprasDao.rankingProyectosComprasDescendente10();
    }    

    public ArrayList<BancoRankeadoAreaPromedio>  consultarBancosRankeadosAreaPromedio() throws SQLException{
        return this.bancoRankeadoAreaPromedioDao.rankingBancosAreaPromedioDescendente();
    }
    
    public ArrayList<MaterialRankeadoCompras> consultarMaterialesRankeadosCompras() throws SQLException {
        return this.materialRankeadoComprasDao.rankingMaterialesComprasDescendente();
    }

}

public class ProyectoRankeadoComprasDao {

    public ArrayList<ProyectoRankeadoCompras> rankingProyectosComprasDescendente10() throws SQLException {

        ArrayList<ProyectoRankeadoCompras> request = new ArrayList<ProyectoRankeadoCompras>();
        Connection conexion = null;        

        try{
            conexion = JDBCUtilities.getConnection();

            String consulta = "SELECT  p.ID_Proyecto, " +
                    "p.Clasificacion, " +
                    "sum( c.Cantidad * m.Precio_Unidad ) as Gasto_Compras, " +
                    "p.Serial " +
                    "FROM Proyecto p " +
                    "JOIN Compra c ON p.ID_Proyecto = c.ID_Proyecto " +
                    "JOIN MaterialConstruccion m ON c.ID_MaterialConstruccion = m.ID_MaterialConstruccion " +
                    "GROUP BY p.ID_Proyecto " +
                    "ORDER BY Gasto_Compras DESC " +
                    "LIMIT 10";

            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                ProyectoRankeadoCompras proyecto = new ProyectoRankeadoCompras();
                //proyecto.setIdProyecto(resultSet.getInt("ID_Proyecto"));
                proyecto.setIdProyecto(resultSet.getInt(1));
                proyecto.setClasificacion(resultSet.getString("Clasificacion"));
                proyecto.setGastoCompras(resultSet.getInt("Gasto_Compras"));
                proyecto.setSerial(resultSet.getString("Serial"));

                request.add(proyecto);
            }

            resultSet.close();
            statement.close();


        } catch(SQLException e) {
            System.err.println("Error consultando los proyectos rankeados por compras! " + e );
        } finally {
            if ( conexion != null ) {
                conexion.close();
            }
        }

        return request;
        
    } 
        
}

public class BancoRankeadoAreaPromedioDao {

    public ArrayList<BancoRankeadoAreaPromedio> rankingBancosAreaPromedioDescendente() throws SQLException {

        ArrayList<BancoRankeadoAreaPromedio> request = new ArrayList<BancoRankeadoAreaPromedio>();
        Connection conexion = null;
        
        try{
            conexion = JDBCUtilities.getConnection();

            String consulta = "SELECT  p.Banco_Vinculado, " +
                        "AVG(t.Area_Max) as Area_Promedio " +
                        "FROM Proyecto p " +
                        "JOIN Tipo t ON p.ID_Tipo = t.ID_Tipo " +
                        "GROUP BY p.Banco_Vinculado " +
                        "ORDER BY Area_Promedio DESC";

            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                BancoRankeadoAreaPromedio banco = new BancoRankeadoAreaPromedio();
                banco.setAreaPromedio(resultSet.getDouble("Area_Promedio"));
                banco.setBancoVinculado(resultSet.getString("Banco_Vinculado"));

                request.add(banco);
            }

            resultSet.close();
            statement.close();

        } catch(SQLException e) {
            System.err.println("Error consultando bancos rankeados areaMax promedio: " + e);
        } finally {
            if ( conexion != null ) {
                conexion.close();
            }
        }

        return request;
    }
    
}

public class MaterialRankeadoComprasDao {

    public ArrayList<MaterialRankeadoCompras> rankingMaterialesComprasDescendente() throws SQLException {

        ArrayList<MaterialRankeadoCompras> request = new ArrayList<MaterialRankeadoCompras>();
        Connection conexion = null;        

        try{
            conexion = JDBCUtilities.getConnection();

            String consulta = "SELECT  mc.Nombre_Material, " +
                        "mc.Importado, " +
                        "COUNT(c.ID_Compra) as No_Compras " +
                        "FROM Compra c " +
                        "inner JOIN MaterialConstruccion mc ON mc.ID_MaterialConstruccion = c.ID_MaterialConstruccion " +
                        "WHERE mc.Importado = 'Si' " +
                        "GROUP BY mc.ID_MaterialConstruccion " +
                        "ORDER BY    No_Compras DESC, " +
                        "mc.Nombre_Material ";

            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                MaterialRankeadoCompras material = new MaterialRankeadoCompras();
                material.setNombreMaterial(resultSet.getString(1));
                material.setImportado(resultSet.getString(2));
                material.setNoCompras(resultSet.getInt(3));                
                request.add(material);
            }

            resultSet.close();
            statement.close();


        } catch (SQLException e) {
            System.err.println("Error consultando los proyectos rankeados por compras! " + e);
        } finally {
            if (conexion != null) {
                conexion.close();
            }
        }

        return request;
        
    }
        
}

public class ProyectoRankeadoCompras {

     private Integer idProyecto;
     private String clasificacion;
     private Integer gastoCompras;
     private String serial;
     
     
     public ProyectoRankeadoCompras() {
     }

     public ProyectoRankeadoCompras(Integer idProyecto, String clasificacion, Integer gastoCompras, String serial) {
          this.idProyecto = idProyecto;
          this.clasificacion = clasificacion;
          this.gastoCompras = gastoCompras;
          this.serial = serial;
     }

     public Integer getIdProyecto() {
          return idProyecto;
     }

     public void setIdProyecto(Integer idProyecto) {
          this.idProyecto = idProyecto;
     }

     public String getClasificacion() {
          return clasificacion;
     }

     public void setClasificacion(String clasificacion) {
          this.clasificacion = clasificacion;
     }

     public Integer getGastoCompras() {
          return gastoCompras;
     }

     public void setGastoCompras(Integer gastoCompras) {
          this.gastoCompras = gastoCompras;
     }

     public String getSerial() {
          return serial;
     }

     public void setSerial(String serial) {
          this.serial = serial;
     }
     
}

public class BancoRankeadoAreaPromedio {

    //Atributos -> Columnas de la tabla que representa la misma entidad
    private String bancoVinculado;
    private Double areaPromedio;

    public BancoRankeadoAreaPromedio(){
        
    }

    public String getBancoVinculado() {
        return bancoVinculado;
    }
    public void setBancoVinculado(String bancoVinculado) {
        this.bancoVinculado = bancoVinculado;
    }
    public Double getAreaPromedio() {
        return areaPromedio;
    }
    public void setAreaPromedio(Double areaPromedio) {
        this.areaPromedio = areaPromedio;
    } 
     
}

public class MaterialRankeadoCompras {

    private String nombreMaterial;
    private String importado;
    private Integer noCompras;

    public MaterialRankeadoCompras() {
    }

    public MaterialRankeadoCompras(String nombreMaterial, String importado, Integer noCompras) {
        this.nombreMaterial = nombreMaterial;
        this.importado = importado;
        this.noCompras = noCompras;
    }

    public String getNombreMaterial() {
        return nombreMaterial;
    }

    public void setNombreMaterial(String nombreMaterial) {
        this.nombreMaterial = nombreMaterial;
    }

    public String getImportado() {
        return importado;
    }

    public void setImportado(String importado) {
        this.importado = importado;
    }

    public Integer getNoCompras() {
        return noCompras;
    }

    public void setNoCompras(Integer noCompras) {
        this.noCompras = noCompras;
    }
     
}

public class JDBCUtilities {

    private static final String UBICACION_BD = "ProyectosConstruccion.db";
    
    public static Connection getConnection() throws SQLException {
        String url = "JDBC:sqlite:" + JDBCUtilities.UBICACION_BD;
        return DriverManager.getConnection( url );
    }

    public static boolean estaVacia(){
        File archivo = new File( JDBCUtilities.UBICACION_BD );
        return archivo.length() == 0;
    }

}
