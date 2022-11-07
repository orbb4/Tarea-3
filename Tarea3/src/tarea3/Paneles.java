package tarea3;
import java.awt.*;
import javax.swing.*;
public class Paneles extends JPanel{
        private Color color;
        //private Comprador comprador;
        private int[] rect; // dimensiones del rectangulo (x, y, ancho, alto)
        public Paneles(Color color, int[] rect, Comprador com){
            //comprador = com;
            this.setBackground(this.color); //se le asigna un color al panel
            this.setLayout(null);
            this.rect = rect;
        }
        public void paint(Graphics g){
            super.paint(g);
            
            g.setColor(color);
            g.fillRect(rect[0], rect[1], rect[2], rect[3]);
            
            comprador.paint(g);
    }
        
}
