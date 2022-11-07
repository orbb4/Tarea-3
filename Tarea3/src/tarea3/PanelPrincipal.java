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
            Toolkit t = Toolkit.getDefaultToolkit(); 
            Image i = new ImageIcon(this.getClass().getResource("cocacola.jpg")).getImage();
            g.drawImage(i, 520,160, 100, 80, this);  
            g.setColor(color); 
            g.fillRect(rect[0], rect[1], rect[2], rect[3]);
            comprador.paint(g);

    }
}
