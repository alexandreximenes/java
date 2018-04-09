package br.com.alura.OO.avancado;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

public class Pagamentos{
	private double valorPago;
	private Collection<Pagamento> pagamentos = new ArrayList<>();
    public void registra(Pagamento pagamento) {
    	double valor = pagamento.getValor();
        if (valor < 0) {
          throw new IllegalArgumentException("Valor invalido para pagamento");
        }
        if (valor > 100) {
          valor = valor - 8;
        }
        this.valorPago += valor;
        this.pagamentos.add(pagamento);
	}

	
	public ArrayList<Pagamento> pagamentosAntesDe(Calendar data) {
        ArrayList<Pagamento> pagamentosFiltrados = new ArrayList<Pagamento>();
        for (Pagamento pagamento : this.pagamentos) {
            if (pagamento.getData().before(data)) {
                pagamentosFiltrados.add(pagamento);
            }
        }
        return pagamentosFiltrados;
    }
    public ArrayList<Pagamento> pagamentosComValorMaiorQue(double valorMinimo) {
        ArrayList<Pagamento> pagamentosFiltrados = new ArrayList<Pagamento>();
        for (Pagamento pagamento : this.pagamentos) {
            if (pagamento.getValor() > valorMinimo) {
                pagamentosFiltrados.add(pagamento);
            }
        }
        return pagamentosFiltrados;
    }
    public ArrayList<Pagamento> pagamentosDo(String cnpjPagador) {
        ArrayList<Pagamento> pagamentosFiltrados = new ArrayList<Pagamento>();
        for (Pagamento pagamento : this.pagamentos) {
            if (pagamento.getCnpjPagador().equals(cnpjPagador)) {
                pagamentosFiltrados.add(pagamento);
            }
        }
        return pagamentosFiltrados;
    }
   
}
