package tarea3;
import java.awt.*;
import javax.swing.*;

public class Ventana extends JFrame { 
    private final Color COLOR_PANEL = new Color(50, 50, 160);
    private final Color COLOR_DEPOSITO_COCACOLA = new Color(0, 128, 0);
    private Paneles panelCocacola = new Paneles(COLOR_DEPOSITO_COCACOLA, new int[] {500,300, 200, 100});
    public Ventana(){
    super();
    this.setLayout(new BorderLayout());
    this.setTitle("Expendedor");
    this.setDefaultCloseOperation(EXIT_ON_CLOSE); 
    this.setSize(1000,800); 
    this.setVisible(true); 
    this.setResizable(false);
    this.add(new Paneles(COLOR_PANEL, new int[] {0, 0, 250, 250}));
    this.add(panelCocacola);
    this.add(new Boton(":D", 250, 250, 40, 40));
    panelCocacola.add(new JButton("este"), BorderLayout.EAST);
   } 
}



