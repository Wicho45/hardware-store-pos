package hardware.store.pos;

import Vista.Ventas;
import javax.swing.SwingUtilities;
import javax.swing.JOptionPane;
import Controlador.ConexionDb;

public class HardwareStorePos {


    public static void main(String[] args) {
        
        ConexionDb.inicializarDb();
        
        SwingUtilities.invokeLater(() -> {
            try {
                
                Ventas ventanaVentas = new Ventas();
                ventanaVentas.setVisible(true);
                
            } catch (Exception e  ){
                JOptionPane.showMessageDialog(null, "Error al iniciar la aplicación " + e , "Error" , JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        });
        
    }    
}
