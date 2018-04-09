package TemplateMethod;

public class ICPP extends TemplateDeImpostos{

	@Override
	public double minimaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * 0.05;
	}

	@Override
	public double maximaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * 0.07;
	}

	@Override
	public boolean deveTerMaximaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() > 500;
	}
	
}
