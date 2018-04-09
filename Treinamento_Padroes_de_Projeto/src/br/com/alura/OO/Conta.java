package br.com.alura.OO;

public abstract class Conta {

	protected double saldo;
	protected int numero;
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	/**
	 * 
	 * @return o saldo da Conta
	 */
	public double getSaldo() {
		return this.saldo;
	}

	/**
	 * 
	 * @param valor
	 *            para efetuar o deposito
	 * @throws ValorInvalidoException
	 *             caso o valor seja menor que 0
	 */

	public void depositar(double valor){
		if (valor < 0) {
			//throw new ValorInvalidoException();
		} else {
			this.saldo += valor;

		}

	}

	/**
	 * 
	 * @param valor
	 *            para efetuar o saque
	 * @throws ValorInvalidoException
	 *             caso o valor seja menor que 0 ou o valor a ser sacado seja
	 *             maior que o saldo da conta <code>this.getSaldo()</code>
	 *
	public void sacar(double valor) throws ValorInvalidoException {
		if (valor > getSaldo() || valor < 0) {
			throw new ValorInvalidoException(valor);
		} else {
			this.saldo -= valor;
		}
	}

	/**
	 * 
	 * @param taxa
	 */
	public abstract void atualiza(double taxa);

	public String toString() {
		return "o saldo é R$ " + this.getSaldo();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numero;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		if (numero != other.numero)
			return false;
		return true;
	}
}
