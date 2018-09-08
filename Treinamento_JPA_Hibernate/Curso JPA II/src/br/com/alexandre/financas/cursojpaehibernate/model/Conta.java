package br.com.alexandre.financas.cursojpaehibernate.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Conta extends AbstractEntity{
	
	private static final long serialVersionUID = 1L;
	private String numero;
	private String agencia;
	private String banco;
	
	@OneToOne
	@JoinColumn(unique=true, nullable = false)
	private Cliente cliente;
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	@OneToMany(mappedBy="conta", cascade=CascadeType.ALL)
	private List<Movimentacao> movimentacoes;
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	public String getBanco() {
		return banco;
	}
	public void setBanco(String banco) {
		this.banco = banco;
	}
	
	public List<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}
	public void setMovimentacoes(List<Movimentacao> movimentacoes) {
		this.movimentacoes = movimentacoes;
	}
	@Override
	public String toString() {
		return numero + " - " + cliente;
	}
}
