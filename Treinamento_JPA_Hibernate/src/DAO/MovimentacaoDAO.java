package DAO;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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
//				System.out.println("transa��o n�o esta ativa");
//			}else {
//				System.out.println("transa��o esta ativa");
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
	
	public BigDecimal listarComFuncoes(Conta conta){
		
		BigDecimal soma = null;
		
		EntityManager em = JPAUtil.getEntityManager();
		
		try {
			em.getTransaction().begin();
			
			Query query = em.createQuery("select sum(m.valor) from movimentacoes m"
					+ " where m.conta = :pConta"
					+ " and tipoMovimentacao = :pTipo");
			
			query.setParameter("pConta", conta);
			query.setParameter("pTipo", TipoMovimentacao.ENTRADA);
			
			soma = (BigDecimal) query.getSingleResult();
		
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