<<<<<<< HEAD
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
=======

package tarea3;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.JFrame; //biblioteca gráfica
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel; 
import javax.swing.SwingConstants;

public class Ventana extends JFrame{
     public JPanel panel;
    
    public Ventana(){
        this.setSize(600, 600); //dimensión de la ventana (ancho,altura)
        setTitle("Ventana"); //título de la ventana
        setLocationRelativeTo(null);//aparece la ventana en el centro de la pantalla
        setMinimumSize(new Dimension(200,200));//tamaño mínimo de la ventana
        //this.getContentPane().setBackground(Color.WHITE);//se le asigna un color a la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE); //cuando se cierre la ventana el programa se finaliza
        //iniciarComponentes(); //se inicia acá desde el constructor de ventana
    }   
        
>>>>>>> cote
}
