package tarea3;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
public class PanelPrincipal extends JPanel{
        private Color color;
        private final Color VERDEMENTA = new Color(36, 211, 154);
        private int[] rect; // dimensiones del rectangulo (x, y, ancho, alto)
        private Comprador comprador;
        private Expendedor exp;
        private Moneda mon;
        private int maxBebidasBolsillo = 26;
        private int maxMonedasBolsillo =45;
        private int boton1Xcord = 655;
        private int boton2Xcord = 655;
        private int boton3Xcord = 655;
        public PanelPrincipal(){
            mon = new Moneda();
            exp = new Expendedor(12, 100);
            comprador = new Comprador(mon, 2, exp);
            this.setLayout(null);
            this.addMouseListener(new EscuchaRaton());
           
            
        }
        public void paint(Graphics g){
            super.paint(g);       
            exp.paint(g);
            // logos bebidas
            Toolkit t = Toolkit.getDefaultToolkit(); 
            Image cocaImage = new ImageIcon(this.getClass().getResource("cocacola.jpg")).getImage();
            Image spriteImage = new ImageIcon(this.getClass().getResource("sprite.jpg")).getImage();
            Image fantaImage = new ImageIcon(this.getClass().getResource("fanta.jpg")).getImage();
            g.drawImage(cocaImage, 520,160, 120, 80, this);  
            g.drawImage(spriteImage, 520,260, 120, 80, this);
            g.drawImage(fantaImage, 520,360, 120, 80, this);  

            //bolsillo
            g.setColor(VERDEMENTA);
            g.fillRect(1050, 0, 150,700);
            // botones (parte trasera):
            g.setColor(new Color(170, 50, 50));
            
            g.fillOval(660, 175, 50, 50);
            g.fillOval(660, 275, 50, 50);
            g.fillOval(660, 375, 50, 50);
            
            // botones (parte delantera):
            g.setColor(new Color(250, 50, 50));
            g.fillOval(boton1Xcord, 175, 50, 50);
            g.fillOval(boton2Xcord, 275, 50, 50);
            g.fillOval(boton3Xcord, 375, 50, 50);
            // bolsillo de bebidas
            g.setColor(new Color(85, 65, 55));
            g.fillRect(725, 50, 170,700);
            // TEXTO INVENTARIO
            /*
            g.setColor(Color.WHITE);
           
            g.drawString("Clickee sobre una bebida", 742, 675);
            g.drawString("comprada para beberla", 747,695);*/
            // TEXTO VUELTO
            g.setColor(Color.WHITE); 
            if(exp.getTamano()==4 || exp.getTamano()==9){
                g.drawString("DBES RETIRAR TU VUELTO ANTES", 510,675);
                g.drawString("DE PODER COMPRAR OTRA BEBIDA", 505,695);
            }
            
            g.setColor(Color.BLACK); 
            g.drawString("Clickee sobre", 360,650);
            g.drawString("  el depósito", 360,665);
            g.drawString("  para retirar", 360,680);
            g.drawString("   su vuelto", 360,695); 
           
            
            g.setColor(Color.WHITE);
            g.drawString("INVENTARIO", 775, 60); 
            g.drawString("Clickee sobre una bebida", 742, 675);
            g.drawString("comprada para beberla", 747,695);
            
            g.setColor(Color.BLACK);            
            g.drawString("  Puede clickear sobre una", 1050, 650);
            g.drawString("    moneda de su bolsillo ", 1050,670);
            g.drawString("  para comprar una bebida", 1050,690);

            // mensaje Bolsillo bebidas lleno:
            g.setColor(Color.RED); 
            if(comprador.getBolsilloBebidas().size() == maxBebidasBolsillo){
                g.drawString("BOLSILLO LLENO: debes beber una", 615, 25);
                g.drawString("bebida antes de poder comprar otra", 615,45);
            }
            //mensaje Bolsillo de bebidas por llenarse:
            g.setColor(Color.RED);
            if((comprador.getBolsilloMonedas().size()+4>maxMonedasBolsillo)){
                g.drawString("YA NO PUEDES", 898, 95);
                g.drawString(" GUARDAR MÁS VUELTO,", 898,115);
                g.drawString("USA TUS MONEDAS O", 898,135);
                g.drawString("SELECCIONA UNA DE 100", 898,155);
            }
            
            if((comprador.getBolsilloMonedas().size()+4<=maxMonedasBolsillo && comprador.getBolsilloMonedas().size()+9>maxMonedasBolsillo)){
                g.drawString("NO PUEDES USAR", 898, 95);
                g.drawString("UNA MONEDA DE 1000,", 898,115);
                g.drawString("USA TUS MONEDAS O", 898,135);
                g.drawString("SELECCIONA UNA DE 100", 898,155);
                g.drawString("  O UNA DE 500", 898,175);
            }
            
            
            // bebidas en bolsillo del comprador:
            int x = 725;
            int y = 620;
            int i = 0;
            
            for(Bebida b: comprador.getBolsilloBebidas()){
                b.setXY(x, y);
                b.paint(g);
                y-=45;
                i++;
                if(i%13==0){
                    x+=85;
                    y = 620;
                }
            }
            
            //monedas en el bolsillo del comprador:
            int xB = 1050;
            int yB = 590;
            int a = 0;
            
            for(Moneda m: comprador.getBolsilloMonedas()){
                m.setXY(xB, yB);
                m.paint(g);
                yB-=41;
                a++;
                if(a%15==0){
                    xB+=45;
                    yB = 590;
                }
            }
            comprador.paint(g);
        }
        private class EscuchaRaton  implements MouseListener {
            public void mouseClicked(MouseEvent me){
                
                // colision mouse -  expendedor: rellena depositos de bebida vacios
                if((me.getX() >= exp.getExpRect().getMinX() && me.getX() <= exp.getExpRect().getMaxX())&&( me.getY() >= exp.getExpRect().getMinY() && me.getY() <= exp.getExpRect().getMaxY()) && !(me.getX() >= 655 && me.getX() <= 705 && me.getY() >= 175  && me.getY() <= 225)
                    && !(me.getX() >= 655 && me.getX() <= 705 && me.getY() >= 175  && me.getY() <= 225)
                    && !(me.getX() >= 655 && me.getX() <= 705 && me.getY() >= 275  && me.getY() <= 325)
                    && !(me.getX() >= 655 && me.getX() <= 705 && me.getY() >= 375  && me.getY() <= 425)){
                    exp.llenarDepositosVacios();
                    PanelPrincipal.this.repaint();
                    
                }  
                // colision mouse - monedas a seleccionar 
                if((me.getX()>1225 && me.getX()<1335 && me.getY()>100 && me.getY()<200)){
                    System.out.println("100");
                    comprador.addMoneda(100);
                    PanelPrincipal.this.repaint();
                }
                if((me.getX()>1225 && me.getX()<1335 && me.getY()>300 && me.getY()<400) && (comprador.getBolsilloMonedas().size()+4<=maxMonedasBolsillo || comprador.getBolsilloMonedas().size()+9<=maxMonedasBolsillo)){
                    System.out.println("500");
                    comprador.addMoneda(500);
                    PanelPrincipal.this.repaint();
                }
                if((me.getX()>1225 && me.getX()<1335 && me.getY()>500 && me.getY()<600) && (comprador.getBolsilloMonedas().size()+9<=maxMonedasBolsillo || comprador.getBolsilloMonedas().size()+9<=maxMonedasBolsillo)){
                    System.out.println("1000");
                    comprador.addMoneda(1000);
                    PanelPrincipal.this.repaint();
                }
                //colision mouse - deposito de vuelto
                if((me.getX()>150 && me.getX()<450 && me.getY()>620 && me.getY()<720)){
                    System.out.println("click en deposito vuelto");
                    int numMonedas = exp.getDepositoVuelto().getTamano();
                    //if(comprador.getBolsilloMonedas().size()+exp.getDepositoVuelto().getTamano()<=maxMonedasBolsillo){
                    for(int i=0; i<numMonedas; i++){
                        System.out.println("ola: "+exp.getDepositoVuelto().getTamano());  
                        System.out.println(comprador.getBolsilloMonedas());   
                        comprador.addMonedaBolsillo(exp.getDepositoVuelto().getMoneda());
                    }
                    if(exp.getTamano()==4){
                        for(int i=0; i<4; i++){
                            exp.getDepositoVuelto().getMoneda();
                        }
                    }
                    if(exp.getTamano()==9){
                        for(int i=0; i<9; i++){
                            exp.getDepositoVuelto().getMoneda();
                        }
                    }
                    PanelPrincipal.this.repaint();
                }
                
 
            }
            
