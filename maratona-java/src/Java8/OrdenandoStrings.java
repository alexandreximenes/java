package Java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OrdenandoStrings {

    public static void main(String[] args) {
        List<String> p = new ArrayList<>();
        p.add("Usando Java 8");
        p.add("para comparar strings ");
        p.add("dentro de uma Colecao");
        p.add("usando Comparator.comparing()");
        p.add("implementado na linguagem em 2014");

        /**
         * imprimindo com java 8
         */
        //p.forEach(i -> System.out.println(i));
        //p.forEach(System.out::println);

        System.out.println(p);
        /**
         * Ordenando com Lambda
         */
        //p.sort(((o1, o2) -> Integer.compare(o1.length(), o2.length())));
        //p.sort(Comparator.comparing(s -> s.length()));
        p.sort(Comparator.comparing(String::length));

        System.out.println(p);
    }
}
