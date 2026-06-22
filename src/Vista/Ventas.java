package Vista;

import java.awt.Dimension;
import java.util.ArrayList;
import Modelo.Producto;
import javax.swing.JOptionPane;

public class Ventas extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Ventas.class.getName());

    
    public Ventas() {
        initComponents();
        this.setTitle("Ventas - Ferretería Marroquín");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    //Logica para buscar dentro de base de datos el producto entre tipo y marca
    private ArrayList buscarProducto(String buscado){
        Producto productoEncontrado = new Producto();
        ArrayList<Producto> listaProductos = new ArrayList<>();
        
        //Logica para encontrar en base de datos
        
        return listaProductos;
    }
    
    private void llenarTabla(ArrayList listaProductos){
        // logica para llenar tabla con productos encontrados
    
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Fondo = new javax.swing.JPanel();
        Logo_ferreteria = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        busquedaTxt = new javax.swing.JTextField();
        buscarBtn = new javax.swing.JToggleButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        inventarioTable = new javax.swing.JTable();
        ingresarBtn = new javax.swing.JButton();
        actualizarBtn = new javax.swing.JButton();
        ventaBtn = new javax.swing.JButton();
        historialBtn = new javax.swing.JButton();
        cerrarBtn = new javax.swing.JButton();
        imagenFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Logo_ferreteria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo_ferre256.png"))); // NOI18N
        Fondo.add(Logo_ferreteria, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 210, 120));

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel1.setText("BIENVENIDO");
        Fondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, -1, -1));
        Fondo.add(busquedaTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 710, -1));

        buscarBtn.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        buscarBtn.setText("BUSCAR");
        buscarBtn.addActionListener(this::buscarBtnActionPerformed);
        Fondo.add(buscarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 180, 140, -1));

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel2.setText("Busqueda de producto:");
        Fondo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        inventarioTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Tipo", "Marca", "Precio", "Unidad", "Cant. Disponible"
            }
        ));
        jScrollPane1.setViewportView(inventarioTable);

        Fondo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 890, 370));

        ingresarBtn.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        ingresarBtn.setText("Ingresar producto");
        ingresarBtn.addActionListener(this::ingresarBtnActionPerformed);
        Fondo.add(ingresarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 620, -1, -1));

        actualizarBtn.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        actualizarBtn.setText("Actualizar inventario");
        actualizarBtn.addActionListener(this::actualizarBtnActionPerformed);
        Fondo.add(actualizarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 620, -1, -1));

        ventaBtn.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        ventaBtn.setText("Venta");
        ventaBtn.setToolTipText("");
        Fondo.add(ventaBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 620, -1, -1));

        historialBtn.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        historialBtn.setText("Historial de ventas");
        Fondo.add(historialBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 620, -1, -1));

        cerrarBtn.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        cerrarBtn.setText("Cerrar");
        Fondo.add(cerrarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 620, -1, 30));

        imagenFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondoNuevo.png"))); // NOI18N
        Fondo.add(imagenFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 700));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ingresarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresarBtnActionPerformed
        ingresoProducto nuevoIngreso = new ingresoProducto();
        nuevoIngreso.setVisible(true);
    }//GEN-LAST:event_ingresarBtnActionPerformed

    private void buscarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarBtnActionPerformed
        String buscado = busquedaTxt.getText().trim().toLowerCase();
        
        
        // logica para obtener informacion de productos con nombre o tipo igual al ingresado
        
    }//GEN-LAST:event_buscarBtnActionPerformed

    private void actualizarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarBtnActionPerformed
        try{
            
            actualizarInventario newActualizar = new actualizarInventario();
            newActualizar.setVisible(true);
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, "Error al abrir actualizacion", "Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_actualizarBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Fondo;
    private javax.swing.JLabel Logo_ferreteria;
    private javax.swing.JButton actualizarBtn;
    private javax.swing.JToggleButton buscarBtn;
    private javax.swing.JTextField busquedaTxt;
    private javax.swing.JButton cerrarBtn;
    private javax.swing.JButton historialBtn;
    private javax.swing.JLabel imagenFondo;
    private javax.swing.JButton ingresarBtn;
    private javax.swing.JTable inventarioTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton ventaBtn;
    // End of variables declaration//GEN-END:variables
}
