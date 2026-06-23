package Vista;

import Controlador.GenerarFactura;
import Controlador.GenerarPresupuesto;
import java.util.ArrayList;
import Modelo.*;
import javax.swing.SpinnerNumberModel;
import Controlador.ProductoControlador;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class formVenta extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(formVenta.class.getName());
    private ArrayList<Producto> productosBuscados = new ArrayList<>();
    private ArrayList<DetalleVenta> carritoResumen = new ArrayList<>();
    
    public formVenta() {
        initComponents();
        this.setTitle("Ventas - Ferretería Marroquín");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void configurarSpinner(int maxStock) {
        // Configura el spinner: valor inicial 0, mínimo 0, máximo stock disponible, paso 1
        int max = maxStock > 0 ? maxStock : 0;
        SpinnerNumberModel model = new SpinnerNumberModel(0, 0, max, 1);
        cantidadSpn.setModel(model);
    }
    
    private void limpiarTablaResumen() {
        javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) resumenTbl.getModel();
        modelo.setRowCount(0);
    }
    
    private void pintarTablaResumen() {
        javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) resumenTbl.getModel();
        modelo.setRowCount(0);

        double totalAcumulado = 0.0;

        for (DetalleVenta dv : carritoResumen) {
            Object[] fila = new Object[6]; // Ahora son 6 columnas físicas en el JTable
            fila[0] = dv.getProducto().getTipo();
            fila[1] = dv.getProducto().getMarca();
            fila[2] = dv.getProducto().getUnidad();
            fila[3] = String.format("%.2f", dv.getProducto().getPrecio());
            fila[4] = dv.getCantidad(); // Nueva columna inyectada
            fila[5] = String.format("%.2f", dv.getSubtotal());
            modelo.addRow(fila);

            totalAcumulado += dv.getSubtotal();
        }

        if (!carritoResumen.isEmpty()) {
            Object[] filaTotal = new Object[6];
            filaTotal[0] = "TOTAL =";
            filaTotal[1] = "";
            filaTotal[2] = "";
            filaTotal[3] = "";
            filaTotal[4] = ""; // Celda vacía bajo la columna cantidad
            filaTotal[5] = String.format("%.2f", totalAcumulado);
            modelo.addRow(filaTotal);
        }
    }

