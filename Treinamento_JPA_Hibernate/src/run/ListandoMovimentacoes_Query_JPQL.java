package run;

import java.util.List;

import DAO.ContaDAO;
import DAO.MovimentacaoDAO;
import model.Conta;
import model.Movimentacao;

/**
 * 
 * @author Alexandre Ximenes
 *
 */
public class ListandoMovimentacoes_Query_JPQL {
	public static void main(String[] args) {
	
				
		/**
		 * Listando os dados do banco
		 */
		Conta conta = new Conta();
		conta.setId(10);
		
		MovimentacaoDAO dao = new MovimentacaoDAO();
		List<Movimentacao> movimentacoes = dao.listar(conta);
		if(movimentacoes != null) 
			movimentacoes.forEach(System.out::println);
		
	}
}