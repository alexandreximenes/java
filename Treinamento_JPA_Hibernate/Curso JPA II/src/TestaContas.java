import java.math.BigDecimal;

import br.com.alexandre.financas.cursojpaehibernate.dao.MovimentacaoDAO;
import br.com.alexandre.financas.cursojpaehibernate.model.Conta;
import br.com.alexandre.financas.cursojpaehibernate.model.Movimentacao;
import br.com.alexandre.financas.cursojpaehibernate.model.TipoMovimentacao;

public class TestaContas {

	public static void main(String[] args) {
		//PopularBanco.start();
		
		
		Conta c = new Conta();
		c.setId(3);
		c.setTitular("Mario");
		c.setNumero("32232550");
		c.setAgencia("99995");
		c.setBanco("Banco da China");
		c.setCpf("5568888");

		Movimentacao m = new Movimentacao()
				.setId(4)
				.setDescricao("A movimentação atual refere-se á um deposito Milagroso .....")
				.setMovimentacao(TipoMovimentacao.ENTRADA)
				.setValor(new BigDecimal(151099))
				.setConta(c);
				
		MovimentacaoDAO daoMov = new MovimentacaoDAO();
		daoMov.salvar(m);
		
		//ContaDAO dao = new ContaDAO();
		//String statusRemove = dao.remove(c);
		
		//System.out.println(statusRemove);
	}
}
