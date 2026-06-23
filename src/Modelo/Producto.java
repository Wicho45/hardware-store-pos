package Modelo;

public class Producto {
     
    private String codigo;
    private String tipo;
    private String marca;
    private String unidad;
    private int stock;
    private double precio;
    private int nivelReorden;

    public Producto() {
    }

    public Producto(String tipo, String marca, int stock, double precio, int nivelReorden) {
        this.tipo = tipo;
        this.marca = marca;
        this.stock = stock;
        this.precio = precio;
        this.nivelReorden = nivelReorden;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }
    
    public String getCodigo(){
        return codigo;
    }
    
    public void setCodigo(String codigo){
        this.codigo = codigo;
    }
        
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getNivelReorden() {
        return nivelReorden;
    }

    public void setNivelReorden(int nivelReorden) {
        this.nivelReorden = nivelReorden;
    }
    
}
