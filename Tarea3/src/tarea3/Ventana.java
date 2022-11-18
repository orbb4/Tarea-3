package tarea3;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.*;
public class Ventana extends JFrame {
    
    private final Color COLOR_PANEL = new Color(50, 50, 160);
    private PanelPrincipal panelPrincipal;
    public Ventana(){
        super();
        this.setLayout(null);
        this.setTitle("Expendedor");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); 
        //this.setSize(1366, 700); 
        this.setSize(1366, 740); 
        
        /*this.setLocationRelativeTo(null);
        this.setMinimumSize(new Dimension(200,200));*/

        this.setVisible(true); 
        this.setResizable(true);
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        panelPrincipal = new PanelPrincipal();     
        panelPrincipal.setBounds(0, 0, 1366, 700);
        
        
        //Botones();
        this.add(panelPrincipal);      

   }        
}         