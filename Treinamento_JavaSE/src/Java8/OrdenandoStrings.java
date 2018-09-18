package Java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OrdenandoStrings {

    public static void main(String[] args) {

        List<String> aulas = populaLista();

        /**
         * imprimindo com java 8
         */
        imprimeAulas(aulas);

        /**
         * Ordenando com Lambda
         */
        formasDeOrdenacao(aulas);

        /**
         * ordenando classe String
         */

        ordenandoClasseString(aulas);
    }




    private static void ordenandoClasseString(List<String> aulas) {
        aulas.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));

        System.out.println("-"+ aulas);

        aulas.sort(Comparator.comparing(s-> s.length()));

        System.out.println(aulas);

        aulas.sort(Comparator.comparing(String::length));

        System.out.println(aulas);
    }

    private static void formasDeOrdenacao(List<String> aulas) {
        aulas.sort(((o1, o2) -> Integer.compare(o1.length(), o2.length())));
        aulas.sort(Comparator.comparing(s -> s.length()));
        aulas.sort(Comparator.comparing(String::length));
    }

    private static void imprimeAulas(List<String> aulas) {
        aulas.forEach(i -> System.out.println(i));
        aulas.forEach(System.out::println);
        System.out.println(aulas);
    }

    private static List<String> populaLista() {
        List<String> aulas = new ArrayList<>();
        aulas.add("Usando Java 8");
        aulas.add("para comparar strings ");
        aulas.add("dentro de uma Colecao");
        aulas.add("usando Comparator.comparing()");
        aulas.add("implementado na linguagem em 2014");
        return aulas;
    }
}
