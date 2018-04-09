package br.com.alura.OO.avancado;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Divida {
	private double total;
    private double valorPago;
    private String credor;
    private Cnpj cnpjCredor;
    private Pagamentos pagamentos = new Pagamentos();
	private Locale locale;
    
	public Divida(String cnpjCredor, String credor, double valorPago, double total) {
		if(valorPago > 0) {
		this.cnpjCredor = new Cnpj(cnpjCredor);
		this.credor = credor;
		this.valorPago = valorPago;
		this.total = total;
		}else {
			throw new IllegalArgumentException("valor invalido para pagamento");
		}
	}

	public double getTotal() {
		return total;
	}

	public double getValorPago() {
		return valorPago;
	}

	public String getCredor() {
		return credor;
	}
;
	public Cnpj getCnpjCredor() {
		return cnpjCredor;
	}
    
    private void paga(double valor) {
    	if(valor > 100 ) {
    		valor -= 8;
    	}
    	
    	this.valorPago = valor;
    }

	public void registra(Pagamento pagamento) {
		pagamentos.registra(pagamento);
		
	}
	
	@Override
	public String toString() {
		Moeda moeda = new Moeda(locale);
		//String cnpjCredor, String credor, double valorPago, double total
		return "CNPJ Credor : "+ cnpjCredor + " - " + credor + " VALOR PAGO : " + moeda.format(valorPago) + " TOTAL : " + moeda.format(total);  
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
		
		
	}
    

}
