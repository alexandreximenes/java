package ChainOfResponsibility;

import java.util.ArrayList;
import java.util.List;

public class Orcamento {
	
	private double valor;
	private List<Item> itens = new ArrayList<>();

	public Orcamento(double valor) {
		this.valor = valor;
		
	}
	
	public double getValor() {
		return valor;
	}
	
	public List<Item> getItens() {
		return itens;
	}
	
	public int getQuantidadeItens() {
		return itens.size();
	}
	
	public double getValorTotal() {
		double total = 0;
		for (Item item : itens) {
			total += item.getValor();
		}
		
		return total;

	}

	public void adicionaItens(Item item) {
		itens.add(item);
		
	}
	
	
	

}
