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
            g.setColor(Color.WHITE);            
            g.drawString("Clickee sobre una bebida", 742, 675);
            g.drawString("comprada para beberla", 747,695);
            // mensaje Bolsillo bebidas lleno:
            g.setColor(Color.RED); 
            if(comprador.getBolsilloBebidas().size() == maxBebidasBolsillo){
                g.drawString("BOLSILLO LLENO: debes beber una", 615, 25);
                g.drawString("bebida antes de poder comprar otra", 615,45);
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
            comprador.paint(g);

        }
        private class EscuchaRaton  implements MouseListener {
            public void mouseClicked(MouseEvent me){
                
                // colision mouse -  expendedor: rellena depositos de bebida vacios
                if((me.getX() >= exp.getExpRect().getMinX() && me.getX() <= exp.getExpRect().getMaxX())&&( me.getY() >= exp.getExpRect().getMinY() && me.getY() <= exp.getExpRect().getMaxY())){
                    exp.llenarDepositosVacios();
                    PanelPrincipal.this.repaint();
                    
                }  
                // colision mouse - monedas a seleccionar 
                if((me.getX()>1225 && me.getX()<1335 && me.getY()>100 && me.getY()<200)){
                    System.out.println("100");
                    comprador.addMoneda(100);
                    PanelPrincipal.this.repaint();
                }
                if((me.getX()>1225 && me.getX()<1335 && me.getY()>300 && me.getY()<400)){
                    System.out.println("500");
                    comprador.addMoneda(500);
                    PanelPrincipal.this.repaint();
                }
                if((me.getX()>1225 && me.getX()<1335 && me.getY()>500 && me.getY()<600)){
                    System.out.println("1000");
                    comprador.addMoneda(1000);
                    PanelPrincipal.this.repaint();
                }
                
 
                
            }
            
            public void mousePressed(MouseEvent me) {
                if(comprador.getBolsilloBebidas().size() != maxBebidasBolsillo){
                // colision boton 1: comprar CocaCola
                if(me.getX() >= 655 && me.getX() <= 705 && me.getY() >= 175  && me.getY() <= 225){
                    System.out.println("boton1");
                    boton1Xcord = 658;

                    // toDo: usar la moneda seleccionada en vez de la misma de 1000 por defecto

                    try{
                        if(comprador.getMonedasBolsillo().size() != 0){
                            exp.comprarBebida(comprador.getMonedasBolsillo().remove(0), 0);
                        }
                        else{
                            throw new PagoIncorrectoException("No hay monedas en el bolsillo");
                        }
                        comprador.addBebida(0, exp.getBebida().getSerie());
                        System.out.println(comprador.getBolsilloBebidas().toString());
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
                        if(comprador.getMonedasBolsillo().size() != 0){
                            exp.comprarBebida(comprador.getMonedasBolsillo().remove(0), 1);
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
                        if(comprador.getMonedasBolsillo().size() != 0){
                            exp.comprarBebida(comprador.getMonedasBolsillo().remove(0), 2);
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
            }}
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
        
        private void Botones(){
        JButton boton1 = new JButton(); 
        //this.setLayout(null); testing
        boton1.setBounds(655, 175, 50, 50);
        boton1.setEnabled(true);
        boton1.setBackground(Color.MAGENTA);
        this.add(boton1);
        
        
        
        JButton boton2 = new JButton(); 
        boton2.setBounds(655, 275, 50, 50);
        boton2.setEnabled(true);
        boton2.setBackground(Color.MAGENTA);
        this.add(boton2);
        
        JButton boton3 = new JButton(); 
        boton3.setBounds(655, 375, 50, 50);
        boton3.setEnabled(true);
        boton3.setBackground(Color.MAGENTA);
        this.add(boton3);
        
        JButton boton4 = new JButton(); 
        //this.setLayout(null); testing
        boton4.setBounds(1225, 100, 100, 100);
        boton4.setEnabled(true);
        boton4.setBackground(Color.YELLOW);
        this.add(boton4);
        
        JButton boton5 = new JButton(); 
        //this.setLayout(null); testing
        boton5.setBounds(1225, 300, 100, 100);
        boton5.setEnabled(true);
        boton5.setBackground(Color.RED);
        this.add(boton5);
        
        JButton boton6 = new JButton(); 
        //this.setLayout(null); testing
        boton6.setBounds(1225, 500, 100, 100);
        boton6.setEnabled(true);
        boton6.setBackground(Color.ORANGE);
        this.add(boton6);
        
        
        // boton 1
        boton1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    
                    exp.comprarBebida(new Moneda1000(), 0);
                    // pintamos los botones para el siguiente frame
                    SwingUtilities.windowForComponent(boton1).repaint();
                    // repintamos panel principal para el siguiente frame
                    repaint();
                } catch (NoHayBebidaException ex) {
                    System.out.println(ex);
                    System.out.println("No quedan bebidas!");
                } catch (PagoIncorrectoException ex) {
                    System.out.println(ex);
                    System.out.println("No se puede obtener bebida ya que no hay pago");
                } catch (PagoInsuficienteException ex) {
                    System.out.println(ex);
                    System.out.println("No se puede obtener bebida ya que el pago es insuficiente");
                }
            }
        });
        // boton 2
        boton2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    exp.comprarBebida(new Moneda1000(), 1);
                    // pintamos los botones para el siguiente frame
                    SwingUtilities.windowForComponent(boton1).repaint();
                    // repintamos panel principal para el siguiente frame
                    repaint();
                } catch (NoHayBebidaException ex) {
                    System.out.println(ex);
                    System.out.println("No quedan bebidas!");
                } catch (PagoIncorrectoException ex) {
                    System.out.println(ex);
                    System.out.println("No se puede obtener bebida ya que no hay pago");
                } catch (PagoInsuficienteException ex) {
                    System.out.println(ex);
                    System.out.println("No se puede obtener bebida ya que el pago es insuficiente");
                }
            }
        });
        // boton 3
        boton3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    exp.comprarBebida(new Moneda1000(), 2);
                    // pintamos los botones para el siguiente frame
                    SwingUtilities.windowForComponent(boton1).repaint();
                    // repintamos panel principal para el siguiente frame
                    repaint();
                } catch (NoHayBebidaException ex) {
                    System.out.println(ex);
                    System.out.println("No quedan bebidas!");
                } catch (PagoIncorrectoException ex) {
                    System.out.println(ex);
                    System.out.println("No se puede obtener bebida ya que no hay pago");
                } catch (PagoInsuficienteException ex) {
                    System.out.println(ex);
                    System.out.println("No se puede obtener bebida ya que el pago es insuficiente");
                }
            }
        });        
    }
}