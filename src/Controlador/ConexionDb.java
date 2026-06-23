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
    
    // Inicialización de la DB con las tablas de auditoría e historial
    public static void inicializarDb(){
        // 1. Tabla original de Productos
        String sqlProductos = "CREATE TABLE IF NOT EXISTS productos ("
            + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
            + "tipo TEXT NOT NULL, "
            + "marca TEXT NOT NULL, "
            + "unidad TEXT NOT NULL, "
            + "stock INTEGER NOT NULL, "
            + "precio REAL NOT NULL, "
            + "nivel_reorden INTEGER NOT NULL"
            + ");";
        
        // 2. Nueva Tabla: Encabezado general de las Facturas
        String sqlVentas = "CREATE TABLE IF NOT EXISTS ventas ("
            + "id_venta INTEGER PRIMARY KEY AUTOINCREMENT, "
            + "fecha TEXT NOT NULL, "
            + "total REAL NOT NULL, "
            + "tipo_comprobante TEXT NOT NULL"
            + ");";
        
        // 3. Nueva Tabla: Renglones/Cuerpo de las Facturas vinculadas por llave foránea
        String sqlDetalleVentas = "CREATE TABLE IF NOT EXISTS detalle_ventas ("
            + "id_detalle INTEGER PRIMARY KEY AUTOINCREMENT, "
            + "id_venta INTEGER NOT NULL, "
            + "id_producto INTEGER NOT NULL, "
            + "cantidad INTEGER NOT NULL, "
            + "subtotal REAL NOT NULL, "
            + "FOREIGN KEY (id_venta) REFERENCES ventas(id_venta) ON DELETE CASCADE, "
            + "FOREIGN KEY (id_producto) REFERENCES productos(id)"
            + ");";
                
        try (Connection conn = obtenerConexion(); Statement stmt = conn.createStatement()){
            
            stmt.execute("PRAGMA foreign_keys = ON;");
            
            stmt.execute(sqlProductos);
            stmt.execute(sqlVentas);
            stmt.execute(sqlDetalleVentas);
            
            System.out.println("Éxito al inicializar la DB. Tablas de inventario, facturas e historial listas.");
            
        } catch(SQLException e){
            System.out.println("Error crítico al inicializar la base de datos: " + e.getMessage());
        }
    }
}