package tarea3;
import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import javax.swing.SwingUtilities;
public class Comprador extends JButton{    
    private String tipoBebida = null;
    private ArrayList<Moneda> monedasBolsillo;
    private ArrayList<Bebida> bolsilloBebidas;
    private int vuelto = 0;    
    private Polygon p;
    private int x=0,y=0;
    
    private Graphics gr;
    
    private Color cUp = new Color(216   ,145,1);
    private Color cDown = new Color(216   ,145,1);
    
    public Comprador(Moneda m, int b, Expendedor e){
        int vueltot;
        this.setLayout(null);
        this.setVisible(true);
        bolsilloBebidas = new ArrayList();
        monedasBolsillo = new ArrayList();
        boolean bebidaComprada = false;
        try { 
            e.comprarBebida(m, b);
            Bebida bebida = e.getBebida();
            bolsilloBebidas.add(bebida);
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
        gr = g;
        g.setColor(cUp);
        g.fillOval(900, 200, 100, 100);
        
        g.setColor(cDown);
        g.fillRect(900, 300, 100, 400);

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
        System.out.println("no");
        if(monedasBolsillo.size() > 0){
            x = 1050;
            y = 650;
            monedasBolsillo.get(0).setXY(1050, 600);
            for(int i = 0; i < monedasBolsillo.size(); i++){
                if(i%17 == 0 && i != 0){
                    y = 650;
                    x +=40;
                }
                monedasBolsillo.get(i).setXY(x, y);
                monedasBolsillo.get(i).paint(g);
                y -= 40;
            }
        }      
    }  
    public void addBebida(int tipoBebida, int serie){
        switch(tipoBebida){
            case 0:
                bolsilloBebidas.add(new CocaCola(serie));
                break;
            case 1:
                bolsilloBebidas.add(new Sprite(serie));
                break;
            case 2:
                bolsilloBebidas.add(new Fanta(serie));
                break;
        }
    }
    public ArrayList<Bebida> getBolsilloBebidas(){
        return bolsilloBebidas;
    }
    public void eliminaBebida(int i){
        bolsilloBebidas.remove(i);
    }
    public int cuantoVuelto(){
        return vuelto;
    }
    public String queBebiste(){
        return tipoBebida;
    }
    
    public  ArrayList<Moneda> getMonedasBolsillo(){
       return monedasBolsillo;
    }
    public void addMoneda(int cant){
        switch(cant){
            case 100:
                monedasBolsillo.add(new Moneda100());
                break;
            case 500:
                monedasBolsillo.add(new Moneda500());
                break;
            case 1000:
                monedasBolsillo.add(new Moneda1000());
                break;
        }
    }
    public Moneda removeMoneda(){
        if (monedasBolsillo.size() != 0) return monedasBolsillo.remove(0);
        else{
            return null;
        }
    }
}