package run;

import java.util.List;

import DAO.ContaDAO;
import DAO.PopularBanco;
import model.Conta;

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
			
		ContaDAO dao = new ContaDAO();
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
			
		ContaDAO dao = new ContaDAO();
		Integer id = dao.atualizar(conta);
		
		System.out.println("ID: "+id);
		*/
		

		/**
		 * Removendo uma conta
		 */
		/*
		Conta conta = new Conta();
			conta.setId(7);
			
		ContaDAO dao = new ContaDAO();
		Integer id = dao.remover(conta);
		
		System.out.println("ID: "+id);
		*/
		
		/**
		 * Listando as Contas
		 */
		
		ContaDAO contaDao = new ContaDAO();
		List<Conta> contas = contaDao.listar();
//		if(contas != null) contas.forEach(System.out::println);

		for (Conta conta : contas) {
			System.out.println(conta.getMovimentacoes().size());
		}
	}
}
