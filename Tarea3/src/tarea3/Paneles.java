package tarea3;

import java.awt.Color;
import javax.swing.JPanel;

public class Paneles {
        public JPanel panel;
        public Paneles(){
            panel = new JPanel(); //se crea un panel 
            panel.setBackground(Color.GREEN); //se le asigna un color al panel
            panel.setLayout(null); //se desactiva el diseño/layout por defecto, esto permite que se pueda cambiar la posición de las etiquetas
            //this.getContentPane().add(panel);//se agrega el panel a la ventana
        }

}
