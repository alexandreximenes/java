import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.alexandre.financas.cursojpaehibernate.infra.JPAUtil;
import br.com.alexandre.financas.cursojpaehibernate.model.Conta;

public class TestaContaEMovimentacoes {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEM();
		
		try {
			em.getTransaction().begin();
			
			if(em.isOpen())
			{
				String jpql = "SELECT DISTINCT c FROM Conta c "
						    + "LEFT JOIN FETCH c.movimentacoes";
				
				Query query = em.createQuery(jpql);
				
				List<Conta> contasConsultada = query.getResultList();
				
				if(contasConsultada != null) {
					contasConsultada
					.stream()
					.filter(c -> c.getCliente().getNome().startsWith("Ale"))
//					.limit(1)
					.forEach(System.out::println);
					
						
				}
				
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
