package tarea3;
import java.awt.*;
import java.util.ArrayList;
public class Comprador{    
    private String tipoBebida = null;
    private ArrayList<Moneda> monedasBolsillo;
    private ArrayList<CocaCola> cocaColasBolsillo;
    private ArrayList<Fanta> fantasBolsillo;
    private ArrayList<Sprite> spritesBolsillo;
    private int vuelto = 0;    
    private Polygon p;
    private int x=0,y=0;
    
    private Color cUp = new Color(216   ,145,1);
    private Color cDown = new Color(216   ,145,1);
    
    public Comprador(Moneda m, int b, Expendedor e){
        int vueltot;
        cocaColasBolsillo = new ArrayList();
        fantasBolsillo = new ArrayList();
        spritesBolsillo = new ArrayList();
        boolean bebidaComprada = false;
        try { 
            e.comprarBebida(m, b);
            Bebida bebida = e.getBebida();
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
        this.x=x+900;
        this.y=y+200;
        
    }
    public void paint(Graphics g){
        g.setColor(cUp);
        g.fillOval(x, y, 100, 100);
        
        g.setColor(cDown);
        g.fillRect(x, y+100, 100, 400);

        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(1200, 0, 150,700);

        
        g.setColor(Color.YELLOW);
        g.fillOval(1225, 100, 100, 100);
        g.setColor(Color.ORANGE);
        g.fillOval(1225, 300, 100, 100);
        g.setColor(Color.RED);
        g.fillOval(1225, 500, 100, 100);
        
        //REFERENCIAS
        g.setColor(Color.YELLOW);
        g.fillOval(110, 10, 25, 25);
        g.setColor(Color.ORANGE);
        g.fillOval(510, 10, 25, 25);
        g.setColor(Color.RED);
        g.fillOval(910, 10, 25, 25);
        
        g.setColor(Color.BLACK);
        g.drawString("100 = ", 70, 30);
        g.drawString("500 = ", 470, 30);
        g.drawString("1000 = ", 860, 30);
        
        
        
        
    }  
    public void addBebida(int tipoBebida){
        switch(tipoBebida){
            case 0:
                cocaColasBolsillo.add(new CocaCola(32));
            case 1:
                spritesBolsillo.add(new Sprite(23656672));
            case 2:
                fantasBolsillo.add(new Fanta(2332));
        }
    }
    public ArrayList<CocaCola> getCocaColasBolsillo(){
        return cocaColasBolsillo;
    }
    public ArrayList<Sprite> getSpritesBolsillo(){
        return spritesBolsillo;
    }
    public ArrayList<Fanta> getFantasBolsillo(){
        return fantasBolsillo;
    }
    public int cuantoVuelto(){
        return vuelto;
    }
    public String queBebiste(){
        return tipoBebida;
    }
}
