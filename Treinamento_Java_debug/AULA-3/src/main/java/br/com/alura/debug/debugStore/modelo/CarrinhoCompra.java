package br.com.alura.debug.debugStore.modelo;

import java.math.BigDecimal;
import java.util.List;

public class CarrinhoCompra {
	
	private FormaPagamento formaPagamento;
	
	public CarrinhoCompra(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	
	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}
	
	public BigDecimal calcularPrecoFinal(List<Produto> produtos) {
		BigDecimal total = new BigDecimal(0);
		for (Produto produto : produtos) {
			BigDecimal preco = produto.getPreco();
			double porcentagemDesconto = this.getFormaPagamento().getPorcentagemDesconto();
			BigDecimal valorComDesconto = preco.multiply(new BigDecimal(porcentagemDesconto)).divide(new BigDecimal("100"));
			BigDecimal valorProdutoComDesconto =  preco.subtract(valorComDesconto);
			if (valorProdutoComDesconto.compareTo(new BigDecimal("700.00")) == 1 ){
				System.out.println("O produto " + produto.getDescricao() + " ganhou mais R$20,00 de desconto");
				valorProdutoComDesconto = valorProdutoComDesconto.subtract(new BigDecimal("20.00"));
			}
			BigDecimal multiplicador = new BigDecimal(produto.getQuantidade());
			total = total.add(valorProdutoComDesconto.multiply(multiplicador));
		}
		total = calcularPromocao(produtos, total);
		return total;
	}
	
	private BigDecimal calcularPromocao(List<Produto> produtos, BigDecimal total) {
		for (Produto produto : produtos) {
			int quantidadeDescontar = produto.getQuantidade() / 3;
			for(int cont = 0; quantidadeDescontar > cont; cont++ ){
				total = total.subtract(produto.getPreco());
			}
		}
		return total;
	}

	
}