            public void mousePressed(MouseEvent me) {
                if(comprador.getBolsilloBebidas().size() != maxBebidasBolsillo && exp.getTamano()!=4 && exp.getTamano()!=9 ){
                // colision boton 1: comprar CocaCola
                if(me.getX() >= 655 && me.getX() <= 705 && me.getY() >= 175  && me.getY() <= 225){
                    System.out.println("boton1");
                    boton1Xcord = 658;

                    // toDo: usar la moneda seleccionada en vez de la misma de 1000 por defecto

                    try{
                        if(comprador.getMonedaDePago().size() != 0){
                            exp.addMonedas(comprador.getMonedaDePago().get(0));
                            exp.comprarBebida(comprador.getMonedaDePago().remove(0), 0);
                        }
                        else{
                            throw new PagoIncorrectoException("No hay monedas en el bolsillo");
                        }
                        comprador.addBebida(0, exp.getBebida().getSerie());
                        System.out.println("comprado");
                        PanelPrincipal.this.repaint();
                    }
                    catch(NoHayBebidaException | PagoIncorrectoException | PagoInsuficienteException ex){
                        
                    }
                }
                
                // colision boton 2: comprar Sprite
                if(me.getX() >= 655 && me.getX() <= 705 && me.getY() >= 275  && me.getY() <= 325){
                    System.out.println("boton2");
                    boton2Xcord = 658;
                    // toDo: crear comprador que tenga la moneda seleccionada en vez de la misma de 1000 por defecto
                    try{
                        if(comprador.getMonedaDePago().size() != 0){
                            exp.addMonedas(comprador.getMonedaDePago().get(0));
                            exp.comprarBebida(comprador.getMonedaDePago().remove(0), 1);
                        }
                        else{
                            throw new PagoIncorrectoException("No hay monedas en el bolsillo");
                        }
                        comprador.addBebida(1, exp.getBebida().getSerie());
                        System.out.println(comprador.getBolsilloBebidas().toString());
                        PanelPrincipal.this.repaint();
                    }
                    catch(NoHayBebidaException | PagoIncorrectoException | PagoInsuficienteException ex){
                        
                    }
                }
                // colision boton 3: comprar Fanta
                if(me.getX() >= 655 && me.getX() <= 705 && me.getY() >= 375  && me.getY() <= 425){
                    System.out.println("boton3");                    
                    boton3Xcord = 658;
                    // toDo: crear comprador que tenga la moneda seleccionada en vez de la misma de 1000 por defecto
                    try{
                        if(comprador.getMonedaDePago().size() != 0){
                            exp.addMonedas(comprador.getMonedaDePago().get(0));
                            exp.comprarBebida(comprador.getMonedaDePago().remove(0), 2);
                        }
                        else{
                            throw new PagoIncorrectoException("No hay monedas en el bolsillo");
                        }
                        comprador.addBebida(2, exp.getBebida().getSerie());
                        System.out.println(comprador.getBolsilloBebidas().toString());
                        PanelPrincipal.this.repaint();
                    }
                    catch(NoHayBebidaException | PagoIncorrectoException | PagoInsuficienteException ex){
                        
                    }
                }
                }else{
                    PanelPrincipal.this.repaint();
                }
                // detectamos si el usuario presionó una bebida del bolsillo para beberla
                // BEBIDAS ancho: 80 - alto: 40
                int i = 0;
                int x = 725;
                int y = 620;
                int bebidaRemovida=-1; // si el valor es -1 significa que el user no clickeo una bebida del bolsillo
                for(Bebida b: comprador.getBolsilloBebidas()){
                    System.out.println("X: " + x + ", " + x+40 + " - Y: " + y+40 + ", " + y);
                    // si se clickea una bebida, se guarda el index que la bebida seleccionada tiene en el bolsillo
                    // y se rompe el ciclo for para eliminarla despues
                    if(me.getX() >= x && me.getX() <= x+80 && me.getY() >= y  && me.getY() <= y+40){                        
                        //b.beber();
                        System.out.println(b);
                        bebidaRemovida = i;
                        break;
                    }
                    i++;
                    y-=45;
                    if(i%13==0){
                        x+=85;
                        y = 620;
                    } 
                }
                if(bebidaRemovida != -1){
                    comprador.eliminaBebida(i);
                }
                
                // detectamos si el usuario presionó una moneda del bolsillo para comprar
                // MONEDAS ancho: 40 - alto: 40
                int b = 0;
                int xM = 1050;
                int yM = 590;
                int monedaRemovida=-1; // si el valor es -1 significa que el user no clickeo una moneda del bolsillo
                Moneda monedaExp = new Moneda();
                for(Moneda m: comprador.getBolsilloMonedas()){
                    System.out.println("X: " + x + ", " + xM+40 + " - Y: " + yM+40 + ", " + yM);
                    // si se clickea una moneda, se guarda el index que la moneda seleccionada tiene en el bolsillo
                    // y se rompe el ciclo for para eliminarla despues
                    if(me.getX() >= xM && me.getX() <= xM+40 && me.getY() >= yM  && me.getY() <= yM+40){                        
                        //b.beber();
                        System.out.println(m);
                        monedaRemovida = b;//b
                        monedaExp=comprador.getBolsilloMonedas().get(b);
                        break;
                    }
                    b++;
                    yM-=41;
                    if(b%15==0){
                        xM+=45;
                        yM = 490;
                    } 
                }
                if(monedaRemovida != -1){
                    comprador.addMonedaBolsilloExp(monedaExp);
                    //monedaExp=comprador.getBolsilloMonedas().get(b);
                    //comprador.addMoneda(100);
                    comprador.eliminaMoneda(b);
                }
                PanelPrincipal.this.repaint();
            }
            public void mouseReleased(MouseEvent me) {
                boton1Xcord = 655;
                boton2Xcord = 655;
                boton3Xcord = 655;
                System.out.println("Y: " + me.getY());
                System.out.println("X: " + me.getX());
            }
            public void mouseEntered(MouseEvent me) {
            }  
            public void mouseExited(MouseEvent me) {;}
        }
        
}