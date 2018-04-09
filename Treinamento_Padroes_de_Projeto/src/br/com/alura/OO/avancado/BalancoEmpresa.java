package br.com.alura.OO.avancado;

import java.util.HashMap;

public class BalancoEmpresa {
	private HashMap<String, Divida> dividas = new HashMap<>();
	
	public void registraDivida(String credor, String cnpjCredor, double valorPago, double total) {
		Divida divida = new Divida(cnpjCredor, cnpjCredor, valorPago, total);
		dividas.put(cnpjCredor, divida);
	}
	
	public void pagaDivida(String cnpjCredor, String pagador, String cnpjPagador, double valor) {
		Divida divida = dividas.get(cnpjCredor);
		if(divida != null) {
			Pagamento pagamento = new Pagamento(cnpjPagador, pagador, valor);
			divida.registra(pagamento);
			
			
		}
	}

}
