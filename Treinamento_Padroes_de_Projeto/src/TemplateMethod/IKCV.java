package TemplateMethod;

public class IKCV extends TemplateDeImpostos{

	@Override
	public double minimaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * 0.05;
	}

	@Override
	public double maximaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * 0.10;
	}

	@Override
	public boolean deveTerMaximaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() > 500 && temItemMaiorQue100ReaisNo(orcamento); 
	}

	private boolean temItemMaiorQue100ReaisNo(Orcamento orcamento) {
		for(Item item : orcamento.getItens()) {
			if(item.getValor() > 100) {
				return true;
			}
		}
		return false;
	}

}
