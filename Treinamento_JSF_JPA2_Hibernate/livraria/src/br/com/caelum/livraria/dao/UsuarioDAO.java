package br.com.caelum.livraria.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.caelum.livraria.modelo.Usuario;

public class UsuarioDAO {

	public UsuarioDAO() {
	}

	public boolean existe(Usuario usuario) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();

		TypedQuery<Usuario> query = em.createNamedQuery("acesso", Usuario.class);
		query.setParameter("pEmail", usuario.getEmail());
		query.setParameter("pSenha", usuario.getSenha());

		Usuario resultado;
		try {
			resultado = query.getSingleResult();
		} catch (NoResultException e) {
			return false;
		}

		em.getTransaction().commit();
		em.close();

		return resultado != null;
	}

}
