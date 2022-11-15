 package tarea3;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

class Moneda{
    private int x,y;
    public void setXY(int x1, int y1){
        x = x1;
        y = y1;
    }
    public String getSerie(){
        return this.toString();
    }
    public int getValor(){
        return 0;
    }
    
    public void paint(Graphics g){              

    }
}
class Moneda100 extends Moneda{
    private int y = 650, x;
    private static int numSerieContador = 0;
    private String numSerie;
    Moneda100(){
       numSerie = Integer.toString(numSerieContador);
       numSerieContador++;
    }
    public int getValor(){
        return 100;
    }
    public String getSerie(){
        return numSerie;
    }
    public void setXY(int x1, int y1){
        x = x1;
        y = y1;
    }
    public void paint(Graphics g){              
        g.setColor(Color.YELLOW);
        g.fillOval(x, y, 40, 40);
        g.setColor(Color.BLACK);
        g.setFont( new Font( "Arial", Font.BOLD, 10 ) );
        g.drawString("Serie: " + numSerie, x, y+20);
    }
}
class Moneda500 extends Moneda{
    private int y = 650, x;
    private static int numSerieContador = 0;
    private String numSerie;
    Moneda500(){
       numSerie = Integer.toString(numSerieContador);
       numSerieContador++;
    }
    public int getValor(){
        return 500;
    }
    public String getSerie(){
        return numSerie;
    }
    public void setXY(int x1, int y1){
        x = x1;
        y = y1;
    }
    public void paint(Graphics g){              
        g.setColor(Color.orange);
        g.fillOval(x, y, 40, 40);
        g.setColor(Color.BLACK);
        g.setFont( new Font( "Arial", Font.BOLD, 10 ) );
        g.drawString("Serie: " + numSerie, x, y+20);
        
    }
}
class Moneda1000 extends Moneda{
    private int y = 650, x;
    private static int numSerieContador = 0;
    private String numSerie;
    Moneda1000( ){
       numSerie = Integer.toString(numSerieContador);
       numSerieContador++;
    }
    public int getValor(){
        return 1000;
    }
    public String getSerie(){
        return numSerie;
    }
    public void setXY(int x1, int y1){
        x = x1;
        y = y1;
    }
    public void paint(Graphics g){              
        g.setColor(Color.RED);
        g.fillOval(x, y, 40, 40);
        g.setColor(Color.BLACK);
        g.setFont( new Font( "Arial", Font.BOLD, 10 ) );
        g.drawString("Serie: " + numSerie, x, y+20);
    }
}
