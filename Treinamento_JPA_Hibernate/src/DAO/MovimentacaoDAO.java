package DAO;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Conta;
import model.Movimentacao;
import model.TipoMovimentacao;

public class MovimentacaoDAO {

	// Regra de negocio
	// Retornar sempre o ID nos metodos;

	private static int id;

	public Integer salvar(Movimentacao Movimentacao) {

		EntityManager em = JPAUtil.getEntityManager();

		try {
			if(!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}
			
			em.persist(Movimentacao);

			this.id = Movimentacao.getId();

			em.getTransaction().commit();

		} catch (Exception e) {
			if (em.isOpen())
				em.getTransaction().rollback();
		} finally {
			if (em.isOpen())
				em.close();
		}

		return id;
	}

	public Integer atualizar(Movimentacao Movimentacao) {

		EntityManager em = JPAUtil.getEntityManager();

		try {
			if(!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}
			
			Movimentacao MovimentacaoAAtualizar = em.find(Movimentacao.class, Movimentacao.getId());
			if (MovimentacaoAAtualizar != null) {
				em.merge(Movimentacao);
				this.id = Movimentacao.getId();
			} else {
				this.salvar(Movimentacao);
			}

			em.getTransaction().commit();

		} catch (Exception e) {
			if (em.isOpen())
				em.getTransaction().rollback();
		} finally {
			if (em.isOpen())
				em.close();
		}

		return id;
	}

	public Integer remover(Movimentacao Movimentacao) {

		EntityManager em = JPAUtil.getEntityManager();
		try {

			if(!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}
			
			Movimentacao MovimentacaoARemover = em.find(Movimentacao.class, Movimentacao.getId());

			if (MovimentacaoARemover != null) {
				em.remove(MovimentacaoARemover);
				this.id = MovimentacaoARemover.getId();
			}

			em.getTransaction().commit();

		} catch (Exception e) {
			if (em.isOpen())
				em.getTransaction().rollback();
		} finally {
			if (em.isOpen())
				em.close();
		}

		return id;
	}

	public List<Movimentacao> listar(Conta conta) {
		List<Movimentacao> movimentacoes = null;
		
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();

		try {

//			if(!em.getTransaction().isActive()) {
//				System.out.println("transação não esta ativa");
//			}else {
//				System.out.println("transação esta ativa");
//			}

			Query query = em.createQuery("select m from movimentacoes m"
					+ " where m.conta <> :pConta"
//					+ " and m.tipoMovimentacao = :pTipo "
					+ " order by m.valor");
			query.setParameter("pConta", conta);
//			query.setParameter("pTipo", TipoMovimentacao.SAIDA);
			
			movimentacoes = query.getResultList();

			em.getTransaction().commit();

		} catch (Exception e) {
			if (em.isOpen())
				em.getTransaction().rollback();
		} finally {

			if (em.isOpen())
				em.close();
		}

		return movimentacoes;
	}
	
//	public BigDecimal listarComFuncoes(Conta conta){
	public Double listarComFuncoes(Conta conta){
//		BigDecimal soma = null;
		Double soma = null;
		EntityManager em = JPAUtil.getEntityManager();
		
		try {
			em.getTransaction().begin();
			
			/**
			 * consulta normal com JPQL
			 */
//			Query query = em.createQuery("select sum(m.valor) from movimentacoes m"
//					+ " where m.conta = :pConta"
//					+ " and tipoMovimentacao = :pTipo");
//			soma = (BigDecimal) query.getSingleResult();
			
			//

			/**
			 * Consulta com JPA2 TypedQuery
			 */
//			TypedQuery<BigDecimal> query = em.createQuery("select sum(m.valor) from movimentacoes m"
//					+ " where m.conta = :pConta"
//					+ " and tipoMovimentacao = :pTipo", BigDecimal.class);
//			
//			query.setParameter("pConta", conta);
//			query.setParameter("pTipo", TipoMovimentacao.SAIDA);
			
			/**
			 * Consulta retornando Double com JPA2 TypedQuery
			 */
			// 
//			TypedQuery<Double> query = em.createQuery("select avg(m.valor) from movimentacoes m"
//					+ " where m.conta = :pConta"
//					+ " and tipoMovimentacao = :pTipo", Double.class);
//			
			/**
			 * Consulta JPQL com NamedQuery
			 */
			TypedQuery<Double> query = em.createNamedQuery("consultaMediaValorMovimentacoes", Double.class);
			query.setParameter("pConta", conta);
			query.setParameter("pTipo", TipoMovimentacao.SAIDA);
			
			soma = query.getSingleResult();
		
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.getTransaction().commit();
			
			if(em.isOpen()) {
				em.close();
			}
		}
		return soma;
	}
}
