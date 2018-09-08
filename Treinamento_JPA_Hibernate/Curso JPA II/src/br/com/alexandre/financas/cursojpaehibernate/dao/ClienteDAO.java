package br.com.alexandre.financas.cursojpaehibernate.dao;

import javax.persistence.EntityManager;

import br.com.alexandre.financas.cursojpaehibernate.infra.JPAUtil;
import br.com.alexandre.financas.cursojpaehibernate.model.Cliente;
import br.com.alexandre.financas.cursojpaehibernate.model.Conta;

public class ClienteDAO {
	
	
	public Cliente salvar(Cliente cliente) {
		EntityManager em = JPAUtil.getEM();
		em.getTransaction().begin();
		
		if(cliente.getId() == 0) { 
			em.persist(cliente);
			System.out.println("Cliente salva com sucesso!");
		}else{
			em.merge(cliente);
			System.out.println("Cliente atualizada com sucesso!");
		}
		
		em.getTransaction().commit();
		
		em.close();
		
		return cliente;
	}

	public Cliente findById(Cliente c) {
		
		EntityManager em = JPAUtil.getEM();
		em.getTransaction().begin();
		
		Cliente cliente = em.find(c.getClass(), c.getId());
		
		if(cliente == null) {
			if(c.getNome() != "") {
				cliente = new ClienteDAO().salvar(c);
			}else {
				return null;
			}
		}
		
		em.getTransaction().commit();
		
		em.close();
		
		return cliente;
	}

	public String remove(Cliente c) {
		EntityManager em = JPAUtil.getEM();
		em.getTransaction().begin();
		
		Cliente cliente = em.find(c.getClass(), c.getId());
		if(cliente == null) return "Cliente inexistente!";
		em.remove(cliente);
		
		em.getTransaction().commit();
		
		em.close();
		return "Cliente "+ cliente.getId() +" : "+ cliente + " removida com sucesso!";
		
		
	}

}
