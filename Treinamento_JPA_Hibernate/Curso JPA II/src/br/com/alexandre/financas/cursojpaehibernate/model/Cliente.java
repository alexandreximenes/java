package br.com.alexandre.financas.cursojpaehibernate.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@Entity
public class Cliente extends AbstractEntity{

	private static final long serialVersionUID = 1L;

	private String nome;
	private String profissao;
	private String endereco;
	private String cpf;
	
	public Cliente() {}
	
	public Cliente(String nome, String profissao, String endereco, String cpf) {
		this.nome = nome;
		this.profissao = profissao;
		this.endereco = endereco;
		this.cpf = cpf;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getProfissao() {
		return profissao;
	}
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	@Override
	public String toString() {
		return nome +" - "+ cpf;
	}
	
}
