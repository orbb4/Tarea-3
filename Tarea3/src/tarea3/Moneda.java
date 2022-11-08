package tarea3;

class Moneda{
    /*private String serie;
    Moneda(String serie){
        this.serie=serie;
    }*/

    public String getSerie(){
        return this.toString();
    }
    public int getValor(){
        return 0;
    }
}
class Moneda100 extends Moneda{
    private static int numSerieContador = 0;
    private String numSerie;
    Moneda100(){
       numSerie = Integer.toString(numSerieContador);
       numSerieContador++;
    }
    public int getValor(){
        return 100;
    }
    public String getSerie(){
        return numSerie;
    }
}
class Moneda500 extends Moneda{
    private static int numSerieContador = 0;
    private String numSerie;
    Moneda500(){
       numSerie = Integer.toString(numSerieContador);
       numSerieContador++;
    }
    public int getValor(){
        return 500;
    }
    public String getSerie(){
        return numSerie;
    }
}
class Moneda1000 extends Moneda{
    private static int numSerieContador = 0;
    private String numSerie;
    Moneda1000( ){
       numSerie = Integer.toString(numSerieContador);
       numSerieContador++;
    }
    public int getValor(){
        return 1000;
    }
    public String getSerie(){
        return numSerie;
    }
}
