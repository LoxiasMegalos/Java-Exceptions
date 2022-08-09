package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import conta.Cliente;
import conta.Conta;
import conta.ContaCorrente;
import conta.ContaEspecial;
import conta.SaldoInsuficienteException;

public class ContaTest{

    static Conta c;
    static ContaCorrente cc;
    static ContaEspecial e;

    static Cliente x;


    @BeforeClass
    public static void setup(){
        c = new Conta(100, 1000, 1);
        cc = new ContaCorrente(200, 1000, 2);
        e = new ContaEspecial(300, 1000, 3);
        x = new Cliente("Murillo", 1234);

        c.addCliente(x);
        cc.addCliente(x);
        e.addCliente(x);
    }

	@Test
    public void testContaGetNumero() {
        assertEquals(1, c.getNumero());
    }

    @Test
    public void testContaCorrenteGetNumero() {
        assertEquals(2, cc.getNumero());
    }

    @Test
    public void testContaEspecialGetNumero() {
        assertEquals(3, e.getNumero());
    }

    @Test
    public void testClientesEmUmConta(){
        assertEquals("Murillo", c.getClientes()[0].getNome());
        assertEquals(1234, c.getClientes()[0].getCpf());
    }

    @Test
    public void testClientesEmUmContaCorrente(){
        assertEquals("Murillo", cc.getClientes()[0].getNome());
        assertEquals(1234, cc.getClientes()[0].getCpf());
    }

    @Test
    public void testClientesEmUmContaEspecial(){
        assertEquals("Murillo", e.getClientes()[0].getNome());
        assertEquals(1234, e.getClientes()[0].getCpf());
    }

    @Test(expected = SaldoInsuficienteException.class)
    public void testSaqueConta(){
        c.sacar(200);
    }

    @Test(expected = SaldoInsuficienteException.class)
    public void testSaqueContaCorrente(){
        cc.sacar(12000);
    }

    @Test(expected = SaldoInsuficienteException.class)
    public void testSaqueContaEspecial(){
        e.sacar(12000);
    }

    @Test
    public void testaMsgErroSaqueConta(){
        String resp;
        try{
            c.sacar(200);
        } catch(SaldoInsuficienteException e){
            resp = e.getMessage();
            assertEquals("Saldo Insuficiente da Conta numero: 1", resp);
        }
        
    }

    @Test
    public void testaMsgErroSaqueContaCorrente(){
        String resp;
        try{
            cc.sacar(12000);
        } catch(SaldoInsuficienteException e){
            resp = e.getMessage();
            assertEquals("Saldo Insuficiente da Conta Corrente: 2", resp);
        }
        
    }

    @Test
    public void testaMsgErroSaqueContaEspecial(){
        String resp;
        try{
            e.sacar(12000);
        } catch(SaldoInsuficienteException e){
            resp = e.getMessage();
            assertEquals("Saldo Insuficiente da Conta especial: 3", resp);
        }
        
    }

    @Test
    public void testaSaqueSucessoConta(){
        float x = 100;
        c.sacar(50);
        assertEquals(x, c.getSaldo(), 0);
    }

    @Test
    public void testaSaqueSucessoContaCorrente(){
        float x = 200;
        cc.sacar(50);
        assertEquals(x, cc.getSaldo(), 0);
    }

    @Test
    public void testaSaqueSucessoContaEspecial(){
        float x = 250;
        e.sacar(50);
        assertEquals(x, e.getSaldo(), 0);
    }

    @Test
    public void testaDepositoConta(){
        c.depositar(50);
        assertEquals(150, c.getSaldo(), 0);
    }

    @Test
    public void testaDepositoContaCorrente(){
        cc.depositar(50);
        assertEquals(250, cc.getSaldo(), 0);
    }

    @Test
    public void testaDepositoContaEspecial(){
        e.depositar(50);
        assertEquals(300, e.getSaldo(), 0);
    }

    @Test
    public void testaToStringConta(){
        assertEquals("Numero: 1\nSaldo: 100.0\nLimite: 1000.0\nNome do cliente: Murillo\nCPF do cliente: 1234\nCliente Inexistente\nCliente Inexistente\nCliente Inexistente\n", c.toString());
    }

    @Test
    public void testaToStringContaCorrente(){
        assertEquals("Numero: 2\nSaldo: 200.0\nLimite: 1000.0\nNome do cliente: Murillo\nCPF do cliente: 1234\nCliente Inexistente\nCliente Inexistente\nCliente Inexistente\n", cc.toString());
    }

    @Test
    public void testaToStringContaEspecial(){
        assertEquals("Numero: 3\nSaldo: 250.0\nLimite: 1000.0\nNome do cliente: Murillo\nCPF do cliente: 1234\nCliente Inexistente\nCliente Inexistente\nCliente Inexistente\n", e.toString());
    }
}