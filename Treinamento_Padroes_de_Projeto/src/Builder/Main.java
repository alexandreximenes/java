package Builder;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		
		ItemDaNota item1 = new ItemDaNota("item1", 100);
		ItemDaNota item2 = new ItemDaNota("item2", 200);
		ItemDaNota item3 = new ItemDaNota("item3", 300);
		List<ItemDaNota> itens = new ArrayList<>();
		itens.add(item1);
		itens.add(item2);
		itens.add(item3);
		
		NotaFiscalBuilder nota = new NotaFiscalBuilder();
		nota.adicionaAcoes(new EnviarEmail());
		nota.adicionaAcoes(new Imprimir());
		
		nota
		.empresa("alura")
		.comCnpj("0123")
		.comItem(itens)
		.comObservacoes("pequena observação")
		.construir();
		
		System.out.println(nota.getEmpresa());
	}
}
