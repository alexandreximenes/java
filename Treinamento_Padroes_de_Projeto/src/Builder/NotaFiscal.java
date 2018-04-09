package Builder;

import java.util.List;

public class NotaFiscal {

	private String Empresa;
	private String cnpj;
	private List<ItemDaNota> itens;
	private String observacoes;
	
	public NotaFiscal(String empresa, String cnpj, List<ItemDaNota> itens, String observacoes) {
		Empresa = empresa;
		this.cnpj = cnpj;
		this.itens = itens;
		this.observacoes = observacoes;
	}
	
	public String getEmpresa() {
		return Empresa;
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
	
	
	
	
}
