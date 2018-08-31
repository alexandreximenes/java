package br.com.alexandre.financas.cursojpaehibernate.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Conta {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String titular;
	private String cpf;
	private String numero;
	private String agencia;
	private String banco;
	@OneToMany(mappedBy="conta")
	private List<Movimentacao> movimentacoes;
	
	public String getTitular() {
		return titular;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
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
	
	
	@Override
	public String toString() {
		return titular;
	}
}
