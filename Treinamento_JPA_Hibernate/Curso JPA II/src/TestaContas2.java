import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.Query;
import javax.persistence.metamodel.Metamodel;

import br.com.alexandre.financas.cursojpaehibernate.infra.JPAUtil;
import br.com.alexandre.financas.cursojpaehibernate.model.Cliente;
import br.com.alexandre.financas.cursojpaehibernate.model.Conta;
import br.com.alexandre.financas.cursojpaehibernate.model.Movimentacao;
import br.com.alexandre.financas.cursojpaehibernate.model.TipoMovimentacao;

public class TestaContas2 {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEM();
		
		try {
			em.getTransaction().begin();
			
			if(em.isOpen())
			{
				Conta conta = new Conta();
				conta.setId(3);
				
				Cliente cliente = new Cliente();
				cliente.setId(3);
						
				ImprimeDetalhesConexao(em);
				
				Query query = montarQuery(em, conta, cliente);
				
				listarMovimentacoes(query);
				
			}
			em.getTransaction().commit();
	
		}catch(Exception e) {
			em.getTransaction().rollback();
			if(em.isOpen()) {
				em.close();
			}
		}	
	}

	private static Query montarQuery(EntityManager em, Conta conta, Cliente cliente) {
		Query query = em.createQuery("SELECT m FROM Movimentacao "
				+ "m WHERE m.conta = :pConta "
				+ "and m.conta.cliente = :pCliente "
				+ "and m.tipoMovimentacao = :pTipo "
				+ "ORDER BY m.valor DESC");
		
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.ENTRADA);
		query.setParameter("pCliente", cliente);
		return query;
	}

	private static void listarMovimentacoes(Query query) {
		query
			.getResultList()
			.forEach(System.out::println);
	}

	private static void ImprimeDetalhesConexao(EntityManager em) {
		FlushModeType flushMode = em.getFlushMode();
		System.out.println("flushMode "+flushMode);
		Object delegate = em.getDelegate();
		System.out.println("delegate "+delegate);
		Metamodel metamodel = em.getMetamodel();
		System.out.println("metamodel "+ metamodel);
		Map<String, Object> properties = em.getProperties();
		System.out.println("properties "+properties);
		EntityTransaction transaction = em.getTransaction();
		System.out.println("transaction "+ transaction);
	}
}
