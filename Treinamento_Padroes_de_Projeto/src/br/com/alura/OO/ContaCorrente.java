package br.com.alura.OO;

public class ContaCorrente extends Conta implements Tributavel{
	
	@Override
	public void atualiza(double taxa) {
		this.saldo += this.saldo * taxa * 2;
	}

	@Override
	public double calcularTributos() {
		return this.saldo * 0.01;
	}

}
