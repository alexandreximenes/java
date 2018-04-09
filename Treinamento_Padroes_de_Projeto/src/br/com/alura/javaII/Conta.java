package br.com.alura.javaII;

public class Conta {

	private String	nome;
	private double	valor;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return nome + " o Saldo da conta é : " + valor;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Conta)) {
			return false;
		}
		Conta outra = (Conta) obj;
		return this.valor == outra.valor;
	}
}
