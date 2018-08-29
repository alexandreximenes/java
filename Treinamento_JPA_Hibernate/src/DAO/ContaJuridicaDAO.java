package DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.ContaJuridica;

public class ContaJuridicaDAO {

	// Regra de negocio
	// Retornar sempre o ID nos metodos;

	private static int id;

	public Integer salvar(ContaJuridica contaJuridica) {

		EntityManager em = JPAUtil.getEntityManager();

		try {
			if(!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}
			
			em.persist(contaJuridica);

			this.id = contaJuridica.getId();

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

	public Integer atualizar(ContaJuridica contaJuridica) {

		EntityManager em = JPAUtil.getEntityManager();

		try {
			if(!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}
			
			ContaJuridica ContaJuridicaAAtualizar = em.find(ContaJuridica.class, contaJuridica.getId());
			if (ContaJuridicaAAtualizar != null) {
				em.merge(contaJuridica);
				this.id = contaJuridica.getId();
			} else {
				this.salvar(contaJuridica);
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

	public Integer remover(ContaJuridica contaJuridica) {

		EntityManager em = JPAUtil.getEntityManager();
		try {

			if(!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}
			
			ContaJuridica contaJuridicaARemover = em.find(ContaJuridica.class, contaJuridica.getId());

			if (contaJuridicaARemover != null) {
				em.remove(contaJuridicaARemover);
				this.id = contaJuridicaARemover.getId();
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

	public List<ContaJuridica> listar() {
		List<ContaJuridica> contaJuridica = new ArrayList<>();
		EntityManager em = JPAUtil.getEntityManager();
		try {
			em.getTransaction().begin();

//			if(!em.getTransaction().isActive()) {
//			}
			
			Query query = em.createQuery("select c from ContaJuridica c join fetch c.movimentacoes");
			
			contaJuridica = query.getResultList();
			
			em.getTransaction().commit();

		} catch (Exception e) {
			if (em.isOpen())
				em.getTransaction().rollback();
		} finally {
			if (em.isOpen())
				em.close();
		}

		return contaJuridica;
	}
}
