package br.com.treinamento.ant;

import com.thoughtworks.xstream.XStream;

public class Aluno {
	
	private String nome;
	private int idade;
	
	public Aluno() {
	}
	
	public Aluno(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public String toXML() {
		XStream xstream = new XStream();
		return xstream.toXML(this);
	}

}
