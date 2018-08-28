package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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

	public List<Movimentacao> listar() {
		List<Movimentacao> movimentacoes = null;
		
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();

		try {

			if(!em.getTransaction().isActive()) {
				System.out.println("transação não esta ativa");
			}else {
				System.out.println("transação esta ativa");
			}

			Query query = em.createQuery("select m from movimentacoes m where m.TipoMovimentacao = :pTipo");
			query.setParameter("pTipo", TipoMovimentacao.SAIDA);
			
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
}
