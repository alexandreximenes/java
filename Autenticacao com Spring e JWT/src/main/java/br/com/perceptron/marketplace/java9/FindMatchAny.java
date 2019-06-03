package br.com.perceptron.marketplace.java9;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.List;

import static java.util.Arrays.asList;

@Slf4j
public class FindMatchAny {

    public static void main(String[] args) {

        List<Pessoa> pessoas = Pessoa.getLista();

        log.info("resultado anyMatch > " + pessoas.parallelStream().anyMatch(p -> p.getIdade() > 30));
        log.info("resultado allMatch > " + pessoas.parallelStream().allMatch(p -> p.getIdade() > 30));
        log.info("resultado noneMatch > " + pessoas.parallelStream().noneMatch(p -> p.getSalario() > 1000.00));

        log.info("resultado findAny > " + pessoas.parallelStream()
                .filter(p -> p.getNome().startsWith("A"))
                .findAny());

        log.info("resultado findAny sorted > " + pessoas.parallelStream()
                .filter(p -> p.getNome().startsWith("A"))
                .sorted(Comparator.comparing(Pessoa::getIdade).reversed())
                .findAny());

        log.info("resultado findFirst > " + pessoas.parallelStream()
                .filter(p -> p.getSalario() > 2000 && p.getIdade() > 27)
                .findFirst());
    }

    @Data
    @AllArgsConstructor
    private static class Pessoa {
        private String nome;
        private double idade;
        private double salario;

        public static List<Pessoa> getLista() {
            return asList(
                    new Pessoa("Dayane", 28, 3000.00),
                    new Pessoa("Alexandre", 29, 5000.00),
                    new Pessoa("Arthur", 4, 100.00),
                    new Pessoa("Amanda", 0.6, 100.00),
                    new Pessoa("Marlene", 54, 1800.00),
                    new Pessoa("Regina", 50, 1500.00)
            );
        }
    }
}


