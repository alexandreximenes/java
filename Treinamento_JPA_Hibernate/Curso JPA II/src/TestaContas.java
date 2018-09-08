import java.math.BigDecimal;

import br.com.alexandre.financas.cursojpaehibernate.dao.ClienteDAO;
import br.com.alexandre.financas.cursojpaehibernate.dao.MovimentacaoDAO;
import br.com.alexandre.financas.cursojpaehibernate.model.Cliente;
import br.com.alexandre.financas.cursojpaehibernate.model.Conta;
import br.com.alexandre.financas.cursojpaehibernate.model.Movimentacao;
import br.com.alexandre.financas.cursojpaehibernate.model.PopularBanco;
import br.com.alexandre.financas.cursojpaehibernate.model.TipoMovimentacao;

public class TestaContas {

	public static void main(String[] args) {
		PopularBanco.start();

		Cliente cliente = new Cliente("Amanda Ximenes", "bagunceira", "Rua X n Y", "5568888");
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.salvar(cliente);

		Conta c = new Conta();
		c.setId(3);
		c.setNumero("32232550");
		c.setAgencia("99995");
		c.setBanco("Banco da China");
		c.setCliente(cliente);

		Movimentacao m = new Movimentacao();
				m.setId(4);
				m.setDescricao("A movimentação atual refere-se á um deposito Milagroso .....")
				.setMovimentacao(TipoMovimentacao.ENTRADA)
				.setValor(new BigDecimal(151099))
				.setConta(c);
				
		MovimentacaoDAO daoMov = new MovimentacaoDAO();
		daoMov.salvar(m);

	}
}
