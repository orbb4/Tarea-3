package tarea3;
import java.awt.*;
import javax.swing.*;
import javax.swing.ImageIcon;

public class Ventana extends JFrame {
    Moneda moneda = new Moneda();

    Expendedor expendedor = new Expendedor(5, 100);
    Comprador comprador = new Comprador(moneda, 2, expendedor);
    //public Expendedor(int nBebidas, int precio){
    
    private final Color COLOR_PANEL = new Color(50, 50, 160);
    private PanelPrincipal panelPrincipal;
    public Ventana(){
        super();
        this.setLayout(null);
        this.setTitle("Expendedor");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); 
        this.setSize(1366, 700); 
        this.setVisible(true); 
        this.setResizable(false);
        panelPrincipal = new PanelPrincipal(comprador, expendedor);     
        panelPrincipal.setBounds(0, 0, 1366, 700);
        this.add(panelPrincipal);
        
        Botones();

        this.add(panelPrincipal);

   } 
   
    private void Botones(){
        JButton boton1 = new JButton(); 
        //this.setLayout(null); testing
        boton1.setBounds(655, 175, 50, 50);
        boton1.setEnabled(true);
        boton1.setBackground(Color.MAGENTA);
        this.add(boton1);
        
        JButton boton2 = new JButton(); 
        boton2.setBounds(655, 275, 50, 50);
        boton2.setEnabled(true);
        boton2.setBackground(Color.MAGENTA);
        this.add(boton2);
        
        JButton boton3 = new JButton(); 
        boton3.setBounds(655, 375, 50, 50);
        boton3.setEnabled(true);
        boton3.setBackground(Color.MAGENTA);
        this.add(boton3);
        
        
    }
}



