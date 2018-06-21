package br.com.alexandre.springboot.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.alexandre.springboot.model.Convidado;

public interface ConvidadoRepository extends CrudRepository<Convidado, Integer>{

}
