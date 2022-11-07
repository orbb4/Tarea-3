package tarea3;
import java.awt.*;
import javax.swing.*;
import javax.swing.ImageIcon;

/*public class Ventana extends JFrame { 
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
=======*/
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
        this.setSize(1366, 700); 
        this.setVisible(true); 
        this.setResizable(false);

        this.add(new Paneles(COLOR_PANEL, new int[] {120, 100, 600, 900}, comprador));t
   } 
}



