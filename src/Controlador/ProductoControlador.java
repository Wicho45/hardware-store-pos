package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Modelo.Producto;
import java.util.ArrayList;

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
    
    
    // Consulta general de inventario unificada con tu propiedad 'codigo'
    public ArrayList<Producto> listarTodosLosProductos() {
        ArrayList<Producto> lista = new ArrayList<>();
        String sql = "SELECT * FROM productos";
        try (Connection conn = ConexionDb.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             java.sql.ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Producto prod = new Producto();

                // Convertimos el id numérico de la DB al String codigo de tu Modelo
                prod.setCodigo(String.valueOf(rs.getInt("id"))); 

                prod.setTipo(rs.getString("tipo"));
                prod.setMarca(rs.getString("marca"));
                prod.setUnidad(rs.getString("unidad"));
                prod.setStock(rs.getInt("stock"));
                prod.setPrecio(rs.getDouble("precio"));
                prod.setNivelReorden(rs.getInt("nivel_reorden"));
                lista.add(prod);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar: " + e.getMessage());
        }
        return lista;
    }

    // Filtro dinámico por tipo o marca unificada con tu propiedad 'codigo'
    public ArrayList<Producto> buscarProductos(String criterio) {
        ArrayList<Producto> lista = new ArrayList<>();
        String sql = "SELECT * FROM productos WHERE tipo LIKE ? OR marca LIKE ?";
        try (Connection conn = ConexionDb.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + criterio + "%");
            ps.setString(2, "%" + criterio + "%");
            try (java.sql.ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Producto prod = new Producto();

                    // Convertimos el id numérico de la DB al String codigo de tu Modelo
                    prod.setCodigo(String.valueOf(rs.getInt("id")));

                    prod.setTipo(rs.getString("tipo"));
                    prod.setMarca(rs.getString("marca"));
                    prod.setUnidad(rs.getString("unidad"));
                    prod.setStock(rs.getInt("stock"));
                    prod.setPrecio(rs.getDouble("precio"));
                    prod.setNivelReorden(rs.getInt("nivel_reorden"));
                    lista.add(prod);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar: " + e.getMessage());
        }
        return lista;
    }
    
    // Método para sumar stock a un producto existente usando su código (id)
    public boolean sumarStockProducto(String codigo, int cantidadASumar) {
        String sql = "UPDATE productos SET stock = stock + ? WHERE id = ?";

        try (java.sql.Connection conn = ConexionDb.obtenerConexion();
             java.sql.PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, cantidadASumar);
            ps.setInt(2, Integer.parseInt(codigo)); // Recuerda que tu id en DB es entero

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0; // Retorna true si encontró el producto y lo actualizó

        } catch (java.sql.SQLException e) {
            System.out.println("Error al actualizar el stock en el Controlador: " + e.getMessage());
            return false;
        }
    }
    
    // Resta la cantidad vendida al stock actual de SQLite
    public boolean restarStockProducto(String codigo, int cantidadAVender) {
        String sql = "UPDATE productos SET stock = stock - ? WHERE id = ?";
        try (java.sql.Connection conn = ConexionDb.obtenerConexion();
             java.sql.PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, cantidadAVender);
            ps.setInt(2, Integer.parseInt(codigo));
            return ps.executeUpdate() > 0;

        } catch (java.sql.SQLException e) {
            System.out.println("Error al restar stock: " + e.getMessage());
            return false;
        }
    }
    
}