package run;

import java.util.List;

import DAO.MovimentacaoDAO;
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
		
		MovimentacaoDAO dao = new MovimentacaoDAO();
		List<Movimentacao> movimentacoes = dao.listar();
		if(movimentacoes != null) 
			movimentacoes.forEach(System.out::println);
	}
}
