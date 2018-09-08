package br.com.alexandre.financas.cursojpaehibernate.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Movimentacao extends AbstractEntity{
	private static final long serialVersionUID = 1L;
	private BigDecimal valor;
	@Enumerated(EnumType.STRING)
	private TipoMovimentacao tipoMovimentacao;
	@Column(length=65535, columnDefinition = "TEXT")
	private String descricao;

	@ManyToOne
	@JoinColumn(name = "conta_id")
	private Conta conta;
	
	@ManyToMany
	private List<Categoria> categorias;
	
	public BigDecimal getValor() {
		return valor;
	}
	public Movimentacao setValor(BigDecimal valor) {
		this.valor = valor;
		return this;
	}
	public TipoMovimentacao getTipoMovimentacao() {
		return tipoMovimentacao;
	}
	public Movimentacao setMovimentacao(TipoMovimentacao tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
		return this;
	}
	public String getDescricao() {
		return descricao;
	}
	public Movimentacao setDescricao(String descricao) {
		this.descricao = descricao;
		return this;
	}
	public Conta getConta() {
		return conta;
	}
	public Movimentacao setConta(Conta conta) {
		this.conta = conta;
		return this;
	}
	
	@Override
	public String toString() {
		return conta.toString() +" \n "+ descricao + " = " + valor;
	}
}
