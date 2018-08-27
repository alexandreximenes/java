package br.com.caelum.agenda.modelo;


public class Contato {

	private Integer id;
	private String nome;
	private String telefone;

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void pegaDadosDo(Contato contato) {
		this.nome = contato.nome;
		this.telefone = contato.telefone;
	}
}
