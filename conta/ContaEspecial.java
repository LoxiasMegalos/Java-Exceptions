package conta;

public class ContaEspecial extends Conta{

    public ContaEspecial(float saldo, float limite, int numero){
        super(saldo, limite, numero);
    }

    public void sacar(float quantia) {
		
		if(quantia <= saldo + (limite / 2)){
			this.saldo -= quantia;
		} else{
			throw new SaldoInsuficienteException("Saldo Insuficiente da Conta especial: "+ this.numero);
		}
	}
}
