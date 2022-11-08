package tarea3;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Ventana extends JFrame {
    private Moneda moneda = new Moneda();

    private Expendedor expendedor = new Expendedor(12, 100);
    private Comprador comprador = new Comprador(moneda, 2, expendedor);
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

        this.add(panelPrincipal);
        JButton boton = new Botones( "Boton" );
        boton.setBackground( Color.red );
        this.getContentPane().add(boton);
          
        Botones(expendedor);
        this.add(panelPrincipal);      
   } 
   
    
    private void Botones(Expendedor expendedor){
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
        
        // boton 1
        boton1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    expendedor.comprarBebida(new Moneda1000(), 0);
                    // pintamos los botones para el siguiente frame
                    SwingUtilities.windowForComponent(boton1).repaint();
                    // repintamos panel principal para el siguiente frame
                    panelPrincipal.repaint();
                } catch (NoHayBebidaException ex) {
                    System.out.println(ex);
                    System.out.println("No quedan bebidas!");
                } catch (PagoIncorrectoException ex) {
                    System.out.println(ex);
                    System.out.println("No se puede obtener bebida ya que no hay pago");
                } catch (PagoInsuficienteException ex) {
                    System.out.println(ex);
                    System.out.println("No se puede obtener bebida ya que el pago es insuficiente");
                }
            }
        });
        // boton 2
        boton2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    expendedor.comprarBebida(new Moneda1000(), 1);
                    // pintamos los botones para el siguiente frame
                    SwingUtilities.windowForComponent(boton1).repaint();
                    // repintamos panel principal para el siguiente frame
                    panelPrincipal.repaint();
                } catch (NoHayBebidaException ex) {
                    System.out.println(ex);
                    System.out.println("No quedan bebidas!");
                } catch (PagoIncorrectoException ex) {
                    System.out.println(ex);
                    System.out.println("No se puede obtener bebida ya que no hay pago");
                } catch (PagoInsuficienteException ex) {
                    System.out.println(ex);
                    System.out.println("No se puede obtener bebida ya que el pago es insuficiente");
                }
            }
        });
        // boton 3
        boton3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    expendedor.comprarBebida(new Moneda1000(), 2);
                    // pintamos los botones para el siguiente frame
                    SwingUtilities.windowForComponent(boton1).repaint();
                    // repintamos panel principal para el siguiente frame
                    panelPrincipal.repaint();
                } catch (NoHayBebidaException ex) {
                    System.out.println(ex);
                    System.out.println("No quedan bebidas!");
                } catch (PagoIncorrectoException ex) {
                    System.out.println(ex);
                    System.out.println("No se puede obtener bebida ya que no hay pago");
                } catch (PagoInsuficienteException ex) {
                    System.out.println(ex);
                    System.out.println("No se puede obtener bebida ya que el pago es insuficiente");
                }
            }
        });        
    }        
}




