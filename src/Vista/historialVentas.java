package Vista;

import Controlador.GenerarFactura;
import Controlador.GenerarReporte;
import Controlador.ProductoControlador;
import Modelo.DetalleVenta;
import Modelo.Venta;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



public class historialVentas extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(historialVentas.class.getName());

    private ArrayList<Venta> listaVentasActuales = new ArrayList<>();
    
    public historialVentas() {
        initComponents();
        this.setTitle("Historial de ventas - Ferretería Marroquín");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        
        cargarTablaHistorial();
        
        this.setVisible(true);
    }
    
    
    private void cargarTablaHistorial() {
        ProductoControlador proCon = new ProductoControlador();
        listaVentasActuales = proCon.listarHistorialVentas();
        
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(0);
        
        if (listaVentasActuales == null || listaVentasActuales.isEmpty()) {
            return;
        }
        
        for (Venta v : listaVentasActuales) {
            Object[] fila = new Object[4];
            fila[0] = "FAC-" + v.getIdVenta();
            fila[1] = v.getFecha();
            fila[2] = "Q " + String.format("%.2f", v.getTotal());
            fila[3] = "Clic para Re-Imprimir / Anular"; 
            modelo.addRow(fila);
        }
    }
    
    private void despacharEImprimirPdf(String rutaArchivo) {
        try {
            File pdfFile = new File(rutaArchivo);
            if (!pdfFile.exists()) return;

            String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("win")) {
                String comando = "cmd /c start \"\" \"" + pdfFile.getAbsolutePath() + "\"";
                Runtime.getRuntime().exec(comando);
            } else if (java.awt.Desktop.isDesktopSupported()) {
                java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
                desktop.open(pdfFile);
                if (desktop.isSupported(java.awt.Desktop.Action.PRINT)) {
                    desktop.print(pdfFile);
                }
            }
        } catch (Exception e) {
            logger.log(java.util.logging.Level.SEVERE, "Error al abrir reporte", e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        reporteBtn = new javax.swing.JButton();
        cancelarBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel2.setText("HISTORIAL DE VENTAS");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "No. Factura", "Fecha", "Monto Cobrado", "Acciones"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 730, 340));

        reporteBtn.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        reporteBtn.setText("REPORTE DE VENTAS");
        reporteBtn.setToolTipText("");
        reporteBtn.addActionListener(this::reporteBtnActionPerformed);
        jPanel1.add(reporteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 430, -1, -1));

        cancelarBtn.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        cancelarBtn.setText("CANCELAR");
        cancelarBtn.addActionListener(this::cancelarBtnActionPerformed);
        jPanel1.add(cancelarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 430, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondoNuevo.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 480));

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

    private void cancelarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBtnActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelarBtnActionPerformed

    private void reporteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reporteBtnActionPerformed
        String inputFecha = JOptionPane.showInputDialog(this,
                "Filtro de Reportes de Caja\n"
                + "Ingrese una fecha fija (ej: 23/06/2026)\n"
                + "O un rango exacto separado por guion (ej: 21/06/2026-23/06/2026):",
                "Generar Cierre de Ventas", JOptionPane.QUESTION_MESSAGE);

        if (inputFecha == null || inputFecha.trim().isEmpty()) {
            return;
        }

        inputFecha = inputFecha.trim();
        ProductoControlador proCon = new ProductoControlador();
        ArrayList<Venta> todas = proCon.listarHistorialVentas();
        ArrayList<Venta> filtradas = new ArrayList<>();

        // Manejo de Rango de Fechas (ej: 21/06/2026-23/06/2026)
        if (inputFecha.contains("-")) {
            String[] partes = inputFecha.split("-");
            if (partes.length == 2) {
                String inicio = partes[0].trim();
                String fin = partes[1].trim();
                
                filtradas = proCon.buscarVentasPorRangoFechas(inicio, fin);
            }
        } 
        else {
            for (Venta v : todas) {
                if (v.getFecha().length() >= 10) {
                    String fechaCorta = v.getFecha().substring(0, 10);
                    if (fechaCorta.equals(inputFecha)) {
                        filtradas.add(v);
                    }
                }
            }
        }

        if (filtradas.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se registraron ventas en el periodo indicado.", "Sin Registros", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Generación del archivo del reporte balance de cierre
        String nombreArchivo = "Reporte_Cierre_" + System.currentTimeMillis() + ".pdf";
        GenerarReporte.emitirReporteCierrePdf(filtradas, inputFecha, nombreArchivo);
        despacharEImprimirPdf(nombreArchivo);
        
        JOptionPane.showMessageDialog(this, "Reporte de cierre generado y enviado a impresión con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_reporteBtnActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {
          int fila = jTable1.getSelectedRow();
          if (fila == -1) return;

          Venta ventaSeleccionada = listaVentasActuales.get(fila);

          // Opciones del menú flotante interactivo para las acciones
          String[] opciones = {"Re-Imprimir Factura", "Anular Factura", "Cancelar"};
          int seleccion = JOptionPane.showOptionDialog(this,
                  "¿Qué acción desea realizar con la Factura FAC-" + ventaSeleccionada.getIdVenta() + "?",
                  "Acciones de Facturación",
                  JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

          ProductoControlador proCon = new ProductoControlador();

          if (seleccion == 0) {
              ArrayList<DetalleVenta> detalles = proCon.obtenerDetallesDeVenta(ventaSeleccionada.getIdVenta());
              ventaSeleccionada.setDetalles(detalles);

              String nombreArchivo = "Reimpresion_Factura_" + ventaSeleccionada.getIdVenta() + ".pdf";
              GenerarFactura.emitirDocumentoPdf(ventaSeleccionada, nombreArchivo);
              despacharEImprimirPdf(nombreArchivo);
          }else if (seleccion == 1) {
              int confirmar = JOptionPane.showConfirmDialog(this,
                      "¿Seguro que desea anular la factura FAC-" + ventaSeleccionada.getIdVenta() + "?\nEsto devolverá los productos al inventario.",
                      "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

              if (confirmar == JOptionPane.YES_OPTION) {
                  if (proCon.anularVentaPorId(ventaSeleccionada.getIdVenta())) {
                      JOptionPane.showMessageDialog(this, "Factura anulada. Inventario restaurado.");
                      cargarTablaHistorial(); // Refrescar los cambios en la tabla
                  } else {
                      JOptionPane.showMessageDialog(this, "Error al intentar anular la factura.", "Error", JOptionPane.ERROR_MESSAGE);
                  }
              }
          }
      }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelarBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton reporteBtn;
    // End of variables declaration//GEN-END:variables
}
