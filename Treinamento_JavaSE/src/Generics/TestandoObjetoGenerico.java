package Generics;

import static java.util.Arrays.asList;

public class TestandoObjetoGenerico {

    public static void main(String[] args) {

        ObjetosGenericos<String> objetoG = new ObjetosGenericos<>();
        objetoG.setElemento("qualquer coisa que seja uma String neste momento");
        //objetoG.setElemento(123); // not compile

        System.out.println(
                objetoG
                    .getElemento()
                    .toUpperCase()
        );

        //Testando tipo
        System.out.println(objetoG.getElemento() instanceof String);

//        double soma = objetoG.soma(asList(10, 10, 20, 10, 1.2));


        //System.out.println(objetoG.exibeDadosOrdenados(asList("c", "d", "a")));
    }

}
