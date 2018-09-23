package Collections;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.Comparator.comparing;

public class TestandoAula {

    public static void main(String[] args) {

        Aula a1 = new Aula("revisitando as Arrayslist", 21);
        Aula a2 = new Aula("Lista de objetos", 15);
        Aula a3 = new Aula("Relacionamento de lista e objetos", 10);
        Aula a4 = new Aula("Aumentando a produtividade com IntelliJ", 30);
        Aula a5 = new Aula("Trabalhando com Stream", 25);

        ArrayList<Aula> aulas = new ArrayList<>(asList(a1, a2, a3, a4, a5));

        System.out.println(aulas);

        /**
         * ordenando por Comparator.compareTO
         * que foi determinado por [ordenação por titulo]
         */

        Collections.sort(aulas);

        System.out.println(aulas);

        /**
         * Ordenando com Comparator.comparing
         * Ordenando por Titulo e depois por Tempo
         */
        aulas.sort(Comparator.comparing(aula -> aula.getTitulo()));

        System.out.println(aulas);

        aulas.sort(Comparator.comparing(Aula::getTempo));

        System.out.println(aulas);

        /**
         * Trabalhando com STREM()
         */

        System.out.println("\nSTREM\n");
        int sum = aulas.stream()
                .filter(c -> c.getTempo() >= 15 /* && c.getTitulo().length() < 25 */)
                .sorted(comparing(Aula::getTempo))
                /*.map(Aula::getTempo)*/
                /*.map(c-> c.getTitulo())*/
                .mapToInt(Aula::getTempo)
                .sum();
        /*.limit(4);*/
        /*.forEach(System.out::println);*/
        System.out.println(sum);

        System.out.println("\nPegando somente aulas com tempo menor que 20 min\n");
        aulas.stream()
                /*.sorted(comparing(Aula::getTitulo))*/
                .filter(c -> c.getTempo() < 20)
                .forEachOrdered(c -> System.out.println(c));

        System.out.println("\nPegando somente aulas que contenham na descrição 'de'\n");
        aulas.stream()
                .filter(a -> a.getTitulo().contains("de"))
                .map(Aula::getTitulo)
                .forEach(System.out::println);

        System.out.println("\nPegando aulas que comecem com a palavra\n");

        aulas.stream()
                .filter(c -> c.getTitulo().startsWith("Aumentando"))
                .forEach(System.out::println);


        System.out.println("\nLimitando a 3 itens list\n");
        List<Aula> collect = aulas.stream()
                .limit(3)
                .sorted(comparing(Aula::getTempo))
                .collect(Collectors.toList());

        System.out.println(collect);

        System.out.println("\nLimitando a 3 itens com set\n");
        Set<Aula> set = aulas.stream()
                .sorted(comparing(Aula::getTitulo))
                .collect(Collectors.toSet());

        System.out.println(set);

    }


}
