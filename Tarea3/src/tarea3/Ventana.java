package tarea3;

import java.awt.*;
import javax.swing.*;

public class Ventana extends JFrame { // como extiende a un JFrame, es un JFrame, pero con algunos agregados
     // propiedades que puedes agregar aquí para que compongan a Ventana. Ventana "es un" JFrame

    public Ventana(){
    super();
    this.setLayout(new BorderLayout());
    this.setTitle("Expendedor");
    this.setDefaultCloseOperation(EXIT_ON_CLOSE); 
    this.setSize(1000,800); 
    this.setVisible(true); 
    this.setResizable(false);
   } 
}



