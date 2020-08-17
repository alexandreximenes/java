package com.mycompany.exercicio5.service;

import com.mycompany.exercicio5.domain.Contato;
import com.mycompany.exercicio5.repositories.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository repository;

    public void salvar(Contato contato) {
        repository.save(contato);
    }

    public Optional<Contato> buscaPorId(Long id) {
        return repository.findById(id);
    }

    public List<Contato> buscarTodos() {
        return repository.findAll();
    }

    public List<Contato> buscarPoridadeQBE(Integer idade){

        Contato contato = new Contato();
        contato.setIdade(idade);
        Example<Contato> example = Example.of(contato);

        return repository.findAll(example);
    }

    public List<Contato> buscarPorNomeQBE(String nome) {

        Contato contato = new Contato();
        contato.setNome(nome);

        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.ENDING);

        Example<Contato> example = Example.of(contato, matcher);

        return repository.findAll(example);
    }
}
