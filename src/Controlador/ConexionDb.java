package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionDb {
    
    private static final String URl = "jdbc:sqlite:ferreteria.db";

    public static Connection obtenerConexion() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver SQLite no encontrado", e);
        }
        return DriverManager.getConnection(URl);
    }   
    
    // Inicialización de la DB
    public static void inicializarDb(){
        String sql = "CREATE TABLE IF NOT EXISTS productos ("
            + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
            + "tipo TEXT NOT NULL, "
            + "marca TEXT NOT NULL, "
            + "unidad TEXT NOT NULL, "
            + "stock INTEGER NOT NULL, "
            + "precio REAL NOT NULL, "
            + "nivel_reorden INTEGER NOT NULL"
            + ");";
                
        try(Connection conn = obtenerConexion(); Statement stmt = conn.createStatement()){
            stmt.execute(sql);
            System.out.println("Éxito al inicializar la DB, tabla productos creada y lista para usar");
        } catch(SQLException e){
            System.out.println("Error crítico al inicializar la base de datos: " + e.getMessage());
        }
    }
}