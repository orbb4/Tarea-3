
package tarea3;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JButton;

public class Boton extends JButton{
    private Color color;
    public Boton(){

    }
     public void paint(Graphics g, int x, int y, int ancho, int largo){
        g.setColor(color);
        g.fillOval(x, y, ancho, largo);
    }   
}
