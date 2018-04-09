package ChainOfResponsibility;

public class DescontoValorAcimaDeQuinhentos implements Desconto{

	private final static double VALOR_PARA_DESCONTO = 500.00;
	private Desconto proximoDesconto;
	@Override
	public double desconta(Orcamento orcamento) {
		double valorTotal = orcamento.getValorTotal();
		if(valorTotal > VALOR_PARA_DESCONTO) {
			return orcamento.getValor() * 0.05;
		}
		return proximoDesconto.desconta(orcamento);
	}

	@Override
	public void setProximo(Desconto proximoDesconto) {
		this.proximoDesconto = proximoDesconto;
	}

}
