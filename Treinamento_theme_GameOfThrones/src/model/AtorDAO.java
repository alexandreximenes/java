package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class AtorDAO {
	EntityManagerFactory	emf;
	EntityManager			em;

	public AtorDAO() {
		emf = Persistence.createEntityManagerFactory("h2");
		em = emf.createEntityManager();
	}

	public void inserir(Ator ator) {

		em.getTransaction().begin();

		em.persist(ator);

		em.getTransaction().commit();

	}

	public ArrayList<Ator> getAtores() {

		em.getTransaction().begin();

		Query query = em.createQuery("from ator");

		List<Ator> atores = query.getResultList();

		em.getTransaction().commit();

		return new ArrayList<>(atores);
	}
}
