import java.math.BigDecimal;

import br.com.alexandre.financas.cursojpaehibernate.dao.ClienteDAO;
import br.com.alexandre.financas.cursojpaehibernate.dao.ContaDAO;
import br.com.alexandre.financas.cursojpaehibernate.dao.MovimentacaoDAO;
import br.com.alexandre.financas.cursojpaehibernate.model.Cliente;
import br.com.alexandre.financas.cursojpaehibernate.model.Conta;
import br.com.alexandre.financas.cursojpaehibernate.model.Movimentacao;
import br.com.alexandre.financas.cursojpaehibernate.model.PopularBanco;
import br.com.alexandre.financas.cursojpaehibernate.model.TipoMovimentacao;

public class TestaContas {

	public static void main(String[] args) {
		PopularBanco.start();

		Cliente cliente = new Cliente("Nair Chagas Ximenes", "Aposentada", "Rua X n Y", "15151515");
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.salvar(cliente);

		Cliente cliente2 = new Cliente("Bruno Caio Ximenes", "Empresario", "Rua X n Y", "3154899");
		clienteDAO = new ClienteDAO();
		clienteDAO.salvar(cliente2);

		Conta c = new Conta();
		c.setNumero("32232550");
		c.setAgencia("99995");
		c.setBanco("Banco da China");
		c.setCliente(cliente);


		Conta cc = new Conta();
		cc.setNumero("51561661");
		cc.setAgencia("355");
		cc.setBanco("Banco do Brasil");
		cc.setCliente(cliente2);

		ContaDAO contaDAO = new ContaDAO();
		contaDAO.salvar(c);
		contaDAO.salvar(cc);
		
		Movimentacao m = new Movimentacao();
		m.setId(4);
		m.setDescricao("salario").setMovimentacao(TipoMovimentacao.ENTRADA).setValor(new BigDecimal(3000)).setConta(c);

		Movimentacao m1 = new Movimentacao();
		m1.setId(4);
		m1.setDescricao("compra mercado").setMovimentacao(TipoMovimentacao.SAIDA).setValor(new BigDecimal(500.00))
				.setConta(cc);

		Movimentacao m2 = new Movimentacao();
		m2.setId(4);
		m2.setDescricao("salario")
				.setMovimentacao(TipoMovimentacao.ENTRADA).setValor(new BigDecimal(1500)).setConta(c);
		MovimentacaoDAO daoMov = new MovimentacaoDAO();
		
		daoMov.salvar(m);
		daoMov.salvar(m1);
		daoMov.salvar(m2);

	}
}
