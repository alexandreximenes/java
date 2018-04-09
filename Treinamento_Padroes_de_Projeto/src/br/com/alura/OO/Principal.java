package br.com.alura.OO;

public class Principal {
	
	public static void main(String[] args) {
		Conta cc = new ContaCorrente();
		Conta cp = new ContaPoupanca();

        cc.depositar(1000); 
        cp.depositar(1000);

        cc.atualiza(0.01);
        cp.atualiza(0.01);

        System.out.println(cc.getSaldo());
        System.out.println(cp.getSaldo());
        
        AtualizadorDeContas adc = new AtualizadorDeContas(0.01);

        adc.roda(cc);
        adc.roda(cp);

        System.out.println("Saldo Total: " + adc.getSaldoTotal());
	}

}
