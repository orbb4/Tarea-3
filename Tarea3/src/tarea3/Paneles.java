package tarea3;

import java.awt.Color;
import javax.swing.JPanel;

public class Paneles extends JPanel{
        private Color color;
        public Paneles(Color color){
            this.setBackground(this.color); //se le asigna un color al panel
            this.setLayout(null);
        }

}
