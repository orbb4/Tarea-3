package tarea3;
import java.awt.*;

abstract class Bebida{
    private int serie;
    static int cocaGlobal = 100;
    static int spriteGlobal = 200;
    static int fantaGlobal = 300;
    private int x,y;
    public Bebida(int serie){
        this.serie = serie;
    }
    public int getSerie(){
        return serie;
    }
    public void setXY(int x1, int y1){
        x = x1;
        y = y1;
    }
    public String getSabor(){
        return "CocaCola";
    }
    public String beber(){

        return "sabor: ";
       
    }
    public void paint(Graphics g){              

    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
}

class CocaCola extends Bebida{
    private int y = 560, x; 
    private int serie;
    public CocaCola(int n1){
        super(n1);
        serie = n1;
    }
    public int getSerie(){
        return serie;
    }
    public String beber(){
        return super.beber()+"Cocacola";
    }
    public void setXY(int x1, int y1){
        x = x1;
        y = y1;
    }
    public String getSabor(){
        return "CocaCola";
    }
    public void paint(Graphics g){              
        g.setColor(Color.RED);
        g.fillRect(x, y, 80, 40);
        g.setColor(Color.WHITE);
        g.drawString("Serie: " + serie, x, y + 10);
        y-= 40 + 1;
    }

}

class Sprite extends Bebida{
    private int y = 560, x; 
    private int serie;
    public Sprite(int n2){
        super(n2);
        serie = n2;
    }
    public String beber(){
        return super.beber()+"Sprite";
    }
    public void setXY(int x1, int y1){
        x = x1;
        y = y1;
    }
    public String getSabor(){
        return "Sprite";
    }
    public void paint(Graphics g){              
        g.setColor(Color.GREEN);
        g.fillRect(x, y, 80, 40);
        g.setColor(Color.BLACK);
        g.drawString("Serie: " + serie, x, y + 10);
        y-= 40 + 1;
    }
}
class Fanta extends Bebida{
    private int y = 560, x; 
    private int serie;
    public Fanta(int n3){
        super(n3);
        serie = n3;
    }
    public String beber(){
        return super.beber()+"Fanta";
    }
    public void setXY(int x1, int y1){
        x = x1;
        y = y1;
    }
    public String getSabor(){
        return "Fanta";
    }
    public void paint(Graphics g){              
        g.setColor(Color.ORANGE);
        g.fillRect(x, y, 80, 40);
        g.setColor(Color.BLACK);
        g.drawString("Serie: " + serie, x, y + 10);
        y-= 40 + 1;
    }
    
}


