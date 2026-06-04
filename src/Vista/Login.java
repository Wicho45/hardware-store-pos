package Vista;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Login.class.getName());

    public Login() {
        initComponents();
        this.setTitle("Inicio de sesión - Ferretería Marroquín");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
        Image icono = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/logo.png"));
        setIconImage(icono);
        
    }

    private void iniciarSesion(String user, String contra){
    
        String usuarioAdmin = "ferreteria";
        String contraAdmin = "Marroquin2026";
        
        if (user == usuarioAdmin && contra == contraAdmin){
            
            
        } else {
            JOptionPane.showMessageDialog(null, "Error al iniciar sesión, contraseña o usuario incorrecto" , "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        userTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        passwordTxt = new javax.swing.JPasswordField();
        signinBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("BIENVENIDO");
        jLabel1.setToolTipText("");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 54, 213, 46));

        jLabel2.setText("USUARIO:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 132, -1, -1));

        userTxt.addActionListener(this::userTxtActionPerformed);
        jPanel1.add(userTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 161, 407, -1));

        jLabel3.setText("CONTRASEÑA:");
        jLabel3.setToolTipText("");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 206, -1, -1));

        passwordTxt.setText("jPasswordField1");
        jPanel1.add(passwordTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 235, 407, -1));

        signinBtn.setText("INICIAR SESIÓN");
        signinBtn.addActionListener(this::signinBtnActionPerformed);
        jPanel1.add(signinBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 280, 164, -1));

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

    private void userTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userTxtActionPerformed
        
    }//GEN-LAST:event_userTxtActionPerformed

    private void signinBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signinBtnActionPerformed
        String usuario = userTxt.getText();
        String contra = passwordTxt.getText();
        
        iniciarSesion(usuario, contra);
        
    }//GEN-LAST:event_signinBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField passwordTxt;
    private javax.swing.JButton signinBtn;
    private javax.swing.JTextField userTxt;
    // End of variables declaration//GEN-END:variables
}
