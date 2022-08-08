package conta;

import conta.Cliente;

public class Conta {

	private float saldo;
	private float limite;
	private int numero;
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
	
	public void sacar(float quantia) {
		this.saldo -= quantia;
	}
	
	public void depositar (float quantia) {
		this.saldo += quantia;
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
				System.out.println("Cliente Inexistente \n");
			}

		}

		return informacoes;
	}
}