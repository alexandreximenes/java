package br.com.alura.OO.avancado;

public class GerenciadorDeDividas {
	public void efetuaPagamento(Pagamento pagamento, Divida divida) {
		divida.registra(pagamento);
	}

}
