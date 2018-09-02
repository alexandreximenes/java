package Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.Comparator.comparing;

public class TestandoAula {

    public static void main(String[] args) {

        Aula a1 = new Aula("revisitando as Arrayslist", 21);
        Aula a2 = new Aula("Lista de objetos", 15);
        Aula a3 = new Aula("Relacionamento de lista e objetos", 10);
        Aula a4 = new Aula("Aumentando a produtividade com IntelliJ", 30);
        Aula a5 = new Aula("Trabalhando com Stream", 25);

        ArrayList<Aula> aulas = new ArrayList<>();
        aulas.addAll(asList(a1, a2, a3, a4, a5));

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
    }


}
