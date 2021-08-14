package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.io.File;

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
