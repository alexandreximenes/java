package run;

import java.math.BigDecimal;
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
public class ListandoMovimentacoes_Query_JPQLComFuncoes {
	public static void main(String[] args) {
	
				
		/**
		 * Listando os dados do banco
		 */
		Conta conta = new Conta();
		conta.setId(1);
		
		MovimentacaoDAO dao = new MovimentacaoDAO();
		BigDecimal soma = dao.listarComFuncoes(conta);
		
		System.out.println(soma);
	}
}
