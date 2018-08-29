package run;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import DAO.ContaFisicaDAO;
import DAO.MovimentacaoDAO;
import DAO.PopularBanco;
import model.Conta;
import model.ContaFisica;
import model.Movimentacao;
import model.TipoMovimentacao;

/**
 * 
 * @author Alexandre Ximenes
 *
 */
public class RelacionamentoManyToOne {
	public static void main(String[] args) {
	
		/**
		 * Metodo auxiliar para popular a base de dados
		 */
		//PopularBanco.start();
	
		/**
		 * salvando uma conta
		 * 
		 */
		//*
		ContaFisica conta = new ContaFisica();
			conta.setId(1);
			
		Movimentacao movimentacao = new Movimentacao()
				.setConta(conta)
				.setData(Calendar.getInstance())
				.setTipoMovimentacao(TipoMovimentacao.ENTRADA)
				.setValor(new BigDecimal("100.05"));
		
		Movimentacao movimentacao2 = new Movimentacao()
				.setConta(conta)
				.setData(Calendar.getInstance())
				.setTipoMovimentacao(TipoMovimentacao.SAIDA)
				.setValor(new BigDecimal("540.05"));
		
		ContaFisicaDAO daoConta = new ContaFisicaDAO();
		daoConta.salvar(conta);
		
		MovimentacaoDAO dao = new MovimentacaoDAO();
		Integer id = dao.salvar(movimentacao);
		System.out.println("ID: "+id);
		
		id = dao.salvar(movimentacao2);
		System.out.println("ID: "+id);
		
		/*/
		
		
		/**
		 * Atualizando uma conta
		 */
		/*
		Conta conta = new Conta()
			.setId(9)
			.setTitular("Julia")
			.setNumero("77777")
			.setAgencia("007")
			.setBanco("Banco da mulheres");
			
		MovimentacaoDAO dao = new MovimentacaoDAO();
		Integer id = dao.atualizar(conta);
		
		System.out.println("ID: "+id);
		*/
		

		/**
		 * Removendo uma conta
		 */
		/*
		Conta conta = new Conta();
			conta.setId(7);
			
		MovimentacaoDAO dao = new MovimentacaoDAO();
		Integer id = dao.remover(conta);
		
		System.out.println("ID: "+id);
		*/
		
		/**
		 * Listando os dados do banco
		 */
		/*
		MovimentacaoDAO dao = new MovimentacaoDAO();
		List<Conta> contas = dao.listar();
		contas.forEach(System.out::println);
		*/
	}
}
