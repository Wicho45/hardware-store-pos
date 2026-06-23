package Vista;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import Controlador.ProductoControlador;

public class Ventas extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Ventas.class.getName());

    
    public Ventas() {
        initComponents();
        this.setTitle("Ventas - Ferretería Marroquín");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        refrescarTablaCompleta();
        
        this.setVisible(true);
    }

    private void refrescarTablaCompleta() {
        ProductoControlador proCon = new ProductoControlador();
        llenarTabla(proCon.listarTodosLosProductos());
    }
    
    private void llenarTabla(ArrayList<Modelo.Producto> listaProductos) {
        javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) inventarioTable.getModel();
        modelo.setRowCount(0);

        if (listaProductos == null || listaProductos.isEmpty()) {
            return;
        }

        for (Modelo.Producto prod : listaProductos) {
            Object[] fila = new Object[6];
            fila[0] = prod.getCodigo();          
            fila[1] = prod.getTipo();            
            fila[2] = prod.getMarca();           
            fila[3] = String.format("%.2f", prod.getPrecio()); 
            fila[4] = prod.getUnidad();          
            fila[5] = prod.getStock();           

            modelo.addRow(fila);
        }
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
        actualizarTableBtn = new javax.swing.JButton();
        imagenFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Logo_ferreteria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo_ferre256.png"))); // NOI18N
        Fondo.add(Logo_ferreteria, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 210, 120));

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel1.setText("BIENVENIDO");
        Fondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, -1, -1));
        Fondo.add(busquedaTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 590, -1));

        buscarBtn.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        buscarBtn.setText("BUSCAR");
        buscarBtn.addActionListener(this::buscarBtnActionPerformed);
        Fondo.add(buscarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 180, 130, -1));

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
        ventaBtn.addActionListener(this::ventaBtnActionPerformed);
        Fondo.add(ventaBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 620, -1, -1));

        historialBtn.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        historialBtn.setText("Historial de ventas");
        Fondo.add(historialBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 620, -1, -1));

        cerrarBtn.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        cerrarBtn.setText("Cerrar");
        cerrarBtn.addActionListener(this::cerrarBtnActionPerformed);
        Fondo.add(cerrarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 620, -1, 30));

        actualizarTableBtn.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        actualizarTableBtn.setText("ACTUALIZAR");
        actualizarTableBtn.addActionListener(this::actualizarTableBtnActionPerformed);
        Fondo.add(actualizarTableBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 180, 130, -1));

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
        
        nuevoIngreso.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                refrescarTablaCompleta();
            }
        });
        
        nuevoIngreso.setVisible(true);;
        
    }//GEN-LAST:event_ingresarBtnActionPerformed

    private void buscarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarBtnActionPerformed
        // logica para obtener informacion de productos con nombre o tipo igual al ingresado
        
        String buscado = busquedaTxt.getText().trim().toLowerCase();
        ProductoControlador proCon = new ProductoControlador();

        if (buscado.isEmpty()) {
            // Si el buscador está vacío, vuelve a mostrar todo el inventario
            llenarTabla(proCon.listarTodosLosProductos());
            busquedaTxt.setText("");
        } else {
            // Logica para filtrar por coincidencia de término
            llenarTabla(proCon.buscarProductos(buscado));
            busquedaTxt.setText("");
        }
        
    }//GEN-LAST:event_buscarBtnActionPerformed

    private void actualizarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarBtnActionPerformed
        try {
            actualizarInventario newActualizar = new actualizarInventario();
            
            newActualizar.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent e) {
                    refrescarTablaCompleta();
                }
            });
            
            newActualizar.setVisible(true);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al abrir actualizacion", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_actualizarBtnActionPerformed

    private void actualizarTableBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarTableBtnActionPerformed
        refrescarTablaCompleta();
        busquedaTxt.setText("");
    }//GEN-LAST:event_actualizarTableBtnActionPerformed

    private void cerrarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarBtnActionPerformed
        System.exit(0);
    }//GEN-LAST:event_cerrarBtnActionPerformed

    private void ventaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ventaBtnActionPerformed
        formVenta newForm = new formVenta();
        
        newForm.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                refrescarTablaCompleta();
            }
        });
        
        newForm.setVisible(true);
    }//GEN-LAST:event_ventaBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Fondo;
    private javax.swing.JLabel Logo_ferreteria;
    private javax.swing.JButton actualizarBtn;
    private javax.swing.JButton actualizarTableBtn;
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
