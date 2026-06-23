package Modelo;

import java.util.ArrayList;

public class Venta {
    
    private int idVenta;                      
    private String fecha;                     
    private double total;                     
    private String tipoComprobante;           
    private ArrayList<DetalleVenta> detalles; 

    public Venta() {
        this.detalles = new ArrayList<>();
    }

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
        this.calcularTotal(); 
    }
    
    public void calcularTotal() {
        this.total = 0.0;
        for (DetalleVenta dv : detalles) {
            this.total += dv.getSubtotal();
        }
    }
}