 package tarea3;

import java.awt.Color;
import java.awt.Graphics;

class Moneda{
    /*private String serie;
    Moneda(String serie){
        this.serie=serie;
    }*/

    public String getSerie(){
        return this.toString();
    }
    public int getValor(){
        return 0;
    }
}
class Moneda100 extends Moneda{
    private int y = 560, x;
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
    public void paint(Graphics g){              
        g.setColor(Color.YELLOW);
        g.fillOval(x, y, 80, 40);
        y-= 40 + 1;
    }
}
class Moneda500 extends Moneda{
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
}
class Moneda1000 extends Moneda{
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
}
