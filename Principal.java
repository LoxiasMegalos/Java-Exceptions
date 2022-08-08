import java.util.Scanner;

import conta.Cliente;
import conta.Conta;

import java.util.ArrayList;


public class Principal {
    
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        int opcao = -1;
        ArrayList<Conta> contas = new ArrayList<Conta>();


        while(opcao != 0){

            System.out.println("******************************");
            System.out.println("Digite uma das opcoes abaixo: ");
            System.out.println("Criar Conta (1)");
            System.out.println("Consultar Conta (2)");
            System.out.println("Remover Conta (3)");
            System.out.println("Listando Contas Cadastradas (4)");
            System.out.println("Adicionando Clientes a contas (5)");
            System.out.println("Sair (0)");
            System.out.println("*******************************");

            opcao = Integer.parseInt(teclado.nextLine());

            switch(opcao){
                case 1:{
                    float limite, saldo;
                    int numero;

                    System.out.println("Informe limite: ");
                    limite = Float.parseFloat(teclado.nextLine());
                    System.out.println("Informe Saldo: ");
                    saldo = Float.parseFloat(teclado.nextLine());
                    System.out.println("Informe Numero: ");
                    numero = Integer.parseInt(teclado.nextLine());

                    Conta conta = new Conta(saldo, limite, numero);
                    contas.add(conta);
                    break;
                }
                case 2:{
                    int n; 
                    System.out.println("Informe o numero da conta que deseja consultar: ");
                    n = Integer.parseInt(teclado.nextLine());

                    System.out.println("Buscando conta: " + n);

                    for(int i = 0; i < contas.size(); i++){
                        if(contas.get(i).getNumero() == n){
                            System.out.println(contas.get(i).toString());
                            break;
                        }
                    }

                    break;
                }
                case 3:{
                    int x; 
                    System.out.println("Informe o numero da conta que deseja remover: ");
                    x = Integer.parseInt(teclado.nextLine());

                    System.out.println("Removendo conta: " + x);

                    for(int i = 0; i < contas.size(); i++){
                        if(x == contas.get(i).getNumero()){
                            contas.remove(i);
                        }
                    }
                }
                case 4:{
                    System.out.println("Listando Contas Cadastradas: ");
                    for(int i = 0; i < contas.size(); i++){
                        System.out.println(contas.get(i).getNumero());
                    }

                    break;
                }
                case 5:{
                    System.out.println("Criando clientes: ");
                    Cliente cliente;
                    
                    String nome;
                    long Cpf;
                    int numero;

                    System.out.println("Informe o nome: ");
                    nome = teclado.nextLine();

                    System.out.println("Informe o cpf: ");
                    Cpf = Long.parseLong(teclado.nextLine());

                    cliente = new Cliente(nome, Cpf);
                    
                    System.out.println("Informe o numero da conta que deseja adicionar: ");
                    numero = Integer.parseInt(teclado.nextLine());

                    for(int i = 0; i < contas.size(); i++){
                        if(contas.get(i).getNumero() == numero){
                            contas.get(i).addCliente(cliente);;
                            break;
                        }
                    }

                    break;
                }
                case 0:{
                    System.out.println("Obrigado por utilizar!");
                    break;
                }
                default:{
                    System.out.println("Opcao Invalida!");
                    break;
                }
            }
        }

    }
}
