package Vista;

import java.awt.Dimension;
import java.util.ArrayList;
import Modelo.Producto;

public class Ventas extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Ventas.class.getName());

    
    public Ventas(ArrayList<Producto> productos) {
        initComponents();
        this.setTitle("Ventas - Ferretería Marroquín");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        imagenFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Logo_ferreteria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo_ferre256.png"))); // NOI18N
        Fondo.add(Logo_ferreteria, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 210, 120));
        Logo_ferreteria.getAccessibleContext().setAccessibleParent(imagenFondo);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel1.setText("BIENVENIDO");
        Fondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, -1, -1));
        Fondo.add(busquedaTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 710, -1));

        buscarBtn.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        buscarBtn.setText("BUSCAR");
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
        Fondo.add(ingresarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 620, -1, -1));

        jButton1.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jButton1.setText("Actualizar inventario");
        Fondo.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 620, -1, -1));

        jButton2.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jButton2.setText("Venta");
        jButton2.setToolTipText("");
        Fondo.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 620, -1, -1));

        jButton3.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jButton3.setText("Presupuesto");
        Fondo.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 620, -1, -1));

        jButton4.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jButton4.setText("Historial de ventas");
        Fondo.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 620, -1, -1));

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Fondo;
    private javax.swing.JLabel Logo_ferreteria;
    private javax.swing.JToggleButton buscarBtn;
    private javax.swing.JTextField busquedaTxt;
    private javax.swing.JLabel imagenFondo;
    private javax.swing.JButton ingresarBtn;
    private javax.swing.JTable inventarioTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
