package model;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@NamedQuery(name = "consultaMediaValorMovimentacoes", 
			query = "select avg(m.valor) from movimentacoes m"
				 + " where m.contaFisica = :pConta and m.tipoMovimentacao = :pTipo")
//
//@NamedQuery(name = "consultaSomaValorMovimentacoes",
//			query = "select sum(m.valor) from movimentacoes m"
//				 + " where m.conta = :pConta and m.tipoMovimentacoes = :pTipo")

@Entity()
public class ContaFisica extends Conta{

	private String cpf;

	
	public String getCpf() {
		return cpf;
	}


	public ContaFisica setCpf(String cpf) {
		this.cpf = cpf;
		return this;
	}


	public ContaFisica() {
	}

	
	@Override
	public String toString() {
		return super.toString() + "\n CPF: " + cpf;
	}

}
