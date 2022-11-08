package tarea3;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JButton;


public class Botones extends JButton{
    public Botones(String rotulo){
        super(rotulo);
        Dimension tamano = getPreferredSize();
        tamano.width = tamano.height = Math.max( tamano.width,tamano.height );
        setPreferredSize( tamano );
        setContentAreaFilled( false );
    }
     protected void paintComponent( Graphics g ) {
    if( getModel().isArmed() ) {
      g.setColor(Color.lightGray );
      } 
    else {
      g.setColor( getBackground() );
      }
    g.fillOval( 0,0,getSize().width-1,getSize().height-1 );
    super.paintComponent( g );
    }
}
