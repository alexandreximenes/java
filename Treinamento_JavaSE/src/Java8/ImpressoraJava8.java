package Java8;

import java.util.ArrayList;
import java.util.Comparator;

public class ImpressoraJava8 {
    static void print(ArrayList<Aula> listaDeAulas) {

        listaDeAulas.sort(Comparator.comparing(Aula::getTempo));

        System.out.println(listaDeAulas);
    }
}