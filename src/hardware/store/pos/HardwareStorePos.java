package hardware.store.pos;

import Vista.Ventas;
import javax.swing.SwingUtilities;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import Modelo.Producto;

public class HardwareStorePos {


    public static void main(String[] args) {
        
        ArrayList<Producto> productos = new ArrayList<>();
        
        SwingUtilities.invokeLater(() -> {
            try {
                
                Ventas ventanaVentas = new Ventas(productos);
                ventanaVentas.setVisible(true);
                
            } catch (Exception e  ){
                JOptionPane.showMessageDialog(null, "Error al iniciar la aplicación " + e , "Error" , JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        });
        
    }    
}
