package Vista;

import javax.swing.JOptionPane;
import Modelo.Producto;

public class ingresoProducto extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ingresoProducto.class.getName());

    public ingresoProducto() {
        initComponents();
        this.setTitle("Ingreso de producto - Ferretería Marroquín");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    public boolean verificarContenido(String tipo, String marca, String unidad, String cantidad, String precio, String nivel){
    
        if (cantidad.isEmpty() || marca.isEmpty() || nivel.isEmpty() || precio.isEmpty() || tipo.isEmpty() || unidad.isEmpty()){
            JOptionPane.showMessageDialog(this,"Debe llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        try{
            
            Integer.parseInt(cantidad);
            Integer.parseInt(nivel);
            
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this,"El campo de cantidad y cantidad para advertencia deben ser numeros exactos sin decimales", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        try{
            
            Double.parseDouble(precio);
            
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this,"El campo de precio debe contener decimales. Ejemplo 20.00", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
  
        return true;
    };

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tipoTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        marcaTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        unidadTxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cantidadTxt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        nivelTxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        precioTxt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cancelarBtn = new javax.swing.JButton();
        ingresarBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel2.setText("INGRESAR NUEVO PRODUCTO");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, -1, -1));
        jPanel1.add(tipoTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 390, -1));

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel3.setText("Tipo de producto:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, 20));
        jPanel1.add(marcaTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 390, -1));

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel4.setText("Tipo de producto:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, 20));

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel5.setText("Marca del prodcuto:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, 20));
        jPanel1.add(unidadTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 390, -1));

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel6.setText("Unidad de medida:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, 20));
        jPanel1.add(cantidadTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 390, -1));

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel7.setText("Cantidad:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, 20));
        jPanel1.add(nivelTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 390, -1));

        jLabel8.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel8.setText("Cantidad para advertencia:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, -1, 20));
        jPanel1.add(precioTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 390, -1));

        jLabel9.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel9.setText("Precio por unidad:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, 20));

        cancelarBtn.setText("CANCELAR");
        cancelarBtn.addActionListener(this::cancelarBtnActionPerformed);
        jPanel1.add(cancelarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 450, -1, -1));

        ingresarBtn.setText("INGRESAR PRODUCTO");
        ingresarBtn.addActionListener(this::ingresarBtnActionPerformed);
        jPanel1.add(ingresarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 450, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ingresarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresarBtnActionPerformed
        try{
            
        String tipo = tipoTxt.getText().trim().toLowerCase();
        String marca = marcaTxt.getText().trim().toLowerCase();
        String unidad = unidadTxt.getText().trim().toLowerCase();
        String cantidad = cantidadTxt.getText().trim();
        String precio = precioTxt.getText().trim();
        String nivel = nivelTxt.getText().trim();
        
        if(!verificarContenido(tipo, marca, unidad, cantidad, precio, nivel)){
            return;
        }
        
        Producto nuevoProducto = new Producto();
        
        nuevoProducto.setStock(Integer.parseInt(cantidad));
        nuevoProducto.setMarca(marca);
        nuevoProducto.setNivelReorden(Integer.parseInt(nivel));
        nuevoProducto.setPrecio(Double.parseDouble(precio));
        nuevoProducto.setTipo(tipo);
        nuevoProducto.setUnidad(unidad);
        
        //debug de prueba
            System.out.println("Producto nuevo creado con nombre: " + nuevoProducto.getTipo() + " " + nuevoProducto.getMarca());
        
        //Logica para ingresar a base de datos SQLite como objeto producto
        
        cantidadTxt.setText("");
        marcaTxt.setText("");
        nivelTxt.setText("");
        precioTxt.setText("");
        tipoTxt.setText("");
        unidadTxt.setText("");
        
        JOptionPane.showMessageDialog(this, "Éxito al registrar el producto", "Éxito", JOptionPane.OK_OPTION);
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, "Error al intentar registrar el producto", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        
    }//GEN-LAST:event_ingresarBtnActionPerformed

    private void cancelarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBtnActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelarBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelarBtn;
    private javax.swing.JTextField cantidadTxt;
    private javax.swing.JButton ingresarBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField marcaTxt;
    private javax.swing.JTextField nivelTxt;
    private javax.swing.JTextField precioTxt;
    private javax.swing.JTextField tipoTxt;
    private javax.swing.JTextField unidadTxt;
    // End of variables declaration//GEN-END:variables
}
