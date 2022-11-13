package tarea3;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.*;
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
     
    public void paint(Graphics g){
        
    }   

    // tipo bebida: 0=cocacola, 1=sprite, 2=fanta
    public void paint(Graphics g, int tipoBebida, int x, int y){
        // comprobamos tipo de bebida para posicionarlas en su columna correspondiente
        switch (tipoBebida) {
            // cocacola
            case 0:
                g.setColor(ROJO);
                x =150;
                for(int i = 0; i < bebidas.size(); i++){
                    if(bebidas.get(i).getSabor() == "CocaCola"){
                        bebidas.get(i).setXY(150, y);
                        bebidas.get(i).paint(g);
                    }
                    else{continue;}
                    y-= 40 + 1;
                }      
                break;
            // sprite
            case 1:
                g.setColor(VERDE);
                for(int i = 0; i < bebidas.size(); i++){
                    if(bebidas.get(i).getSabor() == "Sprite"){
                        bebidas.get(i).setXY(x, y);
                        bebidas.get(i).paint(g);
                    }
                    else{continue;}
                    y-= 40 + 1;
                }   
                break;
            // fanta
            case 2:
                g.setColor(NARANJO);
                x=370;
                for(int i = 0; i < bebidas.size(); i++){
                    if(bebidas.get(i).getSabor() == "Fanta"){
                        bebidas.get(i).setXY(x, y);
                        bebidas.get(i).paint(g);
                    }
                    y-= 40 + 1;
                }   
               break;
            default:
                x = 150;
                break;
        }  
        
    }
    // cristal: g.fillRect(150, 100, 300, 500);
    // coordenadas y tamaño expendedor: 120, 50, 600, 900
    
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
    public int getTamano(){
        return monedas.size();
    }
    public ArrayList<Moneda> getArrayMonedas(){
        return monedas;
    }
    
    public void paint(Graphics g){
        //g.fillRect(150, 620, 300, 60); lugar donde van las monedas de vuelto
        int y=620;
        int x=150;
        int aux=109;
        for(int i = 0; i <monedas.size(); i++){
            monedas.get(i).setXY(x, y);
            monedas.get(i).paint(g);
            if(i<4){ //
                x+= 40+1;
            }
        }
        for(int a = 5; a < monedas.size(); a++){//7
            aux+=40+1;
            y=660;
            monedas.get(a).setXY(aux, y);
            monedas.get(a).paint(g);
        }
    }
         
}


