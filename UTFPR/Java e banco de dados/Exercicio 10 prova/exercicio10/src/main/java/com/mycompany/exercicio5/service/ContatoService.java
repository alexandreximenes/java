package com.mycompany.exercicio5.service;

import com.mycompany.exercicio5.domain.Funcionario;
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

    public void salvar(Funcionario contato) {
        repository.save(contato);
    }

    public Optional<Funcionario> buscaPorId(Long id) {
        return repository.findById(id);
    }

    public List<Funcionario> buscarTodos() {
        return repository.findAll();
    }

    public List<Funcionario> buscarPoridadeQBE(Integer idade){

        Funcionario contato = new Funcionario();
        contato.setIdade(idade);
        Example<Funcionario> example = Example.of(contato);

        return repository.findAll(example);
    }

    public List<Funcionario> buscarPorNomeQBE(String nome) {

        Funcionario contato = new Funcionario();
        contato.setNome(nome);

        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.ENDING);

        Example<Funcionario> example = Example.of(contato, matcher);

        return repository.findAll(example);
    }
}
