package Vista;

import javax.swing.JOptionPane;
import java.util.ArrayList;

public class actualizarInventario extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(actualizarInventario.class.getName());

    public actualizarInventario() {
        initComponents();
        this.setTitle("Actualizar inventario - Ferretería Marroquín");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    public boolean verificarContenido(String buscado, String productoSeleccionado, String cantidad){
    
        if (buscado.isEmpty()){
            JOptionPane.showMessageDialog(this, "Debe buscar un producto antes", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if(productoSeleccionado.isEmpty()){
            JOptionPane.showMessageDialog(this, "Debe seleccionar un producto antes", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if(cantidad.isEmpty()){
            JOptionPane.showMessageDialog(this, "Debe ingresar una cantidad antes", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        
        try{
            
            Integer.parseInt(cantidad);
            
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this,"El campo de cantidad debe ser un numero exacto sin decimales", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        
        return true;
    };
    
    
    public void llenarCombo(ArrayList productosEncontrados){
        //Logica para llenar tabla con productos encontrados
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
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(450, 340));

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
        jPanel1.add(buscarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, -1, -1));

        productoCbx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(productoCbx, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 400, -1));

        actualizarBtn.setText("ACTUALIZAR");
        actualizarBtn.setToolTipText("");
        actualizarBtn.addActionListener(this::actualizarBtnActionPerformed);
        jPanel1.add(actualizarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 260, -1, 30));

        cancelarBtn.setText("CANCELAR");
        cancelarBtn.addActionListener(this::cancelarBtnActionPerformed);
        jPanel1.add(cancelarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, -1, -1));
        jPanel1.add(cantidadTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 400, -1));

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel4.setText("CANTIDAD QUE INGRESA");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 320));

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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void actualizarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarBtnActionPerformed
        try{
            
            String buscado = buscarTxt.getText().trim().toLowerCase();
            String productoSeleccionado = productoCbx.getSelectedItem().toString().trim().toLowerCase();
            String cantidad = cantidadTxt.getText().trim();
            
            if(!verificarContenido(buscado, productoSeleccionado, cantidad)){
                
            }
            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error al intentar actualizar el producto el producto", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }//GEN-LAST:event_actualizarBtnActionPerformed

    private void cancelarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBtnActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelarBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizarBtn;
    private javax.swing.JButton buscarBtn;
    private javax.swing.JTextField buscarTxt;
    private javax.swing.JButton cancelarBtn;
    private javax.swing.JTextField cantidadTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> productoCbx;
    // End of variables declaration//GEN-END:variables
}
