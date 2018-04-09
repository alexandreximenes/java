package br.com.alura.OO.avancado;

import java.util.Locale;

public class RelatorioDeDividas {
	
	
	public static void main(String[] args) {
		Locale locale = new Locale("pt", "BR");
		Divida divida = new Divida("01.002.003/0005-06", "Joao", 22_000, 100_000);
		
		Pagamento pagamento = new Pagamento("98.765.432/1000-01", "Alexandre", 22_000);
		divida.registra(pagamento);
		divida.setLocale(locale);
		pagamento.setLocale(locale);
		
		System.out.println(divida);
		System.out.println(pagamento);
		
		
	}

}
