import javax.persistence.EntityManager;

import br.com.alexandre.financas.cursojpaehibernate.infra.JPAUtil;
import br.com.alexandre.financas.cursojpaehibernate.model.Conta;

public class TestaMovimentacoes2 {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEM();
		
		try {
			em.getTransaction().begin();
			
			if(em.isOpen())
			{
				Conta conta = new Conta();
				conta.setId(3);
						
				Conta contaConsultada = em.find(Conta.class, conta.getId());
				if(contaConsultada != null) {
					System.out.println(contaConsultada.getMovimentacoes().size());
				}else {
					System.out.println(contaConsultada.getClass().getName() + " não foi encontrada");
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
