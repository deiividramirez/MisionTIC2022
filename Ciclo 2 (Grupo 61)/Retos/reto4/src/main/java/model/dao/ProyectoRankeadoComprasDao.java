package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.vo.ProyectoRankeadoCompras;
import util.JDBCUtilities;

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
