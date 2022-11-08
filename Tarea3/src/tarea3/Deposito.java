package tarea3;
<<<<<<< HEAD
import java.awt.Color;
import java.awt.Graphics;
=======
import java.awt.*;
>>>>>>> beta
import java.util.ArrayList;
class Deposito{
    private ArrayList<Bebida> bebidas;
    private final Color NARANJO = new Color(245, 130, 60);
    private final Color VERDE = new Color(80, 200, 95);
    private final Color ROJO = new Color(170, 10, 20);
    public Deposito(){
        bebidas = new ArrayList();
    }
    public void addBebida(Bebida b){
        bebidas.add(b);
    }
    public Bebida getBebida(){
        if(bebidas.size() != 0){
            return bebidas.remove(0);
        }else{
            return null;
        }
       
    }
    public ArrayList<Bebida> getArrayBebidas(){
        return bebidas;
    }
<<<<<<< HEAD
     
    public void paint(Graphics g){
        
    }   
=======
    // tipo bebida: 0=cocacola, 1=sprite, 2=fanta
    public void paint(Graphics g, int tipoBebida){
        int y = 560;
        int x;
        // comprobamos tipo de bebida para posicionarlas en su columna correspondiente
        switch (tipoBebida) {
            // cocacola
            case 0:
                g.setColor(ROJO);
                x =150;               
                break;
            // sprite
            case 1:
                g.setColor(VERDE);
                x = 260;
                break;
            // fanta
            case 2:
                g.setColor(NARANJO);
                x=370;          
               break;
            default:
                x = 150;
                break;
        }
        for(int i = 0; i < bebidas.size(); i++){                   
            g.fillRect(x, y, 80, 40);
            y-= 40 + 2;
        }      
        
    }
    // cristal: g.fillRect(150, 100, 300, 500);
    // coordenadas y tamaño expendedor: 120, 50, 600, 900
    
>>>>>>> beta
}

class DepositoVuelto{
    private ArrayList<Moneda> monedas;
    public DepositoVuelto(){
        monedas = new ArrayList();
    }
    public void addMoneda(Moneda m){
        monedas.add(m);
    }
    public void addMoneda100(){
        monedas.add(new Moneda100());
    }
    public Moneda getMoneda(){
        if(monedas.size() != 0){
            return monedas.remove(0);
        }else{
            return null;
        }      
    }
}
