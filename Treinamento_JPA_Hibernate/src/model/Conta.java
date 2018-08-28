package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@NamedQuery(name = "consultaMediaValorMovimentacoes", 
			query = "select avg(m.valor) from movimentacoes m"
				 + " where m.conta = :pConta and m.tipoMovimentacao = :pTipo")
//
//@NamedQuery(name = "consultaSomaValorMovimentacoes",
//			query = "select sum(m.valor) from movimentacoes m"
//				 + " where m.conta = :pConta and m.tipoMovimentacoes = :pTipo")

@Entity(name = "conta")
public class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String titular;
	private String numero;
	private String banco;
	private String agencia;

	@OneToMany(mappedBy = "conta"/*, fetch = FetchType.EAGER*/)
	private List<Movimentacao> movimentacoes;

	public Conta() {
	}

	public Conta(int id, String titular, String numero, String banco, String agencia) {
		this.id = id;
		this.titular = titular;
		this.numero = numero;
		this.banco = banco;
		this.agencia = agencia;
	}

	public int getId() {
		return id;
	}

	public Conta setId(int id) {
		this.id = id;
		return this;
	}

	public String getTitular() {
		return titular;
	}

	public Conta setTitular(String titular) {
		this.titular = titular;
		return this;
	}

	public String getNumero() {
		return numero;
	}

	public Conta setNumero(String numero) {
		this.numero = numero;
		return this;
	}

	public String getBanco() {
		return banco;
	}

	public Conta setBanco(String banco) {
		this.banco = banco;
		return this;
	}

	public String getAgencia() {
		return agencia;
	}

	public Conta setAgencia(String agencia) {
		this.agencia = agencia;
		return this;
	}

	public List<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}

	public Conta setMovimentacoes(List<Movimentacao> movimentacoes) {
		this.movimentacoes = movimentacoes;
		return this;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Nome: " + titular + "\n " + "Agencia/Conta: " + agencia + "/" + numero + "\n" + "Banco: " + banco;
	}

}
