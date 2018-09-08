package br.com.alexandre.financas.cursojpaehibernate.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractEntity implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int i) {
		this.id = i;
		
	}
	
	
}
