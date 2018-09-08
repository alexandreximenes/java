package br.com.alexandre.financas.cursojpaehibernate.model;

import javax.persistence.Entity;

@Entity
public class Movimentacao_Categoria extends AbstractEntity{

	private static final long serialVersionUID = 1L;
	
	private String status;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
}
