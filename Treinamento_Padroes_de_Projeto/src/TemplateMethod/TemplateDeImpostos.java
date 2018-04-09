package TemplateMethod;

public abstract class TemplateDeImpostos implements Imposto{

	@Override
	public double calcula(Orcamento orcamento) {
		if(deveTerMaximaTaxacao(orcamento)) {
			return maximaTaxacao(orcamento);
		}else {
			return minimaTaxacao(orcamento);
		}
	}

	public abstract double minimaTaxacao(Orcamento orcamento);

	public abstract double maximaTaxacao(Orcamento orcamento);

	public abstract boolean deveTerMaximaTaxacao(Orcamento orcamento);

}
