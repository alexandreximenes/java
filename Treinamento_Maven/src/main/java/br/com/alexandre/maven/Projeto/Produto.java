package br.com.alexandre.maven.Projeto;

public class Produto {
	
	private final String nome;
	private final double preco;
	
	public Produto(String nome, double preco) {
		this.nome = nome;
		this.preco = preco;
	}
	
	public String getNome() {
		return nome;
	}
	public double getPreco() {
		return preco;
	}

	public Object getPrecoProduto() {
		return preco * 1.0;
	}
	
	

}
