
package tarea3;

import java.awt.Color;
import javax.swing.JButton;

public class Boton extends JButton{
    private Color color;
    //private int[] rect; 
    public Boton(String Texto, int posx, int posy, int ancho, int alto){
        this.setText(Texto);
        this.setEnabled(true);
        this.setForeground(this.color); //color del texto del botón
        this.setBounds(posx, posy, ancho, alto);
    }
}
