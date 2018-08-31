package br.com.alexandre.financas.cursojpaehibernate.dao;

import javax.persistence.EntityManager;

import br.com.alexandre.financas.cursojpaehibernate.infra.JPAUtil;
import br.com.alexandre.financas.cursojpaehibernate.model.Conta;

public class ContaDAO {
	
	
	public Conta salvar(Conta conta) {
		EntityManager em = JPAUtil.getEM();
		em.getTransaction().begin();
		
		if(findById(conta) == null) { 
			em.persist(conta);
			System.out.println("Conta salva com sucesso!");
		}else{
			em.merge(conta);
			System.out.println("Conta atualizada com sucesso!");
		}
		
		
		em.getTransaction().commit();
		
		em.close();
		
		return conta;
	}

	public Conta findById(Conta c) {
		EntityManager em = JPAUtil.getEM();
		em.getTransaction().begin();
		
		Conta conta = em.find(c.getClass(), c.getId());
		
		em.getTransaction().commit();
		
		em.close();
		
		return conta;
	}

	public String remove(Conta c) {
		EntityManager em = JPAUtil.getEM();
		em.getTransaction().begin();
		
		Conta conta = em.find(c.getClass(), c.getId());
		if(conta == null) return "Conta inexistente!";
		em.remove(conta);
		
		em.getTransaction().commit();
		
		em.close();
		return "Conta "+ conta.getId() +" : "+ conta + " removida com sucesso!";
		
		
	}

}
