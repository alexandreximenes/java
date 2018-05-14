package br.com.alexandre.contas.modelo;

import java.util.Calendar;

public class Conta {
	
	private Long id;

	private String descricao;

	private boolean paga;
	
	private double valor;

	private Calendar dataPagamento;
	
	private TipoDaConta tipo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isPaga() {
		return paga;
	}

	public void setPaga(boolean paga) {
		this.paga = paga;
	}

	public Calendar getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Calendar dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public TipoDaConta getTipo() {
		return tipo;
	}

	public void setTipo(TipoDaConta tipo) {
		this.tipo = tipo;
	}

	public double getValor() {
		return valor;
	}	
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	

	@Override
	public String toString() {
		return "\nDescri��o : "+descricao + "\nPaga ? " + paga + "\nValor : " + valor + "\nData de Pagamento : " + dataPagamento + "\nTipo conta : " + tipo;
	}
	
}
