import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.alexandre.financas.cursojpaehibernate.infra.JPAUtil;
import br.com.alexandre.financas.cursojpaehibernate.model.Conta;
import br.com.alexandre.financas.cursojpaehibernate.model.TipoMovimentacao;

public class TestaContaEMovimentacoes2 {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEM();
		
		try {
			em.getTransaction().begin();
			
			if(em.isOpen())
			{
				String jpql = "SELECT sum(m.valor) FROM Movimentacoes m"
							+ " WHERE tipoMovimentacao = :pTipo"
							+ " ORDER BY m.valor DESC";
				
				Query query = em.createQuery(jpql);
				query.setParameter("pTipo", TipoMovimentacao.ENTRADA);
				
				
				BigDecimal soma = (BigDecimal) query.getSingleResult();
				System.out.println(soma);
				
			}
			em.getTransaction().commit();
	
		}catch(Exception e) {
			em.getTransaction().rollback();
			if(em.isOpen()) {
				em.close();
			}
		}	
	}

}
