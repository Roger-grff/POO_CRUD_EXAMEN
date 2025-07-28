package App.Modelo;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    // Ruta relativa desde la raíz del proyecto (no desde /src)
    //rivate final String rutaArchivodb = "src/base_datos/prog.db";
    private final String rutaArchivodb = "base_datos/prog.db"; // fuera de src


    public Connection conectar() {
        // Obtiene la ruta absoluta del archivo
        String url = "jdbc:sqlite:" + new File(rutaArchivodb).getAbsolutePath();
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url);
            System.out.println(" Conexión exitosa a la base de datos.");
        } catch (SQLException e) {
            System.err.println(" Error al conectar a la base de datos: " + e.getMessage());
            e.printStackTrace();
        }

        return conn;

    }
    public static void cerrarConexion(Connection conn) {
        try {
            if (conn != null) conn.close();
        } catch (SQLException e) {
            System.err.println("Error cerrando la conexión: " + e.getMessage());
        }
    }
/*
    public static void main(String[] args) {
        Conexion conexion = new Conexion();
        Connection conn = conexion.conectar();

        if (conn != null) {
            try {
                conn.close();
                System.out.println(" Conexión cerrada correctamente.");
            } catch (SQLException e) {
                System.err.println(" Error cerrando la conexión: " + e.getMessage());
            }
        }
    }

 */
}
