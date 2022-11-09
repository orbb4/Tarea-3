package tarea3;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Expendedor{
    private DepositoVuelto depositoVuelto;
    private int precio;
    private Deposito depCocaCola = new Deposito();
    private Deposito depSprite = new Deposito();
    private Deposito depFanta = new Deposito();
    private Rectangle expRect = new Rectangle(120, 50, 600, 900);
    private Bebida bebidaComprada;
    private boolean mousePresionado;
    public Expendedor(int nBebidas, int precio){
        depositoVuelto = new DepositoVuelto();
        this.precio = precio;
        for(int i=0, u=100; i<nBebidas; ++i, u++){
            CocaCola bebCoca = new CocaCola(u);
            depCocaCola.addBebida(bebCoca);
        }
        for(int i=0, u=200; i<nBebidas; ++i, u++){
            Sprite bebSprite = new Sprite(u);
            depSprite.addBebida(bebSprite);
        }
        for(int i=0, u=300; i<nBebidas; ++i, u++){
            Fanta bebFanta = new Fanta(u);
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
    //COLOR_PANEL, new int[] {120, 50, 600, 900}
    public void paint(Graphics g){
        // exterior expendedor 
        g.setColor(new Color(30, 40, 40));
        g.fillRect(120, 50, 600, 900);
        // cristal del deposito de bebidas
        g.setColor(new Color(80, 140, 145));
        g.fillRect(150, 100, 300, 500);
        depCocaCola.paint(g, 0);
        depSprite.paint(g, 1);
        depFanta.paint(g, 2);
        depositoVuelto.paint(g);
        
        
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
            for(int i = 0; i < 12; i++){
                depCocaCola.addBebida(new CocaCola(1));
            }
        }
        if(depFanta.getArrayBebidas().isEmpty()){
            for(int i = 0; i < 12; i++){
                depFanta.addBebida(new Fanta(1));
            }
        }
        if(depSprite.getArrayBebidas().isEmpty()){
            for(int i = 0; i < 12; i++){
                depSprite.addBebida(new Sprite(1));
            }
        }
    }

}
