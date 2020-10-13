package produto;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Venda {
	
	@XmlElementWrapper(name = "produtos")
	@XmlElement(name = "produto")
	private List<Produto> produtos;
	private List<FormaDePagamento> formasDePagamento;
	
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	public List<FormaDePagamento> getFormasDePagamento() {
		return formasDePagamento;
	}
	public void setFormaDePagamento(List<FormaDePagamento> formasDePagamento) {
		this.formasDePagamento = formasDePagamento;
	}
	
	@Override
	public String toString() {
		return produtos.toString();
	}

}