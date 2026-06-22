package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Modelo.Producto;

public class ProductoControlador {

    // Método para registrar un producto en la base de datos
    // Modifica la firma en tu controlador para que reciba el objeto
    public boolean registrarProducto(Producto prod) {
        String sql = "INSERT INTO productos (tipo, marca, unidad, stock, precio, nivel_reorden) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexionDb.obtenerConexion(); 
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, prod.getTipo());
            ps.setString(2, prod.getMarca());
            ps.setString(3, prod.getUnidad());
            ps.setInt(4, prod.getStock());
            ps.setDouble(5, prod.getPrecio());
            ps.setInt(6, prod.getNivelReorden());

            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error al registrar producto en Base de Datos: " + e.getMessage());
            return false;
        }
    }
}