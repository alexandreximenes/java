import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.alexandre.financas.cursojpaehibernate.infra.JPAUtil;
import br.com.alexandre.financas.cursojpaehibernate.model.TipoMovimentacao;

public class TestaContaEMovimentacoes3 {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEM();

		try {
			em.getTransaction().begin();
			
			if(em.isOpen())
			{
				
				TypedQuery<BigDecimal> query = 
						em.createQuery("SELECT sum(m.valor) FROM Movimentacao m WHERE m.tipoMovimentacao = :pTipo ORDER BY m.valor DESC", BigDecimal.class);
				query.setParameter("pTipo", TipoMovimentacao.ENTRADA);
				
				
				BigDecimal soma = query.getSingleResult();
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
