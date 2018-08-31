package br.com.alexandre.financas.cursojpaehibernate.infra;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static EntityManagerFactory emf;
	static {
		emf = Persistence.createEntityManagerFactory("financas");
	}

	public static EntityManager getEM() {
		
		return emf.createEntityManager();
	}

}
