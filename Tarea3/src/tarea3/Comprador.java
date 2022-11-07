package tarea3;
import java.awt.*;
public class Comprador{    
    private String tipoBebida = null;
    private int vuelto = 0;    
    
    private Polygon p;
    private int x,y;
    
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
        this.x=x;
        this.y=y;
        p = new Polygon();
        p.addPoint(x,y);
        p.addPoint(x+120, y+50);
        p.addPoint(x+40, y+150);
    }
    public void paint(Graphics g){
        g.setColor(Color.red);
        if(p!=null)g.drawPolygon(p);
    }  

    public int cuantoVuelto(){
        return vuelto;
    }
    public String queBebiste(){
        return tipoBebida;
    }
}
