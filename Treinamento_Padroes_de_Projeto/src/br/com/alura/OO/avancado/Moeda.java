package br.com.alura.OO.avancado;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class Moeda {
	
	private Locale local;
	private NumberFormat formatador;
	public Moeda(Locale local) {
		this.local = local;
		formatador = NumberFormat.getCurrencyInstance(this.local);
	}

	public String format(double valor) {
		return formatador.format(valor);
	}

}
