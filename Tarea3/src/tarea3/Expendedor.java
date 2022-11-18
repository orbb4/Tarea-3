package tarea3;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Expendedor{
    private DepositoVuelto depositoVuelto;
    private int precio;
    private ArrayList<Moneda> depMonedas;
    private Deposito depCocaCola = new Deposito();
    private Deposito depSprite = new Deposito();
    private Deposito depFanta = new Deposito();
    private Rectangle expRect = new Rectangle(120, 50, 600, 900);
    private Bebida bebidaComprada;
    private boolean mousePresionado;
    public Expendedor(int nBebidas, int precio){
        depMonedas = new ArrayList();
        depositoVuelto = new DepositoVuelto();
        this.precio = precio;
        for(int i=0; i<nBebidas; ++i, Bebida.cocaGlobal++){
            CocaCola bebCoca = new CocaCola(Bebida.cocaGlobal);
            depCocaCola.addBebida(bebCoca);
        }
        for(int i=0; i<nBebidas; ++i, Bebida.spriteGlobal++){
            Sprite bebSprite = new Sprite(Bebida.spriteGlobal);
            depSprite.addBebida(bebSprite);
        }
        for(int i=0; i<nBebidas; ++i, Bebida.fantaGlobal++){
            Fanta bebFanta = new Fanta(Bebida.fantaGlobal);
            depFanta.addBebida(bebFanta);
        }
               
    }
    
    
    public void comprarBebida(Moneda m, int cual) throws NoHayBebidaException, PagoIncorrectoException, PagoInsuficienteException{
        int vuelto;
        if(m == null){
            throw new PagoIncorrectoException("Valor de moneda no puede ser null");
        }
        if(m.getValor() < precio){
            // se devuelve la misma moneda del comprador
            depositoVuelto.addMoneda(m);
            throw new PagoInsuficienteException("Pago insuficiente");
            
            //COCACOLA - SPRITE - FANTA
        }else if((cual==0 && depCocaCola.getArrayBebidas().isEmpty() )|| cual == 1 && depSprite.getArrayBebidas().isEmpty() || (cual == 2 && depFanta.getArrayBebidas().isEmpty())){
            vuelto = m.getValor();
            for(int i = 0; i < vuelto/100; i++){
                depositoVuelto.addMoneda100();
            }
            throw new NoHayBebidaException("No hay bebidas del tipo escogido");
        }
        vuelto = m.getValor() - precio;
        
        for(int i = 0; i < vuelto/100; i++){
            depositoVuelto.addMoneda100();
        }
        switch (cual) {
            case 0:
                bebidaComprada = depCocaCola.getBebida();
                break;
            case 1:
                bebidaComprada = depSprite.getBebida();
                break;
            case 2:
                bebidaComprada = depFanta.getBebida();
                break;
            default:
                break;
        }   
    }
    
    public Moneda getVuelto(){
        return depositoVuelto.getMoneda();
    }
    public DepositoVuelto getDepositoVuelto(){
        return depositoVuelto;
    }
    //cantidad de monedas que tiene el depósito de monedas;
    public int getTamano(){
        return depositoVuelto.getTamano();
    }
    //COLOR_PANEL, new int[] {120, 50, 600, 900}
    public void paint(Graphics g){
        int xExp = 120;
        int yExp = 50;
        //parte izquierda expendedor
        g.setColor(Color.GRAY);
        g.fillRect(xExp-200, yExp, 600, 900);
        // exterior expendedor 
        g.setColor(new Color(30, 40, 40));
        g.fillRect(xExp, yExp, 600, 900);
        // cristal del deposito de bebidas
        g.setColor(new Color(80, 140, 145));
        g.fillRect(xExp+30, yExp+50, 300, 500);
        // deposito de monedas recibidas por comprarBebida
        //deposito en donde se añade moneda seleccionada para comprar
        g.setColor(Color.GRAY);
        g.fillRect(xExp+395, yExp+450, 185, 150);//515.500
        //deposito de monedas de vuelto
        g.setColor(Color.GRAY);
        g.fillRect(xExp+30, yExp+570, 300, 120); //150.620
        depCocaCola.paint(g, 0, xExp+30, yExp+510);
        depSprite.paint(g, 1, xExp + 140, yExp+510);
        depFanta.paint(g, 2, xExp+250, yExp+510);
        // texto precio
        int tamanoFuente = g.getFont().getSize();
        g.setColor(Color.WHITE);
        g.setFont(new Font(g.getFont().getName(), Font.PLAIN, 42)); 
        g.drawString("$100", 515,130);
        // devolvemos la fuente a su tamaño original
        g.setFont(new Font(g.getFont().getName(), Font.PLAIN, tamanoFuente)); 
        depositoVuelto.paint(g);
        // paint de monedas
        int ymx =yExp+600;
        int xmx =xExp-120;
        int i = 0;
        for(Moneda mx: depMonedas){
            mx.setXY(xmx, ymx);
            mx.paint(g);
            ymx-=40;
            if(i == 15){
                xmx +=40;
                ymx = yExp+600;
            }
            if(i%45==0 && i!=0){
                xmx-=40;
                ymx = yExp+600;
            }
            i++;
        }
        
        
        
    }
    public void mousePressed(MouseEvent e){
        if (e.getButton() == MouseEvent.BUTTON1) {
            mousePresionado = true;
        }else{
            mousePresionado = false;
        }
    }
    public Rectangle getExpRect(){
        return expRect;
    }
    public Bebida getBebida(){
        return bebidaComprada;
    }
    //ToDo: cambiar numeros de serie en vez de que todas las bebidas tengan el mismo
    public void llenarDepositosVacios(){
        if(depCocaCola.getArrayBebidas().isEmpty()){
            System.out.println("depCocaCola vacio");
            for(int i = 0; i < 12; i++, ++Bebida.cocaGlobal){
                depCocaCola.addBebida(new CocaCola(Bebida.cocaGlobal));
            }
        }
        if(depFanta.getArrayBebidas().isEmpty()){
            for(int i = 0; i < 12; i++, ++Bebida.fantaGlobal){
                depFanta.addBebida(new Fanta(Bebida.fantaGlobal));
            }
        }
        if(depSprite.getArrayBebidas().isEmpty()){
            for(int i = 0; i < 12; i++, ++Bebida.spriteGlobal){
                depSprite.addBebida(new Sprite(Bebida.spriteGlobal));
            }
        }
    }
    
    public void addMonedas(Moneda m){
        depMonedas.add(m);
        for(Moneda mx: depMonedas){
            mx.setXY(150, 620 - depMonedas.indexOf(mx)*20);
        }
    }
}
