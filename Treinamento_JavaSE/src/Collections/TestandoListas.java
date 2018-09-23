package Collections;

import java.util.*;

public class TestandoListas {

    public static void main(String[] args) {

        String aula1 = "A conhecendo mais de listas";
        String aula2 = "modelando a classe Aula";
        String aula3 = "Trabalhando com Cursos e sets";
        String aula4 = "conhecendo mais de listas";

        ArrayList<String> lista = new ArrayList<>(Arrays.asList(aula1, aula2, aula3, aula4));

        /**
         * 1
         */
        for (String aula : lista
                ) {
            System.out.println(aula);
        }
        /**
         * 2
         */
        System.out.println(lista);

        /**
         * 3
         */
        lista.forEach(System.out::println);

        /**
         * tamanho
         */
        System.out.println(lista.size());

        /**
         * Clone da lista
         */
        List<String> listaClone = (ArrayList<String>) lista.clone();
        System.out.println("lista clone" + listaClone);


        /**
         * ver se esta vazia
         */
        System.out.println(lista.isEmpty());

        /**
         * ordenando
         */
        System.out.println("antes da ordenação \n"+lista);
        Collections.sort(lista);
        System.out.println("apos ordenar \n"+lista);








    }
}
