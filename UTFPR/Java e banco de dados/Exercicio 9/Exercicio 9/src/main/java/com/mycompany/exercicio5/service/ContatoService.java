package com.mycompany.exercicio5.service;

import com.mycompany.exercicio5.domain.Contato;
import com.mycompany.exercicio5.domain.Endereco;
import com.mycompany.exercicio5.repositories.ContatoRepository;
import com.mycompany.exercicio5.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Transactional(readOnly = false)
    public void salvar(Endereco endereco, Contato contato) {
        enderecoRepository.save(endereco);
        contato.setEndereco(endereco);
        contatoRepository.save(contato);
    }

    public Optional<Contato> buscaPorId(Long id) {
        return contatoRepository.findById(id);
    }

    public List<Contato> buscarTodos() {
        return contatoRepository.findAll();
    }

    public List<Contato> buscarPoridadeQBE(Integer idade) {

        Contato contato = new Contato();
        contato.setIdade(idade);
        Example<Contato> example = Example.of(contato);

        return contatoRepository.findAll(example);
    }

    public List<Contato> buscarPorNomeQBE(String nome) {

        Contato contato = new Contato();
        contato.setNome(nome);

        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.ENDING);

        Example<Contato> example = Example.of(contato, matcher);

        return contatoRepository.findAll(example);
    }
}
