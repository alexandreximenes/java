package br.com.alura.OO;

public class GerenciadorDeImpostos {
	
	private double total = 0;
	void adiciona(Tributavel t){
		this.total += t.calcularTributos();
		
	}
	public void getTotal() {
		System.out.printf("Total: %,.2f", this.total);
		
	}

}
