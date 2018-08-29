package run;

import java.util.List;

import DAO.ContaFisicaDAO;
import DAO.MovimentacaoDAO;
import DAO.PopularBanco;
import model.Conta;
import model.ContaJuridica;
import model.Movimentacao;

/**
 * 
 * @author Alexandre Ximenes
 *
 */
public class ListandoMovimentacoes_Query_JPQL {
	public static void main(String[] args) {
	
		PopularBanco.start();
		
		/**
		 * Listando os dados do banco
		 */
		/*ContaJuridicaDAO conta = new ContaJuridicaDAO();
		conta.setId(10);
		
		MovimentacaoDAO dao = new MovimentacaoDAO();
		List<Movimentacao> movimentacoes = dao.listar(conta);
		if(movimentacoes != null) 
			movimentacoes.forEach(System.out::println);
	*/	
	}
}
