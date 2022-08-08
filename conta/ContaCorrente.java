package conta;

public class ContaCorrente extends Conta{

    public ContaCorrente(float saldo, float limite, int numero){
        super(saldo, limite, numero);
    }
    
    public void sacar(float quantia) {
		
		if(quantia <= (saldo + limite)){
			this.saldo -= quantia;
		} else{
			throw new SaldoInsuficienteException("Saldo Insuficiente da Conta Corrente: "+ this.numero);
		}
	}
}
