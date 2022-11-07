package tarea3;
import java.awt.*;
import javax.swing.*;
import javax.swing.ImageIcon;

public class Ventana extends JFrame {
    Moneda moneda = new Moneda();

    Expendedor expendedor = new Expendedor(3, 100);
    Comprador comprador = new Comprador(moneda, 2, expendedor);
    
    private final Color COLOR_PANEL = new Color(50, 50, 160);
    private PanelPrincipal panelPrincipal;
    
    public Ventana(){
        super();
        //expPanel.add(new JButton("sskdkdsf"), BorderLayout.EAST);
        this.setLayout(new BorderLayout());
        this.setTitle("Expendedor");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); 
        this.setSize(1366, 700); 
        this.setVisible(true); 
        this.setResizable(false);
        panelPrincipal = new PanelPrincipal(COLOR_PANEL, new int[] {120, 50, 600, 900}, comprador);
        this.add(panelPrincipal);
   } 
}



