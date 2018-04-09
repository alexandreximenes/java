package Builder;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class NotaFiscalBuilder {
	
	public String getEmpresa() {
		return empresa;
	}

	public String getCnpj() {
		return cnpj;
	}

	public List<ItemDaNota> getItens() {
		return itens;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public Calendar getData() {
		return data;
	}

	private String empresa;
	private String cnpj;
	private List<ItemDaNota> itens = new ArrayList<>();
	private String observacoes;
	private Calendar data;
	private List<AcoesAposEmitirNota> acoes;
	
	public NotaFiscalBuilder() {
		acoes = new ArrayList<>();
	}
	
	public void adicionaAcoes(AcoesAposEmitirNota a) {
		this.acoes.add(a);
	}
	
	public NotaFiscalBuilder empresa(String empresa) {
		this.empresa = empresa;
		return this;
	}
	
	public NotaFiscalBuilder comCnpj(String cnpj) {
		this.cnpj = cnpj;
		return this;
	}
	
	public NotaFiscalBuilder comItem(List<ItemDaNota> itens) {
		this.itens = itens;
		return this;
	}
	
	public NotaFiscalBuilder comObservacoes(String observacoes) {
		this.observacoes = observacoes;
		return this;
	}
	
	public NotaFiscalBuilder naDataAtual() {
		data = Calendar.getInstance();
		return this;
	}
	
	public NotaFiscalBuilder construir( ){
		NotaFiscal nf = new NotaFiscal(empresa, cnpj, itens, observacoes);
		
		for (AcoesAposEmitirNota a : acoes) {
			a.executa(nf);
		}
		
		return this;
	}
	
	
	
	

}
