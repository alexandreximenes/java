package Java8;

import java.util.ArrayList;
import java.util.Collections;

import static java.util.Arrays.asList;
import static java.util.Comparator.comparing;

public class TestandoAula {

    public static void main(String[] args) {

        Aula a1 = new Aula("revisitando as Arrayslist", 21);
        Aula a2 = new Aula("Lista de objetos", 15);
        Aula a3 = new Aula("Relacionamento de lista e objetos", 15);
        Aula a4 = new Aula("Aumentando a produtividade com IntelliJ", 30);

        ArrayList<Aula> aulas = new ArrayList<>();
        aulas.addAll(asList(a1, a2, a3, a4));

        aulas.forEach(System.out::println);

        /**
         * Ordenando lita com compareTo
         * @see Aula
         */
        Collections.sort(aulas);
        System.out.println(aulas);

        /**
         * Ordenando com Java 8
         */

        aulas.sort(comparing(Aula::getTempo));

        System.out.println(aulas);


    }
}
