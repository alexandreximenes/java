package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	static final EntityManagerFactory emf;
	
	static {
		emf = Persistence.createEntityManagerFactory("contas");
	}
	
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

}
