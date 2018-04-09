package ChainOfResponsibility;

public class SemDesconto implements Desconto{

	private Desconto proximoDesconto;

	@Override
	public double desconta(Orcamento orcamento) {
		return 0;
	}

	@Override
	public void setProximo(Desconto proximoDesconto) {
		this.proximoDesconto = this;
		
	}

}
