package tarea3;
import java.awt.*;
import javax.swing.*;
public class PanelPrincipal extends JPanel{
        private Color color;
        private int[] rect; // dimensiones del rectangulo (x, y, ancho, alto)
        private Comprador comprador;
        public PanelPrincipal(Color color, int[] rect, Comprador com){
           
            comprador = com;
            this.setBackground(this.color); //se le asigna un color al panel
            this.setLayout(null);
            this.rect = rect;
        }
        public void paint(Graphics g){
            super.paint(g);
            g.setColor(color);
            g.fillRect(rect[0], rect[1], rect[2], rect[3]);            
            comprador.paint(g);
            Toolkit t = Toolkit.getDefaultToolkit(); 
            Image i = new ImageIcon(this.getClass().getResource("cocacola.jpg")).getImage();
            //Image i=t.getImage("C:\\Users\\renat\\Desktop\\t3\\Tarea-3\\Tarea3\\src\\tarea3\\cocacola.jpg");  
            g.drawImage(i, 520,160, 100, 80, this);  
            g.fillRect(rect[0], rect[1], rect[2], rect[3]);
            comprador.paint(g);

    }
}
