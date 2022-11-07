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
        Boton();
        this.add(comprador);
   } 
   
    private void Boton(){
        JButton boton1 = new JButton(); //en el constructor/argumento le podemos pasar texto entre comillas
        boton1.setText("Click"); //se le establece un texto al botón
        boton1.setBounds(100, 100, 100, 40);
        boton1.setEnabled(true);// si está en false no se puede hacer click sobre el botón, es para habilitar o deshabilitar las funciones del botón
        boton1.setForeground(Color.GREEN);//se le asigna un color a la letra del botón
        this.add(boton1);
    }
}



