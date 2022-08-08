package conta;

import conta.Cliente;

public class Conta {

	protected float saldo;
	protected float limite;
	protected int numero;
	private Cliente[] clientes;

	public Conta(float saldo, float limite, int numero) {
		this.numero = numero;
		this.saldo = saldo;
		this.limite = limite;
		this.clientes = new Cliente[4];
	}

	public int getNumero(){
		return this.numero;
	}

	public void addCliente(Cliente cliente) {
		for (int i = 0; i < clientes.length; i++) {
			if(clientes[i] == null) {
				clientes[i] = cliente;
				break;
			}
		}
	}
	
	public Cliente[] getClientes(){
		return this.clientes;
	}

	public void sacar(float quantia) {
		
		if(quantia <= saldo){
			this.saldo -= quantia;
		} else{
			throw new SaldoInsuficienteException("Saldo Insuficiente da Conta numero: "+ this.numero);
		}
	}
	
	public void depositar (float quantia) {
		this.saldo += quantia;
	}

	public float getSaldo(){
		return this.saldo;
	}

	public String toString() {
		String informacoes = "Numero: " + this.numero + "\n";
		informacoes += "Saldo: " + this.saldo + "\n";
		informacoes += "Limite: "+ this.limite + "\n";

		for(Cliente cliente : clientes){
			try{
				
				informacoes += "Nome do cliente: " + cliente.getNome() + "\n";
				informacoes += "CPF do cliente: " + cliente.getCpf() + "\n";
			}catch (NullPointerException e){
				informacoes += "Cliente Inexistente \n";
			}

		}

		return informacoes;
	}
}