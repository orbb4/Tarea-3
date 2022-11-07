package tarea3;
import java.awt.*;
import javax.swing.JButton;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class Comprador extends JButton{    
    private String tipoBebida = null;
    private int vuelto = 0;    
    
    private Polygon p;
    private int x=0,y=0;
    
    private Color cUp = new Color(216   ,145,1);
    private Color cDown = new Color(216   ,145,1);
    
    public Comprador(Moneda m, int b, Expendedor e){
        int vueltot;
        boolean bebidaComprada = false;
        try { 
            Bebida bebida = e.comprarBebida(m, b);
            bebidaComprada = true;
        } catch (NoHayBebidaException | PagoIncorrectoException | PagoInsuficienteException ex) {
            System.out.println(ex);
        }
        vueltot = 0;
        if(bebidaComprada){
            switch(b){
                case 0:
                    tipoBebida = "CocaCola";
                case 1:
                    tipoBebida = "Sprite";
                case 2:
                    tipoBebida = "Fanta";
                
            }
        }
        
        Moneda moneda_uno = e.getVuelto();
        if(moneda_uno == null){
            vueltot = 0;
        }else{
            while(moneda_uno != null){
                vueltot += moneda_uno.getValor();
                moneda_uno = e.getVuelto();
                 
            } 
        }
        vuelto = vueltot;
        
        //relacionado al dibujo
        this.x=x+1000;
        this.y=y+200;
        
        //Relacionado con eventos
        this.addMouseListener(new EscuchaRaton());
    }
    public void paint(Graphics g){
        g.setColor(cUp);
        g.fillOval(x, y, 100, 100);
        
        g.setColor(cDown);
        g.fillRect(x, y+100, 100, 400);

    }  

    public int cuantoVuelto(){
        return vuelto;
    }
    public String queBebiste(){
        return tipoBebida;
    }
    private class EscuchaRaton implements MouseListener {
        public void mouseClicked(MouseEvent me) {;}
        public void mousePressed(MouseEvent me) {
            if(me.getY() <= y+100){
                System.out.println("arriba");
                cUp = new Color(255, 171, 0);
            }
            if(me.getY() > y+100){
                System.out.println("abajo");
                cDown = new Color(255, 171, 0);
            }
        } 
        public void mouseReleased(MouseEvent me){
            cUp = new Color(216,145,1);
            cDown = new Color(216,145,1);
        }
        public void mouseEntered(MouseEvent me){
        }
        public void mouseExited(MouseEvent me){
        }

   }
}
