package Vista;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import Controlador.ProductoControlador;

public class actualizarInventario extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(actualizarInventario.class.getName());
    private ArrayList<Modelo.Producto> listaActual = new ArrayList<>();

    public actualizarInventario() {
        initComponents();
        this.setTitle("Actualizar inventario - Ferretería Marroquín");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        productoCbx.removeAllItems();
        
        this.setVisible(true);
    }
    
    public boolean verificarContenido(String buscado, int seleccionIdx, String cantidad, String precio) {
        if (buscado.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe buscar un producto antes", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (seleccionIdx == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un producto del combo antes", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Validación crítica: Verificar que al menos uno de los campos contenga datos
        if (cantidad.isEmpty() && precio.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe rellenar al menos un campo: Cantidad o Nuevo Precio.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Verificar formato de la cantidad si no viene vacía
        if (!cantidad.isEmpty()) {
            try {
                int cantNum = Integer.parseInt(cantidad);
                if (cantNum <= 0) {
                    JOptionPane.showMessageDialog(this, "La cantidad a ingresar debe ser mayor a cero", "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "El campo de cantidad debe ser un número exacto sin decimales", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }

        // Verificar formato del precio si no viene vacío
        if (!precio.isEmpty()) {
            try {
                double precioNum = Double.parseDouble(precio);
                if (precioNum <= 0.0) {
                    JOptionPane.showMessageDialog(this, "El nuevo precio debe ser mayor a cero", "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "El precio debe contener un formato numérico válido. Ejemplo: 25.50", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }

        return true;
    }
    
    
    public void llenarCombo(ArrayList<Modelo.Producto> productosEncontrados) {
        productoCbx.removeAllItems();
        this.listaActual = productosEncontrados; 
        if (productosEncontrados == null || productosEncontrados.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se encontraron productos con ese criterio", "Información", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        for (Modelo.Producto prod : productosEncontrados) {
            String item = "[CÓDIGO: " + prod.getCodigo() + "] - " + prod.getTipo() + " - " + prod.getMarca() + " (Stock: " + prod.getStock() + " | Precio: Q" + String.format("%.2f", prod.getPrecio()) + ")";
            productoCbx.addItem(item);
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        buscarTxt = new javax.swing.JTextField();
        buscarBtn = new javax.swing.JButton();
        productoCbx = new javax.swing.JComboBox<>();
        actualizarBtn = new javax.swing.JButton();
        cancelarBtn = new javax.swing.JButton();
        cantidadTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        nuevoPrecioTxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(450, 320));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel2.setText("ACTUALIZAR INVENTARIO");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel3.setText("BUSCAR:");
        jLabel3.setToolTipText("");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));
        jPanel1.add(buscarTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 290, -1));

        buscarBtn.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        buscarBtn.setText("BUSCAR");
        buscarBtn.addActionListener(this::buscarBtnActionPerformed);
        jPanel1.add(buscarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, -1, -1));

        productoCbx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(productoCbx, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 400, -1));

        actualizarBtn.setText("ACTUALIZAR");
        actualizarBtn.setToolTipText("");
        actualizarBtn.addActionListener(this::actualizarBtnActionPerformed);
        jPanel1.add(actualizarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 370, -1, 30));

        cancelarBtn.setText("CANCELAR");
        cancelarBtn.addActionListener(this::cancelarBtnActionPerformed);
        jPanel1.add(cancelarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, -1, -1));
        jPanel1.add(cantidadTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 400, -1));

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel4.setText("ANTIDAD QUE INGRESA:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));
        jPanel1.add(nuevoPrecioTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 400, -1));

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel6.setText("NUEVO PRECIO:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondoNuevo.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 430));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void actualizarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarBtnActionPerformed
        try {
            String buscado = buscarTxt.getText().trim();
            int seleccionIdx = productoCbx.getSelectedIndex();
            String cantidadStr = cantidadTxt.getText().trim();
            String precioStr = nuevoPrecioTxt.getText().trim();
            
            // 1. Validar entradas incluyendo el nuevo parámetro de precio
            if (!verificarContenido(buscado, seleccionIdx, cantidadStr, precioStr)) {
                return;
            }
            
            Modelo.Producto productoSeleccionado = listaActual.get(seleccionIdx);
            
            // 2. Determinar valores por defecto si vienen vacíos
            int cantidadASumar = cantidadStr.isEmpty() ? 0 : Integer.parseInt(cantidadStr);
            double nuevoPrecio = precioStr.isEmpty() ? 0.0 : Double.parseDouble(precioStr);
            
            // 3. Ejecutar la consulta flexible en el controlador
            ProductoControlador proCon = new ProductoControlador();
            if (proCon.actualizarInventarioPrecio(productoSeleccionado.getCodigo(), cantidadASumar, nuevoPrecio)) {
                
                String msg = "¡Inventario actualizado con éxito!\n";
                if (cantidadASumar > 0) msg += "Nuevo Stock: " + (productoSeleccionado.getStock() + cantidadASumar) + "\n";
                if (nuevoPrecio > 0.0) msg += "Nuevo Precio: Q" + String.format("%.2f", nuevoPrecio);
                
                JOptionPane.showMessageDialog(this, msg, "Éxito", JOptionPane.INFORMATION_MESSAGE);
                this.dispose(); 
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo actualizar el registro en la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (Exception e) {
            logger.log(java.util.logging.Level.SEVERE, "Error al actualizar inventario", e);
            JOptionPane.showMessageDialog(this, "Error al intentar actualizar el producto", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_actualizarBtnActionPerformed

    private void cancelarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBtnActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelarBtnActionPerformed

    private void buscarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarBtnActionPerformed
        String criterio = buscarTxt.getText().trim().toLowerCase();
        if (criterio.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor escriba un tipo o marca para buscar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        ProductoControlador proCon = new ProductoControlador();
        llenarCombo(proCon.buscarProductos(criterio));
    }//GEN-LAST:event_buscarBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizarBtn;
    private javax.swing.JButton buscarBtn;
    private javax.swing.JTextField buscarTxt;
    private javax.swing.JButton cancelarBtn;
    private javax.swing.JTextField cantidadTxt;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nuevoPrecioTxt;
    private javax.swing.JComboBox<String> productoCbx;
    // End of variables declaration//GEN-END:variables
}
