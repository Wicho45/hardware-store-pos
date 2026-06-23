package Modelo;

import java.util.ArrayList;

public class Venta {
    
    private int idVenta;                      // ID autoincrementable para el registro en DB
    private String fecha;                     // Fecha y hora en la que se realiza la transacción
    private double total;                     // Monto total acumulado de la venta
    private String tipoComprobante;           // Para diferenciar si fue "VENTA" o "PRESUPUESTO"
    private ArrayList<DetalleVenta> detalles; // Lista de todos los productos incluidos en esta venta

    // Constructor vacío
    public Venta() {
        this.detalles = new ArrayList<>();
    }

    // Constructor con parámetros principales
    public Venta(String fecha, double total, String tipoComprobante, ArrayList<DetalleVenta> detalles) {
        this.fecha = fecha;
        this.total = total;
        this.tipoComprobante = tipoComprobante;
        this.detalles = detalles;
    }

    // Métodos Getter y Setter
    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getTipoComprobante() {
        return tipoComprobante;
    }

    public void setTipoComprobante(String tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }

    public ArrayList<DetalleVenta> getDetalles() {
        return detalles;
    }

    public void setDetalles(ArrayList<DetalleVenta> detalles) {
        this.detalles = detalles;
        this.calcularTotal(); // Recalcula el total automáticamente si se cambia la lista
    }
    
    // Método utilitario para calcular o recalcular el total sumando los subtotales del carrito
    public void calcularTotal() {
        this.total = 0.0;
        for (DetalleVenta dv : detalles) {
            this.total += dv.getSubtotal();
        }
    }
}