private void despacharEImprimirPdf(String rutaArchivo) {
    try {
        File pdfFile = new File(rutaArchivo);
        if (!pdfFile.exists()) {
            return;
        }

        // Detectamos el sistema operativo actual
        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("win")) {
            // --- LOGICA EXCLUSIVA Y SEGURA PARA WINDOWS ---
            // Ejecuta de forma nativa el comando de apertura de Windows (cmd /c start)
            // Esto evita que Swing se congele si Windows tarda en reaccionar.
            String comando = "cmd /c start \"\" \"" + pdfFile.getAbsolutePath() + "\"";
            Runtime.getRuntime().exec(comando);
            
            // Nota para producción: Para mandar a imprimir directo en Windows sin abrir,
            // se suele usar: Runtime.getRuntime().exec("rundll32.exe mshtml.dll,PrintHTML \"" + pdfFile.getAbsolutePath() + "\"");
            // Pero dejar que Windows lo abra y el usuario le dé 'Imprimir' desde su visor de PDFs (Adobe/Edge) es lo más seguro.
            
        } else if (java.awt.Desktop.isDesktopSupported()) {
            // --- LOGICA PARA MAC / LINUX ---
            java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
            desktop.open(pdfFile);
            
            // En Mac la cola de impresión por defecto no congela el hilo de la app
            if (desktop.isSupported(java.awt.Desktop.Action.PRINT)) {
                desktop.print(pdfFile);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo abrir el visor automático. El PDF se guardó en: " + pdfFile.getAbsolutePath());
        }

    } catch (Exception e) {
        logger.log(java.util.logging.Level.SEVERE, "Error al desplegar o imprimir el PDF en entorno multiplataforma", e);
        JOptionPane.showMessageDialog(this, "Se generó el PDF pero no se pudo abrir automáticamente.");
    }
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        buscarTxt = new javax.swing.JTextField();
        buscarBtn = new javax.swing.JToggleButton();
        productosCbx = new javax.swing.JComboBox<>();
        cantidadSpn = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        resumenTbl = new javax.swing.JTable();
        venderBtn = new javax.swing.JButton();
        presupuestoBtn = new javax.swing.JButton();
        cancelarBtn = new javax.swing.JButton();
        agregarBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel2.setText("VENTAS");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, -1, -1));

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel3.setText("BUSCAR:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));
        jPanel1.add(buscarTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 420, -1));

        buscarBtn.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        buscarBtn.setText("BUSCAR");
        buscarBtn.addActionListener(this::buscarBtnActionPerformed);
        jPanel1.add(buscarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 90, -1, -1));

        productosCbx.addActionListener(this::productosCbxActionPerformed);
        jPanel1.add(productosCbx, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 420, -1));
        jPanel1.add(cantidadSpn, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, 100, -1));

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel4.setText("CANTIDAD:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 130, -1, -1));

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel5.setText("RESUMEN:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel6.setText("PRODUCTO:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        resumenTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Tipo", "Marca", "Unidad", "Precio c/u", "Cantidad", "Subtotal"
            }
        ));
        jScrollPane1.setViewportView(resumenTbl);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 550, 340));

        venderBtn.setText("VENDER");
        venderBtn.addActionListener(this::venderBtnActionPerformed);
        jPanel1.add(venderBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 600, -1, -1));

        presupuestoBtn.setText("PRESUPUESTO");
        presupuestoBtn.addActionListener(this::presupuestoBtnActionPerformed);
        jPanel1.add(presupuestoBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 600, -1, -1));

        cancelarBtn.setText("CANCELAR");
        cancelarBtn.addActionListener(this::cancelarBtnActionPerformed);
        jPanel1.add(cancelarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 600, -1, -1));

        agregarBtn.setText("AGREGAR ");
        agregarBtn.addActionListener(this::agregarBtnActionPerformed);
        jPanel1.add(agregarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 200, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondoNuevo.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 660));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarBtnActionPerformed
        String criterio = buscarTxt.getText().trim().toLowerCase();
        if (criterio.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese un criterio de búsqueda.");
            return;
        }
        
        productosCbx.removeAllItems();
        ProductoControlador proCon = new ProductoControlador();
        productosBuscados = proCon.buscarProductos(criterio);
        
        if (productosBuscados.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se encontraron productos.");
            configurarSpinner(0);
            return;
        }
        
        for (Producto prod : productosBuscados) {
            productosCbx.addItem(prod.getTipo() + " - " + prod.getMarca() + " (Dispo: " + prod.getStock() + ")");
        }
    }//GEN-LAST:event_buscarBtnActionPerformed

    private void productosCbxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productosCbxActionPerformed
        int idx = productosCbx.getSelectedIndex();
        if (idx != -1) {
            Producto seleccionado = productosBuscados.get(idx);
            configurarSpinner(seleccionado.getStock()); // Ajusta el techo del spinner según el stock real
        }
    }//GEN-LAST:event_productosCbxActionPerformed

    private void cancelarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBtnActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelarBtnActionPerformed

    private void venderBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_venderBtnActionPerformed
        if (carritoResumen.isEmpty()) {
            JOptionPane.showMessageDialog(this, "La tabla resumen está vacía.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        ProductoControlador proCon = new ProductoControlador();
        boolean exitoCompleto = true;
        StringBuilder advertencias = new StringBuilder();
        
        for (DetalleVenta dv : carritoResumen) {
            String codigo = dv.getProducto().getCodigo();
            int cantidadVendida = dv.getCantidad();
            int stockFinal = dv.getProducto().getStock() - cantidadVendida;
            
            if (!proCon.restarStockProducto(codigo, cantidadVendida)) {
                exitoCompleto = false;
            }
            
            if (stockFinal <= dv.getProducto().getNivelReorden()) {
                advertencias.append("- ").append(dv.getProducto().getTipo()).append(" ").append(dv.getProducto().getMarca())
                            .append("\n  Cantidad disponible: ").append(stockFinal).append("\n");
            }
        }
        
        if (exitoCompleto) {
            // Instanciar y armar el Objeto de Encabezado de Venta
            String fechaActual = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
            Venta nuevaVenta = new Venta();
            nuevaVenta.setFecha(fechaActual);
            nuevaVenta.setTipoComprobante("VENTA EFECTUADA");
            nuevaVenta.setDetalles(carritoResumen); // Esto calcula el total de forma automática
            
            // Definir nombre del archivo destino
            String nombreArchivo = "Factura_Venta_" + System.currentTimeMillis() + ".pdf";
            
            // Ejecutar la generación del PDF con OpenPDF
            GenerarFactura.emitirDocumentoPdf(nuevaVenta, nombreArchivo);
            
            JOptionPane.showMessageDialog(this, "¡Venta procesada con éxito!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            
            if (advertencias.length() > 0) {
                JOptionPane.showMessageDialog(this, "Poco producto disponible:\n" + advertencias.toString(), "Advertencia de Stock", JOptionPane.WARNING_MESSAGE);
            }
            
            // Lanzar visualización e impresión automatizada
            despacharEImprimirPdf(nombreArchivo);
            
            carritoResumen.clear();
            limpiarTablaResumen();
        } else {
            JOptionPane.showMessageDialog(this, "Error al procesar parte de la venta en la Base de Datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_venderBtnActionPerformed

    private void presupuestoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_presupuestoBtnActionPerformed
        if (carritoResumen.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Agregue productos para poder cotizar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Armar el Objeto Venta enfocado en Cotización (No altera la base de datos)
        String fechaActual = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
        Venta cotizacion = new Venta();
        cotizacion.setFecha(fechaActual);
        cotizacion.setTipoComprobante("PRESUPUESTO ESTIMADO");
        cotizacion.setDetalles(carritoResumen);
        
        String nombreArchivo = "Presupuesto_Cotizacion_" + System.currentTimeMillis() + ".pdf";
        GenerarPresupuesto.emitirDocumentoPdf(cotizacion, nombreArchivo);
        
        JOptionPane.showMessageDialog(this, "¡Presupuesto generado con éxito!", "Cotización", JOptionPane.INFORMATION_MESSAGE);
        
        // Lanzar visualización e impresión automatizada
        despacharEImprimirPdf(nombreArchivo);
        
        carritoResumen.clear();
        limpiarTablaResumen();
    }//GEN-LAST:event_presupuestoBtnActionPerformed

    private void agregarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarBtnActionPerformed
        int idx = productosCbx.getSelectedIndex();
        int cantidad = (int) cantidadSpn.getValue();
        
        if (idx == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un producto válido primero.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (cantidad <= 0) {
            JOptionPane.showMessageDialog(this, "La cantidad debe ser mayor a 0.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Producto prodSeleccionado = productosBuscados.get(idx);
        
        DetalleVenta nuevoDetalle = new DetalleVenta(prodSeleccionado, cantidad);
        carritoResumen.add(nuevoDetalle);
        pintarTablaResumen();
        
        buscarTxt.setText("");
        productosCbx.removeAllItems();
        configurarSpinner(0);
    }//GEN-LAST:event_agregarBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarBtn;
    private javax.swing.JToggleButton buscarBtn;
    private javax.swing.JTextField buscarTxt;
    private javax.swing.JButton cancelarBtn;
    private javax.swing.JSpinner cantidadSpn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton presupuestoBtn;
    private javax.swing.JComboBox<String> productosCbx;
    private javax.swing.JTable resumenTbl;
    private javax.swing.JButton venderBtn;
    // End of variables declaration//GEN-END:variables
}
