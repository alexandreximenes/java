package run;

import java.util.List;

import DAO.ContaFisicaDAO;
import DAO.PopularBanco;
import model.Conta;
import model.ContaFisica;

/**
 * 
 * @author Alexandre Ximenes
 *
 */
public class PrincipalContas {
	public static void main(String[] args) {
	
		/**
		 * Metodo auxiliar para popular a base de dados
		 */
		//PopularBanco.start();
	
		/**
		 * salvando uma conta
		 * 
		 */
		/*
		Conta conta = new Conta()
			.setTitular("Regina")
			.setNumero("66666")
			.setAgencia("006")
			.setBanco("Banco das mamaes");
			
		ContaFisicaDAO dao = new ContaFisicaDAO();
		Integer id = dao.salvar(conta);
		*/
		
		
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
			
		ContaFisicaDAO dao = new ContaFisicaDAO();
		Integer id = dao.atualizar(conta);
		
		System.out.println("ID: "+id);
		*/
		

		/**
		 * Removendo uma conta
		 */
		/*
		Conta conta = new Conta();
			conta.setId(7);
			
		ContaFisicaDAO dao = new ContaFisicaDAO();
		Integer id = dao.remover(conta);
		
		System.out.println("ID: "+id);
		*/
		
		/**
		 * Listando as Contas
		 */
		
		ContaFisicaDAO contaDao = new ContaFisicaDAO();
		List<ContaFisica> contas = contaDao.listar();
//		if(contas != null) contas.forEach(System.out::println);

		for (ContaFisica conta : contas) {
			System.out.println(conta.getMovimentacoes().size());
		}
	}
}
