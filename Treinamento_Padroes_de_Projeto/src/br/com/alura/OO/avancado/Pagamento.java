package br.com.alura.OO.avancado;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Locale;

public class Pagamento {
	private String pagador;
    private String cnpjPagador;
    private double valor;
    private Calendar data;
	private Locale locale;
    
	public Pagamento(String cnpjPagador, String pagador, double valor) {
		this.cnpjPagador = cnpjPagador;
		this.pagador = pagador;
		this.valor = valor;
	}
	
	public String getPagador() {
		return pagador;
	}
	
	public Calendar getData() {
		return data;
	}
	
	public String getCnpjPagador() {
		return cnpjPagador;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setLocale(Locale locale) {
		this.locale = locale;
	}
	
	@Override
	public String toString() {
		Moeda moeda = new Moeda(locale);
		return "CNPJ Pagador : " +cnpjPagador +" " + pagador +" " + moeda.format(valor);
	}
	
    
}
