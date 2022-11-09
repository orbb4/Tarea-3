package tarea3;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.*;

public class Ventana extends JFrame {
    private Moneda moneda = new Moneda();
    private Expendedor expendedor = new Expendedor(12, 100);
    // solo usado para dibujarlo en pantalla. No compra nada (moneda sin valor)
    private Comprador comprador = new Comprador(moneda, 2, expendedor);
    
    private final Color COLOR_PANEL = new Color(50, 50, 160);
    private PanelPrincipal panelPrincipal;
    public Ventana(){
        super();
        this.setLayout(null);
        this.setTitle("Expendedor");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); 
        this.setSize(1366, 700); 
        
        /*this.setLocationRelativeTo(null);
        this.setMinimumSize(new Dimension(200,200));*/

        this.setVisible(true); 
        this.setResizable(false);
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        panelPrincipal = new PanelPrincipal(comprador, expendedor);     
        panelPrincipal.setBounds(0, 0, 1366, 700);
        this.add(panelPrincipal);

        this.add(panelPrincipal);
          
        //Botones();
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
        
        /*JButton boton4 = new JButton(); 
        //this.setLayout(null); testing
        boton4.setBounds(1225, 100, 100, 100);
        boton4.setEnabled(true);
        boton4.setBackground(Color.YELLOW);
        this.add(boton4);
        
        JButton boton5 = new JButton(); 
        //this.setLayout(null); testing
        boton5.setBounds(1225, 300, 100, 100);
        boton5.setEnabled(true);
        boton5.setBackground(Color.RED);
        this.add(boton5);
        
        JButton boton6 = new JButton(); 
        //this.setLayout(null); testing
        boton6.setBounds(1225, 500, 100, 100);
        boton6.setEnabled(true);
        boton6.setBackground(Color.ORANGE);
        this.add(boton6);*/
        
        
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




