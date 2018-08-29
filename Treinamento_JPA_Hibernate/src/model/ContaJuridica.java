package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@NamedQuery(name = "consultaMediaValorMovimentacoesJuridica", 
			query = "select avg(m.valor) from movimentacoes m"
				 + " where m.contaJuridica = :pConta and m.tipoMovimentacao = :pTipo")
//
//@NamedQuery(name = "consultaSomaValorMovimentacoes",
//			query = "select sum(m.valor) from movimentacoes m"
//				 + " where m.conta = :pConta and m.tipoMovimentacoes = :pTipo")

@Entity()
public class ContaJuridica extends Conta{

	private String cnpj;
	
	
	public String getCnpj() {
		return cnpj;
	}


	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}


	@Override
	public String toString() {
		return super.toString() + "\n CNPJ: " + cnpj;
	}
}
