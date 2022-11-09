package tarea3;
import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class PanelPrincipal extends JPanel{
        private Color color;
        private int[] rect; // dimensiones del rectangulo (x, y, ancho, alto)
        private Comprador comprador;
        private Expendedor exp;
        private int boton1Xcord = 655;
        private int boton2Xcord = 655;
        private int boton3Xcord = 655;
        public PanelPrincipal(Comprador com, Expendedor exp){
            this.setLayout(null);
            comprador = com;
            this.exp = exp;
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

        }
        private class EscuchaRaton  implements MouseListener {
            
            public void mouseClicked(MouseEvent me){
                if(me.getX() > 1188 && me.getX() < 1288 && me.getY() > 100 && me.getY() < 200){
                    System.out.println("100");
                }
                if(me.getX() > 1188 && me.getX() < 1288 && me.getY() > 300 && me.getY() < 400){
                    System.out.println("500");
                }
                if(me.getX() > 1188 && me.getX() < 1288 && me.getY() > 500 && me.getY() < 600){
                    System.out.println("1000");
                }
                // colision mouse -  expendedor: rellena depositos de bebida vacios
                if((me.getX() >= exp.getExpRect().getMinX() && me.getX() <= exp.getExpRect().getMaxX())&&( me.getY() >= exp.getExpRect().getMinY() && me.getY() <= exp.getExpRect().getMaxY())){
                    System.out.println("colision");
                    exp.llenarDepositosVacios();
                    PanelPrincipal.this.repaint();
                    
                }
 
                
            }
            
            public void mousePressed(MouseEvent me) {
                // colision boton 1: comprar CocaCola
                if(me.getX() >= 655 && me.getX() <= 705 && me.getY() >= 175  && me.getY() <= 225){
                    System.out.println("boton1");
                    boton1Xcord = 658;
                    PanelPrincipal.this.repaint();
                    // toDo: crear comprador que tenga la moneda seleccionada en vez de la misma de 1000 por defecto
                    Comprador  c = new Comprador(new Moneda1000(), 0, exp);
                }
                // colision boton 1: comprar CocaCola
                if(me.getX() >= 655 && me.getX() <= 705 && me.getY() >= 275  && me.getY() <= 325){
                    System.out.println("boton2");
                    boton2Xcord = 658;
                    PanelPrincipal.this.repaint();
                    // toDo: crear comprador que tenga la moneda seleccionada en vez de la misma de 1000 por defecto
                    Comprador  c = new Comprador(new Moneda1000(), 1, exp);
                }
                // colision boton 3: comprar Fanta
                if(me.getX() >= 655 && me.getX() <= 705 && me.getY() >= 375  && me.getY() <= 425){
                    System.out.println("boton3");                    
                    boton3Xcord = 658;
                    PanelPrincipal.this.repaint();
                    // toDo: crear comprador que tenga la moneda seleccionada en vez de la misma de 1000 por defecto
                    Comprador  c = new Comprador(new Moneda1000(), 2, exp);
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
}
