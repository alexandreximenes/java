package com.example.model;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.dao.EmployeRepository;
import com.example.model.Employe;

@SpringBootApplication
public class ProjetoComHibernateApplication implements CommandLineRunner{

	@Autowired
	private EmployeRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetoComHibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Employe employe = getEmploye();
		repository.createEmploye(employe);
	}

	private Employe getEmploye() {
		Employe employe = new Employe();
		employe.setName("Alexandre Ximenes");
		employe.setDate(new Date());
		employe.setSalary(new BigDecimal("100.00"));
		return employe;
	}
}
