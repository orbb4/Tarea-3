package tarea3;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
public class PanelPrincipal extends JPanel{
        private Color color;
        private final Color VERDEMENTA = new Color(36, 211, 154);
        private ArrayList<Moneda> bolsilloMonedas;
        private int[] rect; // dimensiones del rectangulo (x, y, ancho, alto)
        private Comprador comprador;
        private Expendedor exp;
        private Moneda mon;
        private int boton1Xcord = 655;
        private int boton2Xcord = 655;
        private int boton3Xcord = 655;
        public PanelPrincipal(){
            mon = new Moneda();
            exp = new Expendedor(12, 100);
            comprador = new Comprador(mon, 2, exp);
            this.setLayout(null);
            this.addMouseListener(new EscuchaRaton());
           
            
        }
        public void paint(Graphics g){
            super.paint(g);       
            comprador.paint(g);
            exp.paint(g);
            Toolkit t = Toolkit.getDefaultToolkit(); 
            Image cocaImage = new ImageIcon(this.getClass().getResource("cocacola.jpg")).getImage();
            Image spriteImage = new ImageIcon(this.getClass().getResource("sprite.jpg")).getImage();
            Image fantaImage = new ImageIcon(this.getClass().getResource("fanta.jpg")).getImage();
            g.drawImage(cocaImage, 520,160, 120, 80, this);  
            g.drawImage(spriteImage, 520,260, 120, 80, this);
            g.drawImage(fantaImage, 520,360, 120, 80, this);  

            //bolsillo
            g.setColor(VERDEMENTA);
            g.fillRect(1050, 0, 150,700);
            // botones (parte trasera):
            g.setColor(new Color(170, 50, 50));
            
            g.fillOval(660, 175, 50, 50);
            g.fillOval(660, 275, 50, 50);
            g.fillOval(660, 375, 50, 50);
            
            // botones (parte delantera):
            g.setColor(new Color(250, 50, 50));
            g.fillOval(boton1Xcord, 175, 50, 50);
            g.fillOval(boton2Xcord, 275, 50, 50);
            g.fillOval(boton3Xcord, 375, 50, 50);
            // bolsillo de bebidas
            g.setColor(new Color(85, 65, 55));
            g.fillRect(725, 50, 170,700);
            // bebidas en bolsillo del comprador:
            int x = 725;
            int y = 650;
            int i = 0;
            for(Bebida b: comprador.getBolsilloBebidas()){
                b.setXY(x, y);
                b.paint(g);
                y-=45;
                i++;
                if(i%14==0){
                    x+=85;
                    y = 650;
                }
            }


        }
        private class EscuchaRaton  implements MouseListener {
            public void mouseClicked(MouseEvent me){
                /*if(me.getX() > 1188 && me.getX() < 1288 && me.getY() > 100 && me.getY() < 200){
                    System.out.println("100");
                }
                if(me.getX() > 1188 && me.getX() < 1288 && me.getY() > 300 && me.getY() < 400){
                    System.out.println("500");
                }
                if(me.getX() > 1188 && me.getX() < 1288 && me.getY() > 500 && me.getY() < 600){
                    System.out.println("1000");
                }*/
                
                // colision mouse -  expendedor: rellena depositos de bebida vacios
                if((me.getX() >= exp.getExpRect().getMinX() && me.getX() <= exp.getExpRect().getMaxX())&&( me.getY() >= exp.getExpRect().getMinY() && me.getY() <= exp.getExpRect().getMaxY())){
                    System.out.println("colision");
                    exp.llenarDepositosVacios();
                    PanelPrincipal.this.repaint();
                    
                }  
                // colision mouse - monedas a seleccionar 
                if((me.getX()>1225 && me.getX()<1335 && me.getY()>100 && me.getY()<200)){
                    System.out.println("100");
                }
                if((me.getX()>1225 && me.getX()<1335 && me.getY()>300 && me.getY()<400)){
                    System.out.println("500");
                
                }
                if((me.getX()>1225 && me.getX()<1335 && me.getY()>500 && me.getY()<600)){
                    System.out.println("1000");
                
                }
                
 
                
            }
            
            public void mousePressed(MouseEvent me) {
                // colision boton 1: comprar CocaCola
                if(me.getX() >= 655 && me.getX() <= 705 && me.getY() >= 175  && me.getY() <= 225){
                    System.out.println("boton1");
                    boton1Xcord = 658;

                    // toDo: usar la moneda seleccionada en vez de la misma de 1000 por defecto
                    Comprador  c = new Comprador(new Moneda1000(), 0, exp);
                    comprador.addBebida(0, c.getBolsilloBebidas().get(0).getSerie());
                    System.out.println(comprador.getBolsilloBebidas().toString());
                    PanelPrincipal.this.repaint();
                }
                // colision boton 2: comprar Sprite
                if(me.getX() >= 655 && me.getX() <= 705 && me.getY() >= 275  && me.getY() <= 325){
                    System.out.println("boton2");
                    boton2Xcord = 658;
                    // toDo: crear comprador que tenga la moneda seleccionada en vez de la misma de 1000 por defecto
                    Comprador  c = new Comprador(new Moneda1000(), 1, exp);
                    comprador.addBebida(1, c.getBolsilloBebidas().get(0).getSerie());
                    PanelPrincipal.this.repaint();
                }
                // colision boton 3: comprar Fanta
                if(me.getX() >= 655 && me.getX() <= 705 && me.getY() >= 375  && me.getY() <= 425){
                    System.out.println("boton3");                    
                    boton3Xcord = 658;
                    // toDo: crear comprador que tenga la moneda seleccionada en vez de la misma de 1000 por defecto
                    Comprador  c = new Comprador(new Moneda1000(), 2, exp);
                    comprador.addBebida(2, c.getBolsilloBebidas().get(0).getSerie());
                    PanelPrincipal.this.repaint();
                }
                
            }
            public void mouseReleased(MouseEvent me) {
                boton1Xcord = 655;
                boton2Xcord = 655;
                boton3Xcord = 655;
                System.out.println("Y: " + me.getY());
                System.out.println("X: " + me.getX());
            }
            public void mouseEntered(MouseEvent me) {
            }  
            public void mouseExited(MouseEvent me) {;}
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
        
        JButton boton4 = new JButton(); 
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
        this.add(boton6);
        
        
        // boton 1
        boton1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    
                    exp.comprarBebida(new Moneda1000(), 0);
                    // pintamos los botones para el siguiente frame
                    SwingUtilities.windowForComponent(boton1).repaint();
                    // repintamos panel principal para el siguiente frame
                    repaint();
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
                    exp.comprarBebida(new Moneda1000(), 1);
                    // pintamos los botones para el siguiente frame
                    SwingUtilities.windowForComponent(boton1).repaint();
                    // repintamos panel principal para el siguiente frame
                    repaint();
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
                    exp.comprarBebida(new Moneda1000(), 2);
                    // pintamos los botones para el siguiente frame
                    SwingUtilities.windowForComponent(boton1).repaint();
                    // repintamos panel principal para el siguiente frame
                    repaint();
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
