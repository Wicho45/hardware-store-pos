package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Modelo.Producto;
import Modelo.Venta;
import Modelo.DetalleVenta;
import java.util.ArrayList;

public class ProductoControlador {

    // Método para registrar un producto en la base de datos
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
    
    public ArrayList<Producto> listarTodosLosProductos() {
        ArrayList<Producto> lista = new ArrayList<>();
        String sql = "SELECT * FROM productos";
        try (Connection conn = ConexionDb.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Producto prod = new Producto();
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

    // Filtro dinámico por tipo o marca unificada con propiedad 'codigo'
    public ArrayList<Producto> buscarProductos(String criterio) {
        ArrayList<Producto> lista = new ArrayList<>();
        String sql = "SELECT * FROM productos WHERE tipo LIKE ? OR marca LIKE ?";
        try (Connection conn = ConexionDb.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + criterio + "%");
            ps.setString(2, "%" + criterio + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Producto prod = new Producto();
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
        try (Connection conn = ConexionDb.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, cantidadASumar);
            ps.setInt(2, Integer.parseInt(codigo));
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar el stock en el Controlador: " + e.getMessage());
            return false;
        }
    }
    
    // Resta la cantidad vendida al stock actual de SQLite
    public boolean restarStockProducto(String codigo, int cantidadAVender) {
        String sql = "UPDATE productos SET stock = stock - ? WHERE id = ?";
        try (Connection conn = ConexionDb.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, cantidadAVender);
            ps.setInt(2, Integer.parseInt(codigo));
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al restar stock: " + e.getMessage());
            return false;
        }
    }
 
    // Modificación de inventario y precio flexible combinada
    public boolean actualizarInventarioPrecio(String codigo, int cantidadASumar, double nuevoPrecio) {
        if (cantidadASumar > 0 && nuevoPrecio > 0.0) {
            String sql = "UPDATE productos SET stock = stock + ?, precio = ? WHERE id = ?";
            try (Connection conn = ConexionDb.obtenerConexion();
                 PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, cantidadASumar);
                ps.setDouble(2, nuevoPrecio);
                ps.setInt(3, Integer.parseInt(codigo));
                return ps.executeUpdate() > 0;
            } catch (SQLException e) {
                System.out.println("Error al actualizar stock y precio: " + e.getMessage());
                return false;
            }
        }
        if (cantidadASumar > 0) {
            String sql = "UPDATE productos SET stock = stock + ? WHERE id = ?";
            try (Connection conn = ConexionDb.obtenerConexion();
                 PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, cantidadASumar);
                ps.setInt(2, Integer.parseInt(codigo));
                return ps.executeUpdate() > 0;
            } catch (SQLException e) {
                System.out.println("Error al actualizar solo stock: " + e.getMessage());
                return false;
            }
        }
        if (nuevoPrecio > 0.0) {
            String sql = "UPDATE productos SET precio = ? WHERE id = ?";
            try (Connection conn = ConexionDb.obtenerConexion();
                 PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setDouble(1, nuevoPrecio);
                ps.setInt(2, Integer.parseInt(codigo));
                return ps.executeUpdate() > 0;
            } catch (SQLException e) {
                System.out.println("Error al actualizar solo precio: " + e.getMessage());
                return false;
            }
        }
        return false;
    }

    // 1. Guardar transacciones de venta completas (Encabezado + Detalles distribuidos)
    public boolean guardarVentaCompleta(Venta venta) {
        String sqlVenta = "INSERT INTO ventas (fecha, total, tipo_comprobante) VALUES (?, ?, ?)";
        String sqlDetalle = "INSERT INTO detalle_ventas (id_venta, id_producto, cantidad, subtotal) VALUES (?, ?, ?, ?)";
        
        Connection conn = null;
        try {
            conn = ConexionDb.obtenerConexion();
            conn.setAutoCommit(false); 
            
            try (PreparedStatement psV = conn.prepareStatement(sqlVenta, java.sql.Statement.RETURN_GENERATED_KEYS)) {
                psV.setString(1, venta.getFecha());
                psV.setDouble(2, venta.getTotal());
                psV.setString(3, venta.getTipoComprobante());
                psV.executeUpdate();
                
                try (ResultSet rs = psV.getGeneratedKeys()) {
                    if (rs.next()) {
                        int idVentaGenerado = rs.getInt(1);
                        
                        try (PreparedStatement psD = conn.prepareStatement(sqlDetalle)) {
                            for (DetalleVenta dv : venta.getDetalles()) {
                                psD.setInt(1, idVentaGenerado);
                                psD.setInt(2, Integer.parseInt(dv.getProducto().getCodigo()));
                                psD.setInt(3, dv.getCantidad());
                                psD.setDouble(4, dv.getSubtotal());
                                psD.addBatch();
                            }
                            psD.executeBatch();
                        }
                    }
                }
            }
            conn.commit();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al persistir transacción de venta: " + e.getMessage());
            if (conn != null) {
                try { conn.rollback(); } catch (SQLException ex) { System.out.println(ex.getMessage()); }
            }
            return false;
        } finally {
            if (conn != null) { try { conn.close(); } catch (SQLException e) { System.out.println(e.getMessage()); } }
        }
    }

    // 2. Listar todas las facturas generadas en orden cronológico inverso
    public ArrayList<Venta> listarHistorialVentas() {
        ArrayList<Venta> lista = new ArrayList<>();
        String sql = "SELECT * FROM ventas ORDER BY id_venta DESC";
        try (Connection conn = ConexionDb.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Venta v = new Venta();
                v.setIdVenta(rs.getInt("id_venta"));
                v.setFecha(rs.getString("fecha"));
                v.setTotal(rs.getDouble("total"));
                v.setTipoComprobante(rs.getString("tipo_comprobante"));
                lista.add(v);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar historial: " + e.getMessage());
        }
        return lista;
    }

    // 3. Revertir existencias de stock físico y remover facturas anuladas
    public boolean anularVentaPorId(int idVenta) {
        String sqlBuscarDetalles = "SELECT id_producto, cantidad FROM detalle_ventas WHERE id_venta = ?";
        String sqlDevolverStock = "UPDATE productos SET stock = stock + ? WHERE id = ?";
        String sqlBorrarVenta = "DELETE FROM ventas WHERE id_venta = ?";
        
        Connection conn = null;
        try {
            conn = ConexionDb.obtenerConexion();
            conn.setAutoCommit(false);
            
            // Reestablecer existencias vendidas
            try (PreparedStatement psB = conn.prepareStatement(sqlBuscarDetalles)) {
                psB.setInt(1, idVenta);
                try (ResultSet rs = psB.executeQuery()) {
                    try (PreparedStatement psS = conn.prepareStatement(sqlDevolverStock)) {
                        while (rs.next()) {
                            psS.setInt(1, rs.getInt("cantidad"));
                            psS.setInt(2, rs.getInt("id_producto"));
                            psS.addBatch();
                        }
                        psS.executeBatch();
                    }
                }
            }
            
            try (PreparedStatement psDel = conn.prepareStatement(sqlBorrarVenta)) {
                psDel.setInt(1, idVenta);
                psDel.executeUpdate();
            }
            
            conn.commit();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al anular venta: " + e.getMessage());
            if (conn != null) { try { conn.rollback(); } catch (SQLException ex) { System.out.println(ex.getMessage()); } }
            return false;
        } finally {
            if (conn != null) { try { conn.close(); } catch (SQLException e) { System.out.println(e.getMessage()); } }
        }
    }

    public ArrayList<DetalleVenta> obtenerDetallesDeVenta(int idVenta) {
        ArrayList<DetalleVenta> detalles = new ArrayList<>();
        String sql = "SELECT dv.*, p.tipo, p.marca, p.unidad, p.precio FROM detalle_ventas dv "
                   + "JOIN productos p ON dv.id_producto = p.id WHERE dv.id_venta = ?";
        try (Connection conn = ConexionDb.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idVenta);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Producto p = new Producto();
                    p.setCodigo(String.valueOf(rs.getInt("id_producto")));
                    p.setTipo(rs.getString("tipo"));
                    p.setMarca(rs.getString("marca"));
                    p.setUnidad(rs.getString("unidad"));
                    p.setPrecio(rs.getDouble("precio"));
                    
                    DetalleVenta dv = new DetalleVenta(p, rs.getInt("cantidad"));
                    detalles.add(dv);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al recuperar detalles de la venta: " + e.getMessage());
        }
        return detalles;
    }

    // 5. Filtrar facturas según rangos de fecha flexibles de auditoría
    public ArrayList<Venta> buscarVentasPorRangoFechas(String fechaInicio, String fechaFin) {
        ArrayList<Venta> filtradas = new ArrayList<>();
        String sql = "SELECT * FROM ventas WHERE substr(fecha, 1, 10) BETWEEN ? AND ? ORDER BY id_venta ASC";
        try (Connection conn = ConexionDb.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, fechaInicio);
            ps.setString(2, fechaFin);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Venta v = new Venta();
                    v.setIdVenta(rs.getInt("id_venta"));
                    v.setFecha(rs.getString("fecha"));
                    v.setTotal(rs.getDouble("total"));
                    v.setTipoComprobante(rs.getString("tipo_comprobante"));
                    filtradas.add(v);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al auditar rango de fechas: " + e.getMessage());
        }
        return filtradas;
    }
}