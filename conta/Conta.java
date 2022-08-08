package conta;

public class Conta {

	private float saldo;
	private float limite;
	private Cliente[] clientes;

	public Conta(float saldo, float limite) {
		this.saldo = saldo;
		this.limite = limite;
		this.clientes = new Cliente[4];
	}

	public void addCliente(Cliente cliente) {
		for (int i = 0; i < clientes.length; i++) {
			if(clientes[i] == null) {
				clientes[i] = cliente;
				break;
			}
		}
	}
	
	public void sacar(float quantia) {
		this.saldo -= quantia;
	}
	
	public void depositar (float quantia) {
		this.saldo += quantia;
	}

	public String toString() {
		//TODO
		return "";
	}
}