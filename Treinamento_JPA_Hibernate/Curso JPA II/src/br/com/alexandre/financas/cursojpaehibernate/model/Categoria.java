package br.com.alexandre.financas.cursojpaehibernate.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Categoria extends AbstractEntity{
	
	private static final long serialVersionUID = 1L;

	private String nome;
	
	@ManyToMany(mappedBy="categorias")
	private List<Movimentacao> movimentacoes;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}

	public void setMovimentacoes(List<Movimentacao> movimentacoes) {
		this.movimentacoes = movimentacoes;
	}
	
	

}
