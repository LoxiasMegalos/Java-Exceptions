package conta;

public class SaldoInsuficienteException extends RuntimeException{

    public SaldoInsuficienteException(String texto){
        super(texto);
    }
    
}
