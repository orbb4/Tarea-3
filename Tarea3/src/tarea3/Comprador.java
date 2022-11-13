package tarea3;
import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import javax.swing.SwingUtilities;
public class Comprador extends JButton{    
    private String tipoBebida = null;
    private ArrayList<Moneda> monedaDePago;
    private ArrayList<Moneda> bolsilloMonedas;
    private ArrayList<Bebida> bolsilloBebidas;
    private int vuelto = 0;    
    private Polygon p;
    private int x=0,y=0;
    private int MAXMON = 1;
    
    private Graphics gr;
    
    private Color cUp = new Color(216   ,145,1);
    private Color cDown = new Color(216   ,145,1);
    
    public Comprador(Moneda m, int b, Expendedor e){
        int vueltot;
        this.setLayout(null);
        this.setVisible(true);
        bolsilloBebidas = new ArrayList();
        monedaDePago = new ArrayList();
        bolsilloMonedas = new ArrayList();
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
        if(monedaDePago.size() > 0){
            switch(monedaDePago.get(0).getValor()){
                case 100:
                    monedaDePago.get(0).paint(g);
                    break;
                case 500:
                    monedaDePago.get(0).paint(g);
                    break;
                case 1000:
                    monedaDePago.get(0).paint(g);
                    break;
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
    
    public  ArrayList<Moneda> getMonedaDePago(){
       return monedaDePago;
    }
    
    public void addMoneda(int cant){
        Moneda m;
        switch(cant){
            case 100:
                m = new Moneda100();
                monedaDePago.add(m);
                if(monedaDePago.size() > MAXMON){
                    monedaDePago.remove(0);
                    
                    
                }
                m.setXY(515, 500);
                break;
            case 500:
                m = new Moneda500();
                monedaDePago.add(m);
                if(monedaDePago.size() > MAXMON){
                    monedaDePago.remove(0);
                }
                m.setXY(515, 500);
                break;
            case 1000:
                m = new Moneda1000();
                monedaDePago.add(m);
                if(monedaDePago.size() > MAXMON){
                    monedaDePago.remove(0);
                }
                m.setXY(515, 500);
                break;
        }
    }
    public Moneda removeMoneda(){
        if (monedaDePago.size() != 0) return monedaDePago.remove(0);
        else{
            return null;
        }
    }
    public void addMonedaBolsilloExp(Moneda m){
        monedaDePago.add(m);
        if(monedaDePago.size() > MAXMON){
            monedaDePago.remove(0);    
        }
        m.setXY(515, 500);
    }
    public void addMonedaBolsillo(Moneda m){
        //Moneda m = new Moneda100();
        bolsilloMonedas.add(m);
    }
    public ArrayList<Moneda> getBolsilloMonedas(){
        return bolsilloMonedas;
    }
    public void eliminaMoneda(int i){
        bolsilloMonedas.remove(i);
    }
    
}