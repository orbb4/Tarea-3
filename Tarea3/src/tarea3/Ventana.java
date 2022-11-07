package tarea3;
import java.awt.*;
import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Ventana extends JFrame{ 
        //private URL CocaLogo = new URL("import java.net.MalformedURLException;\n" +
        //"import java.net.URL;");
    
    private final Color COLOR_PANEL = new Color(50, 50, 160);
    public Ventana(){
    super();
    this.setLayout(new BorderLayout());
    this.setTitle("Expendedor");
    this.setDefaultCloseOperation(EXIT_ON_CLOSE); 
    this.setSize(1000,800); 
    this.setVisible(true); 
    this.setResizable(false);
    this.add(new Paneles(COLOR_PANEL, new int[] {120, 100, 600, 900}));
   } 
}



