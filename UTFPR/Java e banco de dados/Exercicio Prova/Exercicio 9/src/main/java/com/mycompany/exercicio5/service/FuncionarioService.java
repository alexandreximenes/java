package com.mycompany.exercicio5.service;

import com.mycompany.exercicio5.domain.Funcionario;
import com.mycompany.exercicio5.domain.Cargo;
import com.mycompany.exercicio5.repositories.FuncionarioRepository;
import com.mycompany.exercicio5.repositories.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private CargoRepository cargoRepository;

    @Transactional(rollbackFor = Exception.class)
    public void salvar(Cargo cargo, Funcionario funcionario) {
        cargoRepository.save(cargo);
        funcionario.setCargo(cargo);
        cargo.setFuncionario(funcionario);
        funcionarioRepository.save(funcionario);
    }


    @Transactional(rollbackFor = Exception.class)
    public void salvarFuncionario() {

        Cargo cargo = new Cargo();
        cargo.setCargo("Programador");
        cargoRepository.saveAndFlush(cargo);

        Funcionario pedro = new Funcionario();
        Funcionario tiago = new Funcionario();
        Funcionario joao = new Funcionario();

        pedro.setNome("pedro");
        pedro.setSexo("Masculino");
        pedro.setTelefone("41 9999-9999");
        pedro.setCargo(cargo);

        tiago.setNome("tiago");
        tiago.setSexo("Masculino");
        tiago.setTelefone("41 8888-8888");
        tiago.setCargo(cargo);

        joao.setNome("joao");
        joao.setSexo("Masculino");
        joao.setTelefone("41 9999-7777");
        joao.setCargo(cargo);

        funcionarioRepository.save(pedro);
        funcionarioRepository.save(tiago);
        funcionarioRepository.save(joao);

    }


    @Transactional(rollbackFor = Exception.class)
    public void updateFuncionario() {

        //Antigo cargo Programador

        Cargo cargo = cargoRepository.findByCargo("Analista de teste");
        Funcionario pedro = funcionarioRepository.findByNome("pedro");
        Funcionario tiago = funcionarioRepository.findByNome("tiago");
        Funcionario joao = funcionarioRepository.findByNome("joao");

        pedro.setNome("pedro up");
        pedro.setSexo("Masculino");
        pedro.setTelefone("41 9999-6666");
        pedro.setCargo(cargo);

        tiago.setNome("tiago up");
        tiago.setSexo("Masculino");
        tiago.setTelefone("41 7777-9999");
        tiago.setCargo(cargo);

        joao.setNome("joao up");
        joao.setSexo("Masculino");
        joao.setTelefone("41 8888-9999");
        joao.setCargo(cargo);

        funcionarioRepository.save(pedro);
        funcionarioRepository.save(tiago);
        funcionarioRepository.save(joao);

    }

    @Transactional(rollbackFor = Exception.class)
    public void salvarCargo() {

        Cargo cargo1 = new Cargo();
        cargo1.setCargo("Programador");
        cargoRepository.save(cargo1);

        Cargo cargo2 = new Cargo();
        cargo2.setCargo("Analista de sistemas");
        cargoRepository.save(cargo2);

        Cargo cargo3 = new Cargo();
        cargo3.setCargo("Analista de teste");
        cargoRepository.save(cargo3);

        Cargo cargo4 = new Cargo();
        cargo4.setCargo("Analista desenvolvedor");
        cargoRepository.save(cargo4);

    }

    @Transactional(rollbackFor = Exception.class)
    public void updateCargo() {

        Cargo cargo1 = cargoRepository.findByCargo("Programador");
        Cargo cargo2 = cargoRepository.findByCargo("Analista de sistemas");

        cargo1.setCargo("Programador Java");
        cargoRepository.save(cargo1);

        cargo2.setCargo("Analista de sistemas Senior");
        cargoRepository.save(cargo2);

    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteFuncionario() {

        Funcionario funcionario = funcionarioRepository.findByNome("pedro");
        if(funcionario != null)
            funcionarioRepository.delete(funcionario);
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteCargo() {

        Cargo cargo1 = cargoRepository.findByCargo("Programador Java");
        if(cargo1 != null)
            cargoRepository.delete(cargo1);

    }

    public Optional<Funcionario> buscaPorId(Long id) {
        return funcionarioRepository.findById(id);
    }

    public List<Funcionario> buscarTodos() {
        return funcionarioRepository.findAll();
    }

    public List<Funcionario> buscarPoridadeQBE(Integer idade) {

        Funcionario contato = new Funcionario();
        Example<Funcionario> example = Example.of(contato);

        return funcionarioRepository.findAll(example);
    }

    public List<Funcionario> buscarPorNomeQBE(String nome) {

        Funcionario contato = new Funcionario();
        contato.setNome(nome);

        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.ENDING);

        Example<Funcionario> example = Example.of(contato, matcher);

        return funcionarioRepository.findAll(example);
    }
}
