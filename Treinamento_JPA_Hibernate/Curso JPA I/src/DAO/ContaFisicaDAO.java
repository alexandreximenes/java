package DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.ContaFisica;

public class ContaFisicaDAO {

	// Regra de negocio
	// Retornar sempre o ID nos metodos;

	private static int id;

	public Integer salvar(ContaFisica contaFisica) {

		EntityManager em = JPAUtil.getEntityManager();

		try {
			if(!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}
			
			em.persist(contaFisica);

			this.id = contaFisica.getId();

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

	public Integer atualizar(ContaFisica ContaFisica) {

		EntityManager em = JPAUtil.getEntityManager();

		try {
			if(!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}
			
			ContaFisica ContaFisicaAAtualizar = em.find(ContaFisica.class, ContaFisica.getId());
			if (ContaFisicaAAtualizar != null) {
				em.merge(ContaFisica);
				this.id = ContaFisica.getId();
			} else {
				this.salvar(ContaFisica);
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

	public Integer remover(ContaFisica ContaFisica) {

		EntityManager em = JPAUtil.getEntityManager();
		try {

			if(!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}
			
			ContaFisica ContaFisicaARemover = em.find(ContaFisica.class, ContaFisica.getId());

			if (ContaFisicaARemover != null) {
				em.remove(ContaFisicaARemover);
				this.id = ContaFisicaARemover.getId();
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

	public List<ContaFisica> listar() {
		List<ContaFisica> contaFisica = new ArrayList<>();
		EntityManager em = JPAUtil.getEntityManager();
		try {
			em.getTransaction().begin();

//			if(!em.getTransaction().isActive()) {
//			}
			
			Query query = em.createQuery("select c from contaFisica c join fetch c.movimentacoes");
			
			contaFisica = query.getResultList();
			
			em.getTransaction().commit();

		} catch (Exception e) {
			if (em.isOpen())
				em.getTransaction().rollback();
		} finally {
			if (em.isOpen())
				em.close();
		}

		return contaFisica;
	}
}
