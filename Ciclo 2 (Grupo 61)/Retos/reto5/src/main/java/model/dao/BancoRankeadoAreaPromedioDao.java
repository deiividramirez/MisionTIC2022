package model.dao;

import java.util.ArrayList;
import util.JDBCUtilities;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.vo.BancoRankeadoAreaPromedio;

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
