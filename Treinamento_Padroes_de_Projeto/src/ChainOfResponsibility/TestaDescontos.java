package ChainOfResponsibility;

public class TestaDescontos {
	
	public static void main(String[] args) {
		
		Orcamento orcamento = new Orcamento(600);
		
		orcamento.adicionaItens(new Item("caneta", 100));
		orcamento.adicionaItens(new Item("lapis", 100));
		orcamento.adicionaItens(new Item("borracha", 100));
		orcamento.adicionaItens(new Item("tesoura", 100));
		orcamento.adicionaItens(new Item("papel", 100));
		orcamento.adicionaItens(new Item("lapis de cor", 100));
		
		CalculadorDeDescontos calculador = new CalculadorDeDescontos();
		double desconto = calculador.calcula(orcamento);
		System.out.println(desconto);
		
	}

}
