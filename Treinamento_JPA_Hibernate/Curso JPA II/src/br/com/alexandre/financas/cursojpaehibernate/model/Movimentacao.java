package br.com.alexandre.financas.cursojpaehibernate.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Movimentacao {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private BigDecimal valor;
	@Enumerated(EnumType.STRING)
	private TipoMovimentacao tipoMovimentacao;
	@Column(length=65535, columnDefinition = "TEXT")
	private String descricao;
	@ManyToOne
	@JoinColumn(name = "conta_______id")
	private Conta conta;
	
	public Integer getId() {
		return id;
	}
	public Movimentacao setId(Integer id) {
		this.id = id;
		return this;
	}
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
		return descricao + " = " + valor;
	}
}
