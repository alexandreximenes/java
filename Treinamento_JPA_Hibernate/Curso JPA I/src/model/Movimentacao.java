package model;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "movimentacoes")
public class Movimentacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	private BigDecimal valor;

	@Enumerated(EnumType.STRING)
	private TipoMovimentacao tipoMovimentacao;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar data;

	@ManyToOne
	private Conta conta;

	public Movimentacao() {
	}

	public Movimentacao(int id, BigDecimal valor, TipoMovimentacao tipoMovimentacao, Calendar data, Conta conta) {
		this.id = id;
		this.valor = valor;
		this.tipoMovimentacao = tipoMovimentacao;
		this.data = data;
		this.conta = conta;
	}

	public int getId() {
		return id;
	}

	public Movimentacao setId(int id) {
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

	public Movimentacao setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
		return this;
	}

	public Calendar getData() {
		return data;
	}

	public Movimentacao setData(Calendar data) {
		this.data = data;
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
		return "Conta: " +conta + "\n " + 
				"Tipo: " + tipoMovimentacao + "\n" + 
				"Data: " + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(data.getTime()) + "\n" +
				"Valor: " + valor + "\n";
	}

}
