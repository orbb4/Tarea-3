package tarea3;
import java.awt.*;
import javax.swing.*;
public class PanelPrincipal extends JPanel{
        private Color color;
        private int[] rect; // dimensiones del rectangulo (x, y, ancho, alto)
        private Comprador comprador;
        public PanelPrincipal(Color color, int[] rect, Comprador com){
            //this.setLayout(null); testing
            comprador = com;
            this.setBackground(this.color); //se le asigna un color al panel
            this.rect = rect;
        }
        public void paint(Graphics g){
            super.paint(g);       
            g.fillRect(rect[0], rect[1], rect[2], rect[3]);
            comprador.paint(g);
            Toolkit t = Toolkit.getDefaultToolkit(); 
            Image cocaImage = new ImageIcon(this.getClass().getResource("cocacola.jpg")).getImage();
            Image spriteImage = new ImageIcon(this.getClass().getResource("sprite.jpg")).getImage();
            Image fantaImage = new ImageIcon(this.getClass().getResource("fanta.jpg")).getImage();
            g.drawImage(cocaImage, 520,160, 120, 80, this);  
            g.drawImage(spriteImage, 520,260, 120, 80, this);
            g.drawImage(fantaImage, 520,360, 120, 80, this);  

    }
}
