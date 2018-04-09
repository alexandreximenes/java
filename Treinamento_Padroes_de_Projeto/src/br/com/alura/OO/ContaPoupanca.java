package br.com.alura.OO;

public class ContaPoupanca extends Conta implements Comparable<ContaPoupanca>{
	
	@Override
	public void atualiza(double taxa) {
		this.saldo += this.saldo * taxa * 3;
	}
	
	@Override
	public void depositar(double valor) {
		this.saldo += valor - 0.10;
	}

	@Override
	public int compareTo(ContaPoupanca outra) {
		if( this.getSaldo() < outra.getSaldo() ) return -1;
		if( this.getSaldo() > outra.getSaldo() ) return 1;
		return 0;
		/*if( this.getNumero() < outra.getNumero() ) return -1;
		if( this.getNumero() > outra.getNumero() ) return 1;
		return 0;*/
	}
	
	@Override
	public String toString() {
		return "Nome: " + this.getNome()+
				" " +this.getNumero() + ", " +super.toString();
	}
}
