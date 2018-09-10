package com.example.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.model.Employe;

@Repository
public class EmployeRepository {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void createEmploye(Employe employe) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			
			session.beginTransaction();
			
			session.save(employe);
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
