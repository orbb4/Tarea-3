package tarea3;
public class Expendedor {
    private DepositoVuelto depositoVuelto;
    private int precio;
    private Deposito depCocaCola = new Deposito();
    private Deposito depSprite = new Deposito();
    private Deposito depFanta = new Deposito();
    public Expendedor(int nBebidas, int precio){
        depositoVuelto = new DepositoVuelto();
        this.precio = precio;
        CocaCola bebCoca = new CocaCola(32883);
        for(int i=0; i<nBebidas; ++i){
            depCocaCola.addBebida(bebCoca);
        }
        Sprite bebSprite = new Sprite(29798);
        for(int i=0; i<nBebidas; ++i){
            depSprite.addBebida(bebSprite);
        }
        Fanta bebFanta = new Fanta(39845);
        for(int i=0; i<nBebidas; ++i){
            depFanta.addBebida(bebFanta);
        }
               
    }
    
    
    public Bebida comprarBebida(Moneda m, int cual) throws NoHayBebidaException, PagoIncorrectoException, PagoInsuficienteException{
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
                return depCocaCola.getBebida();
            case 1:
                return depSprite.getBebida();
            case 2:
                return depFanta.getBebida();
            default:
                return depCocaCola.getBebida();
        }   
    }
    
    public Moneda getVuelto(){
        return depositoVuelto.getMoneda();
    }
    public DepositoVuelto getDepositoVuelto(){
        return depositoVuelto;
    }
}
