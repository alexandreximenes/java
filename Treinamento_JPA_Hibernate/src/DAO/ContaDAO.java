package DAO;

import java.util.List;

import javax.persistence.EntityManager;

import model.Conta;

public class ContaDAO {

	// Regra de negocio
	// Retornar sempre o ID nos metodos;

	private static int id;

	public Integer salvar(Conta conta) {

		EntityManager em = JPAUtil.getEntityManager();

		try {
			if(!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}
			
			em.persist(conta);

			this.id = conta.getId();

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

	public Integer atualizar(Conta conta) {

		EntityManager em = JPAUtil.getEntityManager();

		try {
			if(!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}
			
			Conta contaAAtualizar = em.find(Conta.class, conta.getId());
			if (contaAAtualizar != null) {
				em.merge(conta);
				this.id = conta.getId();
			} else {
				this.salvar(conta);
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

	public Integer remover(Conta conta) {

		EntityManager em = JPAUtil.getEntityManager();
		try {

			if(!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}
			
			Conta contaARemover = em.find(Conta.class, conta.getId());

			if (contaARemover != null) {
				em.remove(contaARemover);
				this.id = contaARemover.getId();
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

	public List<Conta> listar() {
		List<Conta> contas = null;
		EntityManager em = JPAUtil.getEntityManager();
		try {

			if(!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}
			

			em.getTransaction().commit();

		} catch (Exception e) {
			if (em.isOpen())
				em.getTransaction().rollback();
		} finally {
			if (em.isOpen())
				em.close();
		}

		return contas;
	}
}
