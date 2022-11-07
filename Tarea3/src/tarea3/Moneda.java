package tarea3;

class Moneda{
    Moneda(){}
    public String getSerie(){
        return this.toString();
    }
    public int getValor(){
        return 0;
    }
}
class Moneda100 extends Moneda{
    Moneda100(){}
    public int getValor(){
        return 100;
    }
}
class Moneda500 extends Moneda{
    Moneda500(){}
    public int getValor(){
        return 500;
    }
}
class Moneda1000 extends Moneda{
    Moneda1000(){}
    public int getValor(){
        return 1000;
    }
}
