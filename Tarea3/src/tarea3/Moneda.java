package tarea3;

class Moneda{
    private String serie;
    Moneda(String serie){
        this.serie=serie;
    }

    public String getSerie(){
        return this.toString();
    }
    public int getValor(){
        return 0;
    }
}
class Moneda100 extends Moneda{
    Moneda100(String n1){
        super(n1);
    }
    public int getValor(){
        return 100;
    }
}
class Moneda500 extends Moneda{
    Moneda500(String n2){
        super(n2);
    }
    public int getValor(){
        return 500;
    }
}
class Moneda1000 extends Moneda{
    Moneda1000(String n3){
        super(n3);
    }
    public int getValor(){
        return 1000;
    }
}
