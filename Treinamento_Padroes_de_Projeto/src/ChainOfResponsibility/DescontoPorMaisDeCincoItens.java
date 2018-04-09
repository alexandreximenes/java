package ChainOfResponsibility;

public class DescontoPorMaisDeCincoItens implements Desconto{

	private Desconto proximoDesconto;

	@Override
	public double desconta(Orcamento orcamento) {
		int totalItens = orcamento.getQuantidadeItens();
		if(totalItens > 5) {
			return orcamento.getValor() * 0.07;
		}else {
			return proximoDesconto.desconta(orcamento);
		}
	}

	@Override
	public void setProximo(Desconto proximoDesconto) {
		this.proximoDesconto = proximoDesconto;
		
	}

}
