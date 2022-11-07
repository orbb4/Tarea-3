package tarea3;
import java.awt.*;
import javax.swing.*;
import javax.swing.ImageIcon;

public class Ventana extends JFrame {
    Moneda moneda = new Moneda();

    Expendedor expendedor = new Expendedor(3, 100);
    Comprador comprador = new Comprador(moneda, 2, expendedor);
    
    final Color COLOR_PANEL = new Color(50, 50, 160);
    //Paneles expPanel = new Paneles(COLOR_PANEL, new int[] {120, 100, 600, 900}, comprador);
    
    public Ventana(){
        super();
        //expPanel.add(new JButton("sskdkdsf"), BorderLayout.EAST);
        this.setLayout(new BorderLayout());
        this.setTitle("Expendedor");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); 
        this.setSize(1000,800); 
        this.setVisible(true); 
        this.setResizable(false);

        this.add(new Paneles(COLOR_PANEL, new int[] {120, 100, 600, 900}, comprador));
   } 
}



