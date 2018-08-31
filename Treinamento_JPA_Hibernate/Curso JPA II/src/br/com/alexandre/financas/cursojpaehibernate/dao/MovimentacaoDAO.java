package br.com.alexandre.financas.cursojpaehibernate.dao;

import javax.persistence.EntityManager;

import br.com.alexandre.financas.cursojpaehibernate.infra.JPAUtil;
import br.com.alexandre.financas.cursojpaehibernate.model.Conta;
import br.com.alexandre.financas.cursojpaehibernate.model.Movimentacao;

public class MovimentacaoDAO {
	
	
	public void salvar(Movimentacao m) {
		Conta conta = verifyExistsConta(m);
		
		EntityManager em = JPAUtil.getEM();
		
		em.getTransaction().begin();
		
		if(conta != null) m.setConta(conta);
		
		if(m.getId() == null) { 
			em.persist(m);
			System.out.println("Movimentação salva com sucesso!");
		}else{
			if(findById(m) != null) { 
				em.merge(m);
				System.out.println("Movimentação atualizada com sucesso!");
			}else {
				System.out.println("Essa movimentação não existe mais no banco de dados");
			}
			
		}
		
		
		em.getTransaction().commit();
		
		em.close();
	}

	private Conta verifyExistsConta(Movimentacao m) {
		Conta conta = null;
		
		ContaDAO daoConta = new ContaDAO();
		conta = daoConta.findById(m.getConta());
		if(conta == null ) {
			conta = daoConta.salvar(conta);
		}
		return conta;
	}

	public Movimentacao findById(Movimentacao m) {
		EntityManager em = JPAUtil.getEM();
		em.getTransaction().begin();
		
		Movimentacao movimentacao = em.find(m.getClass(), m.getId());
		
		em.getTransaction().commit();
		
		em.close();
		
		return movimentacao;
	}

	public String remove(Movimentacao m){
		EntityManager em = JPAUtil.getEM();
		em.getTransaction().begin();
		
		Movimentacao movimentacao = em.find(m.getClass(), m.getId());
		if(movimentacao == null) return "Conta inexistente!";
		em.remove(movimentacao);
		
		em.getTransaction().commit();
		
		em.close();
		return "Conta "+ movimentacao.getId() +" : "+ movimentacao + " removida com sucesso!";
		
		
	}

}
