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
            }
            public void mousePressed(MouseEvent me) {
                System.out.println(me.getY());
            }
            public void mouseReleased(MouseEvent me) {;}
            public void mouseEntered(MouseEvent me) {
            }  
            public void mouseExited(MouseEvent me) {;}
        }
}
