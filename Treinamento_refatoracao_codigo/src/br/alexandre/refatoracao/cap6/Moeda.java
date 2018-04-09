package br.alura.refatoracao.cap6;

public enum Moeda {
	
	DOLAR(2.7),
	EURO(3.4);
	
	double valor;
	Moeda(double valor){
		this.valor = valor;
	}
	
	public double getTaxa(){
		return this.valor;
	}
}
