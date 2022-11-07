package tarea3;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.awt.*;
import javax.swing.*;

public class Ventana extends JFrame { // como extiende a un JFrame, es un JFrame, pero con algunos agregados
     // propiedades que puedes agregar aquí para que compongan a Ventana. Ventana "es un" JFrame
    public Ventana(){
       super();
       this.setLayout(new BorderLayout()); // aunque tiene Layout por defecto, se define uno que es mas práctico
       // auto configuración: puedes poner aquí sentencias para inicializar las propiedades nuevas y heredades de JFrame 
      this.setTitle("esta Ventana");
      this.setDefaultCloseOperation(EXIT_ON_CLOSE); // permite que la X para cerrar la ventana esté habilitada para finalizar la ejecución
      this.setSize(1000,800); 
      this.setVisible(true); 
   } 
}
