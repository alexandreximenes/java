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

        ArrayList<Aula> listaDeAulas = getAulas(a1, a2, a3, a4);
        imprimirAulas(listaDeAulas);

        /**
         * Ordenando lita com compareTo
         * @see Aula
         */
        ordenarEImprimeAula(listaDeAulas);

        /**
         * Ordenando com Java 8
         */
        ImpressoraJava8.print(listaDeAulas);
    }

    private static void ordenarEImprimeAula(ArrayList<Aula> listaDeAulas) {
        Collections.sort(listaDeAulas);
        System.out.println(listaDeAulas);
    }

    private static void imprimirAulas(ArrayList<Aula> listaDeAulas) {
        listaDeAulas.forEach(System.out::println);
    }

    private static ArrayList<Aula> getAulas(Aula a1, Aula a2, Aula a3, Aula a4) {
        ArrayList<Aula> aulas = new ArrayList<>();
        aulas.addAll(asList(a1, a2, a3, a4));
        return aulas;
    }
}
