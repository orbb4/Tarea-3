package tarea3;

class PagoIncorrectoException extends Exception{
    public PagoIncorrectoException(String errorMessage){
        super(errorMessage);
    }
}

