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
        this.setLayout(null);
        this.setTitle("Expendedor");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); 
        this.setSize(1366, 700); 
        this.setVisible(true); 
        this.setResizable(false);
        panelPrincipal = new PanelPrincipal(COLOR_PANEL, new int[] {120, 50, 600, 900}, comprador);     
        panelPrincipal.setBounds(0, 0, 1366, 700);
        this.add(panelPrincipal);
        
        Botones();
        this.add(comprador);
        this.add(panelPrincipal);
        //Botones();

   } 
   
    private void Botones(){
        JButton boton1 = new JButton(); //en el constructor/argumento le podemos pasar texto entre comillas
        //this.setLayout(null); testing
        boton1.setBounds(655, 180, 50, 50);
        boton1.setEnabled(true);// si está en false no se puede hacer click sobre el botón, es para habilitar o deshabilitar las funciones del botón
        this.add(boton1);
        
        JButton boton2 = new JButton(); //en el constructor/argumento le podemos pasar texto entre comillas
        boton2.setBounds(655, 280, 50, 50);
        boton2.setEnabled(true);// si está en false no se puede hacer click sobre el botón, es para habilitar o deshabilitar las funciones del botón
        this.add(boton2);
        
        JButton boton3 = new JButton(); //en el constructor/argumento le podemos pasar texto entre comillas
        boton3.setBounds(655, 380, 50, 50);
        boton3.setEnabled(true);// si está en false no se puede hacer click sobre el botón, es para habilitar o deshabilitar las funciones del botón
        //boton3.setForeground(Color.GREEN);//se le asigna un color a la letra del botón
        this.add(boton3);
        
        
    }
}



