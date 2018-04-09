package TemplateMethod;

public class TestaImposto {
	
	public static void main(String[] args) {

		Imposto ikcv = new IKCV();
		Imposto icpp = new ICPP();
		
		Orcamento orcamento = new Orcamento(500);
		
		orcamento.adicionaItens(new Item("caneta", 101));
		orcamento.adicionaItens(new Item("lapis", 100));
		orcamento.adicionaItens(new Item("borracha", 100));
		orcamento.adicionaItens(new Item("tesoura", 100));
		orcamento.adicionaItens(new Item("papel", 100));
		orcamento.adicionaItens(new Item("lapis de cor", 100));
		
		double calcula = ikcv.calcula(orcamento);
		double calcula2 = icpp.calcula(orcamento);
		
		System.out.println(calcula);
		System.out.println(calcula2);
		
	}

}
